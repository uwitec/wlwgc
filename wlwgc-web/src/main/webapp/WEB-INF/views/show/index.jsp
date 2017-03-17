
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<link rel="shortcut icon" type="image/x-icon" href="/sources/ico/${page}.ico"  />--%>
    <%@ include file="/WEB-INF/views/inc/link.jsp" %>

</head>
<body>

<!-- 引入主页头部 -->
<%@ include file="/WEB-INF/views/inc/menu.jsp" %>

<c:choose>

    <c:when test="${page eq pageutils.home}">
        <title>唯美首页</title>
        <!-- 引入主页界面 -->
        <%@ include file="/WEB-INF/views/container/home.jsp" %>
        <script type="text/javascript">
            $(function () {
                $('.dao-menu .dao-left').addClass('clickmenu');
            })
        </script>
    </c:when>


    <c:when test="${page eq pageutils.yhgl}">
        <title>用户管理</title>
        <%@ include file="/WEB-INF/views/container/yhgl.jsp" %>
        <script type="text/javascript">
            $(function () {
                $('.pagejump[target="yhgl"]').addClass('clickmenu');
            })
        </script>
    </c:when>

    <c:when test="${page eq pageutils.ssjc}">
        <title>实时监测</title>
        <%@ include file="/WEB-INF/views/container/ssjc.jsp" %>
        <script type="text/javascript">
            $(function () {
                $('.pagejump[target="ssjc"]').addClass('clickmenu');
            })
        </script>
    </c:when>

    <c:when test="${page eq pageutils.kzsz}">
        <title>阈值设置</title>
        <%@ include file="/WEB-INF/views/container/kzsz.jsp" %>
        <script type="text/javascript">
            $(function () {
                $('.pagejump[target="kzsz"]').addClass('clickmenu');
            })
        </script>
    </c:when>
    <c:when test="${page eq pageutils.qygl}">
        <title>区域管理</title>
        <%@ include file="/WEB-INF/views/container/qygl.jsp" %>
        <script type="text/javascript">
            $(function () {
                $('.pagejump[target="qygl"]').addClass('clickmenu');
            })
        </script>
    </c:when>
    <c:when test="${page eq pageutils.zjqgl}">
        <title>中继器管理</title>
        <%@ include file="/WEB-INF/views/container/zjqgl.jsp" %>
        <script type="text/javascript">
            $(function () {
                $('.pagejump[target="zjqgl"]').addClass('clickmenu');
            })
        </script>
    </c:when>
    <c:when test="${page eq pageutils.zdgl}">
        <title>终端管理</title>
        <%@ include file="/WEB-INF/views/container/zdgl.jsp" %>
        <script type="text/javascript">
            $(function () {
                $('.pagejump[target="zdgl"]').addClass('clickmenu');
            })
        </script>
    </c:when>
    <c:when test="${page eq pageutils.usercenter}">
        <title>个人中心</title>
        <!-- 引入个人中心界面 -->
        <%@ include file="/WEB-INF/views/container/usercenter.jsp" %>
        <script type="text/javascript">
            $(function () {
                $('.pagejump[target="usercenter"]').addClass('clickmenu');
            })
        </script>
    </c:when>

    <c:when test="${page eq pageutils.sbgl}">
        <title>设备管理</title>
        <%@ include file="/WEB-INF/views/container/sbgl.jsp" %>
        <script type="text/javascript">
            $(function () {
                $('.pagejump[target="sbgl"]').addClass('clickmenu');
            })
        </script>
    </c:when>

    <c:otherwise>
        <!-- 引入单个歌手界面-->
        <title>唯美首页</title>
        <%@ include file="/WEB-INF/views/container/home.jsp" %>
    </c:otherwise>
</c:choose>





<!-- 引入尾部 -->
<%@ include file="/WEB-INF/views/inc/footer.jsp" %>
</body>
</html>