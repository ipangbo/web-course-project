<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/12/10
  Time: 下午 12:19
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
    <title>925 移动开发实验室</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
          integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw" crossorigin="anonymous"/>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/labindex.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/sidebar.css">
    <link rel="stylesheet" href="css/intro-page.css">

</head>
<body>
<%@include file="../../../include/header.jsp" %>
<div class="background-image">
    <div class="core indicator-box">
        <div class="indicator">
            925 实验室
        </div>
    </div>
</div>
<div class="pos-bar">
    <div class="core">
        <div class="pos">
            <i class="mdui-icon material-icons">local_offer</i>
            您现在的位置：<a href=".">首页</a> >> <a href="contents/lab">实验室</a> >> 925 移动开发实验室
        </div>

    </div>
</div>
<div class="content-box">
    <div class="core">
        <%@ include file="/include/sidebar/lab-sidebar.jsp"%>
        <div class="article-box">
            <h2>
                925 移动开发实验室
            </h2>
            <div class="article-text-box">
                <h4>简介</h4>
                <p>
                    大家都知道，925移动开发实验室最近很火，究竟是为什么很火呢？925移动开发实验室到底是什么梗？相信大家对925移动开发实验室都很熟悉，925移动开发实验室就是我们每天都会经常遇到的，但是925移动开发实验室是怎么回事呢？就由小编来为大家介绍一下。
                </p>
                <img src="https://aulin.nefu.edu.cn/__local/1/45/E2/17067C462F7BC486D2C637B2DE1_D0138BF3_BFC56.jpg"
                     alt="925">
                <p>
                    全体教师在圆满完成教学实验管理任务的同时，不断提高业务素质，积极开展科学研究与教学改革项目，主持和参加国家级、省部级、横向科研课题和教学改革课题800余项，多人获得省、市、校级教学成果奖和科学进步奖，在各级期刊中发表教改和学术论文100余篇，正式出版教材20余部，教材均在教学中进行实际应用。
                </p>
                <p> 计算机科学技术实验中心设计算机公共基础实验室, 计算机系统结构实验室, 网络工程与安全实验室,
                    信息管理系统综合实验室，电子信息与通信工程实验室以及信息技术创新实训实验室等6个分室21个房间，建筑面积4800m2。配备品牌台式计算机1200余台，计算机系统结构、计算机组成原理等系统类实验箱200余套；单片机原理、ARM、FPGA、物联网等硬件相关实验箱280余套。实验教学资产1800余万元。
                </p>
                <p>
                    <a href="http://222.27.167.238:8080/syzx/Login">
                        点击进入实验预约系统
                    </a>
                </p>
            </div>
        </div>
    </div>
</div>


<%@include file="../../../include/footer.jsp" %>
</body>
</html>