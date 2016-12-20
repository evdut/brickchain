<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
<script type="text/javascript" src="../resources/js/jquery.min.js"></script>
</head>
<body>
	<c:import url="menu.jsp"></c:import>
	<div style="float: left">
		<c:import url="horizontal-menu.jsp">
			<c:param name="title" value="Вебинары" />
			<c:param name="userName" value="${userName}" />
		</c:import>
		<div style="width: 100%">
			<c:forEach var="webinar" items="${webinars}">
				<div
					style="width: 30%; float: left; margin: 1%; height: 100px border: 1px solid black; border-radius: 3px;">
					<div style="height: 100px border: 1px solid black; border-radius: 3px;">
						<div style="font-size: large;">${webinar.title}</div>
						<div style="">${webinar.description}</div>
					</div>
					<div style="width: 40%; float: left;">${webinar.date}</div>
					<div style="width: 40%; float: right;">100uah</div>				
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>