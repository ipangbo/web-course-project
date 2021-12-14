// 回显正文
let echoContent = [];
let echoAbstract = [];
let editor = null;
let abstractEditor = null;
// console.log($('#editor-text-area').attr('data-aid'))
let aid = $('#editor-text-area').attr('data-aid')
fetch(`api/get-echo-data?aid=${aid}`)
    .then(resp => resp.json())
    .then(res => {
        const wangEditor = window.wangEditor; // 全局变量
        // 正文编辑器的config
        const editorConfig = {MENU_CONF: {}};
        editorConfig.placeholder = '请输入内容';
        editorConfig.scroll = false // 禁止编辑器滚动
        // 已经废弃，在点击确定按钮时同步
        // editorConfig.onChange = (editor) => {
        //     // 当编辑器选区、内容变化时，即触发
        //     const content = editor.children
        //     const contentStr = JSON.stringify(content)
        //     const html = editor.getHtml()
        //     document.getElementById('textarea-1').innerHTML = contentStr
        //     document.getElementById('textarea-2').innerHTML = html
        //     // console.log('content', editor.children)
        //     // console.log('html', editor.getHtml())
        //     // console.log("文本框：" + document.getElementById('textarea-2').innerText)
        // };
        // 摘要编辑器的config
        const editorConfig2 = {MENU_CONF: {}};
        editorConfig2.placeholder = '请输入摘要。请注意，新闻网只能显示约150字，多余会被折叠。';
        editorConfig2.scroll = false // 禁止编辑器滚动
        // 已经废弃，在点击确定按钮时同步
        // editorConfig2.onChange = (editor) => {
        //     // console.log('content', editor.children)
        //     // console.log('html', editor.getHtml())
        //     const abstractContent = editor.children
        //     const abstractJSON = JSON.stringify(abstractContent)
        //     const abstractHTML = editor.getHtml()
        //     document.getElementById('textarea-3').innerHTML = abstractJSON
        //     document.getElementById('textarea-4').innerHTML = abstractHTML
        // };

        // 回显部分
        // console.log(res[0])
        echoContent = JSON.parse(res[0])
        echoAbstract = JSON.parse(res[1])
        // 创建正文编辑器
        const editor = wangEditor.createEditor({
            selector: '#editor-text-area',
            config: editorConfig,
            content: echoContent, // 默认内容，下文有解释
            mode: 'default' // 或者 'simple' ，下文有解释
        });
        // 创建摘要编辑器
        const abstractEditor = wangEditor.createEditor({
            selector: '#editor-abstract-area',
            config: editorConfig2,
            content: echoAbstract, // 默认内容，下文有解释
            mode: 'simple' // 或者 'simple' ，下文有解释
        });

        // 创建工具栏
        const toolbar = wangEditor.createToolbar({
            editor,
            selector: '#toolbar-container',
            mode: 'default', // 或者 'simple' ，下文有解释
            config: {
                excludeKeys: ['fullScreen', 'uploadImage']
            }
        });

        // 点击空白处 focus 编辑器
        document.getElementById('editor-text-area').addEventListener('click', e => {
            if (e.target.id === 'editor-text-area') {
                editor.blur()
                editor.focus(true) // focus 到末尾
            }
        });

        // 向服务器上传数据
        $("#editor-save-dialog-ok").on('click', function () {
            if (editor.isEmpty() || $("input[name=article-title]").val() === "" || $("input[name=article-author]").val() === "") {
                instSave.close()
                mdui.alert("当前标题/发布单位/内容为空，必须写入内容才能提交")
            } else {
                // 再保障一次编辑器内容和隐藏文本框一致
                // 否则仅更改标题不进入正文编辑区域也会引发bug
                const content = editor.children
                const contentStr = JSON.stringify(content)
                const html = editor.getHtml()
                document.getElementById('textarea-1').innerHTML = contentStr
                document.getElementById('textarea-2').innerHTML = html
                const abstractContent = abstractEditor.children
                const abstractJSON = JSON.stringify(abstractContent)
                const abstractHTML = abstractEditor.getHtml()
                document.getElementById('textarea-3').innerHTML = abstractJSON
                document.getElementById('textarea-4').innerHTML = abstractHTML

                $("#editor-save-dialog-ok").css("visibility", "hidden")
                $("#editor-save-dialog-cancel").hide()
                $("#save-spinner").show()

                // 以下是发送给EditNewsServlet的逻辑
                let articleTitle = $("input[name=article-title]").val()
                let articleAuthor = $("input[name=article-author]").val()
                let articleContentJSON = $("#textarea-1").val()
                let articleContentHTML = $("#textarea-2").val()
                let articleAbstractJSON = $("#textarea-3").val()
                let articleAbstractHTML = $("#textarea-4").val()

                // console.log(articleAbstractHTML)
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

                postData('panel/modnews', {
                    "aid": aid,
                    "article-title": articleTitle,
                    "article-author": articleAuthor,
                    "article-content-html": articleContentHTML,
                    "article-content-json": articleContentJSON,
                    "article-abstract-html": articleAbstractHTML,
                    "article-abstract-json": articleAbstractJSON
                })
                    .then(data => {
                        if (data.res === "ok") {
                            location.replace("./panel?page=news")
                        } else {
                            mdui.alert("出现错误，请联系开发者庞礴");
                        }
                    })
                    .catch(err => {
                        console.log(err);
                    });
            }
        })
    })
    .catch(err => {
        console.log(err)
    })


var instHelp = new mdui.Dialog('#editor-help-dialog');
$("#editor-help-button").on('click', function () {
    instHelp.open()
})
$("#editor-help-dialog-ok").on('click', function () {
    instHelp.close()
})
var instSave = new mdui.Dialog('#editor-save-dialog');
$("#editor-save-button").on('click', function () {
    $("#save-spinner").hide()
    instSave.open()
})

var saveDialog = new mdui.Dialog("#editor-save-dialog", {model: true})
$("#editor-save-dialog-cancel").on('click', function () {
    instSave.close()
})
