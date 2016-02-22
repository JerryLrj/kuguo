<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html style="overflow-x: hidden; overflow-y: scroll;" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><sitemesh:title /></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon" />
<script type="text/javascript">
	if (window.ActiveXObject) {
		var ua = navigator.userAgent.toLowerCase();
		var ie = ua.match(/msie ([\d.]+)/)[1]
		if (ie == 6.0)
			location.href = "/ie6/";
	}
</script>
<sitemesh:head/>


</head>
<body>
	<div id="wrapper">
		<div id="popup-layer"></div>
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div class="clear"></div>
		<sitemesh:body />
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
		<%@ include file="/WEB-INF/layouts/right.jsp"%>
	</div>

</body>
</html>