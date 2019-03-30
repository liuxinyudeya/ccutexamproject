layui.use(['form', 'layer'], function () {

    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    var grade;
    $.ajax({
        type: 'POST'
        , url:getRootPath()+ "/MajorManager_Controller/gradeInit.action"
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
        , url:getRootPath()+ "/MajorManager_Controller/academyInit.action"
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

    $.ajax({
        type: 'POST'
        ,
        url: getRootPath()+"/MajorManager_Controller/academyInit.action"
        ,
        data: 'managerid=' + $('.grade_hiden').val() + $('.academyCode_hiden').val() + $('.majorCode_hiden').val() + '&department=01'
        ,
        success: function (res) {
            if (res.length == 0) {
                layer.msg('暂无班级信息哦', {icon: 4, time: 1500})
            }

            var html = "";
            for (var i in res) {
                html += "<option value=" + res[i].id + ">" + res[i].classno + "班</option>"
            }
            $('.classno').append(html);

            $('.classno').removeAttr("classno");
            $('.classno').val($('.classno_hiden').val());
            $('.classno').removeAttr("disabled");
            form.render('select');

        }
        ,
        error: function (res) {
            layer.msg('糟糕，出错了！', {icon: 3, time: 1500})
        }

    })

    console.log("name" + $('.name_hiden').val());
    console.log("studentno" + $('.studentno_hiden').val());
    $('.name').val($('.name_hiden').val());
    $("[name=sex][value=" + $('.sex_hiden').val() + "]").prop('checked', true);
    $('.isdelete').val($('.isdelete_hiden').val());
    $('.studentno').val($('.studentno_hiden').val());

    form.render();


    // 二级联动 根据年级查询学院信息
    form.on('select(grade)', function (data) {
        // console.log(data.value); //得到被选中的值
        grade = data.value;
        console.log($('.grade').val());
        $('.academy').html("<option></option>");
        $('.major').html("<option></option>");
        $('.classno').html("<option></option>");
        $.ajax({
            type: 'POST'
            , url: getRootPath()+"/MajorManager_Controller/academyInit.action"
            , data: 'managerid=' + data.value + '&department=03'
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

        $('.major').html("<option></option>");
        $('.classno').html("<option></option>");
        form.render('select');

        $.ajax({
            type: 'POST'
            , url:getRootPath()+ "/MajorManager_Controller/academyInit.action"
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

    // 四级联动 根据专业信息查询班级信息
    form.on('select(major)', function (data) {

        $('.major').html("<option></option>");
        $('.classno').html("<option></option>");
        form.render('select');

        $.ajax({
            type: 'POST'
            , url: getRootPath()+"/MajorManager_Controller/academyInit.action"
            , data: 'managerid=' + grade + $('.major').val() + data.value + '&department=01'
            , success: function (res) {
                if (res.length == 0) {
                    layer.msg('暂无专业信息哦', {icon: 4, time: 1500})
                }

                var html = "";
                for (var i in res) {
                    html += "<option value=" + res[i].id + ">" + res[i].classno + "班</option>"
                }
                $('.classno').append(html);
                $('.classno').removeAttr("disabled");
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
        obj.studentno = $(".studentno_hiden").val();
        obj.newstudentno = $(".studentno").val();
        obj.grade = $(".grade").val();
        obj.academyName = $(".academy").find("[value=" + $(".academy").val() + "]").text();
        obj.academyCode = $(".academy").val();
        obj.majorName = $(".major").find("[value=" + $(".major").val() + "]").text();
        obj.majorCode = $(".major").val();
        obj.classno = $(".classno").val();
        obj.name = $(".name").val();
        obj.sex = data.field.sex;
        obj.isdelete = $(".isdelete").val();

        console.log(obj);

        $.ajax({
            type: 'POST',
            url:getRootPath()+ "/StudentManager_Controller/updateStudent.action",
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