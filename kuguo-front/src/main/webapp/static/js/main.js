(function($) {
	$.fn.AjaxBtn = function(afterLoad, getParams) {
		var t;
		return this.live("click", function(e) {
			clearTimeout(t);
			var obj = this;
			t = setTimeout(function() {
				var lock = lock || false;
				if (lock)
					return false;
				lock = true;
				var url = $(obj).attr("thelink");
				if (!url)
					return false;
				if (typeof getParams == "function")
					var params = getParams(obj);
				var params = params || {};
				$.post(url, params, function(xhr) {
					lock = false;
					if (typeof afterLoad == "function")
						afterLoad(obj, xhr)
				});
				e.preventDefault()
			}, 300)
		})
	};
	$.fn.WeiboShare = function(c) {
		return this.live("click", function(e) {
			e.preventDefault();
			if (typeof c == "function")
				var content = c(this);
			else
				var content = c;
			var pic = "";
			if ($(this).parent().attr("class").indexOf("link-row") != -1)
				pic = $(this).parents(".entity-notes, .notes").prev().find(
						".image img").attr("src");
			var url = location.href;
			var param = {
				url : url,
				type : "3",
				count : "0",
				appkey : "1459383851",
				title : content,
				pic : pic,
				ralateUid : "2179686555",
				rnd : (new Date).valueOf()
			};
			var temp = [];
			for ( var p in param) {
				temp.push(p + "=" + encodeURIComponent(param[p] || ""))
			}
			var link = "http://service.weibo.com/share/share.php?"
					+ temp.join("&");
			window.open(link)
		})
	};
	$.fn.TagAC = function() {
		var pos, tag, cursor, length, timeout, start = -1, ereg = /^[0-9a-zA-Z\u4e00-\u9fff\u3040-\u30FF\u30A0-\u30FF]*$/, dom = $('<div class="tag-auto-complete"><span>选择 # 标记或直接输入</span></div>');
		function init() {
			tag = "";
			cursor = -1;
			length = 0;
			dom.css("margin", "0");
			clearTimeout(timeout);
			$(".tag-auto-complete, .text_area").hide()
		}
		function getRes(obj, word, callback) {
			var word = word || "";
			var callback = callback || function() {
			};
			var url = "${ctx}/tagsuggest/";
			console.info(url);
			if (word) {
				if (!ereg.test(word)) {
					init();
					return false
				}
				url = url + "?prefix=" + word;
				dom.find("span").text()
			}
			$.post(url, {}, function(xhr) {
				dom.find("p").remove();
				if (xhr == "[]") {
					dom.find("span").text("轻敲空格完成输入")
				} else {
					dom.find("span").text("选择 # 标记或直接输入");
					var arr = eval(xhr);
					for ( var i in arr) {
						dom.append("<p># " + arr[i] + "</p>")
					}
					dom.find("p:first").addClass("hover")
				}
				callback();
				dom.css("margin-left", pos.left - 5).css("margin-top",
						pos.top + 25);
				dom.show();
				dom.find("p").mouseover(function() {
					dom.find("p").removeClass("hover");
					$(this).addClass("hover")
				}).click(function() {
					var text = $(this).text().replace("# ", "");
					var front = obj.val().slice(0, start);
					var back = obj.val().slice(cursor);
					obj.val(front + text + " " + back);
					init()
				})
			})
		}
		init();
		return this.live(
				"keyup",
				function(e) {
					var obj = $(this);
					var e = e || window.event;
					var code = e.which;
					cursor = e.target.selectionEnd;
					if (code == 51 && e.shiftKey) {
						init();
						start = e.target.selectionEnd;
						length = obj.val().length;
						var div_text = $('<div class="text_area"></div>');
						obj.after(div_text);
						div_text.html(obj.val().slice(0, start).replace(/\n/g,
								"<br>").replace(/\s/g, "&nbsp;")
								+ "<span class='pos'>&nbsp;</span>");
						pos = div_text.find(".pos").position();
						getRes(obj, tag,
								function() {
									if (obj.parent().find(".tag-auto-complete")
											.get(0) == undefined)
										obj.after(dom)
								})
					} else if (start >= 0 && length != obj.val().length
							&& !(code > 36 && code < 41)) {
						clearTimeout(timeout);
						length = obj.val().length;
						tag = obj.val().slice(start, cursor);
						timeout = setTimeout(function() {
							getRes(obj, tag)
						}, 300)
					}
				}).live("keydown", function(e) {
			if (start < 0)
				return true;
			var obj = $(this);
			var e = e || window.event;
			var code = e.which;
			cursor = e.target.selectionEnd;
			if (code == 8) {
				if (start == cursor) {
					init();
					start = -1
				}
			} else if (code == 27) {
				obj.blur()
			} else if (code == 13) {
				if (dom.css("display") == "none")
					return true;
				var cur = dom.find("p.hover");
				cur.click();
				e.preventDefault()
			} else if (code == 38) {
				if (dom.css("display") == "none")
					return true;
				var cur = dom.find("p.hover");
				if (cur.get(0) == dom.find("p:first").get(0)) {
					dom.find("p:last").mouseover()
				} else {
					cur.prev().mouseover()
				}
				e.preventDefault()
			} else if (code == 40) {
				if (dom.css("display") == "none")
					return true;
				var cur = dom.find("p.hover");
				if (cur.get(0) == dom.find("p:last").get(0)) {
					dom.find("p:first").mouseover()
				} else {
					cur.next().mouseover()
				}
				e.preventDefault()
			} else if (code == 37) {
				clearTimeout(timeout);
				if (cursor - 1 < start) {
					dom.hide();
					return true
				}
				tag = obj.val().slice(start, cursor - 1);
				timeout = setTimeout(function() {
					getRes(obj, tag)
				}, 300)
			} else if (code == 39) {
				clearTimeout(timeout);
				if (cursor + 1 >= start) {
					tag = obj.val().slice(start, cursor + 1);
					timeout = setTimeout(function() {
						getRes(obj, tag)
					}, 300)
				}
			}
		}).live("blur", function() {
			init()
		})
	};
	$.fn.FormChange = function(check) {
		var flag = true;
		var obj = this;
		if (typeof check == "function")
			flag = check();
		var now, old = this.serialize();
		this.find("input,textarea,select").keyup(
				function() {
					if ($(this).val() == ""
							&& $(this).attr("defaultValue") != undefined) {
						$(this).val($(this).attr("defaultValue"));
						now = obj.serialize();
						$(this).val("")
					} else
						now = obj.serialize();
					if (typeof check == "function")
						flag = check();
					if (old != now && flag) {
						obj.find("input[type='submit']").removeClass(
								"btn-v1 disable").addClass("btn-v2");
						obj.attr("enable", "true")
					} else {
						obj.find("input[type='submit']").removeClass("btn-v2")
								.addClass("btn-v1 disable");
						obj.attr("enable", "false")
					}
				}).change(function() {
			$(this).keyup()
		});
		return this
	}
})(jQuery);
jQuery(function() {
	initLayout();
	initInput();
	initUserTools();
	initLocation();
	initBackToTop();
	initFeedback();
	initPopupLogin();
	initFollowBtn();
	initLikeAction();
	initTag();
	initForm();
	if ($("#new-entity-form").get(0)) {
		initNewEntityForm()
	}
	if ($("#account-setting-form,#avatar-setting-form,#password-setting-form")
			.get(0)) {
		initSettingPage()
	}
	initDetailPage();
	initSelectedPage();
	if ($(".discover").get(0)) {
		initDiscoverPage()
	}
	if ($(".activities").get(0)) {
		initActivityPage()
	}
	if ($(".more-btn").get(0)) {
		initMoreBtn()
	}
});
function initLayout() {
	$("#popup-layer").click(function() {
		$("#feedback").hide();
		$("#popup-login").hide();
		$(this).hide()
	});
	var ml = $("#main-left").height();
	var mr = $("#main-right").height();
	var height = ml > mr ? ml - 107 : mr - 62;
	if ($("#main-left > div").length == 1) {
		$("#main-left .entity").css("min-height", height);
		$("#main-left .no-data").css("min-height", height - 22)
	}
}

