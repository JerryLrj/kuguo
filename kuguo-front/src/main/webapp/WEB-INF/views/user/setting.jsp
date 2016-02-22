<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html style="overflow-x: hidden; overflow-y: scroll;" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="msvalidate.01" content="AC5BC2B7EE50E9FED342DC08F3BA6BAC" />
<title>设置</title>
<link media="all" rel="stylesheet" type="text/css" href="${ctx }/static/styles/setting.css" />
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
		<div id="popup-layer"></div>
		<div class="clear"></div>
		<div id="main">
			<div class="with-border mt60">
				<h1>帐号设置</h1>
				<form class="mid-form" action="${ctx }/origin/upload/" method="post" enctype="multipart/form-data" id="avatar-setting-form">
					<fieldset>
						<div class="user-item">
							<div class="avatar with-border">
								<img src="${user.head }" />
							</div>
							<span class="img-upload"> <a id="file_upload_btn" href="javascript:void(0);" class="green">点击选择图片</a> <em id="file_name">未选择</em> <input id="file_upload" name="file_upload" type="file" class="dn">
								<p>支持 JPG、GIF、PNG 格式，不超过 2MB。</p> <input href="${ctx }/origin/upload/" class="btn-v1 disable btn-upload" type="submit" value="更换头像" />
							</span>
							<div class="clear"></div>
						</div>
					</fieldset>
				</form>
				<form novalidate="novalidate" action="${ctx }/user/setting/" class="mid-form" method="post" id="account-setting-form">
					<input name="id" value="${user.id }" type="hidden"/>
					<fieldset>
						<h4 class="heading">个人资料</h4>
						<div class="row">
							<label>昵称</label> <input name="name" value="${user.name }" original="${user.name }" type="text" readonly="readonly">
						</div>
						<div class="row">
							<label>登录邮箱</label> <input name="email" value="${user.email }" type="email" original="${user.email }" readonly="readonly">
						</div>
						<div class="row-textarea">
							<label>个人介绍</label>
							<textarea name="bio" cols="25" rows="2" maxLength="30">${user.bio }</textarea>
						</div>
						<div class="row">
							<label>所在地</label> 
							<select id="location" name="address" class="select-1 default">
								<option selected="selected">${user.address }</option>
							</select> 
							<select id="city" name="city" class="select-2 default">
								<option selected="selected">${user.city }</option>
							</select>
						</div>
						<div class="row">
							<label>性别</label> <input class="radio" name="gender" value="1" type="radio" <c:if test="${user.gender == '1'}">checked="checked"</c:if> /> <span>男</span> <input class="radio" name="gender" value="0" type="radio" <c:if test="${user.gender == '0'}">checked="checked"</c:if> /> <span>女</span> <input class="radio" name="gender" value="3" type="radio" <c:if test="${user.gender == '3'}">checked="checked"</c:if> /> <span>其他</span>
						</div>
						<div class="row">
							<label for="label5">网址</label> <input id="label5" name="website" value="${user.website }" class="default" type="text">
						</div>
						<div class="row">
							<label>&nbsp;</label> <input value="更新资料" class="btn-v1 disable" type="submit">
						</div>
					</fieldset>
				</form>
				<form novalidate="novalidate" action="${ctx }/user/update/password" class="mid-form" method="post" id="password-setting-form">
					<fieldset>
						<input type="hidden" name="id" value="${user.id }"/>
						<h4 class="heading">修改密码</h4>
						<input type="hidden" name="update_password" value='true' />
						<div class="row">
							<label for="current_password">当前密码</label> <input id="current_password" name="current_password" value="" class="default" type="password">
						</div>
						<div class="row">
							<label for="new_password">新的密码</label> <input id="new_password" name="new_password" value="" class="default" type="password">
						</div>
						<div class="row">
							<label for="confirm_password">确认密码</label> <input id="confirm_password" name="confirm_password" value="" class="default" type="password">
						</div>
						<div class="row">
							<label>&nbsp;</label> <input value="修改密码" class="btn-v1 disable" type="submit">
						</div>
					</fieldset>
				</form>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<script type="text/javascript" src="${ctx }/static/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx }/static/jquery/jquery.from.js"></script>
	<script type="text/javascript" src="${ctx }/static/jquery-validation/1.10.0/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${ctx }/static/js/main.js"></script>
</body>
</html>

