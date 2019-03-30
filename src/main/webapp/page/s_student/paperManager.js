layui.use(['form', 'layer', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#paperList',
        url:getRootPath()+'/S_StudentManager_Controller/queryPaper.action',
        cellMinWidth: 95,
        page: true,
        height: "full-125",
        limits: [10, 15, 20, 25],
        limit: 15,
        id: "paperList",
        cols: [[
            {field: 'courseName', title: '课程名称', minWidth: 60, align: "center", sort: true},
            {field: 'courseno', title: '课程编号', minWidth: 30, align: "center", sort: true},
            {field: 'teacherName', title: '教师姓名', minWidth: 90, align: 'center'},
            {field: 'teacherNo', title: '教师编号', minWidth: 50, align: 'center'},
            {field: 'score', title: '试卷得分', minWidth: 90, align: 'center'},
            {field: 'classAvg', title: '班级平均分', minWidth: 90, align: 'center'},
            {field: 'classrank', title: '班级排名', minWidth: 90, align: 'center'},

        ]]

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


})
