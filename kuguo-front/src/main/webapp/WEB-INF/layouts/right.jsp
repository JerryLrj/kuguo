<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div id="popup-login" class="with-border">
	<a class="close-btn" href="javascript:void(0);">关闭</a>
	<div class="top">
		<form action="${ctx }/login" id="popup-login-form" method="post" enable="true">
			<div class="content">
				<p>
					<b>登录</b> | 没有帐号？ <a href="${ctx}/register" class="green">请注册</a>
				</p>
				<div class="row">
					<label>邮箱</label> <input name="username" type="text" value="" placeholder="电子邮件/用户名"/>
				</div>
				<div class="row">
					<label>密码</label> <input name="password" type="password" value="" placeholder="密码"/>
				</div>
				<input type="hidden" name="next" value="" />
				<input type="checkbox" name="remember_me" /> <span>记住我 &nbsp;·&nbsp;<a
					href="/forget_password/">忘记密码？</a></span> <input type="submit" value="登录"
					class="btn-v2 right" />
			</div>
		</form>
	</div>
</div>