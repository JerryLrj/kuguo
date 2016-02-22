<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html style="overflow-x: hidden; overflow-y: scroll;" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>我的消息</title>
<link media="all" rel="stylesheet" type="text/css" href="${ctx }/static/styles/message.css" />
<link rel="icon" type="image/ico" href="http://static.guoku.com/static/images/favicon.ico">
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
				<h1>
					消息 <a href="#"><span>2013-4-30</span></a>
				</h1>
				<div class="messages with-border">
					<div class="message first">
						<p>
							<span class="note-icon"></span> 你的点评收到 1 条新回应
						</p>
						<div class="image item-image">
							<a href="/detail/4dd1acc1/" target=_blank>
								<div class="img-mask"></div> <img src="http://img02.taobaocdn.com/bao/uploaded/i2/12188022137478940/T1EBGhXw8iXXXXXXXX_!!0-item_pic.jpg_120x120.jpg" />
							</a>
						</div>
					</div>
					<div class="message">
						<p>
							<span class="user-icon"></span> 有 1 个人开始关注你
						</p>
						<div class="note">
							<a href="javascript:void(0);" thelink="/user/follow/163345/0/" class="btn-v1 followBtn s1 w4"> <span></span> <em>关注</em>
							</a>
							<div class="avatar">
								<a href="/u/163345/likes/" target=_blank> <img src="http://image.guoku.com/avatar/default_small_8.png" width="50" height="50" />
								</a>
							</div>
							<a class="name c333" href="/u/163345/likes/" target=_blank>Arrange</a>
							<div class="clear"></div>
						</div>
					</div>
				</div>
				<h1>
					<a href="#"><span>2013-4-29</span></a>
				</h1>
				<div class="messages with-border">
					<div class="message first">
						<p>
							<span class="user-icon"></span> 有 1 个人开始关注你
						</p>
						<div class="note">
							<a href="javascript:void(0);" thelink="/user/follow/69567/1/" class="btn-v1 w4 followBtn s3"> <span></span> <em>取消关注</em>
							</a>
							<div class="avatar">
								<a href="/u/69567/likes/" target=_blank> <img src="http://image.guoku.com/avatar/small_69567_b6a015dbd91b22c31717939a0ab6f325.jpg" width="50" height="50" />
								</a>
							</div>
							<a class="name c333" href="/u/69567/likes/" target=_blank>有劲没劲</a>
							<div class="clear"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="main-right" id="main-right">
				<div class="siderbar with-border">
					<div class="aside">
						<h3>热门的标签</h3>
						<c:forEach items="${labels}" var="label">
							<p class="hottag">
								<span>#</span><a class="c666" href="/t/2674049e/" target=_blank>${label.name}</a>
							</p>
						</c:forEach>
					</div>
					<div class="aside">
						<h3>热门的用户</h3>
						<c:forEach items="${users}" var="user">
							<div class="note">
								<div class="avatar">
									<a href="/u/${user.id}/likes/" target=_blank> <img src="${user.head }" width="50" height="50" />
									</a>
								</div>
								<a class="name c333" href="/u/${user.id}/likes/" target=_blank> ${user.name} </a> <span class="desc l24"> ${user.bio} </span> <a href="javascript:void(0);" thelink="/user/follow/${user.id }/0/" class="btn-v1 followBtn s0 w4"> <span></span> <em>关注</em>
								</a>
								<div class="clear"></div>
							</div>
						</c:forEach>
					</div>
					<div class="aside mobile-download">
						<h3>下载果库客户端</h3>
						<p>
							<a href="http://itunes.apple.com/cn/app/id477652209?mt=8" target="_blank" bi="download_iphone">iPhone</a> / <a href="http://itunes.apple.com/cn/app/id450507565?mt=8" target="_blank" bi="download_ipad">iPad</a> / <a href="http://app.guoku.com/android/latest/guoku.apk" target="_blank" bi="download_andriod">Android</a>
						</p>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<script type="text/javascript" src="${ctx}/static/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/main.js"></script>
</body>
</html>

