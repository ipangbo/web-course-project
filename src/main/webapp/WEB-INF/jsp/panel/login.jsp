<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/12/11
  Time: 下午 2:19
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
    <title>管理员登录</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
          integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw" crossorigin="anonymous"/>
    <style>
        html {
            height: 100%;
        }

        body.bg {
            background-color: #fafafa;
        }

        #login-card {
            width: 500px;
            margin: 150px auto 0;
        }

        #login-button-box {
            display: flex;
            justify-content: flex-end;
            margin-bottom: 20px;
        }

        #msg-model-login {
            color: #8f1919;
            line-height: 36px;
            margin-right: 20px;
        }
    </style>
</head>
<body class="bg mdui-appbar-with-toolbar mdui-theme-primary-blue-grey mdui-theme-accent-pink " id="mdui-title-bar">

<div class="mdui-appbar mdui-appbar-fixed">
    <div class="mdui-toolbar mdui-color-theme">
        <a href="javascript:;" class="mdui-btn mdui-btn-icon" id="drawer-toggle-button"><i class="mdui-icon material-icons">menu</i></a>
        <a href="javascript:;" class="mdui-typo-headline">磅礴新闻网管理系统</a>
        <a href="javascript:;" class="mdui-typo-title">登录</a>
        <div class="mdui-toolbar-spacer"></div>
    </div>
</div>

<div class="mdui-card" id="login-card">
    <!-- 卡片头部，包含头像、标题、副标题 -->
    <div class="mdui-card-header">
        <img class="mdui-card-header-avatar"
             src="https://tc.qn.ipangbo.cn/image/mdui.jpg" />
        <div class="mdui-card-header-title">管理员登录</div>
        <div class="mdui-card-header-subtitle">磅礴新闻网管理系统</div>
    </div>



    <form action="panel/login" method="post">
        <!-- 卡片的内容 -->
        <div class="mdui-card-content">
            <div class="mdui-textfield">
                <i class="mdui-icon material-icons">account_circle</i>
                <label class="mdui-textfield-label">User name</label>
                <input class="mdui-textfield-input" type="text" name="uname"/>
            </div>
            <div class="mdui-textfield">
                <i class="mdui-icon material-icons">lock</i>
                <label class="mdui-textfield-label">Password</label>
                <input class="mdui-textfield-input" type="password" name="password"/>
            </div>
            <br>
        </div>

        <!-- 卡片的按钮 -->
        <div class="mdui-card-actions" id="login-button-box">
            <span id="msg-model-login">${msg.msg}</span>
            <a href="." class="mdui-btn mdui-ripple" id="back-button">返回前台网站</a>
            <input type="submit" class="mdui-btn mdui-ripple mdui-btn-raised mdui-color-theme-accent" value="登录">
        </div>
    </form>

    <button class="mdui-fab mdui-fab-fixed mdui-color-blue-grey mdui-ripple" id="login-help-button">?</button>

</div>



<script src="https://cdn.jsdelivr.net/npm/mdui@1.0.2/dist/js/mdui.min.js"></script>
<script>
    var $ = mdui.$;
    $("#drawer-toggle-button").on("click", () => {
        mdui.alert("请先登录");
    });
    $("#login-help-button").on("click", () => {
        mdui.alert("按照要求，用户名和密码均为admin。请尝试输入错误的密码，登录界面带有消息对象回显功能");
    })
</script>
</body>

</html>