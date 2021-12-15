<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/12/9
  Time: 10:44
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
    <title>专业介绍</title>
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
            专业介绍
        </div>
    </div>
</div>
<div class="pos-bar">
    <div class="core">
        <div class="pos">
            <i class="mdui-icon material-icons">local_offer</i>
            您现在的位置：<a href="index.jsp">首页</a> >> 专业介绍
        </div>

    </div>
</div>
<div class="content-box">
    <div class="core">
        <%@ include file="/include/sidebar/major-sidebar.jsp"%>
        <div class="article-box">
            <h2>东北林业大学计算机科学与技术专业</h2>
            <div class="article-text-box">
                <h4>专业概况</h4>
                <p>
                    计算机科学与技术系始建于1988年的微机应用专业。1995年在原专业基础上建立了“计算机科学与技术系”。2000年申报成功了“计算机应用技术”硕士点。“十一五”期间计算机专业被批准为黑龙江省重点专业建设点和东北林业大学优势专业，2011年通过了省教育厅专家组对省重点专业的验收工作。同年又再次被批准为黑龙江省“十二五”重点专业建设点。2015年计算机科学与技术专业成为教育部专业综合改革试点专业。2019年评为黑龙江省一流专业建设点，2020年评为国家级一流本科专业建设点，2019年通过工程教育专业认证。
                </p>
                <img src="https://tc.qn.ipangbo.cn/image/intro.png" alt="专业介绍图片">
                <h4>培养目标</h4>
                <p>
                  专业培养具有良好的道德与修养，遵守法律法规，具有社会和环境意识，掌握数学与自然科学基础知识以及与计算系统相关的基本理论、基本知识、基本技能和基本方法，具备包括计算思维在内的科学思维能力，设计计算解决方案、实现基于计算原理的系统的能力，能清晰表达，在团队中有效发挥作用，综合素质良好，能通过继续教育或其他的终身学习途径拓展自己的能力，了解和紧跟学科专业发展，在计算系统研究、开发、部署与应用等相关领域具有就业竞争力的高素质IT技术人才。
                </p>
                <h4>核心课程</h4>
                <p>
                    数字逻辑设计、计算机组成原理、数据结构与算法、操作系统、编译原理、软件工程、数据库系统、计算机网络、计算机系统结构等。
                </p>
                <h4>特色优势</h4>
                <p>
                    师资力量雄厚，近40%教师有国外留学经历，具备国际化视野培养学生能力。拥有完善的实验教学条件，拥有1个国家林业和草原局重点实验室，2个黑龙江省工程中心，校企共建实习基地2个；学生科研、竞赛氛围浓厚，近三年来学生参与的学科竞赛取得丰硕成果。
                </p>
                <h4>授予学位类别</h4>
                <p>
                    学制四年，授工学学士学位。
                </p>
                <h4>专业咨询电话</h4>
                <p>
                    0451-82191523
                </p>
            </div>
        </div>
    </div>
</div>


<%@include file="../../../include/footer.jsp" %>
</body>
</html>