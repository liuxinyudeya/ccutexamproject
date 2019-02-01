layui.use(['form', 'layer', 'jquery'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
    $ = layui.jquery;

    $(".loginBody .seraph").click(function () {
        layer.msg("暂未开放，敬请期待", {
            time: 2000
        });
    })

    //登录按钮
    form.on("submit(login)", function (data) {

        $.ajax({
            url: "http://localhost:8080/demo_war_exploded/Account_Controller/verifyLogin.action",
            data: 'username=' + $("#userName").val() + '&password=' + $("#password").val(),
            success: function (res) {

                if(res.state=='0'&&res.count==1){
                    setTimeout(function () {
                       // $(this).text("登录中...").attr("disabled", "disabled").addClass("layui-disabled");
                        window.location.href = "index.html";
                    }, 1000);
                }else{
                    layer.msg('请检查您的账号或者密码', {icon: 3, time: 1500});
                }

            },
            error: function () {
                layer.msg('糟糕,出错了', {icon: 3, time: 1500});
            }

        })


        return false;
    })

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
