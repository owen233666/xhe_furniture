# Extracts the source variant one preprocessor node would see, so that a node-specific
# override file can be generated from the shared tree.
#
# Background: the shared src/ tree is fed to a PSI-based remapper for every linked node, and
# that remapper resolves types against the node's own Minecraft classpath. CRITICAL: it sees the
# source BEFORE comment-preprocessing, so a 26.1-only type cannot appear ANYWHERE in the shared
# tree -- not even inside a `//#if MC >= 260102` block. `//#if` is only a CommentPreprocessor
# marker and hides nothing from PSI. Verified by experiment; see REMAINING_WORK.md section N.
# Only the `//$$` prefix hides a line from PSI, and it does so for EVERY node, so it can express
# a node-specific variant but never shared code behind a version guard.
#
# Per-node overrides under versions/<node>/src replace the generated file outright (PreprocessTask
# skips generating a file whose path exists in the overwrites directory) -- note that this
# mechanism can only ADD or REPLACE files; it cannot remove a file from the shared tree.
#
# Usage: preprocess-extract.ps1 -Path <src file> -Out <target file> [-Vars @{MC=260102;FABRIC=1;...}]

param(
	[Parameter(Mandatory = $true)][string]$Path,
	[Parameter(Mandatory = $true)][string]$Out,
	[hashtable]$Vars = @{ MC = 260102; FABRIC = 1; FORGE = 0; NEOFORGE = 0; FORGE_LIKE = 0; MERGED = 1 }
)

$utf8 = New-Object System.Text.UTF8Encoding($false)
$lines = [System.IO.File]::ReadAllText($Path, [System.Text.Encoding]::UTF8) -split "`r`n"

function Convert-Expression([string]$expr) {
	$e = $expr.Trim()
	foreach ($k in $Vars.Keys) {
		$e = [regex]::Replace($e, "\b$k\b", [string]$Vars[$k])
	}
	$e = $e.Replace('&&', '-and').Replace('||', '-or')
	$e = [regex]::Replace($e, '(?<![<>!=])=(?!=)', '-eq')
	$e = [regex]::Replace($e, '>=', '-ge')
	$e = [regex]::Replace($e, '<=', '-le')
	$e = [regex]::Replace($e, '(?<![<>])>(?!=)', '-gt')
	$e = [regex]::Replace($e, '(?<![<>])<(?!=)', '-lt')
	return $e
}

$result = New-Object System.Collections.Generic.List[string]
$stack = New-Object System.Collections.Generic.Stack[object]
$active = $true

foreach ($line in $lines) {
	$t = $line.TrimStart()
	if ($t.StartsWith('//#if ')) {
		$cond = [bool](Invoke-Expression (Convert-Expression $t.Substring(6)))
		$stack.Push([pscustomobject]@{ Parent = $active; Taken = $cond })
		$active = $active -and $cond
		continue
	}
	if ($t.StartsWith('//#elseif ')) {
		$frame = $stack.Peek()
		$cond = [bool](Invoke-Expression (Convert-Expression $t.Substring(10)))
		$frame.Taken = $frame.Taken -or $cond
		$active = $frame.Parent -and (-not $frame.Taken -or $cond)
		continue
	}
	if ($t.StartsWith('//#else')) {
		$frame = $stack.Peek()
		$active = $frame.Parent -and (-not $frame.Taken)
		$frame.Taken = $true
		continue
	}
	if ($t.StartsWith('//#endif')) {
		$frame = $stack.Pop()
		$active = $frame.Parent
		continue
	}

	if ($active) {
		$result.Add(($line -replace '^(\s*)//\$\$\s?', '$1'))
	} elseif ($line -match '^(\s*)//\$\$\s?(.*)$') {
		# an alternative kept commented for this node -- drop it
		continue
	}
}

$dir = Split-Path -Parent $Out
if ($dir -and -not (Test-Path $dir)) { New-Item -ItemType Directory -Force -Path $dir | Out-Null }
[System.IO.File]::WriteAllText($Out, ([string]::Join("`r`n", $result) + "`r`n"), $utf8)
Write-Host "wrote $Out"
