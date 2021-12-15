let $ = mdui.$;
let mainDraw = new mdui.Drawer("#main-drawer");
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

$("#setting-button").on('click', () => {
    mdui.alert("由于只有一个admin用户，所以不用修改账户。未来将加入修改密码功能。")
})