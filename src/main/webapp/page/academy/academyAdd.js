layui.use(['form', 'layer'], function () {

    var form = layui.form,
    layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;


    form.on("submit(addUser)", function (data) {
        //弹出loading
        var obj = new Object();
        obj.grade = $(".grade").val();
        obj.academyName = $(".academyName").val();
        obj.academyCode = $(".academyCode").val();
        obj.updatetime = new Date();
        obj.isdelete= $(".isdelete").val();


        $.ajax({
            type: 'POST',
            url: getRootPath()+"/AcademyManager/addAcademy.action",
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