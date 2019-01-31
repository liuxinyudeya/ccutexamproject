layui.use(['form', 'layer'], function () {

    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;



    form.on("submit(addUser)", function (data) {
        console.log();
        //弹出loading
        var obj = new Object();
        obj.teacherno = $(".teacherno").val();
        obj.sex = data.field.sex;
        obj.name = $(".name").val();
        obj.isdelete = $(".isdelete").val();
        $.ajax({
            type: 'POST',
            url: "http://localhost:8080/demo_war_exploded/TeacherManager_Controller/addTeacher.action",
            data: obj,
            success: function (res) {
                console.log(res);
                if (res.state == 0) {
                    layer.msg(res.success, {icon: 1, time: 1500});
                } else {
                    layer.msg(res.error, {icon: 2, time: 1500});
                }
            }
            , error: function () {
                layer.msg('糟糕,出错了', {icon: 3, time: 1500});
            }

        })
        setTimeout(function () {
            layer.closeAll("iframe");
            //刷新父页面
            parent.location.reload();
        }, 2000);
        return false;
    })

})