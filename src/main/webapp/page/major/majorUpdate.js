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
            for (var i in res)

                html += "<option value=" + res[i] + ">" + res[i] + "级</option>"

            $('.grade').append(html);
            $('.grade').val($('.grade_hiden').val())
            form.render('select');

        }
        , error: function (res) {
            layer.msg('糟糕，出错了！', {icon: 3, time: 1500})
        }

    })

    $.ajax({
        type: 'POST'
        , url: getRootPath()+"/MajorManager_Controller/academyInit.action"
        , data: 'managerid=' + $('.grade_hiden').val()+'&department=03'
        , success: function (res) {
            if (res.length == 0) {
                layer.msg('暂无学院信息哦', {icon: 4, time: 1500})
            }

            var html = "";
            for (var i in res) {

                html += "<option value=" + res[i].academyCode + ">" + res[i].academyName + "</option>"

            }
            $('.academy').append(html);
            $('.academy').removeAttr("disabled");
            $('.academy').val($('.academyCode_hiden').val());
            form.render('select');

        }
        , error: function (res) {
            layer.msg('糟糕，出错了！', {icon: 3, time: 1500})
        }

    });
    $('.majorName').val($('.majorName_hiden').val());
    $('.majorCode').val($('.majorCode_hiden').val());
    $('.isdelete').val($('.isdelete_hiden').val());


    form.on('select(academy)', function (data) {
        $('.majorName').val("");
        $('.majorCode').val("");
    })
    // 二级联动 根据年级查询学院信息
    form.on('select(grade)', function (data) {
        // console.log(data.value); //得到被选中的值
        $('.academy').html("<option></option>");
        $('.majorName').val("");
        $('.majorCode').val("");
        $.ajax({
            type: 'POST'
            , url:getRootPath()+ "/MajorManager_Controller/academyInit.action"
            , data: 'grade=' + data.value
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
        obj.id = $(".id_hiden").val();
        obj.grade = $(".grade").val();
        obj.academyName = $(".academy").find("[value=" + $(".academy").val() + "]").text();
        obj.academyCode = $(".academy").val();
        obj.majorName = $(".majorName").val();
        obj.majorCode = $(".majorCode").val();
        obj.isdelete = $(".isdelete").val();
        console.log(obj);
        console.log(obj.isdelete);
        $.ajax({
            type: 'POST',
            url: getRootPath()+"/MajorManager_Controller/updateMajor.action",
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