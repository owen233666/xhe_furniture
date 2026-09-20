# 26.1 适配层存档（已从共享树移出）

这 5 个文件原本是 `com.owen233666.blockentityrenderer` 包里为 Minecraft 26.1 的
`extractRenderState` / `submit` 双阶段渲染模型写的适配层。它们在 2026-09 被移出
`src/main/java/`，因为**只要它们在共享树里，1.20.1 和 1.21.1 节点的 `preprocessCode`
就必然失败**。

## 为什么必须移出（实测结论，不要再试 `//#if`）

失败栈：

```
Execution failed for task ':1.21.1-fabric:preprocessCode'.
> Failed to map file "com\owen233666\blockentityrenderer\ModBlockEntityRenderer.java".

Caused by: java.lang.NullPointerException: Failed to resolve type PsiType:CrumblingOverlay
    at com.replaymod.gradle.remap.PsiUtils.getFieldType(PsiUtils.kt:59)
    at com.replaymod.gradle.remap.PsiMapper.findMapping(PsiMapper.kt:336)
    at com.replaymod.gradle.remap.PsiMapper$remapFile$3.visitMethod(PsiMapper.kt:728)
    at com.replaymod.gradle.remap.Transformer.remap(Transformer.kt:163)
    at com.replaymod.gradle.preprocess.PreprocessTask.preprocess(PreprocessTask.kt:318)
```

**`//#if` / `//#endif` 块内的内容对 PSI 重映射器是完全可见的。**
`//#if` 只是给 `CommentPreprocessor` 的标记；`Transformer.remap` 在裁剪**之前**就把
整个源文件树的明文全部交给 PSI 分析，并用**当前节点自己的 classpath** 解析类型。
因此任何节点都不允许在共享树里出现它解析不了的明文类型——**哪怕那行被 `//#if` 包着**。

决定性实验（可复现）：

1. 原样构建 -> `Failed to resolve type PsiType:CrumblingOverlay`
   （来源：`extractRenderState(..., ModelFeatureRenderer.CrumblingOverlay breakProgress)`）
2. 删掉 `extractRenderState` 方法后重跑 -> 报错变成
   `Failed to resolve type PsiType:SubmitNodeCollector`
   （来源：`submit(..., SubmitNodeCollector collector, ...)`）

报错跟着 26.1 类型一个接一个往外冒，证明裁剪对 PSI 不生效。

## 一个需要纠正的旧说法

`tools/preprocess-extract.ps1` 顶部注释和 `REMAINING_WORK.md` K.1 都写着"重映射器只解析
**明文行**"，容易让人以为 `//#if` 能把内容藏起来。**这个描述不准确**，正是它导致了这批
代码的写法。准确的说法是：PSI 看到的是**裁剪前的完整文本**，`//#if` 对它没有任何隐藏作用。

真正能隐藏内容的是 `//$$` 前缀——它把该行变成 `//` 注释，对 PSI 不可见。但 `//$$` 同时
意味着该内容对**所有**节点都不可见，所以它只能用来写"某节点变体"，不能用来写"共享代码
加版本守卫"。

## 将来恢复 26.1 目标时怎么办

`versions/<node>/src` 覆盖机制**只做新增/替换，不能删除文件**（见
`PreprocessPlugin.entry(source, generated, overwrites)` 的字节码），所以覆盖机制救不了
"共享树里不该存在的类"。可选的正确做法：

1. 在 `settings.json` 里加回 `26.1.2-merged`，并把 26.1 渲染器整体放进
   `versions/26.1.2-merged/src/`，而不是共享树；共享树只保留两个版本都合法的代码。
2. 或者让共享树里的渲染器基类在两个节点下都是合法 Java（例如 26.1 侧用 `Object` +
   反射，或把差异全部收进 `RenderEmitter` 这类中立接口），代价是 26.1 侧代码会难看。
3. 或者用 Gradle `sourceSets` 按节点排除整个文件（preprocessor 没有官方排除机制，需要在
   `common.gradle` 里自定义，风险较高）。

注意：恢复 26.1 时，`versions/mapping-1.21.1-fabric-26.1.2-merged.txt` 仍然是有效的
（分隔符必须是**单个空格**，用 TAB 会报 `Failed to parse line N`）。
