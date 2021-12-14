<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/12/11
  Time: 下午 2:58
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
    <title>教师管理</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
          integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw" crossorigin="anonymous"/>
    <link rel="stylesheet" href="css/panel-control-page.css">

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
        <a href="javascript:;" class="mdui-btn mdui-btn-icon" id="drawer-toggle-button"
        ><i class="mdui-icon material-icons">menu</i></a
        >
        <a href="panel" class="mdui-typo-headline">磅礴新闻网管理系统</a>
        <a href="javascript:;" class="mdui-typo-title">教师管理</a>
        <div class="mdui-toolbar-spacer"></div>
        <a href="panel?page=search" class="mdui-btn mdui-btn-icon mdui-ripple" id="panel-search-button"><i
                class="mdui-icon material-icons">search</i></a>
    </div>
</div>

<%@ include file="/include/panel-drawer.jsp" %>


<div class="content-box">
    <div class="tools-bar">
        <a
                href="panel/addnews"
                class="mdui-btn mdui-ripple mdui-color-theme-accent"
        >
            添加教师
        </a>
    </div>
    <div class="mdui-list">
        <label class="mdui-list-item">
            <div class="mdui-checkbox">
                <input type="checkbox"/>
                <i class="mdui-checkbox-icon"></i>
            </div>
            <div class="mdui-list-item-content">请注意</div>
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
                <input type="checkbox"/>
                <i class="mdui-checkbox-icon"></i>
            </div>
            <div class="mdui-list-item-content">只有新闻管理界面有实质功能</div>
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
                <input type="checkbox"/>
                <i class="mdui-checkbox-icon"></i>
            </div>
            <div class="mdui-list-item-content">本页面仅作演示</div>
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