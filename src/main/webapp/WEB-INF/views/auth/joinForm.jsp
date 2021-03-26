<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>당근마켓</title>
</head>
<style>
    a { text-decoration: none; color: black; }
    a:visited { text-decoration: none; }
    a:hover { text-decoration: none; }
    a:focus { text-decoration: none; }
    a:hover, a:active { text-decoration: none; }
</style>
<body>
	<div align="center">
		<img src="img/carrotlogo.svg" />
		<h1 style="color: #ff8a3d">회원가입</h1>
		<hr />
		<form action="/join" method="POST">
			<div style="display: flex; justify-content: center; margin-bottom: 10px;">
				<div>
					<input type="text" placeholder="Username" name="username" /> <br /> 
					<input type="password" placeholder="Password" name="Password" /><br /> 
					<input type="email" placeholder="Email" name="Email" /><br />
				</div>
				<div style="display: flex; align-items: flex-end; margin-left: 10px;">
					<button style="background-color: #FF8A3D; border-radius: 5px; height: 100%">회원가입</button>
				</div>
			</div>
		</form>
		이미 회원가입 하셨나요? <a href="/loginForm" style="border: 1px solid #ff8a3d; border-radius: 5px; width: 200px; margin-bottom: 10px;">로그인</a>
	</div>

</body>
</html>