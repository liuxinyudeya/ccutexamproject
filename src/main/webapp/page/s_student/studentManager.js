layui.use(['form', 'layer', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#studentList',
        url: 'http://localhost:8080/demo_war_exploded/S_StudentManager_Controller/queryCourseList.action',
        cellMinWidth: 95,
        page: true,
        height: "full-125",
        limits: [10, 15, 20, 25],
        limit: 15,
        id: "studentList",
        cols: [[
            {field: 'id', title: 'ID', minWidth: 60, align: "center"},
            {field: 'courseName', title: '课程名称', minWidth: 60, align: "center", sort: true},
            {field: 'courseNo', title: '课程编号', minWidth: 30, align: "center", sort: true},
            {field: 'teacherName', title: '教师姓名', minWidth: 90, align: 'center'},
            {field: 'teacherNo', title: '教师编号', minWidth: 50, align: 'center'},
            {field: 'score', title: '试卷总分', minWidth: 90, align: 'center'},
            {field: 'level', title: '试卷难度', minWidth: 50, align: 'center', sort: true},
            {
                field: 'testTime', title: '考试时间', align: 'center', sort: true, templet: function (d) {
                    if (d.testTime != null) {
                        var unixTimestamp = new Date(d.testTime);
                        return unixTimestamp.toLocaleString();
                    } else {
                        return '-';
                    }

                }
            },
            {
                field: 'endTime', title: '结束时间', align: 'center', sort: true, templet: function (d) {
                    if (d.endTime != null) {
                        var unixTimestamp = new Date(d.endTime);
                        return unixTimestamp.toLocaleString();
                    } else {
                        return '-';
                    }

                }
            },
            {field: 'minuteCount', title: '考试时长', minWidth: 80, align: 'center', sort: true},
            {
                field: 'paperno', title: '考试码', align: 'center', sort: true, templet: function (d) {
                    if (d.paperno == null) {
                        return '未出卷'
                    } else {
                        return d.paperno;
                    }
                }
            },
            {
                field: 'examstate', title: '考试状态', align: 'center', sort: true, templet: function (d) {

                    if (d.finshExam != 0) {
                        return '<span lay-event="checkpaper" class="layui-btn layui-btn-green layui-btn-xs ">考试结束</span>'
                    } else {
                        if (d.examstate == '未考试') {
                            return '<span  lay-event="startexam" class="layui-btn layui-btn-red layui-btn-xs startexam ">进入考场</span>'
                        } else {
                            return '<span lay-event="checkpaper" class="layui-btn layui-btn-green layui-btn-xs ">缺考</span>'
                        }
                    }

                }
            }

        ]]

    });

    //列表操作 监听
    table.on('tool(studentList)', function (obj) {
        var layEvent = obj.event,
            data = obj.data;

        if (layEvent === 'startexam') {
            startexam(data);

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

    function startexam(data) {
        console.log(data);
        var testtime = new Date(data.testTime);
        var endtime = new Date(data.endTime);
        var now = new Date();
        if (testtime > now) {
            // 考试未开始
            layer.msg('考试还未开始', {icon: 3, time: 1500});
        } else if (endtime < now) {
            // 考试已经结束
            layer.msg('考试已结束', {icon: 3, time: 1500});
        } else {
            window.location.href = 'index.html?id=' + data.id;
        }
    }

})
