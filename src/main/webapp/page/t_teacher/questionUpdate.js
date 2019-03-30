layui.use(['form', 'layer'], function () {

    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;


    $.ajax({
        type: 'POST',
        url: getRootPath()+"/T_PaperManager_Controller/queryQuestion.action?questionid=" + $("#questionid_hiden").val(),
        success: function (res) {
            var TypeCode = res.questionTypeCode;

            $(".questionType").val(res.questionTypeCode);
            $(".questionLevel").val(res.questionLevel);
            $(".questionScore").val(res.questionScore);
            $(".questionDesc").val(res.questionDesc);


            if (TypeCode == '02' || TypeCode == '01') { // 多选

                $(".A").val(res.answers[0].answerName);
                $(".A").attr("id", res.answers[0].answerid);
                $(".B").val(res.answers[1].answerName);
                $(".B").attr("id", res.answers[1].answerid);
                $(".C").val(res.answers[2].answerName);
                $(".C").attr("id", res.answers[2].answerid);
                $(".D").val(res.answers[3].answerName);
                $(".D").attr("id", res.answers[3].answerid);

                if (TypeCode == '01') {
                    var realanwser = res.realAnswers;

                    $("input[type=radio][name=answer][value=" + realanwser + "]").attr("checked", 'checked')
                } else {
                    $(".realAnswer").html(" ");
                    var checkbox = " <input type=\"checkbox\" name=\"answer\" value=\"A\" title=\"A\">" +
                        "<input type=\"checkbox\" class=\" answer\"  name=\"answer\" value=\"B\" title=\"B\">" +
                        "<input type=\"checkbox\" class=\" answer\" name=\"answer\" value=\"C\" title=\"C\">" +
                        "<input type=\"checkbox\" class=\" answer\" name=\"answer\" value=\"D\" title=\"D\">";
                    $(".realAnswer").html(checkbox);


                    var str = res.realAnswers;
                    var realanswers = new Array(); //定义一数组
                    realanswers = str.split(","); //字符分割

                    for (var i = 0; i < realanswers.length; i++) {
                        $("input[type=checkbox][name=answer][value=" + realanswers[i] + "]").attr("checked", 'checked');
                    }

                }

            } else if (TypeCode == '03') {// 判断

                $("#contextAnswer01").addClass('layui-hide');
                var context = " <input type=\"radio\" class=\"answer\" name=\"answer\" value=\"true\" title=\"正确\">" +
                    "<input type=\"radio\" class=\"answer\"  name=\"answer\" value=\"false\" title=\"错误\">";
                $(".realAnswer").html(context);

                $("input[type=radio][name=answer][value=" + res.realAnswers + "]").attr("checked", 'checked');


            } else if (TypeCode == '04') {// 填空
                $("#contextAnswer01").addClass('layui-hide');
                var context = "<input type=\"text\" class=\"layui-input answer\" name=\"anwser\" lay-verify=\"required\" placeholder=\"请输入答案描述\">";
                $(".realAnswer").html(context);
                $(".answer").val(res.realAnswers);

            }
            form.render();
        }
        , error: function () {
            layer.msg('糟糕,出错了', {icon: 3, time: 1500});
        }

    })

    form.on("select(questionType)", function (data) {
        if (data.value == '01') {
            $("#contextAnswer01").removeClass('layui-hide');
            var radio = " <input type=\"radio\" name=\"answer\" value=\"A\" title=\"A\">" +
                "<input type=\"radio\" class=\" answer\"  name=\"answer\" value=\"B\" title=\"B\">" +
                "<input type=\"radio\" class=\" answer\" name=\"answer\" value=\"C\" title=\"C\">" +
                "<input type=\"radio\" class=\" answer\" name=\"answer\" value=\"D\" title=\"D\">";
            $(".realAnswer").html(radio);
        } else if (data.value == '02') {// 多选
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
        var questionTypeCode = $(".questionType").val();
        var obj = new Object();
        obj.id=$("#questionid_hiden").val();
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
                obj.AId = $(".A").attr("id");
                obj.B = $(".B").val();
                obj.BId = $(".B").attr("id");
                obj.C = $(".C").val();
                obj.CId = $(".C").attr("id");
                obj.D = $(".D").val();
                obj.DId = $(".D").attr("id");
            }
            str = str.substr(1);
        } else {
            str = $(".answer").val();
        }
        obj.realAnswers = str;
        console.log(obj);
         $.ajax({
              type: 'POST',
              url: getRootPath()+"/T_PaperManager_Controller/updateQuestion.action",
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