# SpringBoot框架搭建学习

### 第一章 创建项目


  
    通过SpringBoot 创建项目
    
  1 . 项目简要说明：
  
  >  - jdk版本: jdk-10
  >  - 项目构建方式：Gradle
  >  - Spring Boot 版本： 2.0.5.RELEASE
  
   

   如下图所示：
   ![图1](doc/img/001_create_project/create_project_1.png)
   
   ----
   
   2 . 选择项目构建方式
   
   如下图2所示：
   ![图2](doc/img/001_create_project/create_project_2.png)
   
   ----
   
   3 . 选择项目依赖
   
   根据可能会用到的功能选择了一下相关依赖：
   
   > Core  : DevTools 、 Lombok <br>
   > Web   : Web 、 REST Docs <br>
   > SQL   : JPA 、 MySQL 、 MyBatis <br> 
   > NoSQL : Redis <br>
   > Integration : RabbitMQ <br>
   > I/O  : Quartz Scheduler
   
  ![图3](doc/img/001_create_project/create_project_3.png)
  
  ----
  
   
   4 . 选择完成之后next 下一步然后Finsh 完成
   
   
   项目完成之后的项目结构图如下所示：
   
 ![图4](doc/img/001_create_project/create_project_4.png)
 
 ----
 
 
 
### 第二章 项目集成Druid作为数据源并添加数据源监控

   #### **添加依赖**
 
 
 从Maven 仓库中查询 Druid 相应依赖配置访问 [Druid Maven仓库](<a href="http://mvnrepository.com/artifact/com.alibaba" target="_blank">Durid Maven仓库</a>)
 
 
    选择1.1.10，点击进入后复制Gradle内容然后粘贴到build.gradle内即可 
    可以单独添加druid依赖或者使用druid-starter
    
 如下图所示： 查询Druid 
 ![Druid Maven仓库](doc/img/002_add_druid/create_project_5.png)
 
 ----

 选择Druid Spring Boot Starter 
 
 ![选择依赖](doc/img/002_add_druid/create_project_6.png)
 
 ----
 复制Gradle 相关配置
 
 ![复制依赖配置文件](./doc/img/002_add_druid/create_project_7.png)

----
 拷贝到项目的Gradle配置文件中，用Gradle将相应的依赖导入项目中
 
 ![添加Gradle配置](./doc/img/002_add_druid/create_project_8.png)
 
 ----
  刷新等待依赖导入完成。
 
 ----
 #### **配置文件中配置Druid**
 
 我们已经将druid添加到我们的项目中，那么接下来我们需要修改application.yml配置文件，添加druid的支持
 
 ```yaml
 
spring:
  datasource:
    #指定数据源类型
    type: com.alibaba.druid.pool.DruidDataSource
    #数据源相关配置
    url: jdbc:mysql://localhost:3306/cambrainc?createDatabaseIfNotExist=true&autoReconnect=true&characterEncoding=utf8&useSSL=false&&zeroDateTimeBehavior=convertToNull
    username: root
    password: root
    driver-class-name: com.mysql.jdbc.Driver
    #最大活跃数
    maxActive: 20
    #初始化数量
    initialSize: 1
    #最大连接等待超时时间
    maxWait: 60000
    #打开PSCache，并且指定每个连接PSCache的大小
    poolPreparedStatements: true
    maxPoolPreparedStatementPerConnectionSize: 20
    #通过connectionProperties属性来打开mergeSql功能；慢SQL记录
    #connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000
    minIdle: 1
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    validationQuery: select 1 from dual
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    #配置监控统计拦截的filters，去掉后监控界面sql将无法统计,'wall'用于防火墙
    filters: stat, wall, log4j
```

 #### **运行项目**
 
 配置完成之后我们启动项目，当看到如下启动日志时，则说明druid已经配置成功。
 
 ![druid配置完成后启动日志](./doc/img/002_add_druid/add_druid_006.png)
 
 我们已经完成了SpringBoot整合Druid连接池的部分，那么我们接下来开启Druid的监控功能。
 
 #### **配置Druid监控**
 
   开启监控功能，可以在应用运行的过程中，通过监控提供的多维度数据来分析使用数据库的运行情况，从而可以调整程序设计，以便于优化数据库的访问性能。
 开启Druid监控功能需要添加Druid相应的配置类。
 
 如下图所示：
 
 ![添加Druid配置类](./doc/img/002_add_druid/add_druid_007.png)
 ----
 
 添加完成相应的配置之后，我们需要重启项目，如果有错误，自己可以搜索尝试解决。在配置中，我们通过在配置类上添加@Configuration注解来将相应的配置应用到全局
 。
 
 项目运行成功后，我们要访问Druid的监控界面，访问地址：127.0.0.1:8630/druid/login.html，效果如下图所示：
 
 ![访问Druid监控页面](./doc/img/002_add_druid/add_druid_008.png)
 ----
 
 用户名和密码就是我么在配置类中填写的用户名和密码：
 
 ![druid用户名和密码](./doc/img/002_add_druid/add_druid_009.png)
 ----
 
 登陆后的监控页面如下图：
 ![druid监控页面](./doc/img/002_add_druid/add_druid_010.png)
 ----
 
 可以看到大致包含了如下几个模块：数据源、SQL监控、SQL防火墙、Web应用、URI监控、Session监控、JSONAPI等。
 
 数据源
 可以看到项目中管理的所有数据源配置的详细情况，除了密码没有显示外其他都在。
 
 SQL监控
 可以查看所有的执行sql语句
 
 SQL防火墙
 druid提供了黑白名单的访问，可以清楚的看到sql防护情况。
 
 Web应用
 可以看到目前运行的web程序的详细信息。
 
 URI监控
 可以监控到所有的请求路径的请求次数、请求时间等其他参数。
 
 Session监控
 可以看到当前的session状况，创建时间、最后活跃时间、请求次数、请求时间等详细参数。
 
 JSONAPI
 通过api的形式访问Druid的监控接口，api接口返回Json形式数据。
 
 至此，我们项目关于Druid 的集成就已经完成了。