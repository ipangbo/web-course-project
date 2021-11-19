<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/11/19
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hans-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:url var="base" value="/"></c:url>
    <base href="${base}">
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
            integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw"
            crossorigin="anonymous"
    />
    <title>头部模板</title>
    <link rel="stylesheet" href="css/header.css">
</head>
<body>
<div class="header-box">
    <div class="header">
        <div class="core" id="header-core">
            <div class="header-logo"></div>
            <div class="header-name"></div>
            <div class="major-name">计算机科学与技术专业</div>
            <div class="slogan"></div>
            <ul class="menu">
                <a href="https://mail.nefu.edu.cn" target="_blank"><li class="menu-button"><i class="mdui-icon material-icons">mail</i></li></a>
                <a href="panel/" target="_blank"><li class="menu-button"><i class="mdui-icon material-icons">account_circle</i></li></a>
            </ul>
        </div>
    </div>
    <div class="banner">
        <div class="core" id="banner-core">
            <ul class="banner-list">
                <li><a href="news.jsp">新闻中心</a></li>
                <li><a href="notice.jsp">通知公告</a></li>
                <li><a href="major.jsp">专业介绍</a></li>
                <li><a href="teachers.jsp">教师队伍</a></li>
                <li><a href="labs.jsp">实验室</a></li>
                <li><a href="job.jsp">就业指南</a></li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>