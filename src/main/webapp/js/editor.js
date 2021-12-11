$(function () {
    const wangEditor = window.wangEditor; // 全局变量
    const editorConfig = {MENU_CONF: {}};
    editorConfig.placeholder = '请输入内容';
    editorConfig.onChange = (editor) => {
        // 当编辑器选区、内容变化时，即触发
        console.log('content', editor.children)
        console.log('html', editor.getHtml())
    };
    editorConfig.scroll = false // 禁止编辑器滚动

    // 创建编辑器
    const editor = wangEditor.createEditor({
        selector: '#editor-text-area',
        content: window.content1,
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
            excludeKeys: 'fullScreen'
        }
    });

    // 点击空白处 focus 编辑器
    document.getElementById('editor-text-area').addEventListener('click', e => {
        if (e.target.id === 'editor-text-area') {
            editor.blur()
            editor.focus(true) // focus 到末尾
        }
    });

    editorConfig.onChange = (editor) => {
        const content = editor.children
        const contentStr = JSON.stringify(content)
        document.getElementById('textarea-1').innerHTML = contentStr

        const html = editor.getHtml()
        document.getElementById('textarea-2').innerHTML = html
    }

    const editorConfig2 = {MENU_CONF: {}};
    editorConfig2.placeholder = '请输入摘要';
    editorConfig2.onChange = (editor) => {
        // 当编辑器选区、内容变化时，即触发
        console.log('content', editor.children)
        console.log('html', editor.getHtml())
    };
    editorConfig2.scroll = false // 禁止编辑器滚动
    // 创建编辑器
    const abstractEditor = wangEditor.createEditor({
        selector: '#editor-abstract-area',
        content: window.content1,
        config: editorConfig2,
        content: [], // 默认内容，下文有解释
        mode: 'default' // 或者 'simple' ，下文有解释
    });

    var instHelp = new mdui.Dialog('#editor-help-dialog');
    $("#editor-help-button").click(function () {
        instHelp.open()
    })
    $("#editor-help-dialog-ok").click(function () {
        instHelp.close()
    })
    var instSave = new mdui.Dialog('#editor-save-dialog');
    $("#editor-save-button").click(function () {
        $("#save-spinner").hide()
        instSave.open()
    })
    $("#editor-save-dialog-ok").click(function () {
        $("#editor-save-dialog-ok").css("visibility", "hidden")
        $("#editor-save-dialog-cancel").hide()
        $("#save-spinner").show()
    })
    $("#editor-save-dialog-cancel").click(function () {
        instSave.close()
    })
})