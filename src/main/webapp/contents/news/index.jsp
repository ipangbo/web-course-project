<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/12/6
  Time: 15:50
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
          integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw" crossorigin="anonymous" />
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/newsindex.css">
    <link rel="stylesheet" href="css/footer.css">
    <style>
        .background-image {
            height: 300px;
            width: 100%;
            background-image: url("http://news.nefu.edu.cn/images/y-ban1.jpg");
            background-size: cover;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
<%@include file="../../include/header.jsp"%>
<div class="background-image">
    <div class="indicator">
        新闻网
    </div>
</div>


<%@include file="../../include/footer.jsp"%>
</body>
</html>