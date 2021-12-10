<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/12/10
  Time: 上午 10:30
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
    <title>讲师</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
          integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw" crossorigin="anonymous"/>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/teachersindex.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/sidebar.css">
</head>
<body>
<%@include file="../../include/header.jsp" %>
<div class="background-image">
    <div class="core indicator-box">
        <div class="indicator">讲师</div>
    </div>
</div>
<div class="pos-bar">
    <div class="core">
        <div class="pos"><i class="mdui-icon material-icons">local_offer</i>
            您现在的位置：<a href=".">首页</a> >> <a href="contents/teachers">教师队伍</a> >> 讲师
        </div>
    </div>
</div>
<div class="content-box">
    <div class="core">
        <div class="sidebar">
            <ul>
                <li><a href="contents/teachers/js.jsp">教授</a></li>
                <li><a href="contents/teachers/fjs.jsp">副教授</a></li>
                <li><a href="contents/teachers/jiangshi.jsp">讲师</a></li>
            </ul>
        </div>
        <div class="article-box">
            <ul>
                <li>
                    <a href="contents/teachers/detail?aid=1">
                        <div class="teacher-card">
                            <img src="https://tc.qn.ipangbo.cn/image/wb.jpg" alt="教师照片" class="teacher-img">
                            <h4>王波</h4>
                            <div class="teacher-title">讲师</div>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="contents/teachers/detail?aid=1">
                        <div class="teacher-card">
                            <img src="https://tc.qn.ipangbo.cn/image/wb.jpg" alt="教师照片" class="teacher-img">
                            <h4>王波</h4>
                            <div class="teacher-title">讲师</div>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="contents/teachers/detail?aid=1">
                        <div class="teacher-card">
                            <img src="https://tc.qn.ipangbo.cn/image/wb.jpg" alt="教师照片" class="teacher-img">
                            <h4>王波</h4>
                            <div class="teacher-title">讲师</div>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="contents/teachers/detail?aid=1">
                        <div class="teacher-card">
                            <img src="https://tc.qn.ipangbo.cn/image/wb.jpg" alt="教师照片" class="teacher-img">
                            <h4>王波</h4>
                            <div class="teacher-title">讲师</div>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="contents/teachers/detail?aid=1">
                        <div class="teacher-card">
                            <img src="https://tc.qn.ipangbo.cn/image/wb.jpg" alt="教师照片" class="teacher-img">
                            <h4>王波</h4>
                            <div class="teacher-title">讲师</div>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="contents/teachers/detail?aid=1">
                        <div class="teacher-card">
                            <img src="https://tc.qn.ipangbo.cn/image/wb.jpg" alt="教师照片" class="teacher-img">
                            <h4>王波</h4>
                            <div class="teacher-title">讲师</div>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="contents/teachers/detail?aid=1">
                        <div class="teacher-card">
                            <img src="https://tc.qn.ipangbo.cn/image/wb.jpg" alt="教师照片" class="teacher-img">
                            <h4>王波</h4>
                            <div class="teacher-title">讲师</div>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="contents/teachers/detail?aid=1">
                        <div class="teacher-card">
                            <img src="https://tc.qn.ipangbo.cn/image/wb.jpg" alt="教师照片" class="teacher-img">
                            <h4>王波</h4>
                            <div class="teacher-title">讲师</div>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="contents/teachers/detail?aid=1">
                        <div class="teacher-card">
                            <img src="https://tc.qn.ipangbo.cn/image/wb.jpg" alt="教师照片" class="teacher-img">
                            <h4>王波</h4>
                            <div class="teacher-title">讲师</div>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="contents/teachers/detail?aid=1">
                        <div class="teacher-card">
                            <img src="https://tc.qn.ipangbo.cn/image/wb.jpg" alt="教师照片" class="teacher-img">
                            <h4>王波</h4>
                            <div class="teacher-title">讲师</div>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>

<%@include file="../../include/footer.jsp" %>
</body>
</html>