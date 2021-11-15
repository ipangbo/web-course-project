<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/11/15
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-Hans-CN">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:url var="base" value="/"></c:url>
    <base href="${base}">
    <title>编辑文章</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
          integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw" crossorigin="anonymous"/>
    <link href="https://cdn.jsdelivr.net/npm/@wangeditor/editor@latest/dist/css/style.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/js/mdui.min.js"
            integrity="sha384-gCMZcshYKOGRX9r6wbDrvF+TcCCswSHFucUzUPwka+Gr+uHgjlYvkABr95TCOz3A"
            crossorigin="anonymous"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" href="css/editor.css">

</head>

<body class=".mdui-appbar-with-toolbar mdui-theme-primary-blue-grey" id="mdui-title-bar">
<div id="box">
    <div class="mdui-appbar">
        <div class="mdui-toolbar mdui-color-theme">
            <a href="javascript:;" class="mdui-btn mdui-btn-icon"><i class="mdui-icon material-icons">menu</i></a>
            <a href="javascript:;" class="mdui-typo-headline">磅礴新闻网管理系统</a>
            <a href="javascript:;" class="mdui-typo-title">编辑文章</a>
            <div class="mdui-toolbar-spacer"></div>
            <a href="javascript:;" class="mdui-btn mdui-btn-icon mdui-ripple" id="editor-save-button"><i
                    class="mdui-icon material-icons">save</i></a>
        </div>
    </div>

    <div id="editor-toolbar-container">
        <div id="toolbar-container"></div>
    </div>
    <div id="content">
        <div id="editor-container">
            <div id="title-container">
                <input type="text" name="article-title" placeholder="请输入标题"><br>
                <input type="text" name="article-author" id="article-author" placeholder="作者">
            </div>
            <div id="editor-text-area"></div>
        </div>
    </div>
    <!-- 1是json -->
    <textarea id="textarea-1" class="fake-textarea"></textarea>
    <!-- 2是html -->
    <textarea id="textarea-2" class="fake-textarea"></textarea>
    <button class="mdui-fab mdui-fab-fixed mdui-color-blue-grey mdui-ripple" id="editor-help-button">?</button>

    <div class="mdui-dialog" id="editor-help-dialog">
        <div class="mdui-dialog-title">帮助</div>
        <div class="mdui-dialog-content">
            <p>
                你可以使用编辑器来创建或者编辑文章。
            </p>
            <p>
                在最终呈现的网页中默认带有首行缩进等css样式。你只需要在这里编辑正文内容并定义必须的样式即可，无需关心新闻网最终样式。
            </p>
            <p>
                你只能上传网络图片
            </p>
            <p>
                本编辑器基于wangEditor项目，版本V5
            </p>
        </div>
        <div class="mdui-dialog-actions">
            <button class="mdui-btn mdui-ripple" id="editor-help-dialog-ok">好</button>
        </div>
    </div>
    <div class="mdui-dialog" id="editor-save-dialog">
        <div class="mdui-dialog-title">保存</div>
        <div class="mdui-dialog-content">点击确认按钮保存，如果你在修改文章，你将丢失之前的版本</div>
        <div class="mdui-dialog-actions">
            <button class="mdui-btn mdui-ripple" id="editor-save-dialog-cancel">取消</button>
            <button class="mdui-btn mdui-ripple" id="editor-save-dialog-ok">确认</button>
            <div class="mdui-spinner" id="save-spinner"></div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@wangeditor/editor@latest/dist/index.min.js"></script>
    <script src="js/editor.js"></script>
</div>
</body>

</html>