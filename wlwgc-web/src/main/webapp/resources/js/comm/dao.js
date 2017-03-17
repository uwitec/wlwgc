/**
 * Created by zxdong on 2017/1/19.
 */


var dao={

    getData:function (url,callback) {
        $.post(url,function (data,stadius) {
            if(stadius=='success'){
                callback(data);
            }else{
                console.info('数据访问失败');
            }
        });

    },
    getDataByPost:function (url,param,callback) {
        $.post(url,param,function (data,stadius) {
            if(stadius=='success'){
                callback(data);
            }else{
                console.info('数据访问失败');
            }
        });

    },
    getDataByAjax:function (param,pdata,callback) {
        $.ajax({
            type: param.type,
            url: param.url,
            data: pdata,
            beforeSend:function () {

                dealload();

            },
            success: function (data,stdius) {
                if(stdius=='success'){
                    $('.sk-double-bounce ').remove();
                    callback(data);
                }
            }
        });
    }


}
function  dealload() {

    $('body').append('<div class="sk-double-bounce">'+
        '<div class="sk-child sk-double-bounce1"></div>'+
        '<div class="sk-child sk-double-bounce2"></div>'+
        '</div>');
    $('.sk-double-bounce').css({
        'top':  ($(document).height()/3) + 'px',
        'left':  ($(document).width()/2) + 'px'
    });

}