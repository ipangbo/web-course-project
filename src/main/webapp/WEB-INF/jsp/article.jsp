<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/12/8
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-Hans-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:url var="base" value="/"></c:url>
    <base href="${base}">
    <title>Title</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
          integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw" crossorigin="anonymous"/>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/newsindex.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/sidebar.css">
    <link rel="stylesheet" href="css/article.css">
</head>
<body>
<%@include file="../../include/header.jsp" %>
<div class="background-image">
    <div class="core indicator-box">
        <div class="indicator">
            新闻网
        </div>
    </div>
</div>
<div class="pos-bar">
    <div class="core">
        <div class="pos">
            <i class="mdui-icon material-icons">local_offer</i>
            您现在的位置：<a href="index.jsp">首页</a> >> <a href="contents/news/">新闻网</a> >> 文章详情
        </div>

    </div>
</div>
<div class="content-box">
    <div class="core">
        <div class="sidebar">
            <ul>
                <li><a href="contents/news/zhxw.jsp">综合新闻</a></li>
                <li><a href="contents/news/dtsy.jsp" class="red-sidebar-menu-item">党团声音</a></li>
                <li><a href="contents/news/xmjx.jsp">新媒精选</a></li>
            </ul>
        </div>
        <div class="article-content-box">
            <div class="article-title-box">
                <h2>
                    ${article.aTitle}
                </h2>
                <span>日期：<fmt:formatDate pattern="yyyy-MM-dd" value="${article.aCreateTime}"/></span>
                <span>发布单位：${article.aAuthor}</span>
            </div>
            <div class="article-text-box">
                ${article.aContentHTML}
            </div>
        </div>
    </div>
</div>


<%@include file="../../include/footer.jsp" %>
</body>
</html>