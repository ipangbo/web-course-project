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

<div class="mdui-drawer" id="main-drawer">
    <div class="mdui-card" id="drawer-inner-card">
        <div class="mdui-card-media">
            <img
                    src="https://cdn.w3cbus.com/mdui/docs~1/static/1ca4b7b2b4b2f2352aeb.jpg"
            />
            <div class="mdui-card-media-covered">
                <div class="mdui-card-primary">
                    <div class="mdui-card-primary-title">管理员</div>
                    <div class="mdui-card-primary-subtitle">admin</div>
                </div>
            </div>
        </div>
        <div class="mdui-card-actions">
            <button
                    class="mdui-btn mdui-ripple draw-card-right-button"
                    id="setting-button"
            >
                修改账户
            </button>
            <button class="mdui-btn mdui-ripple" id="logout-button">登出</button>
        </div>
    </div>
    <ul class="mdui-list">
        <li class="mdui-list-item mdui-ripple">
            <div class="mdui-list-item-content">主页</div>
            <i class="mdui-list-item-icon mdui-icon material-icons">home</i>
        </li>
        <li class="mdui-list-item mdui-ripple">
            <div class="mdui-list-item-content">新闻管理</div>
            <i class="mdui-list-item-icon mdui-icon material-icons">fiber_new</i>
        </li>
        <li class="mdui-list-item mdui-ripple">
            <div class="mdui-list-item-content">公告管理</div>
            <i class="mdui-list-item-icon mdui-icon material-icons"
            >notifications</i
            >
        </li>
        <li class="mdui-list-item mdui-ripple">
            <div class="mdui-list-item-content">教师管理</div>
            <i class="mdui-list-item-icon mdui-icon material-icons">person_add</i>
        </li>
    </ul>
</div>

<div class="content-box">
    <div class="tools-bar">
        <a
                href="panel/addnews"
                class="mdui-btn mdui-ripple mdui-color-theme-accent"
        >
            添加新闻
        </a>
    </div>
    <div class="mdui-list">
        <label class="mdui-list-item">
            <div class="mdui-checkbox">
                <input type="checkbox" />
                <i class="mdui-checkbox-icon"></i>
            </div>
            <div class="mdui-list-item-content">最新的文章</div>
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
        </label>
        <label class="mdui-list-item">
            <div class="mdui-checkbox">
                <input type="checkbox" />
                <i class="mdui-checkbox-icon"></i>
            </div>
            <div class="mdui-list-item-content">最新的文章</div>
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
        </label>
        <label class="mdui-list-item">
            <div class="mdui-checkbox">
                <input type="checkbox" />
                <i class="mdui-checkbox-icon"></i>
            </div>
            <div class="mdui-list-item-content">最新的文章</div>
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
        </label>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/mdui@1.0.2/dist/js/mdui.min.js"></script>
<script>
    var $ = mdui.$;
    var mainDraw = new mdui.Drawer("#main-drawer");
    $("#drawer-toggle-button").on("click", () => {
        mainDraw.toggle();
    });
    $("#logout-button").on('click', () => {
        mdui.confirm(
            "你确认要退出账户吗",
            "警告",
            () => {
                fetch("api/user-transaction?action=logout")
                    .then((resp) => resp.text())
                    .then(res => {
                        // console.log("成功")
                        location.reload()
                    })
                    .catch(error => {
                        console.log(error)
                    })
            },
            () => {
            },
            {
                confirmText: "确认",
                cancelText: "取消",
            }
        )
    })
    $(".delete-button").on("click", () => {
        mdui.confirm(
            "你确认要删除这篇文章吗",
            "警告",
            function () {
                mdui.alert("点击了确认按钮");
                // fetch(删除的接口)
            },
            () => {},
            {
                confirmText: "确认",
                cancelText: "取消",
            }
        );
    });
</script>
</body>

</html>