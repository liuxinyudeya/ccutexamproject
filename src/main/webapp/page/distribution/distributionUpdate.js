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


    $.ajax({
        type: 'POST'
        ,
        url: "http://localhost:8080/demo_war_exploded/MajorManager_Controller/academyInit.action"
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
            $('.classno').removeAttr('disabled');
            console.log($('.classno_hiden').val());
            $('.classno').val($('.classno_hiden').val());
            form.render('select');

        }
        ,
        error: function (res) {
            layer.msg('糟糕，出错了！', {icon: 3, time: 1500})
        }

    })

    // 查询课程
    $.ajax({
        type: 'POST'
        ,
        url: "http://localhost:8080/demo_war_exploded/CourseManager_Controller/queryCourse.action"
        ,
        data: 'grade=' + $('.grade_hiden').val() + '&academyCode=' + $('.academyCode_hiden').val() + '&majorCode=' + $('.majorCode_hiden').val()
        ,
        success: function (res) {
            if (res.length == 0) {
                console.log(res)
                layer.msg('暂无课程信息哦', {icon: 4, time: 1500})
            }

            var html = "";
            for (var i in res) {
                html += "<option value=" + res[i].courseno + ">" + res[i].courseName + "</option>"
            }
            $('.course').append(html);
            $('.course').removeAttr('disabled');
            $('.course').val($('.courseno_hiden').val());
            form.render('select');

        }
        ,
        error: function (res) {
            layer.msg('糟糕，出错了！', {icon: 3, time: 1500})
        }

    })


    // 查询教师
    $.ajax({
        type: 'POST'
        , url: "http://localhost:8080/demo_war_exploded/TeacherManager_Controller/queryTeacher.action"
        , success: function (res) {
            console.log(res);
            if (res.length == 0) {
                layer.msg('暂无教师信息哦', {icon: 4, time: 1500})
            }

            var html = "";
            for (var i in res) {
                html += "<option value=" + res[i].teacherno + ">" + res[i].name + "</option>"
            }
            $('.teacher').append(html);
            $('.teacher').val($('.teacherno_hiden').val());
            form.render('select');

        }
        , error: function (res) {
            layer.msg('糟糕，出错了！', {icon: 3, time: 1500})
        }

    })


    // 二级联动 根据年级查询学院信息
    form.on('select(grade)', function (data) {
        // console.log(data.value); //得到被选中的值
        grade = data.value;
        $('.academy').html("<option></option>");
        $('.major').html("<option></option>");
        $('.classno').html("<option></option>");
        $('.course').html("<option></option>");
        $.ajax({
            type: 'POST'
            , url: "http://localhost:8080/demo_war_exploded/MajorManager_Controller/academyInit.action"
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
        $('.course').html("<option></option>");
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

    // 四级联动 根据专业信息查询班级信息
    form.on('select(major)', function (data) {
        console.log(data.value); //得到被选中的值
        console.log(grade + $('.academy').val() + data.value);

        $('.classno').html("<option></option>");
        form.render('select');

        $.ajax({
            type: 'POST'
            , url: "http://localhost:8080/demo_war_exploded/MajorManager_Controller/academyInit.action"
            , data: 'managerid=' + grade + $('.academy').val() + data.value + '&department=01'
            , success: function (res) {
                if (res.length == 0) {
                    layer.msg('暂无班级信息哦', {icon: 4, time: 1500})
                }

                var html = "";
                for (var i in res) {
                    html += "<option value=" + res[i].id + ">" + res[i].classno + "班</option>"
                }
                $('.classno').append(html);
                $('.classno').removeAttr('disabled')
                form.render('select');

            }
            , error: function (res) {
                layer.msg('糟糕，出错了！', {icon: 3, time: 1500})
            }

        })

    });

    // 四级联动 根据专业信息查询班级信息
    form.on('select(classno)', function (data) {
        console.log(data.value); //得到被选中的值
        console.log(grade + $('.academy').val() + data.value);

        // 查询课程
        $.ajax({
            type: 'POST'
            ,
            url: "http://localhost:8080/demo_war_exploded/CourseManager_Controller/queryCourse.action"
            ,
            data: 'grade=' + $('.grade').val() + '&academyCode=' + $('.academy').val() + '&majorCode=' + $('.major').val()
            ,
            success: function (res) {
                if (res.length == 0) {
                    console.log(res)
                    layer.msg('暂无课程信息哦', {icon: 4, time: 1500})
                }

                var html = "";
                for (var i in res) {
                    html += "<option value=" + res[i].courseno + ">" + res[i].courseName + "</option>"
                }
                $('.course').append(html);
                $('.course').removeAttr('disabled')
                form.render('select');

            }
            ,
            error: function (res) {
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
        obj.classno = $(".classno").val();

        obj.teacherno = $(".teacher").val();
        obj.teacherName = $(".teacher").find("[value=" + $(".teacher").val() + "]").text();
        obj.courseno = $(".course").val();
        obj.courseName = $(".course").find("[value=" + $(".course").val() + "]").text();

        console.log(obj);

           $.ajax({
               type: 'POST',
               url: "http://localhost:8080/demo_war_exploded/Tea_Cla_CouManager_Controller/updateTea_Cla_Cou.action",
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