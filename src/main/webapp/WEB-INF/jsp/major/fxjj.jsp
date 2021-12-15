<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/12/9
  Time: 12:28
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
    <title>方向简介</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
          integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw" crossorigin="anonymous"/>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/majorindex.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/sidebar.css">
    <link rel="stylesheet" href="css/intro-page.css">
</head>
<body>
<%@include file="../../../include/header.jsp" %>
<div class="background-image">
    <div class="core indicator-box">
        <div class="indicator">
            方向简介
        </div>
    </div>
</div>
<div class="pos-bar">
    <div class="core">
        <div class="pos">
            <i class="mdui-icon material-icons">local_offer</i>
            您现在的位置：<a href="index.jsp">首页</a> >> <a href="contents/major">专业介绍</a> >> 方向简介
        </div>
    </div>
</div>
<div class="content-box">
    <div class="core">
        <%@ include file="/include/sidebar/major-sidebar.jsp"%>
        <div class="article-box">
            <h2>东北林业大学奥林学院大数据方向</h2>
            <div class="article-text-box">
                <h4>方向培养目标</h4>
                <p>
                    本方向培养适应国家建设发展需要，德、智、体全面发展，具有良好的科学素养和丰厚的人文底蕴，具备数学、统计学、计算机科学等多学科知识和技能，能够了解数据的获取、建模、管理、利用的全生命周期，熟知相关技术、系统和应用，具备数据分析和数据挖掘技能，能够综合运用所学知识解决与大数据相关的复杂工程技术问题，具有分析问题、解决问题、自主学习以及创新能力的复合型人才。毕业生适合在信息技术企业和企事业单位信息技术相关部门，从事大数据相关的采集、处理、分析、管理、挖掘等为主要内容的各层次工作。 </p>
                <h4>核心课程</h4>
                <p>
                    Statistical Theory，Data Analysis，数据挖掘，数据可视化等。
                </p>
                <h4>特色优势</h4>
                <p>
                    在人才培养模式方面，实施VIP（垂直整合项目）人才培养体系，将大一到大四的全部主要课程和集中实践环节纳入VIP体系，依据人才的认知和成长规律循序渐进地实施工程场景教学。在国际视野方面，发展国际合作办学,课程设置根据Microsoft和伯克利大学提出的数据科学体系设置。在工程实践方面，用全新的新工科体系进行实践环节设计，形成行业驱动的“一条主线、三个层次、四个平台”工程实践与创新能力培养体系。 </p>
                <h4>授予学位类别</h4>
                <p>
                    学制四年，授工学学士学位。
                </p>
                <h4>方向咨询电话</h4>
                <p>
                    0451-82191525
                </p>
            </div>
            <h2>东北林业大学奥林学院软件开发方向</h2>
            <div class="article-text-box">
                <h4>方向培养目标</h4>
                <p>
                    本方向面向软件产业需求，以立德树人为根本任务，培养德智体美劳全面发展的中国特色社会主义合格建设者和可靠接班人。培养具有扎实的软件工程理论基础、工程能力、良好综合素质和职业道德，具有创新、创业意识，竞争和团队精神，能适应软件工程新技术发展和社会需要，在软件工程领域从事软件研发、软件项目管理和软件运行维护等工作的应用研究型软件工程人才。
                <h4>核心课程</h4>
                <p>
                    Java程序设计，Web开发技术，Web开发框架，软件工程等。
                </p>
                <h4>特色优势</h4>
                <p>
                    建立了校企无缝连接的多元化“1.5+1.5+1”创新人才培养模式及学分置换机制，培养符合产业要求“零适应期”优秀学生。建立校企合作的实习、实训基地，通过工程认识、工程实践、项目管理、毕业实习等环节进行实习、实训。同时，以大学生创新、创业实践活动、科技大赛为补充，突出工程化、系统能力的培养。
                <h4>授予学位类别</h4>
                <p>
                    学制四年，授工学学士学位。
                </p>
                <h4>方向咨询电话</h4>
                <p>
                    0451-82192243
                </p>
            </div>
        </div>

    </div>
</div>


<%@include file="../../../include/footer.jsp" %>
</body>
</html>