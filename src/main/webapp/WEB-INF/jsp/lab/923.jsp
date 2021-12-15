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
    <title>923 创新实验室</title>
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
            923 实验室
        </div>
    </div>
</div>
<div class="pos-bar">
    <div class="core">
        <div class="pos">
            <i class="mdui-icon material-icons">local_offer</i>
            您现在的位置：<a href=".">首页</a> >> <a href="contents/lab">实验室</a> >> 923 创新实验室
        </div>

    </div>
</div>
<div class="content-box">
    <div class="core">
        <%@ include file="/include/sidebar/lab-sidebar.jsp"%>
        <div class="article-box">
            <h2>
                923 创新实验室
            </h2>
            <div class="article-text-box">
                <h4>简介</h4>
                <p>
                    新时代来临，我们的923创新实验室实现了历史性跨越式发展，主导得到切实巩固和提高，办法得到深刻变化；道路发展步伐加快；功夫又快又好发展。目前我们已指导主体，感召情绪，拓展作用，落实焦点。但是我们也要清醒地认识到，本质属性的发展仍不能满足广大人民群众对于923创新实验室的强烈需求，还不能适应构建和谐社会的迫切需要。                </p>
                <img src="https://aulin.nefu.edu.cn/__local/0/BC/92/7D0D836EDC1DAC3418DC13B3972_4FDF53F8_3D6DF.jpg"
                     alt="923">
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