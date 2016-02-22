<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>${product.name}</title>
<link media="all" rel="stylesheet" type="text/css" href="${ctx}/static/styles/detail.css" />
<script type="text/javascript">
	if (window.ActiveXObject) {
		var ua = navigator.userAgent.toLowerCase();
		var ie = ua.match(/msie ([\d.]+)/)[1]
		if (ie == 6.0)
			location.href = "/ie6/";
	}
</script>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="detail-body">
				<div class="main-left" id="main-left">
					<h1>${product.name}</h1>
					<div class="with-border upper">
						<div class="entity">
							<div class="image">
								<a href="${product.order_link}" target="_blank" bi="image_taobao">
									<div class="img-mask"></div> <img src="${product.picture }" />
								</a>
							</div>
							<div class="row">
								<shiro:guest>
								<div class="like need-login">
									<span></span>喜爱&nbsp;<em>${product.favorite_num}</em>
								</div>
								</shiro:guest>
								<shiro:user>
								<div class="like" onclick="likeProduct('${product.id}','<shiro:principal property="id"></shiro:principal>');">
									<span></span>喜爱&nbsp;<em id="fnum">${product.favorite_num}</em>
								</div>
								</shiro:user>
							</div>
						</div>
						<div class="notes">
							<div id="display-area">
								<c:forEach items="${comments }" var="comment">
									<div class="note">
										<div class="avatar">
											<a href="${ctx }/u/${comment.user.id }/likes/" target=_blank> <img src="${comment.user.head}" width="50" height="50" />
											</a>
										</div>
										<a class="name c333" href="${ctx }/u/${comment.user.id }/likes/" target=_blank> ${comment.user.name } </a> <span class="desc">${comment.user.bio }</span>
										<p class="with-tag">${comment.content}</p>
										<div class="link-row">
											<div class="approve-btn left need-login">
												<span></span><em></em>
											</div>
											<span class="splite-icon left"></span>
											<div class="disapprove-btn left need-login">
												<span></span><em></em>
											</div>
											<span class="splite-icon left"></span>
											<div class="comment-btn left  need-login">
												<span></span><em></em>
											</div>
											<div class="note-time right"><fmt:formatDate value="${comment.create_time}" pattern="yyyy-MM-dd hh:mm:ss" /></div>
											<a class="right note-weibo-share" href="javascript:void(0);">分享</a>
											<div class="clear"></div>
										</div>
										<div class="comments">
											<div class="arrow-grey"></div>
											<div class="container"></div>
											<shiro:user>
												<div class="new-comment">
													<form action="${ctx }/entity/note/comment/create/" class="new-comment-form" method="post" onsubmit="return false;">
														<input name="entity_note_id" type="hidden" value="147684" /> <input name="comment" type="text" class="content" value="写下你的评论…" defaultValue="写下你的评论…" autocomplete="off" /> <input type="submit" class="btn-v1 disable right" value="评论" /> <a href="javascript:void(0);" class="right new-comment-cancel">取消</a>
													</form>
													<div class="clear"></div>
												</div>
											</shiro:user>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
					<div id="new">
						<shiro:guest>
							<div class="note new-note with-border">
								<div class="note-register">
									收藏、点评、分享心爱好物 <a href="${ctx }/register" class="btn-v2 w4">现在注册</a> <span class="right"> 已有帐号， <a href="${ctx }/login" class="green">从这里登录</a>
									</span>
								</div>
							</div>
						</shiro:guest>
						<shiro:user>
							<div class="note new-note with-border">
								<div class="avatar">
									<a href="${ctx }/u/<shiro:principal property="id"></shiro:principal>/likes"> <img src="<shiro:principal property="head"></shiro:principal>" width="50" height="50" />
									</a>
								</div>
								<div hidden="true" id="uid"><shiro:principal property="id"/></div>
								<a class="name c333" href="${ctx }/u/<shiro:principal property="id"></shiro:principal>/"><shiro:principal property="name"></shiro:principal></a> <span class="desc"><shiro:principal property="bio"></shiro:principal></span>
								<form action="${ctx }/entity/note/create/" method="post" id="new-note-form">
									<textarea id="content" name="content" class="tag-ac" defaultValue="写点评  #贴标签" onfocus="cle();">写点评  #贴标签</textarea>
									<div class="note-prompt">
										<div class="arrow-fcfcfc"></div>
										说说你的评价？欢迎真实、有用、有趣的商品点评。
									</div>
									<input type="hidden" name="productId" value="${product.id }" /> <input class="btn-v2 right" type="submit" value="点评" />
								</form>
								<div class="clear"></div>
							</div>
						</shiro:user>
					</div>
				</div>
				<div class="main-right" id="main-right">
					<shiro:guest>
						<div class="sider-login with-border">
							<p>尽收世上好物！</p>
							<p class="sider-login-bottom">
								<a class="btn-v2" href="${ctx}/register">注册帐号</a>已有帐号，<a class="green" href="${ctx}/login">从这里登录</a>
							</p>
						</div>
					</shiro:guest>
					<div class="siderbar with-border">
						<div class="aside">
							<a class="btn-v2 price" href="${product.order_link}" target=_blank bi="btn_taobao"> 详情 <span>￥${product.price}</span>
							</a>
							<h3>${product.favorite_num }人喜爱</h3>
							<div class="small-avatar-container">
								<c:forEach items="${likedUsers}" var="user">
									<a href="${ctx }/u/${user.id}/likes/" target="_blank"> <img src="${user.head}" width="25" height="25" />
									</a>
								</c:forEach>
							</div>
						</div>
						<div class="aside">
							<p class="into-time">
								<a href="${ctx }/u/${product.user.id }/likes/" target=_blank> <img src="${product.user.head }" width="25" height="25" />
								</a> <a href="${ctx }/u/${product.user.id }/likes/" target=_blank>${product.user.name }</a> 添加于 <fmt:formatDate value="${product.create_time}" pattern="yyyy-MM-dd hh:mm:ss" />
							</p>
						</div>
						<div class="aside">
							<p class="into-time sider-weibo-share">
								<a>分享到微博</a>
							</p>
						</div>
						<div class="aside mobile-download">
							<h3>下载客户端</h3>
							<p>
								<a href="http://itunes.apple.com/cn/app/id477652209?mt=8" target="_blank" bi="download_iphone">iPhone</a> / <a href="http://itunes.apple.com/cn/app/id450507565?mt=8" target="_blank" bi="download_ipad">iPad</a> / <a href="http://app.guoku.com/android/latest/guoku.apk" target="_blank" bi="download_andriod">Android</a>
							</p>
						</div>

					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<script type="text/javascript" src="${ctx}/static/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js"></script>
	<%-- <script type="text/javascript" src="${ctx}/static/js/main.js"></script> --%>
	<script>
		function likeProduct(a,b) {
			$.ajax({
				url:"${ctx}/product/like/"+a+"/"+b,
				type: "POST", 
				success:function(result){
					if(result) {
						var num = $("#fnum").html();
						$("#fnum").html(num*1 + 1);
					} else {
						
					}
				}
			});
		}
		
		/*添加评论*/
		function cle() {
			var con = $("#content");
			var def = con.attr("defaultValue");
			if($.trim(con.val()) == def) {
				con.val("");
			}
		}
		
		$("#new-note-form").submit(function(){
			var content = $.trim($("#content").val());
			var pid = ${product.id};
			var uid = $("#uid").html();
			if(content == "" || content.length < 10 || content == $("#content").attr("defaultValue")) {
				$(".note-prompt").html("最少输入10字评价!");
				return false;
			} else {
				if(content.indexOf("#") >= 0) {
					var tag = content.substring(content.indexOf("#") + 1,content.indexOf(" "));
					if(tag != "") {
						if(tag == "#") {
							tag = content.substring(content.indexOf("#") + 1, content.length);
						}
						$.ajax({
							url : "${ctx}/entity/addtag/",
							type : "POST",
							data : {
								tag : tag,
								uid : uid,
								pid : pid
							},
							success : function(result){
								//完成时
							}
						});
					}
				}
			}
		});
		//添加标签
		
		
		/*添加评论*/
		$(document).ready(function(){
			var array = $(".with-tag");
			for ( var i = 0; i < array.length; i++) {
				var str = array.eq(i).html(
						array.eq(i).html().replace(/\<br[!>]*\>/g, "\n")).text();
				if (str == undefined)
					continue;
				var ereg = /[#＃][0-9a-zA-Z\u4e00-\u9fff\u3040-\u30FF\u30A0-\u30FF]+/g;
				var cut = str.match(ereg);
				if (cut == null) {
					array.eq(i).html(str.replace(/\n/g, "<br>"));
					continue;
				}
				for ( var j in cut) {
					str = str.replace(cut[j], "<a class='tag' href='${ctx}/entity/tag/"
							+ encodeURI(cut[j].replace(/[#＃]/, "")) + "' >" + cut[j]
							+ "</a>&nbsp;")
				}
				array.eq(i).html(str.replace(/\n/g, "<br>"))
			}
		});
	</script>
</body>
</html>

