<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<script type="text/javascript" src="../resources/js/jquery.min.js"></script>
</head>
<body>
	<c:import url="menu.jsp"></c:import>
	<div class="container">
		<c:import url="horizontal-menu.jsp">
			<c:param name="title" value="${title}" />
		</c:import>
		<div class="main">
			<div style="margin:10px 0;width:100%;border-bottom: 1px solid rgb(86, 191, 191)">
				<a href="#"><img style="width: 200px;" src="../resources/img/common/6.png" alt="" /> </a>
			</div>
			<div style="width: 80%;float: left;">

				<c:forEach var="article" items="${articles}">
					<a href="/article?uuid=${article.id}"
						style="width: 100%; float: left; margin: 10px 0 0 0;; display: block;">
						<img style="width: 25%; height: 140px; display: inline-block"
						src="../resources/img/no-image.png" alt="" />
						<div
							style="width: 74%; display: inline-block; vertical-align: top;">
							<div
								style="font-size: 18px; margin: 5px 0 20px 20px; font-family:'
								Avant Garde C Bold', 'OpenSans', Helvetica, Arial, sans-serif;">${article.title}</div>
							<div style="font-size: 11px;margin-left: 20px">${article.description}</div>
							<!--  div style="margin-left: 20px">
								<div style="float: left">${article.views}</div>
								<div style="float: left">${article.likes}</div>
							</div-->
						</div>

					</a>
				</c:forEach>
			</div>
			<div style="width: 20%; float: left; text-align: right; margin-top:20px">
				<div class="section">
					<div class="section-title">Станьте автором блога, <br/> вам
						это понравится.</div>
					<div class="section-content">Мы уверены, что у каждого
						участника нашего сообщества есть свой уникальный опыт, которым он
						может поделиться. Если вы чувствуете в себе потребность делиться
						знаниями, присылайте нам свои статьи</div>
					<a class="button" href="#">Добавить статью</a>
				</div>
				<div class="section">
					<div class="section-title">Интересные статьи</div>
					<c:forEach var="article" items="${interestingArticles}">
						<a href="/article?uuid=${article.id}"
							style="width: 100%; height: 60px; display: block;margin:10px 0">
							<div style="font-size: 14px;">${article.title}</div> <div style="font-size: 11px;">subtitle<br />subtitle</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>