layui.use(['form', 'layer'], function () {

    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;


    $.ajax({
        type: 'POST'
        , url: getRootPath()+"/MajorManager_Controller/gradeInit.action"
        , success: function (res) {
            if (res.length == 0) {
                layer.msg('暂无年级信息哦', {icon: 4, time: 1500})
            }
            var html = "";
            for (var index in res) {
                html += "<option value=" + res[index] + ">" + res[index] + "级</option>"

            }
            $('.grade').append(html);
            form.render('select');

        }
        , error: function (res) {
            layer.msg('糟糕，出错了！', {icon: 3, time: 1500})
        }

    })

    // 二级联动 根据年级查询学院信息
    form.on('select(grade)', function (data) {
        // console.log(data.value); //得到被选中的值

        $('.academy').html("<option></option>");
        form.render('select');

        $.ajax({
            type: 'POST'
            , url: getRootPath()+"/MajorManager_Controller/academyInit.action"
            , data: 'managerid=' + data.value+'&department=03'
            , success: function (res) {
                if (res.length == 0) {
                    layer.msg('暂无年级信息哦', {icon: 4, time: 1500})
                }

                var html = "";
                for (var i in res) {
                    html += "<option value=" + res[i].academyCode + ">" + res[i].academyName + "</option>"
                }
                $('.academy').append(html);
                $('.academy').removeAttr("disabled");
                form.render('select');

            }
            , error: function (res) {
                layer.msg('糟糕，出错了！', {icon: 3, time: 1500})
            }

        })

    });


    form.on("submit(addUser)", function (data) {
        //弹出loading
        var obj = new Object();
        obj.grade = $(".grade").val();
        obj.academyName = $(".academy").find("option[value=" + $(".academy").val() + "]").text();
        obj.academyCode = $(".academy").val();
        obj.majorName = $(".majorName").val();
        obj.majorCode = $(".majorCode").val();
        obj.isdelete = $(".isdelete").val();

        $.ajax({
            type: 'POST',
            url:getRootPath()+ "/MajorManager_Controller/addMajor.action",
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