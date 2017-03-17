/**
 * Created by zxdong on 2017/1/28.
 */
(function ($) {

    $.fn.daoTable = function (data) {
        var opts = $.extend({}, $.fn.daoTable.defaults, data);
        return this.each(function () {
            $this = $(this);
            var o = $.meta ? $.extend({}, opts, $this.data()) : opts;
            $.fn.drawTable(o, $this);
        });

    };

    $.fn.daoTable.defaults = {
        wrap_width: '80%',
        wrap_mgntop: '50px',
        // title: '',
        // data: '',//表格数据
        // op: '',//操作
        onDelete: function () {
            return false;
        }, onEdit: function () {
            return false;
        }, onLook: function () {
            return false;
        }

    };

    $.fn.drawTable = function (o, obj) {
        var htmlstr = ' <table class="table table-responsive table-hover"> <thead><tr>';

        // 处理头部
        $.each(o.title, function (index, item) {
            htmlstr += '<th';

            if (o.talign.indexOf(item) != -1) {
                if(o.twidth[index]!=null){
                    htmlstr += ' style="text-align: center;width:'+o.twidth[index]+';"';
                }else{
                    htmlstr += ' style="text-align: center"';
                }

            } else{
                if(o.twidth[index]!=null){
                    htmlstr += ' style="width:'+o.twidth[index]+';"';
                }
            }

            htmlstr +='>'+item + '</>';
        })
        htmlstr += '</tr></thead><tbody>';
        $.each(o.data, function (index, item) {
            htmlstr += '<tr id="'+item.id+'">';
            //处理每一个datable
            for (var i = 0; i < o.type.length; i++) {
                var daotype = o.type[i];
                htmlstr += '<td type="' + daotype + '">';
                htmlstr += item[daotype];
                htmlstr += '</td>';
            }
            var opstr = '';
            for (var i = 0; i < o.op.length; i++) {
                if (o.op[i] == 'delete') {
                    opstr += '<span  class="delete" title="删除信息"><img class="dao-btn" style="height: 23px;width: 23px;" src="' + $_ctx + '/resources/img/edit.png"/></span>'


                } else if (o.op[i] == 'edit') {
                    opstr += '<span  class="edit" title="编辑信息"><img class="dao-btn" style="height: 23px;width: 23px;" src="' + $_ctx + '/resources/img/edit.png"/></span>'

                } else if (o.op[i] == 'look') {
                    opstr += '<span class="look" title="查看信息"><img class="dao-btn"  style="height: 23px;width: 23px;" src="' + $_ctx + '/resources/img/edit.png"/></span>'
                }
            }
            if (opstr != '') {
                htmlstr += '<td style="text-align: center">' + opstr + ' </td>';

            }

            htmlstr += '</tr>';
        })
        htmlstr += '</tbody>';

        $(obj).html(htmlstr);
        $(obj).css({
            'width': o.wrap_width,
            'margin': 'auto',
            'margin-top': o.wrap_mgntop
        });

        $('.look').click(function () {
            o.onLook($(this).parents('tr').attr('id'));
        });
        $('.edit').click(function () {
            o.onEdit($(this).parents('tr').attr('id'));
        });
        $('.delete').click(function () {
            o.onDelete($(this).parents('tr').attr('id'));
        });


    };

})(jQuery);