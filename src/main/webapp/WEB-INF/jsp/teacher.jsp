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

    <%--    调试用，功能尚未完全开发--%>
    <c:if test="${tid == 1}">
        <c:set var="tname" value="王波讲师"> </c:set>
        <c:set var="timg" value="https://tc.qn.ipangbo.cn/image/wb.jpg"> </c:set>
        <c:set var="tintro" value="王波，讲师，硕士。主要研究方向：计算数学，软件开发。发表学术论文3篇。"> </c:set>
        <c:set var="temail" value="iwangbo@ipangbo.cn"> </c:set>

    </c:if>
    <c:if test="${tid == 2}">
        <c:set var="tname" value="董素宇讲师"> </c:set>
        <c:set var="timg"
               value="https://icec.nefu.edu.cn/__local/1/3F/53/080C34477886766CDF935DCF4C1_EA2C9277_C142.png"> </c:set>
        <c:set var="tintro"
               value="董素宇，工学博士，讲师。西安大略大学访问学者。主要研究方向：多模态医学图像分析与人工智能技术。在领域顶级或重要期刊和国际会议（Medical Image Analysis、IEEE Transactions on Medical Imaging，IEEE Transactions on Biomedical Engineering，MICCAI等）上发表论文20余篇。主持中国博士后科学基金会面上项目和中央高校项目共三项。参与国家自然科学基金项和国家重点研发计划子课题。获国家发明专利3项。2017 年度 CCCV “心血管OCT易损斑块识别”人工智能专题竞赛一等奖 (冠军)。"> </c:set>
        <c:set var="temail" value="dongsuyu@nefu.edu.cn"> </c:set>
    </c:if>

    <title>教师详情</title>
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
            教师队伍
        </div>
    </div>
</div>
<div class="pos-bar">
    <div class="core">
        <div class="pos">
            <i class="mdui-icon material-icons">local_offer</i>
            您现在的位置：<a href="index.jsp">首页</a> >> <a href="contents/teachers">教师队伍</a> >> 教师详情
        </div>

    </div>
</div>
<div class="content-box">
    <div class="core">
        <%@ include file="/include/sidebar/teachers-sidebar.jsp" %>
        <div class="article-content-box">
            <div class="article-title-box">
                <h2>
                    ${tname}
                </h2>
            </div>
            <div class="article-text-box">
                <img src="${timg}" alt="教师照片" class="teacher-article-img">
                <p>
                    ${tintro}
                </p>
                <a href="mailto:${temail}" class="mdui-chip" id="email-chip">
                    <span class="mdui-chip-icon mdui-color-blue-grey">
                        <i class="mdui-icon material-icons">mail</i>
                    </span>
                    <span class="mdui-chip-title">${temail}</span>
                </a>
            </div>
        </div>
    </div>
</div>


<%@include file="../../include/footer.jsp" %>
</body>
</html>