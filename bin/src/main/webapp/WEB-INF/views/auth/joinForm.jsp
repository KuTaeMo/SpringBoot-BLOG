<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>블로그</title>
</head>
<body>
	<h1>회원가입 페이지</h1>
	<hr />
	<form action="/join" method="POST">
		<input type="text" placeholder="Username" name="username" /> <br/>
		<input type="password" placeholder="Password" name="Password" /><br/>
		<input type="email" placeholder="Email" name="Email" /><br/>
		
		<button>회원가입</button>
	</form>
	이미 회원가입이 안되셨나요? <a href="/loginForm">로그인</a>
</body>
</html>