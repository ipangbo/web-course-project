# web-course-project

#### 介绍
东百林带“Web开发技术”课程设计：计算机科学与技术专业网站。包含新闻公告发布系统和其他静态页面。

![封面](https://images.gitee.com/uploads/images/2021/1112/123536_f3a322db_7883329.png "封面")

#### 软件架构
- 项目管理：Maven
- 前端技术：html，css，js，jsp。使用了jQuery、MDUI等框架
- 后端技术：Servlet，JDBC，MySQL 8.0.27
- 开发模式：MVC


#### 安装教程

##### 编译安装
1.  git克隆：`git clone https://gitee.com/ipangbocn/web-course-project.git`
2.  打包war包： `mvn package`
3.  部署到Tomcat
##### 二进制安装
1. 下载war包
2. 部署到Tomcat

#### 建立数据库
该应用程序需要创建（连接）`MySQL`数据库才能使用。在`src/main/webapp/META-INF/context.xml`（编译安装）`/META-INF/context.xml`（二进制安装）下使用以下模板创建：
```
<?xml version="1.0" encoding="UTF-8"?>
<Context>
    <Resource name="jdbc/MySQL" type="javax.sql.DataSource"
              maxTotal="100" maxIdle="30" maxWaitMillis="10000" initialSize="1"
              username="$your-username$" password="$your-password$"
              driverClassName="com.mysql.cj.jdbc.Driver"
              url="jdbc:mysql://$ip.ip.ip.ip$:3306/$schema-name$?serverTimezone=Asia/Shanghai" />
</Context>
```

#### Demo
暂无


#### 参与贡献

1.  提交代码
2.  新建 Pull Request


#### 开源许可声明
本软件遵循GNU General Public License v3.0开源协议，您一旦使用了本开源软件，必须遵守相关协议。作者对于用途不承担任何法律责任。

Gitee：

<a href='https://gitee.com/ipangbocn/web-course-project/stargazers'><img src='https://gitee.com/ipangbocn/web-course-project/badge/star.svg?theme=dark' alt='star'></img></a>

Github：

<a href="https://github.com/ipangbo/web-course-project/stargazers"><img alt="GitHub stars" src="https://img.shields.io/github/stars/ipangbo/web-course-project"></a>

#### 备注
本软件前端部分在GitHub Pages实验性更新

仓库：https://github.com/ipangbo/ipangbo.github.io

地址：https://ipangbo.github.io