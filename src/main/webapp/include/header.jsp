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
    <title>头部模板</title>
    <link rel="stylesheet" href="css/header.css">
</head>
<body>
<div class="header">
    <div class="core">
        <div class="header-logo"></div>
        <div class="header-name"></div>
        <div class="major-name">计算机科学与技术专业</div>
    </div>
</div>
</body>
</html>