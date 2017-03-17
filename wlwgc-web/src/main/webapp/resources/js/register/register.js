/**
 * Created by dzx on 2016/10/31.
 */
$('#register_form #username').change(function () {
    $.post($_ctx + '/login/usernameIsNew', {username: $(this).val()}, function (data, stadius) {
        if (data == true) {
            imgSeccess('username_flag');
            return true;
        } else {
            $('#register_form #username').prop('value', '');
            imgError('username_flag');
            window.wxc.xcConfirm('注册信息：用户名已存在！', window.wxc.xcConfirm.typeEnum.error, {
                title: "错误"
            });
            $('#register_form #username').focus();
            return false;
        }
    });
});

$('#register_form [type="password"]').change(function () {
    var thisval = $(this).val();
    var thisid = this.id;
    var pwd = $('#register_form #password').val();
    var repwd = $('#register_form #password2').val();

    var filter = /^[\\@A-Za-z0-9\\!\\#\$\\%\^\\&\*\.\\~]{6,22}$/;
    if (filter.test(thisval)) {
        if (repwd != '') {
            if (pwd != '') {
                if (pwd == repwd) {
                    imgSeccess('password_flag');
                    cleanErrorMsg('register_form #password');
                    imgSeccess('password2_flag');
                    cleanErrorMsg('register_form #password2');
                    return true;
                } else {
                    imgError('password2_flag');
                    showErrorMsg('register_form #password2', '两次输入密码不同');
                }
            } else {
                imgError('password_flag');
                showErrorMsg('register_form #password', '密码未填写');
            }
        } else {
            cleanErrorMsg('register_form #password2');
        }
    } else {

        imgError(thisid + '_flag');

        showErrorMsg('register_form #' + thisid, '请输入合法密码（6~22位字符（字母+数字+特殊字符））');

    }
    return false;

});


$('#realname').change(function () {

    if ($(this).val().length > 20) {
        imgError('realname_flag');
        showErrorMsg('realname', '真实姓名不能超过20个字符');
        return false;

    } else {
        imgSeccess('realname_flag');
        cleanErrorMsg('realname');
        return true;
    }

})

$('#other').change(function () {

    if ($(this).val().length > 50) {
        imgError('other_flag');
        showErrorMsg('other', '备注不能超过50个字符');
        return false;

    } else {
        imgSeccess('other_flag');
        cleanErrorMsg('other');
        return true;
    }
})


function imgSeccess(argID) {
    $('#' + argID).html('<img alt="" src=' + $_ctx + '/resources/img/onSuccess.gif />');
}

function imgError(argID) {
    $('#' + argID).html('<img alt="" src=' + $_ctx + '/resources/img/onError.gif />');
}


function showErrorMsg(argID, argMsg) {
    $('#' + argID).attr('data-toggle', 'popover');
    $('#' + argID).attr('data-trigger', 'fouck');
    $('#' + argID).attr('data-placement', 'top');
    $('#' + argID).attr('data-content', argMsg);
    $('#' + argID).popover('show');
}

function cleanErrorMsg(argID) {
    $('#' + argID).removeAttr('data-toggle');
    $('#' + argID).removeAttr('data-trigger');
    $('#' + argID).removeAttr('data-placement');
    $('#' + argID).removeAttr('data-content');
    $('#' + argID).popover('destroy');
}

//建立一個可存取到該file的url
function getObjectURL(file) {
    var url = null;
    if (window.createObjectURL != undefined) { // basic
        url = window.createObjectURL(file);
    } else if (window.URL != undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file);
    } else if (window.webkitURL != undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file);
    }
    return url;
}

$('#login_button').click(function () {
    location.href = $_ctx + '/page/login';
});

function check() {

}

// var sea=true;
// var keyval='';
// var pagenum=1;
// $('#areaid').click(function () {
//             getpagedata(pagenum);
//
// })
//  // 失焦
//
//
// function getpagedata(pagenum) {
//     $('#arealbl').slideDown();
//     dao.getDataByAjax({type:'post',url:$_ctx + '/area//findAreaByPage'},{
//         pagesize: 5,
//         pagenum: pagenum
//     },dealPagedata)
// }
//
// function dealPagedata(areadata) {
//     data=areadata.t;
//     pagenum = data.pagenum;
//     var total = Math.ceil(data.total / 5);
//     var htmlstr = '';
//     $.each(data.rows, function (index, item) {
//         htmlstr += '<div code="' + item.id + '"  class="areaval">' + item.name+'('+item.id+')' + '</div>'
//     })
//     if (htmlstr != '') {
//         if (pagenum == 1) {
//             if (pagenum == total) {
//                 htmlstr += '<div style="height: 2px;margin-top: 0px;margin-bottom: 0px;background-color:#000"></div><div class="pagexx"><label>' + pagenum + '/' + total + '</label></div>';
//             } else {
//                 htmlstr += '<div style="height: 2px;margin-top: 0px;margin-bottom: 0px;background-color:#000"></div><div class="pagexx"><label>' + pagenum + '/' + total + '</label><div class="page-next"><button pagenum="' + (pagenum + 1) + '"  class="dao-btn-pn">下一页</button></div></div>';
//             }
//         } else if (pagenum == total) {
//             htmlstr += '<div style="height: 2px;margin-top: 0px;margin-bottom: 0px;background-color:#000"></div><div class="pagexx"><div class="page-pre"><button pagenum="' + (pagenum - 1) + '" class="dao-btn-pn">上一页</button></div><label>' + pagenum + '/' + total + '</label>';
//
//         } else {
//             htmlstr += '<div style="height: 2px;margin-top: 0px;margin-bottom: 0px;background-color:#000"></div><div class="pagexx"><div class="page-pre"><button pagenum="' + (pagenum - 1) + '" class="dao-btn-pn">上一页</button></div><label>' + pagenum + '/' + total + '</label><div class="page-next"><button pagenum="' + (pagenum + 1) + '"  class="dao-btn-pn">下一页</button></div></div>';
//
//         }
//     }else{
//         htmlstr='<div id="no-data">暂无数据</div>'
//     }
//     $('#arealbl').html(htmlstr);
//     $('#arealbl').css({
//         'position':'absolute',
//         'width':'95%',
//         'z-index':'999'
//     })
//     $('.areaval').css({
//         'display': 'block',
//         'text-align': 'center',
//         'cursor': 'pointer',
//         'line-height': '25px',
//         'border-bottom': '1px dashed #90EE90',
//         'border-top': '1px dashed #90EE90',
//         'background-color': '#CCCCCC',
//         'color': '#000000'
//     });
//     $('.pagexx').css({
//         'background-color': '#CCCCCC',
//         'color': '#000000'
//     });
//     $('.page-pre').css({'cursor': 'pointer', 'float': 'left'});
//     $('.page-next').css({'cursor': 'pointer', 'float': 'right'});
//
//     $('.areaval').hover(function () {
//         $(this).css({'background-color': '#551A8B', 'color': '#FFFFFF'});
//     }, function () {
//         $(this).css({'background-color': '#CCCCCC', 'color': '#000000'});
//     })
//
//     $('.areaval').click(function () {
//         $('#areaid').val($(this).attr('code'));
//         $('#arealbl').slideToggle();
//     });
//
//     $('.page-pre').find('button').click(function () {
//         pagenum = $(this).attr('pagenum');
//         getpagedata(pagenum)
//     });
//
//     $('.page-next').find('button').click(function () {
//         pagenum = $(this).attr('pagenum');
//         getpagedata(pagenum)
//     });
//
//
//
// }



