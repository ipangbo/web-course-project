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