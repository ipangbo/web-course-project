<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/12/11
  Time: 下午 2:58
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
    <title>新闻管理</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
          integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw" crossorigin="anonymous"/>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        #drawer-inner-card {
            box-shadow: none;
            border-bottom: 1px solid #ccc;
        }

        .content-box {
            padding: 35px 25px;
        }

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

        .mdui-list .list-control-button {
            margin-left: 10px;
            color: #666;
        }

        .mdui-list .red-list-control-button:hover {
            color: rgb(197, 6, 6);
        }

    </style>
</head>
<body
        class="
      mdui-appbar-with-toolbar
      mdui-theme-primary-blue-grey
      mdui-drawer-body-left
      mdui-theme-accent-pink
    "
        id="mdui-title-bar"
>
<div class="mdui-appbar mdui-appbar-fixed">
    <div class="mdui-toolbar mdui-color-theme">
        <a
                href="javascript:;"
                class="mdui-btn mdui-btn-icon"
                id="drawer-toggle-button"
        ><i class="mdui-icon material-icons">menu</i></a
        >
        <a href="javascript:;" class="mdui-typo-headline">磅礴新闻网管理系统</a>
        <a href="javascript:;" class="mdui-typo-title">新闻管理</a>
        <div class="mdui-toolbar-spacer"></div>
    </div>
</div>

<%@ include file="/include/panel-drawer.jsp" %>

<div class="content-box">
    <div class="tools-bar">
        <a
                href="panel/addnews"
                class="mdui-btn mdui-ripple mdui-color-theme-accent"
        >
            添加新闻
        </a>
    </div>
    <div class="mdui-list" id="article-list">
        <div class="mdui-list-item">
            <label class="mdui-checkbox">
                <input type="checkbox"/>
                <i class="mdui-checkbox-icon"></i>
            </label>
            <div class="mdui-list-item-content">为了测试，在初始的DOM中保留了这一项，将在生产环境移除</div>
            <select class="mdui-select article-type-select" mdui-select>
                <option value="1">综合新闻</option>
                <option value="2">党团声音</option>
                <option value="3">新媒精选</option>
            </select>
            <a
                    href="contents/news/article?aid=1"
                    class="mdui-btn mdui-btn-icon mdui-ripple list-control-button"
            >
                <i class="mdui-icon material-icons">find_in_page</i>
            </a>
            <button
                    class="
              mdui-btn mdui-btn-icon mdui-ripple
              list-control-button
              red-list-control-button
              delete-button
            "
                    data-article-index="1"
            >
                <i class="mdui-icon material-icons">delete_forever</i>
            </button>
            <a
                    href="panel/modnews?aid=1"
                    class="mdui-btn mdui-btn-icon mdui-ripple list-control-button"
            >
                <i class="mdui-icon material-icons">mode_edit</i>
            </a>
        </div>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/mdui@1.0.2/dist/js/mdui.min.js"></script>
<script src="js/panel-general.js"></script>
<script src="js/newscontrol.js"></script>
</body>

</html>