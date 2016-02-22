<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>添加商品</title>
<link media="all" rel="stylesheet" type="text/css" href="${ctx }/static/styles/add.css">
</head>
<body>
	<div id="main">
		<div class="main-left" id="main-left">
			<h1>添加商品入库</h1>
			<div class="entity with-border" style="min-height: 278px;">
				<form action="${ctx}/entity/taobao/info" method="post" id="new-entity-form" _lpchecked="1">
					<label>选择货真价实，有用、有趣、有价值的好商品</label> <br> <input type="text" id="new-entity-url" name="url" value="粘贴商品链接到这里" defaultvalue="粘贴商品链接到这里" style="color: rgb(187, 187, 187);"> <input type="button" onclick="validateurl();" name="btn" class="btn-v1" value="载入">
				</form>
			</div>
		</div>
		<div class="main-right" id="main-right">
			<div class="siderbar with-border">
				<div class="aside">
					<h3>全是好商品</h3>
					<p class="c999">如果，一件商品，</p>
					<p class="c999">你愿意让家人使用或与朋友分享，也许这就应该是件不错的东西。</p>
				</div>
				<div class="aside">
					<h3>创建人信息</h3>
					<p class="c999">作为第一个把商品推荐到的人，你将被永久记录在商品页。</p>
				</div>
				<div class="aside mobile-download">
					<h3>下载客户端</h3>
					<p>
						<a href="http://itunes.apple.com/cn/app/id477652209?mt=8" target="_blank" bi="download_iphone">iPhone</a> / <a href="http://itunes.apple.com/cn/app/id450507565?mt=8" target="_blank" bi="download_ipad">iPad</a> / <a href="http://app.guoku.com/android/latest/guoku.apk" target="_blank" bi="download_android">Android</a>
					</p>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<script type="text/javascript" src="${ctx}/static/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/main.js"></script>
	<script type="text/javascript">
		function validateurl() {
			var url = $("#new-entity-url").val();
			var strreg = "[taobao|tmail]";
			var reg = new RegExp(strreg);
			if(reg.test(url)) {
				$("#new-entity-form").submit();
			} else {
				alert("请输入正确的url");
			}
		}
		
		function cle() {
			var con = $("#content");
			var def = con.attr("defaultValue");
			if($.trim(con.val()) == def) {
				con.val("");
			}
		}
	</script>
</body>
</html>