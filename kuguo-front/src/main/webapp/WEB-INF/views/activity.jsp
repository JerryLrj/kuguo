<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html">
<html style="overflow-x: hidden; overflow-y: scroll;" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>动态</title>
<link media="all" rel="stylesheet" type="text/css" href="${ctx }/static/styles/activity.css" />
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
			<div class="main-left" id="main-left">
				<h1>好友动态</h1>
				<div class="activities with-border">
				<c:forEach items="${products }" var="product" >
					<div class="activity user-info">
						<div class="avatar">
							<a href="${ctx }/u/${product.user.id }/likes/" target=_blank> <img src="${product.user.head }" />
							</a>
						</div>
						<a href="${ctx }/u/${product.user.id }/likes/" class="name" target=_blank> ${product.user.name } </a> <span class="desc">推荐了 1 件商品</span>
						<div class="content add-container">
							<div class="image">
								<a href="${ctx }/detail/${product.id }/" target=_blank>
									<div class="img-mask"></div> <img src="${product.picture }" />
								</a>
							</div>
							<div class="like " thelink="/entity/like/81303/0/">
								<span></span>喜爱&nbsp;<em>${product.favorite_num }</em>
							</div>
							<p class="with-tag">${product.comment.content }</p>
							<div class="link-row">
								<span class="time left"><fmt:formatDate value="${product.create_time }" pattern="yyyy 年 MM 月 dd 日 HH:mm:ss"/></span>
								<div class="approve-btn left" thelink="/entity/note/poke/146454/">
									<span></span><em>1</em>
								</div>
								<span class="splite-icon left"></span>
								<div class="disapprove-btn left" thelink="/entity/note/hoot/146454/">
									<span></span><em></em>
								</div>
								<span class="splite-icon left"></span>
								<div class="comment-btn left">
									<span></span><em></em>
								</div>
							</div>
							<div class="comments">
								<div class="arrow-grey"></div>
								<div class="container"></div>
								<div class="new-comment">
									<form action="/entity/note/comment/create/" class="new-comment-form" method="post" onsubmit="return false;">
										<input name="entity_note_id" type="hidden" value="146454" /> <input name="comment" type="text" class="content" value="写下你的评论…" defaultValue="写下你的评论…" autocomplete="off" /> <input type="submit" class="btn-v1 disable right" value="评论" /> <a href="javascript:void(0);" class="right new-comment-cancel">取消</a>
									</form>
									<div class="clear"></div>
								</div>
							</div>
						</div>
					</div>
					</c:forEach>
					<%-- <c:if test="${products != null }">
						<div id="items-loading">
							<a href="javascript:void(0);">点击加载更多</a>
						</div>
					</c:if> --%>
				</div>
			</div>
			<div class="main-right" id="main-right">
				<div class="siderbar with-border">
					<div class="aside">
						<h3>热门的标签</h3>
						<c:forEach items="${labels}" var="label">
							<p class="hottag">
								<span>#</span><a class="c666" href="/t/${label.id }/" target=_blank>${label.name }</a>
							</p>
						</c:forEach>
					</div>
					<div class="aside">
						<h3>热门的用户</h3>
						<c:forEach items="${users }" var="user">
							<div class="note">
								<div class="avatar">
									<a href="${ctx }/u/${user.id}/likes/" target=_blank> <img src="${user.head }" width="50" height="50" />
									</a>
								</div>
								<a class="name c333" href="${ctx }/u/${user.id}/likes/" target=_blank> ${user.name} </a> <span class="desc l24"> ${user.bio} </span> 							
								<shiro:user>
									<c:if test="${user.id != uid}">
										<a href="javascript:void(0);" thelink="${ctx}/user/follow/${user.id }/<shiro:principal property='id' />/0/" class="btn-v1 followBtn s0 w4"> <span>+</span> <em>关注</em></a>
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
	</div>
</body>
</html>
