<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html style="overflow-x: hidden; overflow-y: scroll;" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<title>欢迎加入</title>
<link media="all" rel="stylesheet" type="text/css" href="${ctx }/static/styles/register.css" />

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
			<div class="rlcontainer">
				<div class="top">
					<div class="big_logo">
						<a href="${ctx }/selected/"> <img src="${ctx}/static/images/logo.jpg" />
						</a>
					</div>
					<form action="${ctx }/login" class="rl-form" onsubmit="" id="login-in-form" method="post" enable="true">
						<div class="content">
							<p>
								<b>登录</b> | 没有帐号？ <a href="${ctx }/register" class="green">请注册</a>
							</p>
							<div class="row">
								<label>邮箱</label><input name="username" type="text" value="${username }" placeholder="电子邮件/用户名"/>
							</div>
							<div class="row">
								<label>密码</label><input name="password" type="password" value="" placeholder="密码"/>
								<c:if test="${error != null }">
									<em class="error">${error }</em>
								</c:if>
							</div>
							<input type="checkbox" name="rememberMe" /> <span>记住我 &nbsp;·&nbsp;<a href="#">忘记密码？</a></span> <input type="submit" value="登录" class="btn-v2" />
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="footer">
			<div class="footer-container">
				<span>京ICP备</span>
				<ul class="footer-items">
					<li><a href="">iPhone</a></li>
					<li><a href="">iPad</a></li>
					<li><a href="">Android</a></li>
					<li><a href="mailto:rujie.liu@qq.com" alt="Keep in touch :)">邮件反馈</a></li>
					<li><a href="http://www.weibo.com/guoku" target="_blank" bi="sina">新浪微博</a></li>
					<li><a href="http://guoku.com/agreement/">用户协议</a></li>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${ctx}/static/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/main.js"></script>
</body>
</html>
