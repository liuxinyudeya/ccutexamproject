layui.use(['form', 'layer', 'jquery'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
    $ = layui.jquery;
    var grade;
    $.ajax({
        type: 'post'
        , url: getRootPath()+"/MajorManager_Controller/gradeInit.action"
        , success: function (res) {
            if (res.length == 0) {
                layer.msg('暂无年级信息哦', {icon: 4, time: 1500})
            }
            var html = "";
            for (var i in res) {
                html += "<option value=" + res[i] + ">" + res[i] + "级</option>"

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

        grade = data.value;

        $('.academy').html("<option></option>");
        form.render('select');

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
        console.log(data.value); //得到被选中的值
        console.log(grade + data.value);

        $('.major').html("<option></option>");
        form.render('select');

        $.ajax({
            type: 'POST'
            , url: getRootPath()+"/MajorManager_Controller/academyInit.action"
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
            , url:getRootPath()+ "/MajorManager_Controller/academyInit.action"
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


    //登录按钮
    form.on("submit(register)", function (data) {
        var obj = new Object();
        obj.grade = $(".grade").val();
        obj.academyName = $(".academy").find("option[value=" + $(".academy").val() + "]").text();
        obj.academyCode = $(".academy").val();
        obj.majorName = $(".major").find("option[value=" + $(".major").val() + "]").text();
        obj.majorCode = $(".major").val();
        obj.classno = $(".classno").val();
        obj.name = $(".name").val()
        obj.studentno = $(".stuno").val();
        obj.sex = '男';
        obj.isdelete = '0';

        console.log(obj);

        $.ajax({
            url: getRootPath()+"/StudentManager_Controller/addStudent.action",
            data: obj,
            success: function (res) {

                if (res.state == '0') {
                    verifyLogin();
                } else {
                    layer.msg(res.error, {icon: 3, time: 1500});
                }

            },
            error: function () {
                layer.msg('糟糕,出错了', {icon: 3, time: 1500});
            }

        })

        return false;
    })

    function verifyLogin() {
        $.ajax({
            url: getRootPath()+"/Account_Controller/verifyLogin.action",
            data: 'username=' + $(".stuno").val() + '&password=123456',
            success: function (res) {

                if (res.state == '0') {
                    if (res.count == 1) {
                        setTimeout(function () {
                            // $(this).text("登录中...").attr("disabled", "disabled").addClass("layui-disabled");
                            window.location.href = "index.jsp";
                        }, 1000);
                    }
                } else {
                    layer.msg('请检查您的账号或者密码哦', {icon: 3, time: 1500});
                }

            },
            error: function () {
                layer.msg('糟糕,出错了', {icon: 3, time: 1500});
            }
        })
    }

    //表单输入效果
    $(".loginBody .input-item").click(function (e) {
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function () {
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function () {
        $(this).parent().removeClass("layui-input-focus");
        if ($(this).val() != '') {
            $(this).parent().addClass("layui-input-active");
        } else {
            $(this).parent().removeClass("layui-input-active");
        }
    })
})
