/**
 * Created by zxdong on 2017/1/16.
 */

$(function () {
    $('#usermsg').hover(function () {
        $('#userset').slideDown();
    }, function () {
        $('#userset').slideUp();
    })

    $('.pagejump').click(function () {
        var target = $(this).attr('target');
        if (target == 'exit') {
            location.href=$_ctx+'/login/exit';
        } else {
            location.href = $_ctx + '/page/' + target;
        }
    });
    // $.fn.snow({
    //     minSize: 3,	//雪花的最小尺寸
    //     maxSize: 80, //雪花的最大尺寸
    //     newOn: 150,	//雪花出现的频率 这个数值越小雪花越多
    //     iswwjd:true
    //
    // });
})