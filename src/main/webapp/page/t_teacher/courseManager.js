layui.use(['form', 'layer', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    // 课程列表
    var tableIns = table.render({
        elem: '#courseList',
        url: 'http://localhost:8080/demo_war_exploded/T_CourseManager_Controller/courseList.action',
        cellMinWidth: 95,
        page: true,
        height: "full-125",
        limits: [10, 15, 20, 25],
        limit: 15,
        id: "paperList",
        cols: [[
            {field: 'id', title: 'ID', minWidth: 50, align: "center"},
            {field: 'grade', title: '年级', minWidth: 50, align: "center", sort: true},
            {field: 'courseName', title: '课程名称', minWidth: 60, align: 'center', sort: true},
            {field: 'courseno', title: '课程编号', minWidth: 60, align: 'center', sort: true},
            {field: 'classno', title: '班级编号', minWidth: 100, align: "center", sort: true},
            {field: 'academyName', title: '学院名称', minWidth: 120, align: 'center'},
            {field: 'majorName', title: '专业名称', minWidth: 150, align: 'center'},
            {field: 'stuCount', title: '班级人数', minWidth: 150, align: 'center'},
            {
                field: '', title: '考试码', align: 'center',sort: true,templet: function (d) {
                    if (d.examCode != null) {
                        return d.examCode
                    } else {
                        return '<span  class="layui-btn layui-btn-green layui-btn-xs">未出卷</span>'
                    }
                }
            },
            {
                field: '', title: '考试状态', align: 'center', sort: true,templet: function (d) {
                    if (d.examstate == '1') {
                        return '已完成'
                    } else {
                        return '未考试'
                    }
                }
            },
            {field: 'updatetime_str', title: '最后修改时间', align: 'center', minWidth: 150},
            {title: '操作', minWidth: 120, fixed: "right", align: "center",templet: function (d) {
                    if (d.examCode != null) {
                        return '<span lay-event="setpaper" lay-event="setpaper" class="layui-btn layui-btn-red layui-btn-xs">查看试卷</span>'
                    } else {
                        return '<span lay-event="setpaper" lay-event="setpaper" class="layui-btn layui-btn-green layui-btn-xs">立即出卷</span>'
                    }
                }}
        ]]

    });

    //列表操作 监听
    table.on('tool(courseList)', function (obj) {
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent==='setpaper'){
            setpaper(data);
        }
    });


    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click", function () {
        if ($(".searchVal").val() != '') {
            table.reload("courseList", {
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
    // 添加试卷
    function setpaper(edit) {
        var index = layui.layer.open({
            title: "",
            // 如果是iframe层
            type: 2,
            content: "examManager.html",//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content:
            success: function (layero, index) {
                var body = layui.layer.getChildFrame('body', index);
                if (edit) {
                    body.find(".id_hiden").val(edit.id);  // id
                    form.render();
                }

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
