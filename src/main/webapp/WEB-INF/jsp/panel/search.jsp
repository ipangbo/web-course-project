<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/12/11
  Time: 19:37
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
    <title>搜索</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
          integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw" crossorigin="anonymous"/>
    <link rel="stylesheet" href="css/panel-control-page.css">
    <style>
        .search-header-box {
            display: flex;
            flex-wrap: wrap;
        }

        #search-box {
            padding: 5px;
            width: 100%;
        }

        .search-condition-box {
            margin-top: 15px;
            margin-left: auto;
        }

        .search-condition-box > * {
            margin-left: 35px;
        }


    </style>
</head>
<body class="
      mdui-appbar-with-toolbar
      mdui-theme-primary-blue-grey
      mdui-drawer-body-left
      mdui-theme-accent-pink
    " id="mdui-title-bar">
<div class="mdui-appbar mdui-appbar-fixed">
    <div class="mdui-toolbar mdui-color-theme">
        <a href="javascript:;" class="mdui-btn mdui-btn-icon" id="drawer-toggle-button"
        ><i class="mdui-icon material-icons">menu</i></a
        >
        <a href="panel" class="mdui-typo-headline">磅礴新闻网管理系统</a>
        <a href="javascript:;" class="mdui-typo-title">搜索</a>
        <div class="mdui-toolbar-spacer"></div>
        <a href="panel?page=search" class="mdui-btn mdui-btn-icon mdui-ripple" id="panel-search-button"><i
                class="mdui-icon material-icons">search</i></a>
    </div>
</div>

<%@ include file="/include/panel-drawer.jsp" %>

<div class="content-box">
    <div class="search-header-box">
        <div class="mdui-textfield" id="search-box">
            <i class="mdui-icon material-icons">search</i>
            <label class="mdui-textfield-label">输入要搜索的内容</label>
            <input class="mdui-textfield-input" id="search-key"></input>
        </div>
        <div class="search-condition-box">
            <select class="mdui-select" id="category-select" mdui-select>
                <option value="0">全部</option>
                <option value="1" selected>新闻网</option>
                <option value="2" disabled>通知公告</option>
                <option value="3" disabled>教师队伍</option>
            </select>
            <label class="mdui-checkbox">
                <input type="checkbox" id="is-search-title-only-checkbox"/>
                <i class="mdui-checkbox-icon"></i>
                仅搜索标题，不搜索正文
            </label>
            <button class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent" id="search-button">搜索</button>
        </div>
    </div>
    <div class="mdui-list" id="article-list"></div>
</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/mdui@1.0.2/dist/js/mdui.min.js"></script>
<script src="js/panel-general.js"></script>
<script src="js/panel-search.js"></script>

</body>

</html>