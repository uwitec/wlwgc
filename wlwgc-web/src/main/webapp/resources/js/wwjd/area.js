/**
 * Created by zxdong on 2017/2/4.
 */
$(function () {


var sea=true;
var keyval='';
var pagenum=1;
$('#areaid').click(function () {
    getpagedata(pagenum);

})
// 失焦


function getpagedata(pagenum) {
    $('#arealbl').slideDown();
    dao.getDataByAjax({type:'post',url:$_ctx + '/area//findAreaByPage'},{
        pagesize: 5,
        pagenum: pagenum
    },dealPagedata)
}

function dealPagedata(areadata) {
    data=areadata.t;
    pagenum = data.pagenum;
    var total = Math.ceil(data.total / 5);
    var htmlstr = '';
    $.each(data.rows, function (index, item) {
        htmlstr += '<div code="' + item.id + '"  class="areaval">' + item.name+'('+item.id+')' + '</div>'
    })
    if (htmlstr != '') {
        if (pagenum == 1) {
            if (pagenum == total) {
                htmlstr += '<div style="height: 2px;margin-top: 0px;margin-bottom: 0px;background-color:#000"></div><div class="pagexx"><label>' + pagenum + '/' + total + '</label></div>';
            } else {
                htmlstr += '<div style="height: 2px;margin-top: 0px;margin-bottom: 0px;background-color:#000"></div><div class="pagexx"><label>' + pagenum + '/' + total + '</label><div class="page-next"><button pagenum="' + (pagenum + 1) + '"  class="dao-btn-pn">下一页</button></div></div>';
            }
        } else if (pagenum == total) {
            htmlstr += '<div style="height: 2px;margin-top: 0px;margin-bottom: 0px;background-color:#000"></div><div class="pagexx"><div class="page-pre"><button pagenum="' + (pagenum - 1) + '" class="dao-btn-pn">上一页</button></div><label>' + pagenum + '/' + total + '</label>';

        } else {
            htmlstr += '<div style="height: 2px;margin-top: 0px;margin-bottom: 0px;background-color:#000"></div><div class="pagexx"><div class="page-pre"><button pagenum="' + (pagenum - 1) + '" class="dao-btn-pn">上一页</button></div><label>' + pagenum + '/' + total + '</label><div class="page-next"><button pagenum="' + (pagenum + 1) + '"  class="dao-btn-pn">下一页</button></div></div>';

        }
    }else{
        htmlstr='<div id="no-data">暂无数据</div>'
    }
    $('#arealbl').html(htmlstr);
    $('#arealbl').css({
        'position':'absolute',
        'width':'95%',
        'z-index':'999'
    })
    $('.areaval').css({
        'display': 'block',
        'text-align': 'center',
        'cursor': 'pointer',
        'line-height': '25px',
        'border-bottom': '1px dashed #90EE90',
        'border-top': '1px dashed #90EE90',
        'background-color': '#CCCCCC',
        'color': '#000000'
    });
    $('.pagexx').css({
        'background-color': '#CCCCCC',
        'color': '#000000'
    });
    $('.page-pre').css({'cursor': 'pointer', 'float': 'left'});
    $('.page-next').css({'cursor': 'pointer', 'float': 'right'});

    $('.areaval').hover(function () {
        $(this).css({'background-color': '#551A8B', 'color': '#FFFFFF'});
    }, function () {
        $(this).css({'background-color': '#CCCCCC', 'color': '#000000'});
    })

    $('.areaval').click(function () {
        $('#areaid').val($(this).attr('code'));
        $('#arealbl').slideToggle();
    });

    $('.page-pre').find('button').click(function () {
        pagenum = $(this).attr('pagenum');
        getpagedata(pagenum)
    });

    $('.page-next').find('button').click(function () {
        pagenum = $(this).attr('pagenum');
        getpagedata(pagenum)
    });



}
})