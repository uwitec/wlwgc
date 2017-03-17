<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<style type="text/css">
    .header-wrap{
        margin-top: 40px;
    }
</style>

<script type="text/javascript"></script>
<div class="header-wrap">
    <div class="form-group col-lg-5 col-md-5 col-lg-offset-1 col-md-offset-1">
        <label class="col-lg-2 col-md-2 control-label" for="areaid" style="line-height: 30px;">区域：</label>
        <div class="col-lg-10 col-md-10">
            <input type="text" name="areaid" id="areaid" title="区域ID" class="form-control"
                   placeholder="请选择区域" readonly="readonly">
            <div id="arealbl" ></div>
        </div>

    </div>
    <div class="form-group col-lg-5 col-md-5 col-lg-offset-1 col-md-offset-1"><button class="dao-btn" id="checkarea">检测</button></div>
</div>
<div class="dao-table">

</div>

<div class="dao-page"></div>