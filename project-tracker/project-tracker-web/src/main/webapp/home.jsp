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

	<div class="main-wrapper">
		<div class="logout">logout</div>
		<div class="container">
			<div class="panel side-panel">
				<header class="header list-header">
				<div class="user">
					<div class="avatar icon-user-default">
						<div class="avatar-body">
							<img style="height: 100%; width: 100%; border-radius: 100%;"
								src="/resources/img/icon/avatar_placeholder_thumb.png"
								draggable="false" class="avatar-image">
						</div>
					</div>
				</div>
				<div class="controls">
					<div class="menu menu-horizontal">
						<span>
							<div class="menu-item">
								<button class="icon icon-project" title="New chat"></button>
								<span></span>
							</div>
							<div class="menu-item">
								<button class="icon icon-menu" title="Menu"></button>
								<span></span>
							</div>
						</span>
					</div>
				</div>
				</header>
			</div>
			<div class="panel main-panel">
				<header class="header list-header project-header"> </header>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var registered = false;
	$(document).ready(function() {
		$('.logout').click(function() {
			$.ajax({
				url : '/api/auth/signout',
				type : "PUT",
				success : function() {
					window.location.href = "/";
				}
			});
		})
	});
</script>
</html>
