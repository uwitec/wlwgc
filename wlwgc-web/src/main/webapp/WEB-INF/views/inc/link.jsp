<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%--引入jquery--%>
<script src="${ctx}/resources/plugs/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${ctx}/resources/plugs/jquerySession.js"></script>
<script src="${ctx}/resources/plugs/jquery.cookie.js" type="text/javascript"></script>


<%--引入bootstrap--%>
<script src="${ctx}/resources/plugs/bootstrap/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/plugs/bootstrap/css/bootstrap-theme.css"/>
<link rel="stylesheet" href="${ctx}/resources/plugs/bootstrap/css/bootstrap.css"/>



<%--引入对话框js--%>
<script type="text/javascript" src="${ctx}/resources/plugs/xcConfirm/js/xcConfirm.js"></script>
<link rel="stylesheet" href="${ctx}/resources/plugs/xcConfirm/css/xcConfirm.css"/>


<%--引自己开发的插件的js和自己写的css样式--%>
<link rel="stylesheet" href="${ctx}/resources/css/wwjd/wwjd.css"/>
<link href="${ctx}/resources/css/inc/loading.css" rel="stylesheet"/>
<link href="${ctx}/resources/css/wwjd/adao.css" rel="stylesheet"/>


<script src="${ctx}/resources/js/wwjd/dao-page.js"></script>
<script src="${ctx}/resources/js/wwjd/dao-table.js"></script>
<script src="${ctx}/resources/js/comm/dao.js"></script>
<script src="${ctx}/resources/js/wwjd/area.js"></script>


<script type="text/javascript">
    //去除左右两端的空格
    function trim(str) {
        if (str == null) {
            str = "";
        }
        return str.replace(/(^\s*)|(\s*$)/g, "");
    }
    ;
</script>








	
	
	
	