<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/12/11
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
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
        <a href="panel?page=home">
            <li class="mdui-list-item mdui-ripple">
                <div class="mdui-list-item-content">主页</div>
                <i class="mdui-list-item-icon mdui-icon material-icons">home</i>
            </li>
        </a>
        <a href="panel?page=news">
            <li class="mdui-list-item mdui-ripple">
                <div class="mdui-list-item-content">新闻管理</div>
                <i class="mdui-list-item-icon mdui-icon material-icons">fiber_new</i>
            </li>
        </a>
        <a href="panel?page=notice">
            <li class="mdui-list-item mdui-ripple">
                <div class="mdui-list-item-content">公告管理</div>
                <i class="mdui-list-item-icon mdui-icon material-icons"
                >notifications</i
                >
            </li>
        </a>
        <a href="panel?page=teachers">
            <li class="mdui-list-item mdui-ripple">
                <div class="mdui-list-item-content">教师管理</div>
                <i class="mdui-list-item-icon mdui-icon material-icons">person_add</i>
            </li>
        </a>
        <a href="panel?page=search">
            <li class="mdui-list-item mdui-ripple">
                <div class="mdui-list-item-content">搜索</div>
                <i class="mdui-list-item-icon mdui-icon material-icons">search</i>
            </li>
        </a>
    </ul>
</div>