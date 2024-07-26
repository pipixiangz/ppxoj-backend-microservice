# 皮皮码来判判 (微服务项目后端代码仓库)
## ppx - online judge

基于Spring Boot + Spring Cloud 微服务+ Docker (+ Vue 3 + Arco Design)的编程题目在线评测系统。

Spring Boot + Spring Cloud Microservices + Docker (+ Vue 3 + Arco Design)

在系统前台，管理员可以创建、管理题目;用户可以自由搜索题目、阅读题目、编写并提交代码。

在系统后端，能够根据管理员设定的题目测试用例在自主实现的代码沙箱中对代码进行编译、运行、判断输出是否正确。其中，代码沙箱可以作为独立服务，提供给其他开发者使用。

Frontend: Administrators can create and manage problems, while users can freely search for problems, read problem statements, write and submit code.

Backend: The system can compile, run, and judge the correctness of the code based on test cases set by the administrators in a self-implemented code sandbox. This code sandbox can also be provided as an independent service for other developers to use.

![主页图片](https://github.com/pipixiangz/ppxoj-frontend/blob/main/imgs/mainPage.jpg)
![浏览题目](https://github.com/pipixiangz/ppxoj-frontend/blob/main/imgs/questionView.jpg)
![浏览提交题目](https://github.com/pipixiangz/ppxoj-frontend/blob/main/imgs/questionSubmitView.jpg)
![创建题目](https://github.com/pipixiangz/ppxoj-frontend/blob/main/imgs/createQuestionView.jpg)
![管理题目](https://github.com/pipixiangz/ppxoj-frontend/blob/main/imgs/manageQuestionView.jpg)
![做题页面](https://github.com/pipixiangz/ppxoj-frontend/blob/main/imgs/doQuestionView.png)
![关于](https://github.com/pipixiangz/ppxoj-frontend/blob/main/imgs/about.png)

1. 系统架构：根据功能职责，将系统划分为负责核心业务的后端模块、负责校验结果的判题模块、负责编译执行代码的可复用代码沙箱。各模块相互独立，并通过API接口和分包的方式实现协作。

2. 自主设计判题机模块的架构，定义了代码沙箱的抽象调用接口和多种实现类（比如远程/本地代码沙箱），并通过静态工厂模式+Spring配置化的方式实现了对多种代码沙箱的灵活调用。

3. 使用代理模式对代码沙箱接口进行能力增强，统一实现了对代码沙箱调用前后的日志记录，减少重复代码。

4. 使用Java Runtime对象的exec方法实现了对Java 程序的编译和执行，并通过Process类的输入流获取执行结果，实现了Java原生代码沙箱。

5. 通过编写Java脚本自测代码沙箱，模拟了多种程序异常情况并针对性解决，如使用守护线程+Thread.sleep等待机制实现了对进程的超时中断、使用JVM -Xmx 参数限制用户程序占用的最大堆内存、使用黑白名单＋字典树的方式实现了对敏感操作的限制。

6. 使用Java安全管理器和自定义的Security Manager对用户提交的代码进行权限控制，比如关闭写文件、执行文件权限，进一步提升了代码沙箱的安全性。

7. 为保证沙箱宿主机的稳定性，选用Docker隔离用户代码，使用Docker Java库创建容器隔离执行代码，并通过tty和Docker进行传参交互，从而实现了更安全的代码沙箱。

8. 使用虚拟机搭建Ubuntu Linux+Docker环境，并通过JetBrains Client连接虚拟机进行实时SSH远程开发，提高了开发效率。

9. 由于Java原生和Docker代码沙箱的实现流程完全一致（编译、执行、获取输出、清理），选用模板方法模式定义了一套标准的流程并允许子类自行扩展部分流程，提高代码一致性并大幅简化冗余代码。
