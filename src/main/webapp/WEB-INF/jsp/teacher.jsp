<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/12/8
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-Hans-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:url var="base" value="/"></c:url>
    <base href="${base}">
    <title>教师详情</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
          integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw" crossorigin="anonymous" />
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/newsindex.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/sidebar.css">
    <link rel="stylesheet" href="css/article.css">
</head>
<body>
<%@include file="../../include/header.jsp"%>
<div class="background-image">
    <div class="core indicator-box">
        <div class="indicator">
            教师团队
        </div>
    </div>
</div>
<div class="pos-bar">
    <div class="core">
        <div class="pos">
            <i class="mdui-icon material-icons">local_offer</i>
            您现在的位置：<a href="index.jsp">首页</a> >> <a href="contents/teachers">教师团队</a>  >> 教师详情
        </div>

    </div>
</div>
<div class="content-box">
    <div class="core">
        <div class="sidebar">
            <ul>
                <li><a href="contents/teachers?page=js">教授</a></li>
                <li><a href="contents/teachers?page=fjs">副教授</a></li>
                <li><a href="contents/teachers?page=jiangshi">讲师</a></li>
            </ul>
        </div>
        <div class="article-content-box">
            <div class="article-title-box">
                <h2>
                    王波讲师
                </h2>
            </div>
            <div class="article-text-box">
                <img src="https://tc.qn.ipangbo.cn/image/wb.jpg" alt="教师照片" class="teacher-article-img">
                <p>
                    王波，讲师，硕士。主要研究方向：计算数学，软件开发。发表学术论文3篇。
                </p>
            </div>
        </div>
    </div>
</div>



<%@include file="../../include/footer.jsp"%>
</body>
</html>