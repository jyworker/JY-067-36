# 新增 HanziSimilarHelper 相似汉字查找方法

> **Workspace:** /home/jiangyong/ws/bytedance/solo0601/JY-067/JY-067-36

---

**User**

为  HanziSimilarHelper  新增  findSimilarInText(String text, char target, double threshold)  方法，在一段文本中找出与目标汉字相似度超过阈值的所有汉字及其位置。返回  List<SimilarMatch> ，每个元素包含匹配汉字、位置索引、相似度分数。

**Assistant**

我来帮你实现这个功能。首先让我找到 `HanziSimilarHelper` 类和相关代码结构。

### Relevant Code Snippets
1. /home/jiangyong/ws/bytedance/solo0601/JY-067/JY-067-36/src/main/java/com/github/houbb/nlp/hanzi/similar/util/HanziSimilarHelper.java:L1-L54
  — HanziSimilarHelper 类的定义和实现，这是一个工具类，提供了计算汉字相似度的静态方法。

2. /home/jiangyong/ws/bytedance/solo0601/JY-067/JY-067-36/src/main/java/com/github/houbb/nlp/hanzi/similar/core/HanziSimilar.java:L1-L100
  — HanziSimilar 类的定义，该类是核心的汉字相似度计算类，提供了相似度计算的主要逻辑。

3. /home/jiangyong/ws/bytedance/solo0601/JY-067/JY-067-36/src/main/java/com/github/houbb/nlp/hanzi/similar/core/HanziSimilarListData.java:L1-L50
  — HanziSimilarListData 类的定义，该类用于存储和管理相似汉字列表数据。

4. /home/jiangyong/ws/bytedance/solo0601/JY-067/JY-067-36/src/main/java/com/github/houbb/nlp/hanzi/similar/core/HanziSimilarListDatas.java:L1-L30
  — HanziSimilarListDatas 类的定义，该类用于管理多个相似汉字列表数据。

5. /home/jiangyong/ws/bytedance/solo0601/JY-067/JY-067-36/src/main/java/com/github/houbb/nlp/hanzi/similar/support/similar/HanziSimilars.java:L1-L20
  — HanziSimilars 类的定义，该类用于管理各种相似性计算策略。

6. /home/jiangyong/ws/bytedance/solo0601/JY-067/JY-067-36/src/main/java/com/github/houbb/nlp/hanzi/similar/support/similar/HanziSimilarContext.java:L1-L20
  — HanziSimilarContext 类的定义，该类用于维护相似性计算的上下文信息。

7. /home/jiangyong/ws/bytedance/solo0601/JY-067/JY-067-36/src/main/java/com/github/houbb/nlp/hanzi/similar/bs/HanziSimilarBs.java:L1-L50
  — HanziSimilarBs 类的定义，这是一个构建器类，用于构建和配置汉字相似度计算实例。

让我读取 HanziSimilarHelper 类的内容，并检查是否有 SimilarMatch 类：

现在让我查看一下项目结构和 HanziSimilarBs 类来了解更多上下文：


让我查看一下测试目录和项目构建配置，以便更好地理解项目结构：


让我查看测试文件来了解测试风格和项目惯例：



现在我有了足够的信息。让我创建一个任务列表来规划实现：




现在开始实现。首先创建 SimilarMatch 类：



让我查看测试目录中的 SimilarListDataItem 类来参考数据类的编写风格：



现在创建 SimilarMatch 类：





现在在 HanziSimilarHelper 中添加 findSimilarInText 方法：







现在添加 findSimilarInText 方法：






现在编写测试用例：








现在运行测试来验证功能：










所有测试都通过了！让我更新任务状态：

















已成功完成功能实现！以下是实现详情：

## 实现内容

### 1. 创建了 SimilarMatch 类
位置：[SimilarMatch.java](file:///home/jiangyong/ws/bytedance/solo0601/JY-067/JY-067-36/src/main/java/com/github/houbb/nlp/hanzi/similar/util/SimilarMatch.java)

包含三个字段：
- `hanzi` (char) - 匹配的汉字
- `index` (int) - 汉字在文本中的位置索引
- `score` (double) - 相似度分数

### 2. 新增了 findSimilarInText 方法
位置：[HanziSimilarHelper.java#L57-L82](file:///home/jiangyong/ws/bytedance/solo0601/JY-067/JY-067-36/src/main/java/com/github/houbb/nlp/hanzi/similar/util/HanziSimilarHelper.java#L57-L82)

方法签名：
```java
public static List<SimilarMatch> findSimilarInText(String text, char target, double threshold)
```

实现逻辑：
- 使用 `ArgUtil.notNull` 和 `ArgUtil.notNegative` 进行参数校验（与项目现有风格一致）
- 空文本快速返回空列表
- 遍历文本每个字符，调用已有的 `similar()` 方法计算与目标汉字的相似度
- 相似度超过阈值的字符封装为 `SimilarMatch` 加入结果列表

### 3. 测试验证
位置：[HanziSimilarHelperTest.java](file:///home/jiangyong/ws/bytedance/solo0601/JY-067/JY-067-36/src/test/java/com/github/houbb/nlp/hanzi/similar/util/HanziSimilarHelperTest.java)

编写了 3 个测试用例：
- `findSimilarInTextTest` - 正常匹配场景，验证返回结果的正确性
- `findSimilarInTextEmptyTest` - 空文本边界情况
- `findSimilarInTextNoMatchTest` - 无匹配情况

**所有 8 个测试全部通过** ✅，其中新方法的测试输出示例：
```
匹配结果:
SimilarMatch{hanzi=未, index=0, score=0.9696969696969697}
SimilarMatch{hanzi=来, index=1, score=0.8017316017316016}
SimilarMatch{hanzi=末, index=8, score=1.0}
SimilarMatch{hanzi=日, index=9, score=0.537878787878788}
SimilarMatch{hanzi=来, index=12, score=0.8017316017316016}
SimilarMatch{hanzi=木, index=15, score=0.7681818181818182}
```

---

