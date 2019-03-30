layui.use(['form', 'layer'], function () {

    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    var questionTypeCode = '01';


    form.on("select(questionType)", function (data)    {

        if (data.value == '02') {// 多选
            $("#contextAnswer01").removeClass('layui-hide');
            var checkbox = " <input type=\"checkbox\" name=\"answer\" value=\"A\" title=\"A\">" +
                "<input type=\"checkbox\" class=\" answer\"  name=\"answer\" value=\"B\" title=\"B\">" +
                "<input type=\"checkbox\" class=\" answer\" name=\"answer\" value=\"C\" title=\"C\">" +
                "<input type=\"checkbox\" class=\" answer\" name=\"answer\" value=\"D\" title=\"D\">";
            $(".realAnswer").html(checkbox);

        } else if (data.value == '03') {// 判断

            $("#contextAnswer01").addClass('layui-hide');
            var context = " <input type=\"radio\" class=\"answer\" name=\"answer\" value=\"true\" title=\"正确\">" +
                "<input type=\"radio\" class=\"answer\"  name=\"answer\" value=\"false\" title=\"错误\">";
            $(".realAnswer").html(context);
        } else if (data.value == '04') {// 填空
            $("#contextAnswer01").addClass('layui-hide');
            var context = "<input type=\"text\" class=\"layui-input answer\" name=\"anwser\" lay-verify=\"required\" placeholder=\"请输入答案描述\">";
            $(".realAnswer").html(context);

        }
        form.render();
        questionTypeCode = data.value;
    })
    form.on("submit(addUser)", function (data) {
        //弹出loading
        var obj = new Object();
        obj.questionTypeName = $(".questionType").find("option[value=" + $(".questionType").val() + "]").text();
        obj.questionTypeCode = questionTypeCode;
        obj.questionLevel = $(".questionLevel").val();
        obj.questionScore = $(".questionScore").val();
        obj.questionDesc = $(".questionDesc").val();
        var str = "";
        if (questionTypeCode != '04') {
            $(".realAnswer input[name=answer]:checked").each(function () {
                str += ',' + this.value;
            })
            if (questionTypeCode == '01' || questionTypeCode == '02') {
                obj.A = $(".A").val();
                obj.B = $(".B").val();
                obj.C = $(".C").val();
                obj.D = $(".D").val();
            }
            str = str.substr(1);
        } else {
            str = $(".answer").val();
        }
        obj.realAnswers = str;
        obj.courseno = $("#courseno").val();
        console.log(obj.realAnswers);
        $.ajax({
            type: 'POST',
            url: getRootPath()+"/T_PaperManager_Controller/addQuestion.action",
            data: obj,
            error: function () {
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