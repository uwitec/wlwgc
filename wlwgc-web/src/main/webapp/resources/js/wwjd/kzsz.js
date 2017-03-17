/**
 * Created by zxdong on 2017/2/8.
 */
$(function () {
    getkzs();

    $('#savekzsz').click(function () {

        var kzs = $('#kzsz').find('tr');

        var datajson =new Array();

        for (var i = 0; i < kzs.length; i++) {
            var id = $(kzs[i]).attr('id');
            var sx = $(kzs[i]).find('[name$="sx"]').val();
            var xx = $(kzs[i]).find('[name$="xx"]').val();
            var kzjson = JSON.parse(localStorage.getItem('kzjson'));
            for (var j = 0; j < kzjson.length; j++) {
                if (id == kzjson[j].id) {
                    if (sx != kzjson[i].first) {
                        if (xx != kzjson[i].last) {
                            datajson.push({'id': id, 'first': sx, 'last': xx});
                        } else {
                            datajson.push({'id': id, 'first': sx});
                        }
                    } else {
                        if (xx != kzjson[i].last) {
                            datajson.push({'id': id, 'last': xx});
                        }
                    }


                }
            }


        }

        dao.getDataByAjax({type:'post',url:$_ctx+'/kzgl/update'},{'kzgls': JSON.stringify(datajson)},updateOver)


    });

})
var getkzs=function () {
    $.post($_ctx + '/kzgl/find', function (data, stadius) {
        if (stadius == 'success') {
            localStorage.removeItem('kzjson');
            localStorage.setItem('kzjson', JSON.stringify(data.t));
            $('#kzsz').daoKZSZ({
                data: data.t
            })
        }
    })
}
function updateOver(data){
    getkzs();
}