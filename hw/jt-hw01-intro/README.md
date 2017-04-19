Java 高级编程 - 编程作业 1
===========

该项目是[Java 高级编程](https://github.com/ppdai/java_training)的**第一个编程作业**。 该作业的目标是熟悉后续作业的形式和结构，了解如何提交作业。

本课程的编程作业将遵循[Maven](http://maven.apache.org/)项目的结构。

开始
---------------

运行如下命令clone git项目：

```shell
git clone https://github.com/ppdai/java_training
```
或者下载并解压文件 [homework zip](https://github.com/ppdai/java_training/archive/master.zip)。

进入目录：
```
hw\jt-hw01-intro
```

作业结构
--------------------------

本作业项目包含2个源目录和3个类
```
src/main/java
+- com.ppdai.jt.Main
\- com.ppdai.jt.homework1.Homework
src/main/test
\- com.ppdai.jt.homework1.HomeworkTest
```

`HomeworkTest`是包含两个[JUnit](http://junit.org/junit4/)测试方法的容器类，测试方法会调用并验证`Homework`类中的方法功能正确。

构建项目
--------------------

你可以如下方式构建应用程序：
```shell
./mvnw clean package
```
但是，运行上面的命令行会报**JUnit**测试失败，可以再控制台看到如下错误消息：

```shell
Results :

Failed tests:   testGetCommonSuffix(com.ppdai.jt.homework1.HomeworkTest): expected:<[JavaFundamentals]> but was:<[fix me!]>

Tests run: 2, Failures: 1, Errors: 0, Skipped: 0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.105 s
[INFO] Finished at: 2017-01-26T17:04:14+02:00
[INFO] Final Memory: 18M/304M
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.12.4:test (default-test) on project homework1: There are test failures.
```

看错误消息，会看到`HomeworkTest`类中的`testGetCommonSuffix()`方法失败了。 打开该类，可以看到这个测试方法调用了`Homework.getCommonSuffix(String first, String second)`，但如果看这个方法的实现，会发现缺少相应的实现 - 它只返回"fix me!"。

待完成作业
-------------------

本课程的第一个作业是修改`Homework`类中的`getCommonSuffix(String first, String second)`方法，让它正确实现功能 - 找出两个字符串的公共前缀， 具体可以参考方法的*javadoc*注释。


完成实现后，据运行构建：
```shell
./mvnw clean package
```

测试应该通过，可以再控制台上看到如下成功消息：
```shell
Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

[INFO]
[INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ homework1 ---
[INFO] Building jar: /Users/archcentric/Projects/java/jt/jt-hw01-intro/target/jt-homework1.jar
[INFO]
[INFO] --- maven-shade-plugin:2.4.3:shade (default) @ homework1 ---
[INFO] Including org.apache.commons:commons-lang3:jar:3.4 in the shaded jar.
[INFO] Replacing original artifact with shaded artifact.
[INFO] Replacing /Users/archcentric/Projects/java/jt/jt-hw01-intro/target/jt-homework1.jar with /Users/archcentric/Projects/java/jt/jt-hw01-intro/target/homework1-0.0.1-SNAPSHOT-shaded.jar
[INFO] Dependency-reduced POM written at: /Users/archcentric/Projects/java/jt/jt-hw-intro/dependency-reduced-pom.xml
[INFO] Dependency-reduced POM written at: /Users/archcentric/Projects/java/jt/jt-hw-intro/dependency-reduced-pom.xml
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.355 s
[INFO] Finished at: 2017-01-26T17:18:38+02:00
[INFO] Final Memory: 19M/215M
[INFO] ------------------------------------------------------------------------
```

待这个失败的测试通过之后，可以在`HomeworkTest`类中增加更多的测试，覆盖更多的不同的字符串对，以确保功能完整和正确。


注意！如果只是在`getCommonSuffix`中返回**"JavaFundamentals"** - 虽然是个小聪明 - 但不会被接受为正确答案:)

运行应用
-----------------------

成功构建应用之后，会生成一个java文件`target/jt-homework1.jar`。你现在可以通过调用`main`方法运行程序：
```shell
java -jar target/jt-homework1.jar firstString secondString
```

如果你确实修复了`getCommonSuffix`方法，则可以在控制台上看到正确的输出`String`。


*注意：如果你想用一个不同的类作为`Main`入口，你可以修改`pom.xml`文件的第*42行**。

提交作业
--------------------------

测试通过并成功构建以后，可以在homework目录中运行如下命令提交作业：

```shell
./mvnw clean deploy
```

命令将提示你输入**employee name**, **Employee Id**和一个**comment** *(可选)*。

Example:

```shell
./mvnw clean deploy

#...skipping building, testing and packaging output from Maven...

[INFO] --- maven-antrun-plugin:1.7:run (package homework ZIP) ---
[INFO] Executing tasks

main:
Your employee name (e.g. archcentric):
archcentric
Your Employee Id (e.g. PPD006789):
PPD006789
Comment:
Java IO
      [zip] Building zip: /Users/archcentric/Projects/java/jt/jt-hw01-intro/target/jt-howework1-PPD006789.zip
   [delete] Deleting: /Users/archcentric/Projects/java/jt/jt-hw01-intro/homework.properties
[INFO] Executed tasks
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 45.028s
[INFO] Finished at: Thu Aug 28 15:36:19 EEST 2014
[INFO] Final Memory: 17M/99M
[INFO] ------------------------------------------------------------------------
```

Maven成功构建之后，你可以找到**target/jt-homework1-PPD006789.zip**的**ZIP文件**，*(zip文件的文件名中包含作业号和你的雇员号)*。

ZIP文件中包含我们要检查评分的所有文件。

剩下就是将ZIP文件作为邮件附件发送到*jt@ppdai.com*，邮件主题**"编程作业 1 - *你的雇员号*"**。


建议
============

如果你想在不修复测试的情况下构建应用程序，那么你需要在运行构面命令时通过加`-DskipTests`参数跳过测试：
```shell
./mvnw clean package -DskipTests
```

注意，你想要分数的话，测试必须正确通过。

使用Eclipse
-------------

如果你是Eclipse用户，可以将项目导入workspace。 通过*File* - *Import* - *Existing Maven Projects*。


使用IntelliJ IDEA
-------------------

如果你是IntelliJ IDEA用户，可以通过选择 *File* - *New* - *Project from Existing Sources...*，然后按照对话框指示导入项目。