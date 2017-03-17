<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<script src="${ctx}/resources/js/wwjd/menu.js"></script>

<div class="dao-menu">
    <div class="dao-left"><span target="home" class="pagejump">My&nbsp;<i style="color: #F4FF77" class="glyphicon glyphicon-heart"></i>&nbsp;Territory</span></div>
    <div class="dao-mid">
        <span target="yhgl" class="pagejump"><i style="color: #d972ff" class="glyphicon glyphicon-pencil"></i>&nbsp;用户管理</span>
        <span target="ssjc" class="pagejump"><i style="color: #6cffe4" class="glyphicon glyphicon-list-alt"></i>&nbsp;实时监测</span>
        <span target="kzsz" class="pagejump"><i style="color: #65ff31" class="glyphicon glyphicon-picture"></i>&nbsp;阈值设置</span>
        <span target="qygl" class="pagejump"><i style="color: #ffb96a" class="glyphicon glyphicon-star"></i>&nbsp;区域管理</span>
        <span target="zjqgl" class="pagejump"><i style="color: #FF0000" class="glyphicon glyphicon-fire"></i>&nbsp;中继器管理</span>
        <span target="zdgl" class="pagejump"><i style="color: #9492ff" class="glyphicon glyphicon-bell"></i>终端管理</span>
        <span target="sbgl" class="pagejump"><i style="color: #9492ff" class="glyphicon glyphicon-bell"></i>设备管理</span>
    </div>
    <div class="dao-right">

        <div id="usermsg">
            <span><img src="${ctx}/resources/img/user.png" style="width:30px;height: 30px;border-radius:50%; "/>&nbsp;${currentUser.username}</span>
            <div id="userset">
                <span target="usercenter" class="pagejump"><i style="color: #9d1e91;" class="glyphicon glyphicon-globe"></i>&nbsp;个人中心</span>
                <span target="exit" class="pagejump"><i style="color: #ee78ff;" class="glyphicon glyphicon-log-out"></i>&nbsp;退出登录</span>
            </div>
        </div>

    </div>
</div>