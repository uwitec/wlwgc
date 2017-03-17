/**
 * Created by zxdong on 2017/2/6.
 */

/**
 * Created by zxdong on 2017/1/28.
 */
(function ($) {


    $.fn.daoKZSZ = function (data) {
        var opts = $.extend({}, $.fn.daoKZSZ.defaults, data);
        return this.each(function () {
            $this = $(this);
            var o = $.meta ? $.extend({}, opts, $this.data()) : opts;
            $.fn.drawKZSZ(o, $this);
        });

    };

    $.fn.daoKZSZ.defaults = {    };

    $.fn.drawKZSZ= function (o, obj) {

        var rs='';
        
        $.each(o.data,function (index,item) {
            rs+='<tr id="'+item.id+'">';

            rs+='<td> <label style="line-height: 35px;">'+item.csname+'</label></td>';

            var option_f='',option_l='';

            if(item.cscode=='00'){
                option_f=getSelect({
                    first:-50,
                    last:100,
                    default:item.first
                });
                option_l=getSelect({
                    first:-50,
                    last:100,
                    default:item.last
                });
            }else if(item.cscode=='01'){
                option_f=getSelect({
                    first:-50,
                    last:100,
                    default:item.first
                });
                option_l=getSelect({
                    first:-50,
                    last:100,
                    default:item.last
                });
            }else if(item.cscode=='02'){
                option_f=getSelect({
                    first:-50,
                    last:100,
                    default:item.first
                });
                option_l=getSelect({
                    first:-50,
                    last:100,
                    default:item.last
                });
            }else if(item.cscode=='03'){
                option_f=getSelect({
                    first:-50,
                    last:100,
                    default:item.first
                });
                option_l=getSelect({
                    first:-50,
                    last:100,
                    default:item.last
                });
            }else if(item.cscode=='04'){
                option_f=getSelect({
                    first:-50,
                    last:100,
                    default:item.first
                });
                option_l=getSelect({
                    first:-50,
                    last:100,
                    default:item.last
                });
            }else if(item.cscode=='05'){
                option_f=getSelect({
                    first:-50,
                    last:100,
                    default:item.first
                });
                option_l=getSelect({
                    first:-50,
                    last:100,
                    default:item.last
                });
            }
            rs+='<td>  <select class="form-control" id="'+item.cscode+'_sx" name="'+item.cscode+'_sx">'+option_f+'</select></td>';


            rs+='<td><select class="form-control" id="'+item.cscode+'_xx" name="'+item.cscode+'_xx">'+option_l+'</select></td>';


            rs+='</tr>';
        })


        $(obj).html(rs);


        function getSelect(data) {
            var opts = $.extend({}, {
                s_wth: '100%',
                first:-50,
                last:100,
                default:0
            }, data);


                var o = $.meta ? $.extend({}, opts, $this.data()) : opts;


                return $.fn.drawSelect(o);


        };



    }







    $.fn.drawSelect = function (o) {

        var rs='';
        for(var i=o.first;i<=o.last;i++){
            rs+=getOPtions(i);
        }




        function getOPtions(num) {
            if(num==o.default){
                return '<option value="'+num+'" selected>'+num+'</option>';
            }
            return '<option value="'+num+'">'+num+'</option>';
        }

        return rs;

    }

})(jQuery);