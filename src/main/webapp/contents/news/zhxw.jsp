<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/12/8
  Time: 20:52
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
    <title>东林计科新闻网</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
          integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw" crossorigin="anonymous" />
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/newsindex.css">
    <link rel="stylesheet" href="css/footer.css">
</head>
<body>
<%@include file="../../include/header.jsp"%>
<div class="background-image">
    <div class="core indicator-box">
        <div class="indicator">
            综合新闻
        </div>
    </div>
</div>
<div class="pos-bar">
    <div class="core">
        <div class="pos">
            <i class="mdui-icon material-icons">local_offer</i>
            您现在的位置：<a href="index.jsp">首页</a> >> <a href="contents/news/">新闻网</a> >> 综合新闻
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
        <div class="article-box">
            <ul>
                <li>
                    <a href="contents/news/article?aid=1" class="title">关于这是一条新闻的通知的新闻</a>
                    <div class="article-detail-box">
                        <div class="article-abstract">
                            为引导广大东林学子深入学习习近平总书记“七一”重要讲话精神，深刻领会和把握讲话的重大意义、丰富内涵、核心要义、实践要求，把学习成果转化为奋进新征程、建功新时代的实际行动，奥林学院指导中心在2021年10月9日星期六16:00于奥林学院401举办政治观摩会。为了响应疫情防控要求，除参演人员及工作人员到场外，另有将近300余人在线上一同参加本次活动。为引导广大东林学子深入学习习近平总书记“七一”重要讲话精神为引导广大东林学子深入学习习近平总书记“七一”重要讲话精神为引导广大东林学子深入学习习近平总书记“七一”重要讲话精神
                        </div>
                        <div class="date-indicator">
                            <div class="date-indicator-day">08</div>
                            <div class="date-indicator-month-year">2021-12</div>
                        </div>
                    </div>
                </li>
                <li>
                    <a href="contents/news/article?aid=1" class="title">关于这是一条新闻的通知的新闻</a>
                    <div class="article-detail-box">
                        <div class="article-abstract">
                            为引导广大东林学子深入学习习近平总书记“七一”重要讲话精神，深刻领会和把握讲话的重大意义、丰富内涵、核心要义、实践要求，把学习成果转化为奋进新征程、建功新时代的实际行动，奥林学院指导中心在2021年10月9日星期六16:00于奥林学院401举办政治观摩会。为了响应疫情防控要求，除参演人员及工作人员到场外，另有将近300余人在线上一同参加本次活动。为引导广大东林学子深入学习习近平总书记“七一”重要讲话精神为引导广大东林学子深入学习习近平总书记“七一”重要讲话精神为引导广大东林学子深入学习习近平总书记“七一”重要讲话精神
                        </div>
                        <div class="date-indicator">
                            <div class="date-indicator-day">08</div>
                            <div class="date-indicator-month-year">2021-12</div>
                        </div>
                    </div>
                </li>
                <li>
                    <a href="contents/news/article?aid=1" class="title">关于这是一条新闻的通知的新闻</a>
                    <div class="article-detail-box">
                        <div class="article-abstract">
                            为引导广大东林学子深入学习习近平总书记“七一”重要讲话精神，深刻领会和把握讲话的重大意义、丰富内涵、核心要义、实践要求，把学习成果转化为奋进新征程、建功新时代的实际行动
                        </div>
                        <div class="date-indicator">
                            <div class="date-indicator-day">08</div>
                            <div class="date-indicator-month-year">2021-12</div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>



<%@include file="../../include/footer.jsp"%>
</body>
</html>