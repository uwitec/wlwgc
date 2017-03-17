(function($) {

	$.fn.daoPage = function(data) {
		var opts = $.extend({}, $.fn.daoPage.defaults, data);
		return this.each(function() {
			$this = $(this);
			var o = $.meta ? $.extend({}, opts, $this.data()) : opts;
			$.fn.draw(o, $this, o.pagestart);
		});

	};

	$.fn.daoPage.defaults = {
		bgcolor: '#A2CD5A',
		bghovercolor: '#000000',
		bgshowcolor: '#8B5A00',
		showpage: 7,
		pagestart: 1,
		pagetotal: 10,

		toPage: function() {
			return false;
		}

	};

	$.fn.draw = function(o, obj, selectpage) {

		var oldps = o.pagestart;
		var pagestart = selectpage;
		var showpage = o.showpage;
		var bgcolor = o.bgcolor;
		var bghovercolor = o.bghovercolor;
		var bgshowcolor = o.bgshowcolor;
		var pagetotal = o.pagetotal;


		var fontcolor = oppositeColor(bgshowcolor);
		var color = oppositeColor(bgcolor);
		var hcolor = oppositeColor(bghovercolor);
		var str = '';

		str += '<div class="dao-sy dao-page topage" id="1">首页</div>';
		str += '<div class="dao-li dao-page" id="dao-pre">&lt;&lt;</div>';

		if (pagetotal < showpage) {
			showpage = pagetotal;
		}
		//这个宽度可能要重新调整。。。原因不详
		var wd = 285 + 35* showpage;
		//页面显示情况
		var page = Math.floor(showpage / 2);

		if (oldps == pagestart) {
			if (oldps - page <= 0) {
				pagestart = 1;
			} else if (pagetotal - oldps < page) {
				pagestart = pagetotal - showpage + 1;
			} else {
				pagestart = oldps - page;
			}
		} else {
			if (pagestart + showpage > pagetotal + 1) {
				pagestart = pagetotal - showpage + 1;
			} else if (pagestart < 1) {
				pagestart = 1;
			}
		}
		for (var i = 0; i < showpage; i++) {
			str += '<div class="dao-li dao-page topage" id="' + (pagestart + i) + '">' + (pagestart + i) + '</div>';
		}

		str += '<div class="dao-li dao-page" id="dao-next">&gt;&gt;</div>';
		str += '<div class="dao-wy dao-page topage" id="' + pagetotal + '">尾页</div>';
		str += '<div class="dao-in"><input type="text" id="goPage" value="' + oldps + '"/><div class="xu-btn">Go</div></div>';
		$(obj).html(str);

		function oppositeColor(a) {
			a = a.replace('#', '');
			var c16, c10, max16 = 15,
				b = [];
			for (var i = 0; i < a.length; i++) {
				c16 = parseInt(a.charAt(i), 16); //  to 16进制
				c10 = parseInt(max16 - c16, 10); // 10进制计算
				b.push(c10.toString(16)); // to 16进制
			}
			return '#' + b.join('');
		}

		$(obj).css({
			'display': 'block',
			'line-height': '25px',
			'width': wd + 'px',
			'height': '27px',
			'margin': 'auto'
		})

		$(obj).find('.dao-page').css({
			'display': 'block',
			'float': 'left',
			'border': '1px solid #003333',
			'margin-left': '5px',
			'text-align': 'center',
			'background-color': bgcolor,
			'color': color,
			'cursor': 'pointer',
			'transition': '0.5s ease-out',
			'-moz-transition': '0.5s ease-out',
			'-webkit-transition': '0.5s ease-out'
		});
		$(obj).find('.dao-in #goPage').css({
			'width': '50px',
			'height': '30px',
			'border': '1px solid #9400D3',
			'margin-left': '25px',
			'border-radius': '9px',
			'background': '#2F4F4F',
			'color': '#E0FFFF',
			'transition': '0.3s ease-out',
			'-moz-transition': '0.3s ease-out',
			'-webkit-transition': '0.3s ease-out'
		});
		$(obj).find('.dao-in #goPage').focus(function() {
			$(this).css({
				'background': '#698B22',
				'color': '#FFE4E1',
			});
			var filter = /^[0-9]*[1-9][0-9]*$/;
			$this = $(this);

			$(document).on('keyup', function(event) {
				if ($($this).val() != '') {

					if (!filter.test($($this).val())) {
						$($this).val('')
					}
					if ($($this).val() > pagetotal) {
						$($this).val('')
					}
				}
			})
		});
		$(obj).find('.dao-in #goPage').focusout(function() {
			$(this).css({
				'background': '#2F4F4F',
				'color': '#E0FFFF',
			});
			if ($($this).val() == ''){
				$($this).val(oldps)
			}
		});

		$(obj).find('.dao-in .xu-btn').css({
			'display': 'block',
			'float': 'right',
			'width': '30px',
			'line-height': '30px',
			'border': '1px solid #9400D3',
			'border-radius': '8px',
			'text-align': 'center',
			'cursor': 'pointer',
			'background': '#363636',
			'color': '#00FF00',
			'transition': '0.5s ease-out',
			'-moz-transition': '0.5s ease-out',
			'-webkit-transition': '0.5s ease-out'
		});
		$(obj).find('.dao-in .xu-btn').hover(function() {
			$(this).css({
				'background': '#1C1C1C',
				'color': '#FFA500',
				'transform': 'scale(0.9)'
			});
		}, function() {
			$(this).css({
				'background': '#363636',
				'color': '#00FF00',
				'transform': 'scale(1.0)'
			});
		});

		$(obj).find('.dao-li').css({
			'width': '30px'
		});
		$(obj).find('.dao-sy').css({
			'width': '50px'
		});

		$(obj).find('.dao-wy').css({
			'width': '50px'
		});

		$(obj).find('.dao-li#' + oldps).css({

			'background-color': bgshowcolor,
			'color': fontcolor,
			'transition': '0.5s ease-out',
			'-moz-transition': '0.5s ease-out',
			'-webkit-transition': '0.5s ease-out'

		});
		$(obj).find('.dao-page').hover(function() {
			$(this).css({
				'background-color': bghovercolor,
				'color': hcolor,
				'transform': 'scale(1.1)'
			})
		}, function() {
			if (this.id != oldps) {
				$(this).css({
					'background-color': bgcolor,
					'color': color,
					'transform': 'scale(1.0)'
				})
			} else {
				$(this).css({
					'background-color': bgshowcolor,
					'color': fontcolor,
					'transform': 'scale(1.0)'
				})
			}
		});

		$(obj).find('.topage').click(function() {
			o.toPage(this.id);
		})
		$(obj).find('.dao-in .xu-btn').click(function() {
			o.toPage($(obj).find('.dao-in #goPage').val());
		})

		$('#dao-pre').click(function() {

			if (pagestart != 0) {

				pagestart = pagestart - showpage;
				$.fn.draw(o, obj, pagestart);

			}
		});

		$('#dao-next').click(function() {

			if (pagestart < pagetotal) {

				pagestart = pagestart + showpage;
				$.fn.draw(o, obj, pagestart);

			}
		});

	};

})(jQuery);