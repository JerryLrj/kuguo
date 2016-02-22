<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:if test="${item!=null }">
	<div class="entity-detail">
		<label>品牌</label> <label class="ml90">商品名称</label> <br /> <input type="text" id="new-entity-brand" name="brand" value="如果有" defaultValue="如果有" /> <input type="text" id="new-entity-name" name="title" value="${item.title }" />
		<h4 id="brand-name">
			<span></span><span>${item.title }</span>
		</h4>
		<div class="image entity-img">
			<a href="#">
				<div class="img-mask"></div> <img src="${item.picUrl }" />
			</a>
		</div>
		<div class="thumbnail-container">
			<c:forEach items="${item.itemImgs}" var="itemImg">
				<div class="thumbnail-outer active">
					<div class="thumbnail">
						<img src="${itemImg.url}" />
					</div>
				</div>
			</c:forEach>
			<div class="clear"></div>
		</div>
	</div>
	<h2>点评</h2>
	<div class="notes with-border">
		<div class="note new-note">
			<div class="avatar">
				<img src="<shiro:principal property="head"/>" width="50" height="50" />
			</div>
			<div hidden="true" id="uid"><shiro:principal property="id"/></div>
			<a class="name c333" href="${ctx }/u/<shiro:principal property="id"></shiro:principal>/"><shiro:principal property="name" /></a> <span class="desc"><shiro:principal property="bio" /></span>
			<form action="${ctx}/entity/new/" id="add-form" method="post">
				<input type="hidden" name="taobao_id" value="${item.numIid }"> <input type="hidden" name="category_id" value="128"> <input type="hidden" name="brand" value=""> <input type="hidden" name="price" value="${item.price}"> <input type="hidden" name="order_link" value="${item.detailUrl}"> <input type="hidden" name="name" value="${item.title }"> <input type="hidden" name="picture" value="${item.picUrl }"> <input type="hidden" name="taobaoke_info" value="">
				<textarea name="comment.content" defaultValue="写点评  #加标签">写点评  #加标签</textarea>
				<div class="note-prompt">
					<div class="arrow-fcfcfc"></div>
					来说说你的评价吧？欢迎真实、有用、有趣的商品点评。
				</div>
				<em class="error add-error"></em> <input class="btn-v2 right" type="submit" value="发表" />
			</form>
			<div class="clear"></div>
		</div>
	</div>
</c:if>
<c:if test="${item==null}">
	<div>获取商品失败</div>
</c:if>
