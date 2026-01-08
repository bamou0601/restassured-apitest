本项目在tag-parallel-case的基础上，开始编写所给出测试网站的所有测试用例。
练习所有类型页面功能的测试用例编写。
CI时命令如下：
mvn clean test -Psmoke --% -Dbase.url=https://the-internet.herokuapp.com
allure serve target/allure-results --port 5050
本项目实现了测试报告中step的显示，添加配置如下：
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.22</version>
    <scope>test</scope>
</dependency>
在 maven-surefire-plugin 中加：
	<argLine>
        -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/1.9.22/aspectjweaver-1.9.22.jar"
    </argLine>
加入这两行配置后，实现step显示的效果。

1-4 新增弹窗认证测试用例digest_auth，DynamicControls
完成后，可以加入如下两步，超越70%的自动化测试工程师
1️ BasePage 加“失败自动截图 + attach 到 Allure”
2️ Page 层引入“状态断言方法”（isLoginSuccess / hasError）
1-6:加入失败后自动截图，和多种浏览器执行测试用例。
多种浏览器并行运行,在base中加入了枚举类BrowserType 
mvn clean test -Psmoke --% -Dbrowser=chrome -Dbase.url=https://the-internet.herokuapp.com
mvn clean test -Psmoke --% -Dbrowser=firefox -Dbase.url=https://the-internet.herokuapp.com
mvn clean test -Psmoke --% -Dbrowser=edge -Dbase.url=https://the-internet.herokuapp.com



	



