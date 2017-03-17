<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/inc/taglibs.jsp" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" type="image/x-icon" href="${ctx}/resource/img/default.ico"/>
    <title>Welcome</title>
    <%@ include file="/WEB-INF/views/inc/link.jsp" %>
    <link href="${ctx}/resources/css/wwjd/login.css" rel="stylesheet"/>

    <script type="text/javascript">

        $(function () {
//            var co = new Array('#000000', '#1C1C1C', '#363636', '#4F4F4F', '#5D478B', '#551A8B', '#483D8B', '#556B2F', '#2F4F4F', '#00B2EE', '#009ACD', '#00688B');
//            var conum = 0;
//
//            //背景颜色轮换
//            setInterval(function () {
//                if (conum == 12) {
//                    conum = 0;
//                } else {
//                    conum++;
//                }
//                $('.dao-wrap').css({'background-color': co[conum]});
//            }, 600);

            $('.dao-wrap').css({'background-color': '#000000'});
            //登录模块下滑
            $('.dao-wrap').animate({'margin-top': '100px'});


            //获取cookie

            $('#username').val($.cookie('username'));
            $('#password').val($.cookie('password'));
            if ($.cookie('remenber') != null && $.cookie('remenber') != '') {
                $('#remenber').attr('checked', 'checked');
            }


            //获取验证码
            $('#getYzm').click(function () {
                $(this).parents('.dao-yzm').find('img').attr('src', $_ctx + '/util/getYzm?date=' + new Date());
            })


            //点击Let's Go触发事件
            $('.dao-btn.go').click(function () {
                var yzm = $('#yzm').val();
                var remenber = $('[name="remenber"]:checked').val();

                var username = $('#username').val();
                var password = $('#password').val();


                //登录验证
                if (trim(username) == '') {
                    window.wxc.xcConfirm('请输入用户！', window.wxc.xcConfirm.typeEnum.info, {
                        title: "温馨提示"
                    });
                    return;
                }

                if (trim(password) == '') {
                    window.wxc.xcConfirm('请输入密码！', window.wxc.xcConfirm.typeEnum.info, {
                        title: "温馨提示"
                    });

                    return;
                }
                if (trim(yzm).length != 4) {
                    window.wxc.xcConfirm('请输入正确的验证码！', window.wxc.xcConfirm.typeEnum.info, {
                        title: "温馨提示"
                    });
                    return;
                }

                //正在登录
                $.post($_ctx + '/login/enter', {
                    username: username,
                    password: password,
                    yzm: yzm,
                    remenber: remenber
                }, function (data, stadius) {


                    //对登录后的结果进行处理
                    if (data.flag == 200 && stadius == 'success') {
                        var loginData = data.t;
                        if (loginData.flag == 1) {
                            $('.dao-wrap').animate({'margin-right': '-550px'}, 'slow', 'swing', function () {
                                if (loginData.remenber == 'on') {
                                    $.cookie('username', loginData.username, {expires: 7});
                                    $.cookie('password', loginData.password, {expires: 7});
                                    $.cookie('remenber', loginData.remenber, {expires: 7});
                                } else {
                                    $.cookie('username', '', {expires: -1});
                                    $.cookie('password', '', {expires: -1});
                                    $.cookie('remenber', '', {expires: -1});
                                }
//                               进入主页
                                location.href = $_ctx + '/page/home';
                            });
                        } else if (loginData.flag == 3) {
                            window.wxc.xcConfirm('用户名或者密码不正确！', window.wxc.xcConfirm.typeEnum.error, {
                                title: "温馨提示"
                            });
                        }
                        else {
                            window.wxc.xcConfirm('验证码不正确！', window.wxc.xcConfirm.typeEnum.error, {
                                title: "温馨提示"
                            });
                        }
                    } else {
                        window.wxc.xcConfirm('服务器故障！', window.wxc.xcConfirm.typeEnum.error, {
                            title: "温馨提示"
                        });
                    }
                });
            });

            $('#register').click(function () {
                location.href = $_ctx + '/page/register';
            });

        })
    </script>
</head>
<body background="${ctx}/resources/img/loginbg.jpg">
<div class="dao-wrap login">
    <div class="dao-title">尊敬的用户，敬请登录</div>


    <div class="dao-input"><label for="username">&nbsp;&nbsp;&nbsp;&nbsp;用&nbsp;&nbsp;&nbsp;户：</label><input
            name="username"
            id="username"
            placeholder="请输入用户名"/>
    </div>
    <div class="dao-input"><label for="password">&nbsp;&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码：</label><input
            type="password"
            id="password"
            name="password"
            placeholder="请输入密码"/>
    </div>
    <div class="dao-yzm">
        <label for="yzm">&nbsp;&nbsp;&nbsp;&nbsp;验证码：</label><input id="yzm" name="yzm" placeholder="请输入验证码"/>
        <img style="height: 30px;width: 80px;border-radius:6px " src="${ctx}/util/getYzm">&nbsp;&nbsp;<span id="getYzm"
                                                                                                            style="cursor: pointer">看不清？</span>
    </div>
    <div class="dao-input" style=" width: 100%;
        margin-left:125px ;">&nbsp;&nbsp;&nbsp;&nbsp;<input id="remenber" name="remenber" type="checkbox">

        <label for="remenber">&nbsp;&nbsp;记住我</label>
    </div>
    <div id="register">
        <sapn>还没有账号？请点击注册</sapn>
    </div>
    <div class="go dao-btn">Let's Go!</div>

</div>

</body>
</html>
