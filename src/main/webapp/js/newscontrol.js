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

fetch("api/query-all-news")
    .then(resp => resp.json())
    .then(res => {
        res.forEach((item) => {
            //let listItem = `<div class="mdui-list-item"><label class="mdui-checkbox"><input type="checkbox"/><i class="mdui-checkbox-icon"></i></label><div class="mdui-list-item-content">${item.title}</div><select class="mdui-select article-type-select"mdui-select><option value="1">综合新闻</option><option value="2">党团声音</option><option value="3">新媒精选</option></select><a href="contents/news/article?aid=${item.id}"class="mdui-btn mdui-btn-icon mdui-ripple list-control-button"><i class="mdui-icon material-icons">find_in_page</i></a><button class="mdui-btn mdui-btn-icon mdui-ripple list-control-button red-list-control-button delete-button"data-article-index="${item.id}"><i class="mdui-icon material-icons">delete_forever</i></button><a href="panel/modnews?aid=${item.id}"class="mdui-btn mdui-btn-icon mdui-ripple list-control-button"><i class="mdui-icon material-icons">mode_edit</i></a></div>`
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
            >
                <i class="mdui-icon material-icons">delete_forever</i>
            </button>
            <a
                    href="panel/modnews?aid=${item.id}"
                    class="mdui-btn mdui-btn-icon mdui-ripple list-control-button"
            >
                <i class="mdui-icon material-icons">mode_edit</i>
            </a>
        </div>`;// html结束
            $("#article-list").prepend(listItem);
        })
        mdui.mutation()
        $(".article-type-select").each( (index, element) => {
            $(element).on('change', () => {
                // console.log("aid" + $(element).attr('data-select-aid'))
                // console.log("newval" + $(element).val())

                postData('api/modify-news-category', {
                    aid: $(element).attr('data-select-aid'),
                    newcategory: $(element).val()
                })
                    .then(data => {
                        if (data.res === "ok") {
                            mdui.snackbar({
                                message: '类别已更改'
                            });
                        } else {
                            mdui.alert("出现错误，请联系开发者庞礴");
                        }
                    })
                    .catch(err => {
                        console.log(err);
                    });
            })
        })
        $('.delete-button').each( (index, element) => {
            $(element).on('change', () => {
                // console.log("aid" + $(element).attr('data-select-aid'))

                postData('api/delete-news', {
                    aid: $(element).attr('data-select-aid')
                })
                    .then(data => {
                        if (data.res === "ok") {
                            mdui.snackbar({
                                message: '已删除'
                            });

                        } else {
                            mdui.alert("出现错误，请联系开发者庞礴");
                        }
                    })
                    .catch(err => {
                        console.log(err);
                    });
            })
        })
    })
    .catch(err => {
        console.log(err)
    })

