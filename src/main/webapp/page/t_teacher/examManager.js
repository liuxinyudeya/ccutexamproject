layui.use(['form', 'layer', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;
    var paperid;

    $.ajax({
        type: 'POST',
        url: "http://localhost:8080/demo_war_exploded/T_PaperManager_Controller/isinitpaper.action?courseid=" + $("#courseno_hiden").val(),
        success: function (res) {
            $(".addPaperButton").removeClass('layui-hide');
            if (res != null) {
                $(".addPaperButton").addClass('layui-hide');
            }


        }
    })

    // 试题列表
    var tableIns = table.render({
        elem: '#paperList',
        url: 'http://localhost:8080/demo_war_exploded/T_PaperManager_Controller/queryAllQuestion.action?courseno=' + $("#courseno_hiden").val(),
        cellMinWidth: 95,
        page: true,
        height: "full-125",
        limits: [10, 15, 20, 25],
        limit: 15,
        id: "paperList",
        cols: [[
            {field: 'id', title: '试题ID', minWidth: 100, align: "center", sort: true},
            {field: 'questionTypeName', title: '题目类型', minWidth: 100, align: "center", sort: true},
            {field: 'questionLevel', title: '题目难度', minWidth: 150, align: 'center'},
            {field: 'questionDesc', title: '题目描述', minWidth: 600, align: 'center'},
            {field: 'realAnswers', title: '正确答案', minWidth: 180, align: 'center'},
            {title: '操作', minWidth: 100, templet: '#userListBar', fixed: "right", align: "center"}
        ]]

    });

    //列表操作 监听
    table.on('tool(paperList)', function (obj) {
        var layEvent = obj.event,
            data = obj.data;

        if (layEvent === 'del') { //编辑
            del(data);
        }

        if (layEvent === 'edit') { //编辑
            update(data);
        }
    });


    // 删除题目
    function del(data) {
        console.log(data);
        console.log(data.id);
        $.ajax({
            type: 'POST',
            url: "http://localhost:8080/demo_war_exploded/T_PaperManager_Controller/delQuestion.action?questionid=" + data.id,
            error: function () {
                layer.msg('糟糕,出错了', {icon: 3, time: 1500});
            }
        })
        setTimeout(function () {
            layer.closeAll("iframe");
            //刷新父页面
            parent.location.reload();
        }, 2000);
        return false;
    }

    // 编辑信息
    function update(edit) {
        console.log(edit.id);

        var index = layui.layer.open({
            title: "更新学院信息",
            // 如果是iframe层
            type: 2,
            content: "questionUpdate.html",//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content:
            success: function (layero, index) {

                var body = layui.layer.getChildFrame('body', index);
                if (edit) {
                    body.find("#questionid_hiden").val(edit.id);  // id
                    form.render();
                }
                setTimeout(function () {
                    layui.layer.tips('点击此处返回试卷信息列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                }, 500)
            }
        })
        layui.layer.full(index);
        window.sessionStorage.setItem("index", index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize", function () {
            layui.layer.full(window.sessionStorage.getItem("index"));
        })


    }


    $(".addNews_btn").click(function () {
        addUser();
    })

    $(".addPaper").click(function () {
        addPaper();
    })

    function addPaper() {
        var index = layui.layer.open({
            title: "生成试卷",
            // 如果是iframe层
            type: 2,
            content: "paperInit.html",//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content:
            success: function (layero, index) {
                var body = layui.layer.getChildFrame('body', index);
                body.find("#paperid").val($("#paperid_hiden").val());  // paperid
                body.find("#id").val($("#id_hiden").val());  //
                body.find("#courseno_hiden").val($("#courseno_hiden").val());  //


                setTimeout(function () {
                    layui.layer.tips('点击此处返回试卷题目列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                }, 500)
            }
        })
        layui.layer.full(index);
        window.sessionStorage.setItem("index", index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize", function () {
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }


    function addUser() {
        var index = layui.layer.open({
            title: "添加试题",
            // 如果是iframe层
            type: 2,
            content: "paperAdd.html",//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content:
            success: function (layero, index) {
                var body = layui.layer.getChildFrame('body', index);


                body.find("#courseno").val($("#courseno_hiden").val());  // id


                setTimeout(function () {
                    layui.layer.tips('点击此处返回试卷题目列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                }, 500)
            }
        })
        layui.layer.full(index);
        window.sessionStorage.setItem("index", index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize", function () {
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }

})
