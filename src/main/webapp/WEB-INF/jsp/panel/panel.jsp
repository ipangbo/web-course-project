<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/12/11
  Time: 下午 2:59
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
    <title>新闻网管理系统首页</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
          integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw" crossorigin="anonymous"/>
    <link rel="stylesheet" href="css/panel-control-page.css">
    <style>
        .data-card-box {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }

        .data-card {
            margin-top: 20px;
            width: 300px;
            height: 200px;
            border: 1px solid #ddd;
            border-radius: 10px;
            padding: 15px;
        }

        .data-card-title-box {
            display: flex;
            align-items: center;
        }

        .data-card-title-box > i {
            display: inline-block;
            width: 45px;
            height: 45px;
            font-size: 45px;
            line-height: 45px;
        }

        .data-card-title {
            display: inline-block;
            font-size: 25px;
            margin-left: 10px;
        }

        .data-card-data-box {
            font-size: 60px;
            font-weight: 700;
            color: #444;
            text-align: right;
            margin-top: 25px;
            margin-right: 15px;
        }

        .data-card-info-box {
            text-align: right;
            color: #888;
            margin-right: 5px;
            margin-top: 10px;
        }
    </style>
</head>
<body
        class="
      mdui-appbar-with-toolbar
      mdui-theme-primary-blue-grey
      mdui-theme-accent-pink
      mdui-drawer-body-left
    "
        id="mdui-title-bar"
>
<div class="mdui-appbar mdui-appbar-fixed">
    <div class="mdui-toolbar mdui-color-theme">
        <a href="javascript:;" class="mdui-btn mdui-btn-icon" id="drawer-toggle-button"
        ><i class="mdui-icon material-icons">menu</i></a
        >
        <a href="panel" class="mdui-typo-headline">磅礴新闻网管理系统</a>
        <a href="javascript:;" class="mdui-typo-title">主页</a>
        <div class="mdui-toolbar-spacer"></div>
        <a href="." class="mdui-btn mdui-btn-icon mdui-ripple" target="_blank" mdui-tooltip="{content: '回到前台页面'}"><i
                class="mdui-icon material-icons">home</i></a>
        <a href="panel?page=search" class="mdui-btn mdui-btn-icon mdui-ripple" id="panel-search-button" mdui-tooltip="{content: '搜索'}"><i
                class="mdui-icon material-icons">search</i></a>
    </div>
</div>

<%@ include file="/include/panel-drawer.jsp" %>

<div class="content-box">
    <div class="data-card-box">

        <div class="data-card">
            <div class="data-card-title-box">
                <i class="mdui-list-item-icon mdui-icon material-icons"
                >person_add</i
                >
                <span class="data-card-title">教师总数</span>
            </div>
            <div class="data-card-data-box">18</div>
            <div class="data-card-info-box">上次发布时间：2021-12-8 12:30</div>
        </div>
    </div>

    <br>
    <br>
    <br>
    <b style="display: block; padding: 70px; color: #555;">提示：由于只有新闻和公告是动态页面，教师是静态页面，所以只有新闻和公告的数据是真实数据，从数据库中查出</b>
</div>

<script src="https://cdn.jsdelivr.net/npm/mdui@1.0.2/dist/js/mdui.min.js"></script>
<script src="js/panel-general.js"></script>
<script src="js/panel-data.js"></script>
</body>

</html>