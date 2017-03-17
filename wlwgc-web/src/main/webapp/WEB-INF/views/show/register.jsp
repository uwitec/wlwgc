<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/inc/taglibs.jsp" %>
<html>
<head>
    <%@ include file="/WEB-INF/views/inc/meta.jsp" %>
    <%@ include file="/WEB-INF/views/inc/link.jsp" %>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/register/register.css"/>


    <title>请注册</title>

    <script>

    </script>

</head>
<body background="${ctx}/resources/img/registerbg.jpg">


            <div id="wwjd-register">

                    <!-- 基本信息填写 -->
                    <small class="text-muted m-b">
                        <form action="${ctx}/user/register" class="bs-example form-horizontal" id="register_form"
                              method="post" onsubmit="return check(this)">

                            <div class="form-group">
                                <label class="col-lg-2 col-md-2 control-label" for="username">用户名：</label>
                                <div class="col-lg-9 col-md-9">
                                    <input type="text" name="username" id="username" class="form-control" title="用户名"
                                           placeholder="请填写用户名" required="required">
                                </div>
                                <div class="col-lg-1 col-md-1 flag-img-box" id="username_flag">

                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-lg-2 col-md-2 control-label" for="password">密码：</label>
                                <div class="col-lg-9 col-md-9">
                                    <input type="password" name="password" id="password" title="密码" class="form-control"
                                           placeholder="请填写密码" required="required">
                                </div>
                                <div class="col-lg-1 col-md-1 flag-img-box" id="password_flag">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-lg-2 col-md-2 control-label" for="password2">确认密码：</label>
                                <div class="col-lg-9 col-md-9">
                                    <input type="password" name="password2" id="password2" title="确认密码"
                                           class="form-control" placeholder="请确认密码" required="required">
                                </div>
                                <div class="col-lg-1 col-md-1 flag-img-box" id="password2_flag">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-lg-2 col-md-2 control-label" for="realname">真实姓名：</label>
                                <div class="col-lg-9 col-md-9">
                                    <input type="text" name="realname" id="realname" title="真实姓名" class="form-control"
                                           placeholder="请输入真实姓名">
                                </div>
                                <div class="col-lg-1 col-md-1 flag-img-box" id="realname_flag">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-lg-2 col-md-2 control-label" for="areaid">区域ID：</label>
                                <div class="col-lg-9 col-md-9">
                                    <input type="text" name="areaid" id="areaid" title="区域ID" class="form-control"
                                           placeholder="请选择区域ID" readonly="readonly">
                                    <div id="arealbl" ></div>
                                </div>

                                <div class="col-lg-1 col-md-1 flag-img-box" id="areaid_flag">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-lg-2 col-md-2 control-label" for="other">备&nbsp;&nbsp;注：</label>
                                <div class="col-lg-9 col-md-9">
                                    <textarea name="other" id="other" class="form-control" title="备注"
                                              placeholder="请填写备注"
                                              style="overflow-y:auto;resize: none;height: 80px"></textarea>

                                </div>
                                <div class="col-lg-1 col-md-1 flag-img-box" id="other_flag"></div>
                            </div>

                            <div class="form-group">
                                <label class="col-lg-2 col-md-2 control-label">注册之后：</label>
                                <div class="col-lg-9 col-md-9">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="zczh" id="optionsRadios1" value="1" checked>跳转到登录界面登录其他用户
                                        </label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <label>
                                            <input type="radio" name="zczh" id="optionsRadios2" value="2">直接使用注册的账号登录
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-offset-2 col-lg-3 col-md-offset-2 col-md-3">
                                    <button type="submit" id="register_sumbit" class="btn btn-primary text-right">注册
                                    </button>
                                </div>
                                <div class=" col-lg-6 col-md-6">
                                    <button type="button" id="login_button" class="btn  text-right">我有账号</button>
                                </div>
                            </div>



                        </form>
                    </small>
                </div>

            </div>
        </div>
        <script src="${ctx}/resources/js/register/register.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>
