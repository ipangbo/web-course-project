<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/12/8
  Time: 21:18
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
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
          integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw" crossorigin="anonymous" />
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/noticeindex.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/article.css">
</head>
<body>
<%@include file="../../include/header.jsp"%>
<div class="background-image">
    <div class="core indicator-box">
        <div class="indicator">
            通知公告
        </div>
    </div>
</div>
<div class="pos-bar">
    <div class="core">
        <div class="pos">
            <i class="mdui-icon material-icons">local_offer</i>
            您现在的位置：<a href="index.jsp">首页</a> >> <a href="contents/notice/">通知公告</a> >> 公告详情
        </div>

    </div>
</div>
<div class="content-box">
    <div class="core">
        <div class="sidebar">
            <ul>
                <li><a href="contents/notice/jyjx.jsp">教育教学</a></li>
                <li><a href="contents/notice/xsdt.jsp">学术动态</a></li>
                <li><a href="contents/notice/hqbz.jsp">后勤保障</a></li>
            </ul>
        </div>
        <div class="article-content-box">
            <div class="article-title-box">
                <h2>
                    我校帽儿山教学区首次记录到国家重点保护动物黑熊和马鹿我校帽儿山教学区首次记录到国家重点保护动物黑熊和马鹿
                </h2>
                <span>日期：2021-12-08</span>
                <span>发布单位：帽儿山实验林场</span>
                <span>文字：陈健</span>
            </div>
            <div class="article-text-box">
                <p>
                    近日，帽儿山教学区在野生动物监测方面获得了重要发现。工作人员在定期收集尖砬沟施业区内红外相机影像资料时，相继发现黑熊（Ursus thibetanu）、马鹿（Cervus
                    elaphus）、狍（Capreolus pygargus bedfordi）、野猪（Sus scrofa）、獾（Meles meles）、黄鼬（Mustela
                    sibirica）等多种野生动物活动画面。此次发现是帽儿山教学区首次以影像形式记录到国家重点保护动物（II级）黑熊和马鹿。
                </p>
                <p>
                    帽儿山教学区于2021年初成立野生动物监测小组，并购置了红外相机、外业笔记本电脑等设备。2021年4月份经我校动保学院专家现场指导，监测小组在尖砬沟施业区内布设红外相机6台，并定期进行野生动物影像数据收集。该小组依托基于多年的野外调查经验，对红外相机进行科学布点，为野生动物监测工作实现突破性进展。
                </p>
                <p>
                    动保学院姜广顺教授说：“马鹿和黑熊是我国东北地区珍贵的大型林栖兽类，但由于历史上的大规模森林开发，栖息地破碎化严重，种群数量十分稀少。此次这两种国家重点保护动物的同时发现，反映出帽儿山教学区生态环境的保护成效十分显著”。
                </p>
                <p>
                    近年来，随着帽儿山教学区对自然生态环境保护力度的不断加大，野生动物原始生境逐渐恢复，境内野生动物种类、数量正在不断增加，对于维护生态平衡，改善自然环境，促进社会经济持续稳定发展意义重大。
                </p>
                <img style="margin: 0 auto;"
                     src="http://news.nefu.edu.cn/__local/4/DA/F4/C5C8F8C7C5C3942CACD853A71DC_D4D53972_1E96B6.jpg"
                     alt="图片">
                <video controls
                       src="http://news.nefu.edu.cn/__local/2/0A/16/D394D8D9C48FEFEC719DFB5F9CF_1E9C5196_7BD5A2.mp4"></video>
            </div>
        </div>
    </div>
</div>



<%@include file="../../include/footer.jsp"%>
</body>
</html>