function initInput() {
	$("input[type='text'], textarea").live("focus", function() {
		this.style.color = "#666666";
		if ($.trim(this.value) == $(this).attr("defaultValue")) {
			this.value = ""
		}
	}).live(
			"blur",
			function() {
				if ($.trim(this.value) == ""
						&& $(this).attr("defaultValue") != undefined) {
					this.value = $(this).attr("defaultValue");
					this.style.color = "#BBBBBB"
				}
			})
}

function initLocation() {
	var GP = [ "安徽", "澳门", "北京", "福建", "甘肃", "广东", "广西", "贵州", "海南", "河北",
			"河南", "黑龙江", "湖北", "湖南", "吉林", "江苏", "江西", "辽宁", "内蒙古", "宁夏", "青海",
			"山东", "山西", "陕西", "上海", "四川", "台湾", "天津", "西藏", "香港", "新疆", "云南",
			"浙江", "重庆", "海外" ];
	var GT = [
			[ "合肥", "安庆", "蚌埠", "亳州", "巢湖", "池州", "滁州", "阜阳", "淮北", "淮南", "黄山",
					"六安", "马鞍山", "宿州", "铜陵", "芜湖", "宣城" ],
			[ "澳门" ],
			[ "昌平", "朝阳", "崇文", "大兴", "东城", "房山", "丰台", "海淀", "怀柔", "门头沟",
					"密云", "平谷", "石景山", "顺义", "通州", "西城", "宣武", "延庆" ],
			[ "福州", "龙岩", "南平", "宁德", "莆田", "泉州", "三明", "厦门", "漳州" ],
			[ "兰州", "白银", "定西", "甘南", "嘉峪关", "金昌", "酒泉", "临夏", "陇南", "平凉",
					"庆阳", "天水", "武威", "张掖" ],
			[ "广州", "潮州", "东莞", "佛山", "河源", "惠州", "江门", "揭阳", "茂名", "梅州", "清远",
					"汕头", "汕尾", "韶关", "深圳", "阳江", "云浮", "湛江", "肇庆", "中山", "珠海" ],
			[ "桂林", "百色", "北海", "崇左", "防城港", "贵港", "河池", "贺州", "来宾", "柳州",
					"南宁", "钦州", "梧州", "玉林" ],
			[ "贵阳", "安顺", "毕节", "六盘水", "黔东南", "黔南", "黔西南", "铜仁", "遵义" ],
			[ "海口", "白沙", "保亭", "昌江", "澄迈", "儋州", "定安", "东方", "乐东", "临高", "陵水",
					"南沙群岛", "琼海", "琼中", "三亚", "屯昌", "万宁", "文昌", "五指山", "西沙群岛",
					"中沙群岛" ],
			[ "石家庄", "保定", "沧州", "承德", "邯郸", "衡水", "廊坊", "秦皇岛", "唐山", "邢台",
					"张家口" ],
			[ "郑州", "安阳", "鹤壁", "焦作", "开封", "洛阳", "漯河", "南阳", "平顶山", "濮阳",
					"三门峡", "商丘", "新乡", "信阳", "许昌", "周口", "驻马店" ],
			[ "哈尔滨", "大庆", "大兴安岭", "鹤岗", "黑河", "鸡西", "佳木斯", "牡丹江", "七台河",
					"齐齐哈尔", "双鸭山", "绥化", "伊春" ],
			[ "武汉", "鄂州", "恩施", "黄冈", "黄石", "荆门", "荆州", "潜江", "神农架", "十堰",
					"随州", "天门", "仙桃", "咸宁", "襄樊", "孝感", "宜昌" ],
			[ "长沙", "常德", "郴州", "衡阳", "怀化", "娄底", "邵阳", "湘潭", "湘西", "益阳", "永州",
					"岳阳", "张家界", "株洲" ],
			[ "长春", "白城", "白山", "吉林", "辽源", "四平", "松原", "通化", "延边" ],
			[ "南京", "常州", "淮安", "连云港", "南通", "苏州", "宿迁", "泰州", "无锡", "徐州",
					"盐城", "扬州", "镇江" ],
			[ "南昌", "抚州", "赣州", "吉安", "景德镇", "九江", "萍乡", "上饶", "新余", "宜春", "鹰潭" ],
			[ "沈阳", "鞍山", "本溪", "朝阳", "大连", "丹东", "抚顺", "阜新", "葫芦岛", "锦州",
					"辽阳", "盘锦", "铁岭", "营口" ],
			[ "呼和浩特", "阿拉善", "巴彦淖尔", "包头", "赤峰", "鄂尔多斯", "呼伦贝尔", "通辽", "乌海",
					"乌兰察布", "锡林郭勒", "兴安" ],
			[ "银川", "固原", "石嘴山", "吴忠", "中卫" ],
			[ "西宁", "果洛", "海北", "海东", "海南", "海西", "黄南", "玉树" ],
			[ "济南", "滨州", "德州", "东营", "菏泽", "济宁", "莱芜", "聊城", "临沂", "青岛", "日照",
					"泰安", "威海", "潍坊", "烟台", "枣庄", "淄博" ],
			[ "太原", "长治", "大同", "晋城", "晋中", "临汾", "吕梁", "朔州", "忻州", "阳泉", "运城" ],
			[ "西安", "安康", "宝鸡", "汉中", "商洛", "铜川", "渭南", "咸阳", "延安", "榆林" ],
			[ "宝山", "长宁", "崇明", "奉贤", "虹口", "黄浦", "嘉定", "金山", "静安", "卢湾", "闵行",
					"南汇", "浦东", "普陀", "青浦", "松江", "徐汇", "杨浦", "闸北" ],
			[ "成都", "阿坝", "巴中", "达州", "德阳", "甘孜", "广安", "广元", "乐山", "凉山", "泸州",
					"眉山", "绵阳", "内江", "南充", "攀枝花", "遂宁", "雅安", "宜宾", "资阳", "自贡" ],
			[ "台北", "阿莲", "安定", "安平", "八德", "八里", "白河", "白沙", "板桥", "褒忠", "宝山",
					"卑南", "北斗", "北港", "北门", "北埔", "北投", "补子", "布袋", "草屯", "长宾",
					"长治", "潮州", "车城", "成功", "城中区", "池上", "春日", "刺桐", "高雄",
					"花莲", "基隆", "嘉义", "苗栗", "南投", "屏东", "台东", "台南", "台中", "桃园",
					"新竹", "宜兰", "彰化" ],
			[ "宝坻", "北辰", "大港", "东丽", "汉沽", "和平", "河北", "河东", "河西", "红桥", "蓟县",
					"津南", "静海", "南开", "宁河", "塘沽", "武清", "西青" ],
			[ "拉萨", "阿里", "昌都", "林芝", "那曲", "日喀则", "山南" ],
			[ "北区", "大埔区", "东区", "观塘区", "黄大仙区", "九龙", "葵青区", "离岛区", "南区",
					"荃湾区", "沙田区", "深水埗区", "屯门区", "湾仔区", "西贡区", "香港", "新界",
					"油尖旺区", "元朗区", "中西区" ],
			[ "乌鲁木齐", "阿克苏", "阿拉尔", "阿勒泰", "巴音郭楞", "博尔塔拉", "昌吉", "哈密", "和田",
					"喀什", "克拉玛依", "克孜勒苏柯尔克孜", "石河子", "塔城", "图木舒克", "吐鲁番",
					"五家渠", "伊犁" ],
			[ "昆明", "保山", "楚雄", "大理", "德宏", "迪庆", "红河", "丽江", "临沧", "怒江", "曲靖",
					"思茅", "文山", "西双版纳", "玉溪", "昭通" ],
			[ "杭州", "湖州", "嘉兴", "金华", "丽水", "宁波", "衢州", "绍兴", "台州", "温州", "舟山" ],
			[ "巴南", "北碚", "璧山", "长寿", "城口", "大渡口", "大足", "垫江", "丰都", "奉节",
					"涪陵", "合川", "江北", "江津", "九龙坡", "开县", "梁平", "南岸", "南川",
					"彭水", "綦江", "黔江", "荣昌", "沙坪坝", "石柱", "双桥", "铜梁", "潼南",
					"万盛", "万州", "巫山", "巫溪", "武隆", "秀山", "永川", "酉阳", "渝北", "渝中",
					"云阳", "忠县" ],
			[ "阿根廷", "埃及", "爱尔兰", "奥地利", "奥克兰", "澳大利亚", "巴基斯坦", "巴西", "保加利亚",
					"比利时", "冰岛", "朝鲜", "丹麦", "德国", "俄罗斯", "法国", "菲律宾", "芬兰",
					"哥伦比亚", "韩国", "荷兰", "加拿大", "柬埔寨", "喀麦隆", "老挝", "卢森堡",
					"罗马尼亚", "马达加斯加", "马来西亚", "毛里求斯", "美国", "秘鲁", "缅甸", "墨西哥",
					"南非", "尼泊尔", "挪威", "葡萄牙", "其它地区", "日本", "瑞典", "瑞士", "斯里兰卡",
					"泰国", "土耳其", "委内瑞拉", "文莱", "乌克兰", "西班牙", "希腊", "新加坡",
					"新西兰", "匈牙利", "以色列", "意大利", "印度", "印度尼西亚", "英国", "越南", "智利" ] ];
	var _locations = $("#location");
	var _slocation = _locations.val();
	var _city = $("#city");
	var _scity = _city.val();
	_locations.html("");
	_city.html("");
	$.each(GP, function(i, value) {
		if (_slocation == value) {
			_locations.append('<option selected="selected">' + value
					+ "</option>");
			return true
		}
		_locations.append("<option>" + value + "</option>")
	});
	_locations.find("option").each(
			function(i, value) {
				if ($(this).attr("selected")) {
					$.each(GT[i], function(n, v) {
						if (_scity == v) {
							_city.append('<option selected="selected">' + v
									+ "</option>");
							return true
						}
						_city.append("<option>" + v + "</option>")
					})
				}
			});
	_locations.change(function() {
		_locations.find("option").each(function(i, value) {
			if ($(this).attr("selected")) {
				_city.html("");
				$.each(GT[i], function(n, v) {
					_city.append("<option>" + v + "</option>")
				})
			}
		})
	})
}

