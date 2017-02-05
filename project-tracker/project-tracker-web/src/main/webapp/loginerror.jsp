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
<link rel="shortcut icon" type="image/x-icon" href="/resources/img/favicon.png"/>
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
</head>
<body>
	<div class="main-wrapper">
		<div class="container">
			<form method="post" action="j_security_check" class="left">
				<div>
					<input style="color:rgb(255,95,95) !important" type="text" disabled="disabled" value="Wrong credentials" />
				</div>
				<div>
					<input type="text" name="j_username" placeholder="Email" />
				</div>
				<div>
					<input class="last" type="text" name="j_password" placeholder="Password" />
				</div>
				<div style="text-align: center;">
					<input style="width: 150px;" class="button" type="submit" name="submit" value="Login" />
				</div>
			</form>
			<form id="form2" method="post" action="j_security_check"
				class="right">
				<div>
					<input type="text" id="username" name="j_username"
						placeholder="Email" />
				</div>
				<div>
					<input type="password" id="password" name="j_password"
						placeholder="Password" />
				</div>
				<div>
					<div id="confirmError"></div>
					<input class="last" id="confirm" type="password" placeholder="Confirm password" />
				</div>
				<div style="text-align: center;">
					<input style="width: 220px;" id="signup" type="button" class="button" value="Sign-up" />
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
					$('#confirm').css("color","rgb(255,95,95)");
					$('#confirmError').css("color","rgb(255, 95, 95) !important");
					$('#confirmError').text("Password do not match");
					return false;
				} else {
					if (!registered) {
						$.ajax({
						  url: '/api/public/auth/signup',
						  type: "POST",
						  data: JSON.stringify({
								"email" : username,
								"password" : password
							}),
						  contentType :"application/json",
						  success: function() {
								alert(3);
								registered = true;
								$('#form2').submit();
							}
						});
						return false;
					}
				}
			});
		});
	</script>
</body>

</html>
