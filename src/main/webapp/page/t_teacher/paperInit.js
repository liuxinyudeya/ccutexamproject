layui.use(['form', 'layer', 'laydate'], function () {

    var form = layui.form,
        laydate = layui.laydate,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    var questionTypeCode = '01';
    $.ajax({
        type: 'POST'
        ,
        url: "http://localhost:8080/demo_war_exploded/T_PaperManager_Controller/queryPaper.action?courseno=" + $("#courseno_hiden").val()
        ,
        success: function (res) {
            console.log(res);
            $(".questionCount").val(res.paperCount);
            $(".paperScore").val(res.paperScore);
            $(".paperLevel").val(res.paperLevel);

            $(".radioCount").val(res.radioCount);
            $(".checkboxCount").val(res.checkboxCount);
            $(".judgeCount").val(res.judgeCount);
            $(".fillCount").val(res.fillCount);
            form.render();
        }
        , error: function () {
            layer.msg('糟糕,出错了', {icon: 3, time: 1500});
        }
    })

    //格式化时间
    function filterTime(val) {
        if (val < 10) {
            return "0" + val;
        } else {
            return val;
        }
    }

    //定时发布
    var time = new Date();

    var submitTime = time.getFullYear() + '-' + filterTime(time.getMonth() + 1) + '-' + filterTime(time.getDate()) + ' ' + filterTime(time.getHours()) + ':' + filterTime(time.getMinutes()) + ':' + filterTime(time.getSeconds());
    laydate.render({
        elem: '#testTime',
        type: 'datetime',
        trigger: "click",
        done: function (value, date, endDate) {
            submitTime = value;
        }
    });

    form.on("submit(addUser)", function (data) {
        //弹出loading
        console.log(data);
        var obj = new Object();
        console.log();
        console.log();
        obj.testTime_str = submitTime;
        obj.minuteCount = $(".minuteCount").val();
        obj.tea_cla_couid = $("#id").val();
        obj.courseno = $("#courseno_hiden").val();
        console.log(obj.id);

        $.ajax({
            type: 'POST',
            url: "http://localhost:8080/demo_war_exploded/T_PaperManager_Controller/setPaper.action",
            data: obj,
            success: function (res) {
                layer.msg(res.success, {icon: 1, time: 1500});
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