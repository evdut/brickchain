<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
</head>
<body>
	<c:import url="WEB-INF/menu.jsp"></c:import>
	<div class="container">
		<c:import url="WEB-INF/horizontal-menu.jsp">
			<c:param name="title" value="${title}" />
		</c:import>
		<div class="main">
			<div class="column third">
				<div class="title">Новые курсы</div>				
				<br />
				<c:forEach var="course" items="${courses}">
					<div class="item">
						<img style="width:85%" src="resources/img/common/no-image.png" alt="" />
						<a class="name" href="">${course.title}</a>
					</div>
				</c:forEach>
			</div>
			<div class="column third">
				<div class="title">Новые вебинары</div>				
				<br />
				<c:forEach var="webinar" items="${webinars}">
					<div class="item">
						<img style="width:85%" src="resources/img/common/no-image.png" alt="" />
						<div class="date">${webinar.date}</div>
						<a class="name" href="">${webinar.title}</a>
					</div>
				</c:forEach>
			</div>
			<div class="column third">
				<div class="title">Новые статьи</div>
				<br />
				<c:forEach var="article" items="${articles}">
						<div class="item">
							<img style="width:85%" src="resources/img/common/no-image.png" alt="" />
							<a class="name" href="">${article.title}</a>
						</div>
					</c:forEach>
				</div>
			</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
		   var maxHeight = -1;

		   $('.column .item').each(function() {
		     maxHeight = maxHeight > $(this).height() ? maxHeight : $(this).height();
		   });

		   $('.column .item').each(function() {
		     $(this).height(maxHeight);
		   });
		 });
	</script>	
</body>
</html>
