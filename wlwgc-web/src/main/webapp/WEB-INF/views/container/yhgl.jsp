<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        var tbpagenum=1;
        getpageUser(tbpagenum);
    })

    var dealdata=function (data) {
        $('.dao-table').daoTable({
            title:['用户名','权限','区域ID','备注','操作'],
            twidth:['15%','15%','15%','25%','30%'],
            talign:['操作'],
            type:['username','usertype','areaid','other'],
            wrap_mgntop:'100px',
            op:['edit'],
            data:data.t.rows,
            onEdit:function (id) {
                dao.getDataByPost($_ctx+'/user/findUserById',{id:id},function (d,stadius) {
console.info(d)
                })
            }

        })

        var count = Math.ceil(data.t.total / 10);
        $('.dao-page').daoPage( {
            pagestart: data.t.pagenum,
            pagetotal: count,
            showpage:5,
            toPage: function (page) {
                getpageUser(page);
            }
        })

    }

    var getpageUser=function (tbpagenum) {
        dao.getDataByAjax({type:'post',url:$_ctx+'/user/findUserByPage'},{
            pagesize: 10,
            pagenum: tbpagenum
        },dealdata)
    }
</script>

<div class="dao-table">

</div>

<div class="dao-page"></div>