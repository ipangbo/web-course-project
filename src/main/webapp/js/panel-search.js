async function postData(url = '', data = {}) {
    // Default options are marked with *
    const response = await fetch(url, {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: JSON.stringify(data) // body data type must match "Content-Type" header
    });
    return response.json(); // parses JSON response into native JavaScript objects
}

$("#search-button").on('click', () => {
    // 清空现有列表
    $("#article-list").children(".mdui-list-item").remove();
    // 收集搜索条件
    let searchKey = $("#search-key").val();
    let category = $("#category-select").val();
    let isSearchTitleOnly = $("#is-search-title-only-checkbox").prop("checked");
    // 发送搜索条件
    postData('api/panel-search', {
        "search-key": searchKey,
        "category": category,
        "is-search-title-only": isSearchTitleOnly
    })
        .then(res => {
            // 返回的内容是[{}, {}]
            res.forEach(item => {

                let listItem = `
        <div class="mdui-list-item" data-aid="${item.id}">
            <label class="mdui-checkbox">
                <input type="checkbox"/>
                <i class="mdui-checkbox-icon"></i>
            </label>
            <div class="mdui-list-item-content">${item.title}</div>
            <select class="mdui-select article-type-select" mdui-select data-select-aid="${item.id}">
                <option value="1" ${item.category === 1 ? "selected" : ""}>综合新闻</option>
                <option value="2" ${item.category === 2 ? "selected" : ""}>党团声音</option>
                <option value="3" ${item.category === 3 ? "selected" : ""}>新媒精选</option>
            </select>
            <a
                    href="contents/news/article?aid=${item.id}"
                    class="mdui-btn mdui-btn-icon mdui-ripple list-control-button"
                    target="_blank"
                    mdui-tooltip="{content: '在前台页面显示'}"
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
                    data-article-index="${item.id}"
                    mdui-tooltip="{content: '删除'}"
            >
                <i class="mdui-icon material-icons">delete_forever</i>
            </button>
            <a
                    href="panel/modnews?aid=${item.id}"
                    class="mdui-btn mdui-btn-icon mdui-ripple list-control-button"
                    target="_blank"
                    mdui-tooltip="{content: '编辑'}"
            >
                <i class="mdui-icon material-icons">mode_edit</i>
            </a>
        </div>`;// html结束
                $("#article-list").prepend(listItem);
            });

            // 为删除按钮绑定删除事件
            $('.delete-button').each( (index, element) => {
                $(element).on('click', () => {
                    // console.log("aid" + $(element).parents('.mdui-list-item').attr('data-aid'))
                    // $(element).parents('.mdui-list-item').remove();
                    // console.log("删除")
                    mdui.confirm("确定要删除吗？", () => {
                        postData('api/delete-news', {
                            aid: $(element).parents('.mdui-list-item').attr('data-aid')
                        })
                            .then(data => {
                                if (data.res === "ok") {
                                    mdui.snackbar({
                                        message: '已删除'
                                    });
                                    $(element).parents('.mdui-list-item').remove();
                                    // Todo: 加入撤回
                                } else {
                                    mdui.alert("出现错误，请联系开发者庞礴");
                                }
                            })
                            .catch(err => {
                                console.log(err);
                            });
                    }, () => {}, {
                        confirmText: "删除",
                        cancelText: "取消"
                    })
                })
            })
        })
        .catch(err => {
            console.log(err);
            mdui.alert("查询失败，请查看panel-search.js和控制台")
        });
    mdui.mutation();
})