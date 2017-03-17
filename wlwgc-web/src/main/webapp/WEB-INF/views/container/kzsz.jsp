<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<script src="${ctx}/resources/js/wwjd/dao-kzsz.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/wwjd/kzsz.js"></script>



<div class="dao-table" style=" margin: auto;
        width: 800px;
        margin-top: 50px;">

    <table class="table table-responsive table-bordered table-hover">
        <thead>
        <tr>
            <th>参数名称</th>
            <th>范围上限</th>
            <th>范围下限</th>
        </tr>
        </thead>
        <tbody id="kzsz">
        </tbody>
    </table>

</div>
<div class="col-md-4 col-md-offset-2 col-lg-4 col-lg-offset-2">
    <button class="dao-btn" id="savekzsz">提交</button>
</div>
