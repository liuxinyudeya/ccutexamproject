layui.use(['form', 'layer'], function () {

    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    var grade;
    $.ajax({
        type: 'POST'
        , url: "http://localhost:8080/demo_war_exploded/MajorManager_Controller/gradeInit.action"
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
        , url: "http://localhost:8080/demo_war_exploded/MajorManager_Controller/academyInit.action"
        , data: 'managerid=' + $('.grade_hiden').val() + '&department=03'
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

    $.ajax({
        type: 'POST'
        , url: "http://localhost:8080/demo_war_exploded/MajorManager_Controller/academyInit.action"
        , data: 'managerid=' + $('.grade_hiden').val() + $('.academyCode_hiden').val() + '&department=02'
        , success: function (res) {
            if (res.length == 0) {
                layer.msg('暂无专业信息哦', {icon: 4, time: 1500})
            }

            var html = "";
            for (var i in res) {
                html += "<option value=" + res[i].majorCode + ">" + res[i].majorName + "</option>"
            }
            $('.major').append(html);
            console.log(html);
            console.log($('.majorCode_hiden').val());
            $('.major').removeAttr("disabled");
            $('.major').val($('.majorCode_hiden').val());
            form.render('select');

        }
        , error: function (res) {
            layer.msg('糟糕，出错了！', {icon: 3, time: 1500})
        }

    })

    $('.classno').val($('.classno_hiden').val());
    $('.isdelete').val($('.isdelete_hiden').val());

    form.render();

    form.on('select(academy)', function (data) {
        $('.major').html("<option></option>");
        $('.classno').val("");
    })
    // 二级联动 根据年级查询学院信息
    form.on('select(grade)', function (data) {
        // console.log(data.value); //得到被选中的值
        grade = data.value;
        console.log($('.grade').val());
        $('.academy').html("<option></option>");
        $('.major').html("<option></option>");
        $('.classno').val("");
        $.ajax({
            type: 'POST'
            , url: "http://localhost:8080/demo_war_exploded/MajorManager_Controller/academyInit.action"
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

    // 三级联动 根据学院信息查询专业信息
    form.on('select(academy)', function (data) {
        console.log(data.value); //得到被选中的值
        console.log(grade + data.value);

        $('.major').html("<option></option>");
        form.render('select');

        $.ajax({
            type: 'POST'
            , url: "http://localhost:8080/demo_war_exploded/MajorManager_Controller/academyInit.action"
            , data: 'managerid=' + grade + data.value + '&department=02'
            , success: function (res) {
                if (res.length == 0) {
                    layer.msg('暂无专业信息哦', {icon: 4, time: 1500})
                }

                var html = "";
                for (var i in res) {
                    html += "<option value=" + res[i].majorCode + ">" + res[i].majorName + "</option>"
                }
                $('.major').append(html);
                $('.major').removeAttr("disabled");
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
        obj.majorName = $(".major").find("[value=" + $(".major").val() + "]").text();
        obj.majorCode = $(".major").val();
        obj.isdelete = $(".isdelete").val();
        obj.classno = $(".classno").val();
        console.log(obj.majorName);
        console.log(obj.majorCode);

        $.ajax({
            type: 'POST',
            url: "http://localhost:8080/demo_war_exploded/ClassManager_Controller/updateClass.action",
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