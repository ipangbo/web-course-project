<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/12/11
  Time: 19:37
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
    <title>搜索</title>
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
            padding: 10px 25px;
        }

        /* .data-card-box {
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

        .data-card-title-box>i {
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
        } */

        /* 以上是仅登陆界面需要的css，需要被重构 */

         .mdui-list .list-control-button {
            margin-left: 10px;
            color: #666;
        }

        .mdui-list .red-list-control-button:hover {
            color: rgb(197, 6, 6);
        }

        .search-header-box {
            display: flex;
            align-items: center;
        }

        #search-box {
            flex: 8;
        }

        .search-condition-box {
            flex: 2;
            text-align: center;
            margin-top: 15px;
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
        <a href="javascript:;" class="mdui-btn mdui-btn-icon" id="drawer-toggle-button"><i
                class="mdui-icon material-icons">menu</i></a>
        <a href="javascript:;" class="mdui-typo-headline">磅礴新闻网管理系统</a>
        <a href="javascript:;" class="mdui-typo-title">搜索</a>
        <div class="mdui-toolbar-spacer"></div>
    </div>
</div>

<%@ include file="/include/panel-drawer.jsp"%>

<div class="content-box">
    <div class="search-header-box">
        <div class="mdui-textfield mdui-textfield-floating-label" id="search-box">
            <i class="mdui-icon material-icons">search</i>
            <label class="mdui-textfield-label">输入要搜索的内容</label>
            <textarea class="mdui-textfield-input"></textarea>
        </div>
        <div class="search-condition-box">
            <label class="mdui-checkbox">
                <input type="checkbox" checked />
                <i class="mdui-checkbox-icon"></i>
                仅搜索标题，不搜索正文
            </label>
        </div>
    </div>
    <div class="search-result-box">
        <div class="mdui-list">
            <label class="mdui-list-item">
                <div class="mdui-checkbox">
                    <input type="checkbox" />
                    <i class="mdui-checkbox-icon"></i>
                </div>
                <div class="mdui-list-item-content">最新的文章</div>
                <a href="contents/news/article?aid=1"
                   class="mdui-btn mdui-btn-icon mdui-ripple list-control-button">
                    <i class="mdui-icon material-icons">find_in_page</i>
                </a>
                <button class="
                      mdui-btn mdui-btn-icon mdui-ripple
                      list-control-button
                      red-list-control-button
                      delete-button
                    " data-article-index="1">
                    <i class="mdui-icon material-icons">delete_forever</i>
                </button>
                <a href="panel/modnews?aid=1" class="mdui-btn mdui-btn-icon mdui-ripple list-control-button">
                    <i class="mdui-icon material-icons">mode_edit</i>
                </a>
            </label>
            <label class="mdui-list-item">
                <div class="mdui-checkbox">
                    <input type="checkbox" />
                    <i class="mdui-checkbox-icon"></i>
                </div>
                <div class="mdui-list-item-content">最新的文章</div>
                <a href="contents/news/article?aid=1"
                   class="mdui-btn mdui-btn-icon mdui-ripple list-control-button">
                    <i class="mdui-icon material-icons">find_in_page</i>
                </a>
                <button class="
                      mdui-btn mdui-btn-icon mdui-ripple
                      list-control-button
                      red-list-control-button
                      delete-button
                    " data-article-index="1">
                    <i class="mdui-icon material-icons">delete_forever</i>
                </button>
                <a href="panel/modnews?aid=1" class="mdui-btn mdui-btn-icon mdui-ripple list-control-button">
                    <i class="mdui-icon material-icons">mode_edit</i>
                </a>
            </label>
            <label class="mdui-list-item">
                <div class="mdui-checkbox">
                    <input type="checkbox" />
                    <i class="mdui-checkbox-icon"></i>
                </div>
                <div class="mdui-list-item-content">最新的文章</div>
                <a href="contents/news/article?aid=1"
                   class="mdui-btn mdui-btn-icon mdui-ripple list-control-button">
                    <i class="mdui-icon material-icons">find_in_page</i>
                </a>
                <button class="
                      mdui-btn mdui-btn-icon mdui-ripple
                      list-control-button
                      red-list-control-button
                      delete-button
                    " data-article-index="1">
                    <i class="mdui-icon material-icons">delete_forever</i>
                </button>
                <a href="panel/modnews?aid=1" class="mdui-btn mdui-btn-icon mdui-ripple list-control-button">
                    <i class="mdui-icon material-icons">mode_edit</i>
                </a>
            </label>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/mdui@1.0.2/dist/js/mdui.min.js"></script>
<script src="js/panel-general.js"></script>
<script>
    $(".delete-button").on("click", () => {
        mdui.confirm(
            "你确认要删除这篇文章吗",
            "警告",
            function () {
                mdui.alert("点击了确认按钮");
                // fetch(删除的接口)
            },
            () => {
            },
            {
                confirmText: "确认",
                cancelText: "取消",
            }
        );
    });
</script>
</body>

</html>