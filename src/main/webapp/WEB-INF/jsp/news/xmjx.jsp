<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/12/8
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="zh-Hans-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:url var="base" value="/"></c:url>
    <base href="${base}">
    <title>新媒精选</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
          integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw" crossorigin="anonymous" />
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/newsindex.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/sidebar.css">
</head>
<body>
<%@include file="../../../include/header.jsp"%>
<div class="background-image">
    <div class="core indicator-box">
        <div class="indicator">
            新媒精选
        </div>
    </div>
</div>
<div class="pos-bar">
    <div class="core">
        <div class="pos">
            <i class="mdui-icon material-icons">local_offer</i>
            您现在的位置：<a href="index.jsp">首页</a> >> <a href="contents/news">新闻网</a> >> 新媒精选
        </div>

    </div>
</div>
<div class="content-box">
    <div class="core">
        <div class="sidebar">
            <ul>
                <li><a href="contents/news?page=zhxw">综合新闻</a></li>
                <li><a href="contents/news?page=dtsy" class="red-sidebar-menu-item">党团声音</a></li>
                <li><a href="contents/news?page=xmjx">新媒精选</a></li>
            </ul>
        </div>
        <div class="article-box">
            <ul>
                <c:forEach items="${allNews}" var="article">
                    <li>
                        <a href="contents/news/article?aid=${article.aid}" class="title">${article.aTitle}</a>
                        <div class="article-detail-box">
                            <div class="article-abstract">
                                    ${article.aAbstractHTML}
                            </div>
                            <div class="date-indicator">
                                <div class="date-indicator-day"><fmt:formatDate pattern="dd" value="${article.aCreateTime}"/></div>
                                <div class="date-indicator-month-year"><fmt:formatDate pattern="yyyy-MM" value="${article.aCreateTime}"/></div>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>



<%@include file="../../../include/footer.jsp"%>
</body>
</html>