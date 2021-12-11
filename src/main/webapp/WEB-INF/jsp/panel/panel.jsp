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
    </style>
</head>
<body
        class="
      mdui-appbar-with-toolbar
      mdui-theme-primary-blue-grey
      mdui-drawer-body-left
    "
        id="mdui-title-bar"
>
<div class="mdui-appbar mdui-appbar-fixed">
    <div class="mdui-toolbar mdui-color-theme">
        <a href="javascript:;" class="mdui-btn mdui-btn-icon" id="drawer-toggle-button"
        ><i class="mdui-icon material-icons">menu</i></a
        >
        <a href="javascript:;" class="mdui-typo-headline">磅礴新闻网管理系统</a>
        <a href="javascript:;" class="mdui-typo-title">主页</a>
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
    <div class="data-card-box">
        <div class="data-card">
            <div class="data-card-title-box">
                <i class="mdui-list-item-icon mdui-icon material-icons"
                >fiber_new</i
                >
                <span class="data-card-title">新闻总数</span>
            </div>
            <div class="data-card-data-box">23</div>
            <div class="data-card-info-box">上次发布时间：2021-12-8 12:30</div>
        </div>
        <div class="data-card">
            <div class="data-card-title-box">
                <i class="mdui-list-item-icon mdui-icon material-icons"
                >notifications</i
                >
                <span class="data-card-title">公告总数</span>
            </div>
            <div class="data-card-data-box">99</div>
            <div class="data-card-info-box">上次发布时间：2021-12-8 12:30</div>
        </div>
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
</script>
</body>

</html>