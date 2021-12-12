var $ = mdui.$;

const wangEditor = window.wangEditor; // 全局变量
const editorConfig = {MENU_CONF: {}};
editorConfig.placeholder = '请输入内容';
editorConfig.onChange = (editor) => {
    // 当编辑器选区、内容变化时，即触发
    console.log('content', editor.children)
    console.log('html', editor.getHtml())
    const content = editor.children
    const contentStr = JSON.stringify(content)
    document.getElementById('textarea-1').innerHTML = contentStr
    const html = editor.getHtml()
    document.getElementById('textarea-2').innerHTML = html
    console.log("文本框：" + document.getElementById('textarea-2').innerText)
};
editorConfig.scroll = false // 禁止编辑器滚动

// 创建编辑器
const editor = wangEditor.createEditor({
    selector: '#editor-text-area',
    config: editorConfig,
    content: [], // 默认内容，下文有解释
    mode: 'default' // 或者 'simple' ，下文有解释
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


const editorConfig2 = {MENU_CONF: {}};
editorConfig2.placeholder = '请输入摘要。请注意，新闻网只能显示约150字，多余会被折叠。';
editorConfig2.onChange = (editor) => {
    console.log('content', editor.children)
    console.log('html', editor.getHtml())
};
editorConfig2.scroll = false // 禁止编辑器滚动
// 创建编辑器
const abstractEditor = wangEditor.createEditor({
    selector: '#editor-abstract-area',
    config: editorConfig2,
    content: [], // 默认内容，下文有解释
    mode: 'simple' // 或者 'simple' ，下文有解释
});

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
$("#editor-save-dialog-ok").on('click', function () {
    if (editor.isEmpty()) {
        instSave.close()
        mdui.alert("当前内容为空，必须写入内容才能提交")
    } else {
        $("#editor-save-dialog-ok").css("visibility", "hidden")
        $("#editor-save-dialog-cancel").hide()
        $("#save-spinner").show()
    }
})
$("#editor-save-dialog-cancel").on('click', function () {
    instSave.close()
})
