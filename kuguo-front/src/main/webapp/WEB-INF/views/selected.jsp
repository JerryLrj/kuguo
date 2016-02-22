<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>首页</title>
<link media="all" rel="stylesheet" type="text/css" href="${ctx}/static/styles/selection.css" />
</head>
<body>
	<div id="main">
		<div class="main-left selected-body" id="main-left">
			<h1>
				所有商品
			</h1>
			<c:forEach items="${products}" var="product">
				<div class="entity with-border">
					<div class="entity-attrs">
						<h3>
							<a href="${ctx }/detail/${product.id }/" target=_blank> ${product.name } </a>
						</h3>
						<div class="image">
							<a href="${ctx }/detail/${product.id }/" target=_blank>
								<div class="img-mask"></div> <img src="${product.picture }" alt="${product.name }" title="${product.name }" />
							</a>
						</div>
						<shiro:guest>
						<div class="like need-login">
							<span></span>喜爱&nbsp;<em>${product.favorite_num}</em>
						</div>
						</shiro:guest>
						<shiro:user>
						<div class="like" onclick="likeProduct('${product.id}','<shiro:principal property="id"></shiro:principal>');">
							<span></span>喜爱&nbsp;<em id="${product.id }" >${product.favorite_num}</em>
						</div>
						</shiro:user>
					</div>
					<div class="entity-notes">
						<div class="note">
							<div class="avatar">
								<a href="${ctx }/u/${product.user.id }/likes/" target=_blank> <img src="${product.user.head}" width="50" height="50" />
								</a>
							</div>
							<a class="name c333" href="${ctx }/u/${product.user.id }/likes/" target=_blank> ${product.user.name} </a> <span class="desc">${product.user.bio}</span>
							<p class="with-tag">${product.comment.content}</p>
							<div class="link-row">
								<div class="approve-btn left need-login">
									<span></span><em></em>
								</div>
								<span class="splite-icon left"></span>
								<div class="disapprove-btn left need-login" thelink="${ctx }/entity/note/poke/147604/">
									<span></span><em></em>
								</div>
								<span class="splite-icon left"></span>
								<div class="comment-btn left  need-login" thelink="${ctx }/entity/note/poke/147604/">
									<span></span><em></em>
								</div>
								<div class="note-time right"><fmt:formatDate value="${product.comment.create_time}" pattern="yyyy-MM-dd hh:mm:ss"/></div>
								<a class="right note-weibo-share" href="javascript:void(0);">分享</a>
								<div class="clear"></div>
							</div>
							<div class="comments">
								<div class="arrow-grey"></div>
								<div class="container"></div>
								<shiro:user>
									<div class="new-comment">
										<form action="${ctx}/entity/note/comment/create/" class="new-comment-form" method="POST" onsubmit="return false;">
											<input name="entity_note_id" type="hidden" value="147684" /> <input name="comment" type="text" class="content" value="写下你的评论…" defaultValue="写下你的评论…" autocomplete="off" /> <input type="submit" class="btn-v1 disable right" value="评论" /> <a href="javascript:void(0);" class="right new-comment-cancel">取消</a>
										</form>
										<div class="clear"></div>
									</div>
								</shiro:user>
							</div>
						</div>
						<div class="hidden-area dn"></div>
						<div class="fold-note">
							<shiro:guest>
								<a href="javascript:void(0);" class="need-login"> 写点评 </a>
							</shiro:guest>
							<shiro:user>
								<a href="${ctx }/detail/${product.id }/"> 写点评 </a>
							</shiro:user>
						</div>
					</div>
				</div>
			</c:forEach>
			<c:if test="${page != pagenum - 1 }">
				<a href="${ctx}/selected/?page=${page + 1}" class="paging-btn">下一页</a> 
			</c:if>
			<c:if test="${page != 0 }">
				<a href="${ctx}/selected/?page=${page - 1}" class="paging-btn">上一页</a>
			</c:if>
		</div>
		<div class="main-right" id="main-right">
			<shiro:guest>
				<div class="sider-login with-border">
					<p>尽收世上好物！</p>
					<p class="sider-login-bottom">
						<a class="btn-v2" href="${ctx}/register">注册帐号</a>已有帐号， <a class="green" href="${ctx}/login">从这里登录</a>
					</p>
				</div>
			</shiro:guest>
			<div class="siderbar with-border">
				<div class="aside">
					<a class="all-cate active " href="${ctx}/selected/"> 所有 </a>
					<ul>
						<c:forEach items="${channels}" var="channel">
							<li>· <a class="link-v1" href="${ctx }/selected/?c=${channel.id}"> ${channel.name} </a>
							</li>
						</c:forEach>
					</ul>
				</div>
				<div class="aside">
					<h3>热门的标签</h3>
					<c:forEach items="${labels}" var="label">
						<p class="hottag">
							<span>#</span><a class="c666" href="${ctx }/entity/tag/${label.name}" target=_blank>${label.name}</a>
						</p>
					</c:forEach>
				</div>
				<div class="aside">
					<h3>热门的用户</h3>
					<c:forEach items="${users}" var="user">
						<div class="note">
							<div class="avatar">
								<a href="${ctx }/u/${user.id}/likes/" target=_blank> <img src="${user.head}" width="50" height="50" />
								</a>
							</div>
							<a class="name c333" href="${ctx }/u/${user.id}/likes/" target=_blank> ${user.name} </a> <span class="desc l24"> ${user.bio} </span>
							<shiro:user>
								<c:if test="${user.id != uid}">
									<a id="${user.id }" href="javascript:void(0);" thelink="${ctx}/user/follow/${user.id }/<shiro:principal property='id' />/0/" class="btn-v1 followBtn s0 w4"> <span>+</span> <em>关注</em></a>
								</c:if>
							</shiro:user>
							<div class="clear"></div>
						</div>
					</c:forEach>
				</div>
				<div class="aside mobile-download">
					<h3>下载客户端</h3>
					<p>
						<a href="http://itunes.apple.com/cn/app/id477652209?mt=8" target="_blank" bi="download_iphone">iPhone</a> / <a href="http://itunes.apple.com/cn/app/id450507565?mt=8" target="_blank" bi="download_ipad">iPad</a> / <a href="http://app.guoku.com/android/latest/guoku.apk" target="_blank" bi="download_andriod">Android</a>
					</p>
				</div>
			</div>
		</div>
		<a id="back-to-top" href="#"></a>
		<div class="clear"></div>
	</div>
	<script type="text/javascript" src="${ctx}/static/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/main.js"></script>
	<script type="text/javascript">
	function likeProduct(a,b) {
		$.ajax({
			url:"${ctx}/product/like/"+a+"/"+b,
			type: "POST", 
			success:function(result){
				if(result) {
					var id = "#"+a;
					var num = $(id).html();
					$(id).html(num*1 + 1);
				} else {
					alert("喜爱失败");
				}
			}
		});
	}
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
				continue
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
