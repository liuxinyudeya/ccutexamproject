layui.use(['form', 'layer', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#studentList',
        url: getRootPath()+'/StudentManager_Controller/queryAllStudent.action',
        cellMinWidth: 95,
        page: true,
        height: "full-125",
        limits: [10, 15, 20, 25],
        limit: 15,
        id: "studentList",
        cols: [[
            {type: "checkbox", fixed: "left", width: 50},
            {field: 'studentno', title: '学生学号', minWidth: 60, align: "center", sort: true},
            {field: 'grade', title: '年级', minWidth: 30, align: "center", sort: true},
            {field: 'academyName', title: '学院名称', minWidth: 90, align: 'center'},
            {field: 'academyCode', title: '学院编号', minWidth: 50, align: 'center'},
            {field: 'majorName', title: '专业名称', minWidth: 90, align: 'center'},
            {field: 'majorCode', title: '专业编号', minWidth: 50, align: 'center', sort: true},
            {field: 'classno', title: '班级编号', minWidth: 80, align: 'center', sort: true},
            {field: 'name', title: '学生姓名', minWidth: 80, align: 'center', sort: true},
            {field: 'sex', title: '学生性别', minWidth: 30, align: 'center', sort: true},
            {
                field: 'isdelete', title: '是否禁用', align: 'center', sort: true, templet: function (d) {
                    if (d.isdelete == "1") {
                        return '<span class="layui-btn layui-btn-danger layui-btn-xs">禁用</span>'
                    } else {
                        return '<span class="layui-btn layui-btn-green layui-btn-xs">启用</span>'
                    }
                }
            },

            {field: 'updatetime_str', title: '最后修改时间', align: 'center', minWidth: 120},
            {title: '操作', minWidth: 120, templet: '#userListBar', fixed: "right", align: "center"}
        ]]

    });

    //列表操作 监听
    table.on('tool(studentList)', function (obj) {
        var layEvent = obj.event,
            data = obj.data;

        if (layEvent === 'edit') { //编辑
            update(data);
        }
    });


    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click", function () {
        if ($(".searchVal").val() != '') {
            table.reload("studentList", {
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
            title: "更新学院信息",
            // 如果是iframe层
            type: 2,
            content: "studentUpdate.html",//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content:
            success: function (layero, index) {

                var body = layui.layer.getChildFrame('body', index);
                if (edit) {
                    body.find(".studentno_hiden").val(edit.studentno);  // id
                    body.find(".isdelete_hiden").val(edit.isdelete);  // 是否启用
                    body.find(".grade_hiden").val(edit.grade);  //年级
                    body.find(".academyName_hiden").val(edit.academyName);  // 学院名称
                    body.find(".academyCode_hiden").val(edit.academyCode);  // 学院编码
                    body.find(".majorCode_hiden").val(edit.majorCode);  // 学院编码
                    body.find(".majorName_hiden").val(edit.majorName);  // 学院编码
                    body.find(".classno_hiden").val(edit.classno);  // 学院编码
                    body.find(".name_hiden").val(edit.name);  // 姓名
                    body.find(".sex_hiden").val(edit.sex);  // 性别

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


    $(".addNews_btn").click(function () {
        addUser();
    })

    // 添加学院
    function addUser() {
        var index = layui.layer.open({
            title: "添加班级",
            // 如果是iframe层
            type: 2,
            content: "studentAdd.html",//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content:
            success: function (layero, index) {
                var body = layui.layer.getChildFrame('body', index);
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

})
