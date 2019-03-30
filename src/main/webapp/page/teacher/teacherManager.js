layui.use(['form', 'layer', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    // 教师列表
    var tableIns = table.render({
        elem: '#teacherList',
        url: getRootPath()+'/TeacherManager_Controller/queryAllTeacher.action',
        cellMinWidth: 95,
        page: true,
        height: "full-125",
        limits: [10, 15, 20, 25],
        limit: 15,
        id: "teacherList",
        cols: [[
            {type: "checkbox", fixed: "left", width: 50},
            {field: 'teacherno', title: '教师工号', minWidth: 100, align: "center", sort: true},
            {field: 'name', title: '姓名', align: 'center', sort: true},
            {field: 'sex', title: '性别', align: 'center', sort: true},
            {
                field: 'isdelete', title: '是否禁用', align: 'center', sort: true, templet: function (d) {
                    if (d.isdelete == "1") {
                        return '<span class="layui-btn layui-btn-danger layui-btn-xs">禁用</span>'
                    } else {
                        return '<span class="layui-btn layui-btn-green layui-btn-xs">启用</span>'
                    }
                }
            },

            {field: 'updatetime_str', title: '最后修改时间', align: 'center', minWidth: 150},
            {title: '操作', minWidth: 175, templet: '#userListBar', fixed: "right", align: "center"}
        ]]/*, done: function () {
            $("[data-field='id']").css('display', 'none');
        }*/

    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click", function () {
        if ($(".searchVal").val() != '') {
            table.reload("teacherList", {
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    key: '%' + $(".searchVal").val() + '%'  //搜索的关键字
                }
            })
        } else {
            layer.msg("请输入搜索的内容");
        }
    });

    // 编辑信息
    function update(edit) {


        var index = layui.layer.open({
            title: "更新教师信息",
            // 如果是iframe层
            type: 2,
            content: "teacherUpdate.html",//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content:
            success: function (layero, index) {
                var body = layui.layer.getChildFrame('body', index);
                if (edit) {
                    body.find(".teacherno_hiden").val(edit.teacherno);  // id
                    body.find(".name_hiden").val(edit.name);  // id
                    body.find(".sex_hiden").val(edit.sex);  // id
                    body.find(".isdelete_hiden").val(edit.isdelete);  // id


                    form.render();
                }
                setTimeout(function () {
                    layui.layer.tips('点击此处返回学院信息列表', '.layui-layer-setwin .layui-layer-close', {
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

    // 添加学院
    function addUser(edit) {
        var index = layui.layer.open({
            title: "添加教师",
            // 如果是iframe层
            type: 2,
            content: "teacherAdd.html",//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content:
            success: function (layero, index) {
                var body = layui.layer.getChildFrame('body', index);
                setTimeout(function () {
                    layui.layer.tips('点击此处返回教师信息列表', '.layui-layer-setwin .layui-layer-close', {
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


    //列表操作
    table.on('tool(academyList)', function (obj) {
        var layEvent = obj.event,
            data = obj.data;

        if (layEvent === 'edit') { //编辑
            update(data);
        }
    });


})
