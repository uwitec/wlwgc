<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/register/register.css"/>
<div class="dao-shadow">    
</div>
<div id="edityh">
    <form action="${ctx}/user/update" class="bs-example form-horizontal" id="register_form"
          method="post" onsubmit="return check(this)">
        <input name="id" id="id" class="dao-hide" />
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
            <div class="col-lg-offset-2 col-lg-3 col-md-offset-2 col-md-3">
                <button type="submit" id="register_sumbit" class="btn btn-primary text-right">完成
                </button>
            </div>
            <div class=" col-lg-6 col-md-6">
                <button type="button" id="cancel_button" class="btn  text-right">取消</button>
            </div>
        </div>



    </form>
</div>