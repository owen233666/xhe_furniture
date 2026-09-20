# Preprocessor directive validator (PowerShell)
#
# Root `src/` is compiled verbatim by the *core* project (versions/mainProject == 1.21.1-neoforge),
# because the preprocessor is only applied when generating the other version projects.
# Consequences checked here:
#   1. every //#if is closed by a matching //#endif (nesting must be balanced)
#   2. every line that belongs to a branch which is NOT active for the core project is prefixed with //$$
#      -- otherwise the core would compile it as real code
#   3. //$$ markers may only appear inside a //#if block

$ErrorActionPreference = 'Stop'

$Root = Join-Path $PSScriptRoot '..\src\main'
# Core project = 1.21.1-neoforge -> MC 12101, NEOFORGE 1, everything else 0
$CoreVars = @{ MC = 12101; FABRIC = 0; MERGED = 0; FORGE = 0; NEOFORGE = 1; FORGE_LIKE = 1 }

function Get-Value([string]$token) {
	if ($CoreVars.ContainsKey($token)) { return $CoreVars[$token] }
	if ($token -match '^[0-9_]+$') { return [int]($token -replace '_', '') }
	throw "Cannot evaluate token '$token' for the core project"
}

function Eval-Expr([string]$expr) {
	$e = $expr.Trim()
	$parts = $e -split [regex]::Escape('||')
	if ($parts.Count -gt 1) { foreach ($p in $parts) { if (Eval-Expr $p) { return $true } }; return $false }
	$parts = $e -split [regex]::Escape('&&')
	if ($parts.Count -gt 1) { foreach ($p in $parts) { if (-not (Eval-Expr $p)) { return $false } }; return $true }
	if ($e.StartsWith('!')) { return -not (Eval-Expr $e.Substring(1)) }
	$m = [regex]::Match($e, '^(.+?)(==|!=|<=|>=|<|>)(.+)$')
	if ($m.Success) {
		$lhs = Get-Value $m.Groups[1].Value.Trim()
		$rhs = Get-Value $m.Groups[3].Value.Trim()
		switch ($m.Groups[2].Value) {
			'==' { return $lhs -eq $rhs } '!=' { return $lhs -ne $rhs }
			'>=' { return $lhs -ge $rhs } '<=' { return $lhs -le $rhs }
			'>' { return $lhs -gt $rhs } '<' { return $lhs -lt $rhs }
		}
	}
	return (Get-Value $e) -ne 0
}

$problems = New-Object System.Collections.Generic.List[string]
$files = Get-ChildItem -Recurse -File (Join-Path $Root 'java') -Include *.java
$fileCount = 0
$directiveCount = 0

foreach ($file in $files) {
	$fileCount++
	$lines = [System.IO.File]::ReadAllLines($file.FullName, [System.Text.Encoding]::UTF8)
	$stack = New-Object System.Collections.Generic.List[object]
	$active = $true
	$n = 0
	foreach ($line in $lines) {
		$n++
		$t = $line.Trim()

		if ($t.StartsWith('//#if ')) {
			$directiveCount++
			$cond = Eval-Expr $t.Substring(5)
			# frame: parentActive, anyBranchTaken, currentBranchSelected
			$stack.Add([pscustomobject]@{ Parent = $active; Taken = $cond; Current = $cond })
			$active = $active -and $cond
			continue
		}
		if ($t.StartsWith('//#elseif ')) {
			$directiveCount++
			if ($stack.Count -eq 0) { $problems.Add("$($file.Name):$n unexpected //#elseif"); continue }
			$f = $stack[$stack.Count - 1]
			if ($f.Taken) { $f.Current = $false } else { $c = Eval-Expr $t.Substring(9); $f.Taken = $c; $f.Current = $c }
			$active = $f.Parent -and $f.Current
			continue
		}
		if ($t -eq '//#else') {
			$directiveCount++
			if ($stack.Count -eq 0) { $problems.Add("$($file.Name):$n unexpected //#else"); continue }
			$f = $stack[$stack.Count - 1]
			$f.Current = -not $f.Taken
			$active = $f.Parent -and $f.Current
			continue
		}
		if ($t -eq '//#endif') {
			$directiveCount++
			if ($stack.Count -eq 0) { $problems.Add("$($file.Name):$n unexpected //#endif"); continue }
			$f = $stack[$stack.Count - 1]
			$stack.RemoveAt($stack.Count - 1)
			$active = $f.Parent
			continue
		}
		if ($t.StartsWith('//$$')) {
			if ($stack.Count -eq 0) { $problems.Add("$($file.Name):$n //`$`$ outside of any //#if block") }
			continue
		}
		if ($t.Length -eq 0) { continue }
		if (-not $active) {
			$problems.Add("$($file.Name):$n inactive-for-core line is not //`$`$-prefixed: $t")
		}
	}
	if ($stack.Count -ne 0) { $problems.Add("$($file.Name): missing //#endif ($($stack.Count) unclosed)") }
}

if ($problems.Count -eq 0) {
	Write-Host "OK - $fileCount java files, $directiveCount directives, all consistent with the core project (1.21.1-neoforge)"
} else {
	Write-Host "FOUND $($problems.Count) problem(s):"
	$problems | Select-Object -First 60 | ForEach-Object { Write-Host "  $_" }
	if ($problems.Count -gt 60) { Write-Host "  ... and $($problems.Count - 60) more" }
	exit 1
}
