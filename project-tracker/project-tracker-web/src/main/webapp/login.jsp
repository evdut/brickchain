<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="resources/css/login.css" />
<link rel="shortcut icon" type="image/x-icon" href="/resources/img/logo/logo.png"/>
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
</head>
<body>
	<div class="vertical-menu">
		<div class="logo">
			<div class="img"></div>
		</div>
	</div>
	<div class="container">
		<div class="horizontal-menu">
			<div style="max-width: 1050px; margin: 0 auto;">
				<div class="title">Вход</div>
				<div class="title">Регистрация</div>
			</div>
		</div>
		<div class="main">
			<form method="post" action="j_security_check" class="left">
				<div>
					<input type="text" name="j_username" placeholder="Email" required/>
				</div>
				<div>
					<input class="last" type="password" name="j_password" placeholder="Пароль" required/>
				</div>
				<div>
					<input type="checkbox" name="rememberMe" id="rememberMe" /><label
						for="rememberMe"></label><span
						style="line-height: 27px;letter-spacing: 0.5px; color: rgb(15, 114, 114)">Запомнить
						меня</span>
				</div>
				<div style="text-align: center;">
					<input style="width: 150px;" class="button" type="submit" name="submit" value="Вход" />
				</div>
			</form>
			<form id="form2" method="post" action="j_security_check"
				class="right">
				<div>
					<input type="text" id="username" name="j_username"
						placeholder="Email" required/>
				</div>
				<div>
					<input type="password" id="password" name="j_password"
						placeholder="Пароль" required/>
				</div>
				<div>
					<div id="confirmError"></div>
					<input class="last" id="confirm" type="password" placeholder="Повторите пароль" required/>
				</div>
				<div>
					<input type="checkbox" name="agreement" id="agreement" /><label
						for="agreement"></label><span
						style="letter-spacing: 0.5px; color: rgb(15, 114, 114)">Я ознакомился и соглашаюсь с правилами пользования сервисом</span>
				</div>
				<div style="text-align: center;">
					<input style="width: 220px;" id="signup" type="button" class="button" value="Регистрация" />
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		var registered = false;
		$(document).ready(function() {
			$('#signup').click(function() {
				var password = $('#password').val();
				var username = $('#username').val();

				if (password != $('#confirm').val()) {
					$('#confirm').css("color","rgb(255,95,95) !important");
					$('#confirmError').css("color","rgb(255, 95, 95) !important");
					$('#confirmError').text("Пароль не совпадает");
					return false;
				} else {
					if (!registered) {
						$.post('/signup-student', {
							"username" : username,
							"password" : password
						}, function() {
							registered = true;
							$('#form2').submit();
						});
						return false;
					}
				}
			});
		});
	</script>
</body>

</html>