function initBackToTop() {
	if (!$("#back-to-top").get(0)) {
		return false
	}
	var win_height = $(window).height();
	$(window).scroll(function() {
		var offset = $(window).scrollTop();
		if (offset > 2 * win_height) {
			$("#back-to-top").fadeIn()
		} else {
			$("#back-to-top").fadeOut()
		}
	})
}
function initFeedback() {
	$("#feedback-button").click(function() {
		var height = $(document).height();
		$("#popup-layer").css("height", height);
		$("#feedback,#popup-layer,#feedback-form").show()
	});
	$("#feedback-form").submit(function() {
		var obj = this;
		var content = this.content.value;
		var url = this.action;
		$.post(url, {
			content : content
		}, function() {
			$(obj).hide();
			$(obj).next().show()
		});
		return false
	})
}
function initPopupLogin() {
	$(".need-login").live("click", function() {
		var height = $(document).height();
		$("#popup-layer").css("height", height);
		$("#popup-login,#popup-layer").show()
	});
	$("#popup-login-form").submit(
			function() {
				this.next.value = $.trim(location.href).replace(
						/^http:\/\/[!0-9a-zA-Z.:]+\//, "/")
			});
	$("#popup-login .close-btn").click(function() {
		$("#popup-login,#popup-layer").hide()
	})
}
function initFollowBtn() {
	$(".followBtn,.folderFollowBtn").AjaxBtn(
			function(obj, xhr) {
				var state = $(obj).attr("thelink").slice(-2, -1);
				var objclass = $(obj).attr("class");
				if (state == 1) {
					if (objclass.indexOf("s3") == -1) 
						$(obj).addClass("s0").find("em").html("关注");
					else
						$(obj).removeClass("s3").addClass("s1").find("em")
								.html("关注");
					$(obj).attr("thelink",
							$(obj).attr("thelink").replace("/1", "/0"))
				} else {
					if (objclass.indexOf("s0") == -1) 
						$(obj).removeClass("s1").addClass("s3").find("em")
								.html("取消关注");
					else
						$(obj).removeClass("s0").find("em").html("取消关注");
					$(obj).attr("thelink",
							$(obj).attr("thelink").replace("/0", "/1"))
				}
			})
}
function initLikeAction() {
	$(".like").AjaxBtn(
			function(obj, xhr) {
				var num = $(obj).find("em");
				var state = $(obj).attr("thelink").slice(-2, -1);
				if (state == 1) {
					$(obj).removeClass("active");
					num.text(parseInt(num.text()) - 1);
					$(obj).attr("thelink",
							$(obj).attr("thelink").replace("/1/", "/0/"))
				} else {
					$(obj).addClass("active");
					num.text(parseInt(num.text()) + 1);
					$(obj).attr("thelink",
							$(obj).attr("thelink").replace("/0/", "/1/"))
				}
			})
}

function initNewEntityForm() {
	$("#new-entity-url").focus(function() {
		this.select()
	});
	var lock = false;
	$("#new-entity-form")
			.submit(
					function() {
						if (lock
								|| this.url.value == $(this.url).attr(
										"defaultValue") || this.url.value == "")
							return false;
						$(".entity-detail").remove();
						$("h2").remove();
						$(".notes").remove();
						$(".entity-exist").remove();
						$(".entity p").remove();
						var form = $(this);
						var input = $("#new-entity-url");
						var btn = $(this.btn);
						lock = true;
						btn.attr("value", "加载中...").attr("class",
								"btn-v1 w4 disable");
						var url = this.action;
						var param = {
							url : this.url.value
						};
						$
								.ajax({
									url : url,
									type : "post",
									data : param,
									success : function(xhr) {
										if (xhr.indexOf("entity-detail") != -1) {
											var middle = xhr.indexOf("<h2>");
											var detail = xhr.slice(0, middle);
											form.after(detail);
											var notes = xhr.slice(middle);
											$(".entity").addClass("mb60")
													.after(notes);
											$("#new-entity-brand")
													.keyup(
															function() {
																if (this.value != "")
																	$(
																			"#brand-name span")
																			.get(
																					0).innerHTML = this.value
																			+ " - ";
																else
																	$(
																			"#brand-name span")
																			.get(
																					0).innerHTML = ""
															});
											$("#new-entity-name")
													.keyup(
															function() {
																$(
																		"#brand-name span")
																		.eq(1)
																		.text(
																				this.value)
															});
											$(".entity-detail .thumbnail")
													.click(
															function() {
																$(
																		".thumbnail-outer")
																		.removeClass(
																				"active");
																$(this)
																		.parent()
																		.addClass(
																				"active");
																var url = $(
																		this)
																		.children()
																		.attr(
																				"src")
																		.replace(
																				"40x40",
																				"310x310");
																$(
																		".entity-img img")
																		.attr(
																				"src",
																				url);
																$("#add-form")
																		.get(0).picture.value = url
															});
											$("#add-form textarea")
													.keyup(
															function() {
																if ($
																		.trim(this.value.length) > 10)
																	$(
																			"#add-form .note-prompt")
																			.fadeOut();
																if ($
																		.trim(this.value.length) == 0)
																	$(
																			"#add-form .note-prompt")
																			.fadeIn()
															});
//											$("#add-form")
//													.submit(
//															function() {
//																var value = $(
//																		"#new-entity-brand")
//																		.val();
//																if (value == $(
//																		"#new-entity-brand")
//																		.attr(
//																				"defaultValue"))
//																	value = "";
//																$("#add-form")
//																		.get(0).brand.value = value;
//																value = $(
//																		"#new-entity-name")
//																		.val();
//																if (value == $(
//																		"#new-entity-name")
//																		.attr(
//																				"defaultValue"))
//																	value = "";
//																$("#add-form")
//																		.get(0).title.value = value;
//																if ($(
//																		"#new-entity-name")
//																		.val() == "") {
//																	$(this)
//																			.find(
//																					".add-error")
//																			.text(
//																					"商品名称不能为空")
//																			.show();
//																	return false
//																}
//																var note = $
//																		.trim($(
//																				"#add-form textarea")
//																				.val());
//																$(
//																		"#add-form textarea")
//																		.val(
//																				note);
//																if (note.val() == ""
//																		|| note
//																				.val() == note
//																				.attr("defaultValue"))
//																	return false
//															});
											var old_url = $("#new-entity-url")
													.val();
											if (old_url != ""
													&& old_url
															.match(/[?&](id|item_id)=(\d+)/)) {
											}
											var taobao_id = old_url
													.match(/[?&](id|item_id)=(\d+)/)[2];
											TOP
													.api(
															"rest",
															"get",
															{
																method : "taobao.taobaoke.widget.items.convert",
																fields : "num_iid,title,nick,pic_url,promotion_price,price,click_url,commission,commission_rate,commission_num,commission_volume,shop_click_url,seller_credit_score,item_location,volume ",
																num_iids : taobao_id
															},
															function(res) {
																if (res.total_results != 0
																		&& !res.error_response) {
																	var item = res.taobaoke_items.taobaoke_item[0];
																	var data = JSON
																			.stringify(item);
																	$(
																			"#add-form")
																			.get(
																					0).taobaoke_info.value = data
																}
															})
										} else {
											form.after(xhr)
										}
										lock = false;
										btn.attr("value", "重新载入").attr("class",
												"btn-v1 w4 disable");
										return false
									},
									error : function() {
										lock = false;
										btn.attr("value", "重新载入").attr("class",
												"btn-v1 w4 disable")
									}
								});
						return false
					});
	$("#new-entity-form").FormChange(function(obj) {
		if ($("#new-entity-url").val() == "")
			return false;
		else
			return true
	})
}
function initSettingPage() {
	$(".confirmation a").AjaxBtn(function(obj, xhr) {
		$(obj).text("重新发送")
	});
	$("#file_upload_btn").click(function() {
		$("#file_upload").click()
	});
	var now, old = $("#file_upload").val();
	$("#file_upload").change(function() {
		now = $("#file_upload").val();
		if (old == now) {
			$("#avatar-setting-form").attr("enable", "false");
			$(".btn-upload").removeClass("btn-v2").addClass("btn-v1 disable")
		} else {
			$("#avatar-setting-form").attr("enable", "true");
			$(".btn-upload").removeClass("btn-v1 disable").addClass("btn-v2")
		}
		$("#file_name").text(this.value)
	});
	var lock = false;
	$("#avatar-setting-form").submit(function() {
		var btn = $(this).find("input[type='submit']");
		if (lock)
			return false;
		lock = true;
		if ($(this).attr("enable") == "true")
			btn.removeClass("btn-v2").addClass("btn-v1 disable").val("上传中...");
		$(this).ajaxSubmit({
			success : function(xhr) {
				var json = $.parseJSON(xhr);
				if (json.status == "0")
					$(".avatar img").attr("src", json.image_url)
			},
			complete : function() {
				btn.val("重新上传");
				lock = false
			}
		});
		return false
	});
	$.validator.addMethod("remote_ex", function(value, element, params) {
		if (params.value != "" && value == params.value())
			return true;
		var res;
		var p = {};
		p[params.key] = value;
		$.ajax({
			type : "POST",
			async : false,
			url : params.url,
			data : p,
			complete : function(xhr) {
				res = xhr.responseText == "true" ? true : false
			}
		});
		return res
	});
	$("#account-setting-form")
			.validate(
					{
						onkeyup : false,
						errorElement : "em",
						rules : {
							email : {
								required : true,
								email : true,
								remote_ex : {
									url : "/check_email_availability/",
									key : "email",
									value : function() {
										return $(
												document
														.getElementById("account-setting-form").email)
												.attr("original")
									}
								}
							},
							nickname : {
								required : true,
								maxlength : 15,
								remote_ex : {
									url : "/check_nickname_availability/",
									key : "nickname",
									value : function() {
										return $(
												document
														.getElementById("account-setting-form").nickname)
												.attr("original")
									}
								}
							}
						},
						messages : {
							email : {
								required : "邮箱帐号不能为空",
								email : "请输入正确的邮箱地址",
								remote_ex : jQuery.format("邮箱已经被注册")
							},
							nickname : {
								required : "昵称不能为空",
								maxlength : jQuery.format("昵称不能超过{0}个字"),
								remote_ex : jQuery.format("昵称已经被占用")
							}
						}
					});
	$("#password-setting-form").validate({
		onkeyup : false,
		errorElement : "em",
		rules : {
			current_password : {
				required : true,
				minlength : 6,
				remote : {
					url : "check_password_availability/",
					type : "post",
					data : {
						password : function() {
							return $("#password-setting-form").get(0).current_password.value
						}
					}
				}
			},
			new_password : {
				required : true,
				minlength : 6
			},
			confirm_password : {
				required : true,
				equalTo : "#new_password",
				minlength : 6
			},
			password : {
				required : true,
				minlength : 6
			}
		},
		messages : {
			current_password : {
				required : "请输入当前密码",
				minlength : jQuery.format("密码至少{0}位"),
				remote : jQuery.format("输入的密码有误")
			},
			new_password : {
				required : "请设置新的密码",
				minlength : jQuery.format("密码至少{0}位")
			},
			confirm_password : {
				required : "请再次输入密码",
				minlength : jQuery.format("密码至少{0}位"),
				equalTo : "两次输入密码不符合"
			},
			password : {
				required : "请设置新的密码",
				minlength : jQuery.format("密码至少{0}位")
			}
		}
	});
	$("#account-setting-form").submit(function() {
		var btn = $(this).find("input[type='submit']");
		this.bio.value = $.trim(this.bio.value);
		if ($(this).attr("enable") == "true") {
			return true
		}
		return false
	});
	$("#account-setting-form").FormChange();
	$("#password-setting-form").submit(function() {
		var btn = $(this).find("input[type='submit']");
		if ($(this).attr("enable") == "true") {
			return true
		}
		return false
	});
	$("#password-setting-form").FormChange()
}
function initDetailPage() {
	if (location.href.indexOf("#new") != -1) {
		$(document).scrollTop($(document).scrollTop() - 300)
	}
	$(".approve-btn, .disapprove-btn").AjaxBtn(
			function(obj, xhr) {
				if (xhr == 1) {
					var num = parseInt($(obj).find("em").text()) ? parseInt($(
							obj).find("em").text()) : 0;
					$(obj).find("em").text(num + 1);
					$(obj).attr("nlink", $(obj).attr("thelink")).removeAttr(
							"thelink").addClass("active");
					var opp;
					if ($(obj).attr("class").indexOf("disapprove") == -1) {
						opp = $(obj).parent().find(".disapprove-btn")
					} else {
						opp = $(obj).parent().find(".approve-btn")
					}
					if (opp.attr("class").indexOf("active") != -1) {
						num = parseInt(opp.find("em").text()) - 1;
						num = num == 0 ? "" : num;
						opp.find("em").text(num);
						opp.attr("thelink", opp.attr("nlink")).removeAttr(
								"nlink").removeClass("active")
					}
				}
			});
	$(".comment-btn:not('.need-login')").live("click", function() {
		var div = $(this).parent().next();
		var style = div.css("display");
		if (style == "none") {
			var pos = $(this).position();
			var arrow = div.find(".arrow-grey");
			arrow.css("left", pos.left);
			div.show()
		} else
			div.hide()
	});
	$(".new-comment-cancel").live("click", function() {
		var div = $(this).parents(".comments");
		var style = div.css("display");
		if (style == "none")
			div.show();
		else
			div.hide()
	});
	$(".delete-btn").AjaxBtn(function(obj, xhr) {
		var p = $(obj).parent().parent();
		if (p.attr("class").indexOf("comment") == -1) {
			p.fadeOut(function() {
				$(".new-note").show()
			});
			p.remove()
		} else {
			var em = p.parent().parent().prev().find(".comment-btn em");
			var num = parseInt(em.text()) - 1;
			num = num == 0 ? "" : num;
			em.text(num);
			p.fadeOut();
			p.remove()
		}
	});
	$(".modify-btn")
			.live(
					"click",
					function() {
						var obj = $(this);
						var url = obj.attr("thelink");
						var row = obj.parent();
						var p = row.prev();
						if (row.parent().find("textarea").get(0)) {
							row.parent().find(".cancel-modify-btn").click();
							obj.text("修改");
							return false
						}
						obj.text("取消修改");
						var textarea = $("<textarea class='tag-ac'></textarea>");
						var cancel_btn = $("<a href='javascript:void(0);' class='right cancel-modify-btn'>取消</a>");
						var confirm_btn = $("<a href='javascript:void(0);' class='right btn-v2'>修改</a>");
						var clear = $("<div class='clear'></div>");
						p.before(textarea, confirm_btn, cancel_btn, clear);
						p.html(p.html().replace(/\<br[!\>]*\>/g, "\n"));
						textarea.val(p.text()).focus().select();
						p.hide();
						cancel_btn.click(function() {
							obj.text("修改");
							textarea.remove();
							cancel_btn.remove();
							confirm_btn.remove();
							clear.remove();
							p.html(p.html().replace(/\n/g, "<br>"));
							p.show()
						});
						textarea.keyup(function() {
							if ($.trim(textarea.val()) == "") {
								confirm_btn.removeClass("btn-v2").addClass(
										"btn-v1 disable");
								return false
							} else {
								confirm_btn.removeClass("btn-v1 disable")
										.addClass("btn-v2")
							}
						});
						confirm_btn.click(function() {
							var content = $.trim(textarea.val());
							if (content == "")
								return false;
							$.post(url, {
								note : content
							}, function() {
								p.text(content.replace(/\n/g, "<br>"));
								cancel_btn.click();
								initTag()
							})
						})
					});
	$(".new-comment-form").live("submit", function() {
		if ($(this).attr("enable") == "true") {
			var input = $(this).find(".content");
			var btn = $(this).find("input[type='submit']");
			if (input.val() == "" || input.val() == input.attr("defaultValue"))
				return false;
			var p = $(this).parent().parent();
			var target = $(this).parent().prev();
			$(this).ajaxSubmit({
				success : function(xhr) {
					var dom = $(xhr);
					dom.css("display", "none");
					target.append(dom);
					dom.fadeIn();
					var em = p.prev().find(".comment-btn em");
					em.text(parseInt(em.text() || "0") + 1);
					input.val("");
					btn.removeClass("btn-v2").addClass("btn-v1 disable");
					initTag()
				}
			})
		}
		return false
	});
//	$("#new-note-form")
//			.submit(
//					function() {
//						this.note.value = $.trim(this.note.value);
//						if (this.note.value == ""
//								|| this.note.value == $(this.note).attr(
//										"defaultValue"))
//							return false;
//						$(this).ajaxSubmit({
//							success : function(xhr) {
//								var dom = $(xhr);
//								dom.css("display", "none");
//								var notes = $("#display-area");
//								notes.append(dom);
//								dom.fadeIn();
//								$(".new-note").hide();
//								initTag();
//								$(".new-comment-form").FormChange()
//							}
//						});
//						return false
//					});
	$(".new-comment-form").FormChange();
	$(".new-comment-form input.content").TagAC();
	$("#new-note-form textarea").keyup(function() {
		var value = $.trim($(this).val());
		if (value == "")
			$(".note-prompt").fadeIn();
		if (value.length > 10)
			$(".note-prompt").fadeOut()
	});
	$(".note textarea").TagAC();
	$("#extand-btn").toggle(function() {
		$("#hidden-area").slideDown()
	}, function() {
		$("#hidden-area").slideUp()
	});
	$(".sider-weibo-share").WeiboShare(function() {
		return $("#display-area>.note p").eq(0).text()
	}());
	$(".note-weibo-share").WeiboShare(function(obj) {
		return $(obj).parent().prev().text()
	})
}
function initSelectedPage() {
	$(".extand-btn").click(function() {
		var more_btn = $(this).parent().find(".more-notes");
		var ha = $(this).parents(".entity-notes").find(".hidden-area");
		var ha_height = ha.height();
		if (ha.css("display") == "none") {
			ha.height(0).show().animate({
				height : ha_height
			}, 300, function() {
				ha.height("auto")
			});
			more_btn.attr("text", more_btn.text());
			more_btn.text("收起")
		} else {
			ha.animate({
				height : 0
			}, 300, function() {
				ha.height(ha_height).hide()
			});
			more_btn.text(more_btn.attr("text"))
		}
	})
}
function initDiscoverPage() {
	var url = location.href;
	var cat, index = url.indexOf("cat=");
	if (index == -1)
		cat = 0;
	else
		cat = url.slice(index + 4);
	var rest = $("#footer").outerHeight()
			+ parseInt($("#footer").css("margin-top")) + 500 * 3;
	var lock = false;
	$(window).scroll(
			function() {
				if ($(window).scrollTop() > $(document).height() - rest
						&& !lock) {
					var p = parseInt($("#items-loading").attr("p")) || 2;
					lock = true;
					$("#items-loading").show();
					$.post("/discover/more/", {
						cat : cat,
						p : p
					}, function(xhr) {
						$("ul.items-list li").eq(
								$("ul.items-list li").length - 1).after(xhr);
						lock = false;
						$("#items-loading").hide().attr("p", p + 1);
						initTag()
					})
				}
			})
}
function initActivityPage() {
	var rest = $("#footer").outerHeight()
			+ parseInt($("#footer").css("margin-top")) + 500 * 3;
	var lock = false;
	var p = 2;
	$(window).scroll(
			function() {
				if ($(window).scrollTop() > $(document).height() - rest
						&& !lock && (p - 1) % 4 != 0) {
					$("#items-loading a").click()
				}
			});
	$("#items-loading a").click(function() {
		var obj = $(this);
		var div = $(this).parent();
		p = parseInt($("#items-loading").attr("p")) || p;
		if (lock)
			return false;
		lock = true;
		obj.html("加载中");
		$.post("/activity/more/?p=" + p, {}, function(xhr) {
			if ($.trim(xhr) == "") {
				obj.html("加载失败")
			}
			obj.html("点击加载更多");
			div.before(xhr).attr("p", p + 1);
			initTag();
			if ($("#activity_finish").get(0)) {
				obj.html("没有更多动态了。  (￣(工)￣)").addClass("invalid")
			} else {
				lock = false
			}
		})
	})
}
function initUserTools() {
	var $userMenu = $("#user-tools"), $userNav = $userMenu.children("a"), $userWrap = $userMenu
			.children("ul");
	$userMenu.mouseenter(function() {
		$userWrap.show().css("width", $userNav.outerWidth());
		$userMenu.addClass("mouseon").css("height",
				$userNav.outerHeight() + $userWrap.outerHeight())
	});
	$userMenu.mouseleave(function() {
		$userWrap.hide();
		$userMenu.removeClass("mouseon").css("height", $userNav.outerHeight())
	})
}
function initMoreBtn() {
	$(".more-btn").AjaxBtn(function(obj, xhr) {
		var array = $(obj).parent().prev().find("li");
		array.eq(array.length - 1).after(xhr);
		var offset = parseInt($(obj).attr("offset")) || 15;
		$(obj).attr("offset", offset + 15);
		var num = parseInt($(obj).parent().find("em").text());
		if (num > 15)
			$(obj).parent().find("em").text(num - 15);
		else
			$(obj).parent().hide()
	}, function(obj) {
		var date = $(obj).parent().prev().prev().text();
		var year = date.slice(0, date.indexOf("年"));
		var month = date.slice(date.indexOf("年") + 1, date.indexOf("月"));
		var count = 15;
		var offset = parseInt($(obj).attr("offset")) || 15;
		var params = {
			year : $.trim(year),
			month : $.trim(month),
			offset : offset,
			count : count
		};
		return params
	})
}
function initTag() {
//	var array = $(".with-tag");
//	for ( var i = 0; i < array.length; i++) {
//		var str = array.eq(i).html(
//				array.eq(i).html().replace(/\<br[!>]*\>/g, "\n")).text();
//		if (str == undefined)
//			continue;
//		var ereg = /[#＃][0-9a-zA-Z\u4e00-\u9fff\u3040-\u30FF\u30A0-\u30FF]+/g;
//		var cut = str.match(ereg);
//		if (cut == null) {
//			array.eq(i).html(str.replace(/\n/g, "<br>"));
//			continue
//		}
//		for ( var j in cut) {
//			str = str.replace(cut[j], "<a class='tag' href='tag/"
//					+ encodeURI(cut[j].replace(/[#＃]/, "")) + "' >" + cut[j]
//					+ "</a>&nbsp;")
//		}
//		array.eq(i).html(str.replace(/\n/g, "<br>"))
//	}
}
function initForm() {
	if ($("#login-in-form").get(0)) {
		var form = $("#login-in-form");
		var validater = form.validate({
			errorElement : "em",
			rules : {
				password : {
					required : true,
					minlength : 6
				},
				username : {
					required : true,
					maxlength : 25,
				}
			},
			messages : {
				username : {
					required : "请填写邮箱/用户名",
					maxlength : jQuery.format("用户名不能超过{0}个字"),
				},
				password : {
					required : "请填写密码",
					minlength : jQuery.format("密码至少{0}位")
				}
			},
			onkeyup : false
		});
//		if (form.get(0).text.value == "") {
//			$(form.get(0).email).prev().show()
//		}
//		if (form.get(0).password.value == "") {
//			$(form.get(0).password).prev().show()
//		}
//		form.find("input").focus(function() {
//			$("#msg_error").remove();
//			if (this.value == "")
//				$(this).parent().find("label").show();
//			else
//				$(this).parent().find("label").hide()
//		}).blur(function() {
//			if (this.value == "")
//				$(this).parent().find("label").show();
//			else
//				$(this).parent().find("label").hide()
//		}).keydown(function(e) {
//			if (this.value == "" && e.keyCode != 8)
//				$(this).parent().find("label").hide()
//		}).keyup(function() {
//			if (this.value == "")
//				$(this).parent().find("label").show()
//		});
//		form.find("label").click(function() {
//			$(this).parent().find("input").focus()
//		})
	}
	if ($("#popup-login-form").get(0)) {
		var form = $("#popup-login-form");
		var validater = form.validate({
			errorElement : "em",
			rules : {
				password : {
					required : true,
					minlength : 6
				},
				username : {
					required : true,
					maxlength : 25,
				}
			},
			messages : {
				username : {
					required : "请填写邮箱/用户名",
					maxlength : jQuery.format("用户名不能超过{0}个字"),
				},
				password : {
					required : "请填写密码",
					minlength : jQuery.format("密码至少{0}位")
				}
			},
			onkeyup : false
		});
	}
	if ($("#sign-in-up-form").get(0)) {
		var form = $("#sign-in-up-form");
		var validater = form.validate({
			errorElement : "em",
			rules : {
				plainPassword : {
					required : true,
					minlength : 6
				},
				email : {
					required : true,
					email : true,
					remote : {
						url : "check_email_availability/",
						type : "post",
						data : {
							email : function() {
								return form.get(0).email.value
							}
						}
					}
				},
				name : {
					required : true,
					maxlength : 15,
					remote : {
						url : "check_nickname_availability/",
						type : "post",
						data : {
							name : function() {
								return form.get(0).name.value
							}
						}
					}
				}
			},
			messages : {
				email : {
					required : "邮箱帐号不能为空",
					email : "请输入正确的邮箱地址",
					remote : jQuery.format("邮箱已经被注册")
				},
				plainPassword : {
					required : "请填写密码",
					minlength : jQuery.format("密码至少{0}位")
				},
				name : {
					required : "昵称不能为空",
					maxlength : jQuery.format("昵称不能超过{0}个字"),
					remote : jQuery.format("昵称已经被占用")
				}
			},
			onkeyup : false
		});
//		if (form.get(0).nickname.value == "") {
//			$(form.get(0).nickname).prev().show()
//		}
//		if (form.get(0).email.value == "") {
//			$(form.get(0).email).prev().show()
//		}
//		if (form.get(0).password.value == "") {
//			$(form.get(0).password).prev().show()
//		}
//		form.find("input").focus(function() {
//			if (this.value == "")
//				$(this).parent().find("label").show();
//			else
//				$(this).parent().find("label").hide()
//		}).blur(function() {
//			if (this.value == "")
//				$(this).parent().find("label").show();
//			else
//				$(this).parent().find("label").hide()
//		}).keydown(function(e) {
//			if (this.value == "" && e.keyCode != 8)
//				$(this).parent().find("label").hide()
//		}).keyup(function() {
//			if (this.value == "")
//				$(this).parent().find("label").show()
//		});
//		form.find("label").click(function() {
//			$(this).parent().find("input").focus()
//		})
	}
	if ($("#reset-password-form").get(0)) {
		$("#reset-password-form").FormChange();
		$("#reset-password-form").validate({
			onkeyup : false,
			errorElement : "em",
			rules : {
				email : {
					required : true,
					email : true
				}
			},
			messages : {
				email : {
					required : "邮箱帐号不能为空",
					email : "请输入正确的邮箱地址"
				}
			}
		})
	}
	if ($("#weibo-login-form").get(0)) {
		var form = $("#weibo-login-form");
		form.FormChange();
		form.validate({
			errorElement : "em",
			onkeyup : false,
			rules : {
				password : {
					required : true,
					minlength : 6
				},
				email : {
					required : true,
					email : true,
					remote : {
						url : "/check_email_availability/",
						type : "post",
						data : {
							email : function() {
								return form.get(0).email.value
							}
						}
					}
				},
				nickname : {
					required : true,
					maxlength : 15,
					remote : {
						url : "/check_nickname_availability/",
						type : "post",
						data : {
							nickname : function() {
								return form.get(0).nickname.value
							}
						}
					}
				}
			},
			messages : {
				email : {
					required : "邮箱帐号不能为空",
					email : "请输入正确的邮箱地址",
					remote : jQuery.format("邮箱已经被注册")
				},
				password : {
					required : "请填写密码",
					minlength : jQuery.format("密码至少{0}位")
				},
				nickname : {
					required : "昵称不能为空",
					maxlength : jQuery.format("昵称不能超过{0}个字"),
					remote : jQuery.format("昵称已经被占用")
				}
			}
		})
	}
	$("form").submit(function() {
		if ($(this).attr("enable") != "true")
			return false
	})
}