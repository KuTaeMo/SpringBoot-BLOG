<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
	<img src="img/carrotlogo.svg"/>
	<h1 style="color: #ff8a3d">로그인</h1>
	<hr />
	<form action="/login" method="POST">
		<div style="display: flex; justify-content: center; margin-bottom: 10px;">
			<div style="display: flex; flex-direction: column;">
				<input type="text" placeholder="Username" name="username" /> 
				<input type="password" placeholder="Password" name="password" />
			</div>
		<div style="display: flex; align-items: flex-end; margin-left: 10px;">
			<button style="background-color: #FF8A3D; border-radius: 5px; height: 100%;">로그인</button>
		</div>
	</div>
		
	</form>
	아직 회원가입이 안되셨나요?
	<a href="/joinForm" style="border: 1px solid #ff8a3d; border-radius: 5px; width: 200px; margin-bottom: 10px;">회원가입</a>
	<div style="display: flex; flex-direction: column; justify-content: center; align-items: center; margin-top: 10px;">
		<a href="/oauth2/authorization/google" style="border: 1px solid gray; border-radius: 5px; width: 200px; margin-bottom: 10px;"><img src="img/google.png" style="width: 25px;"/>구글 로그인</a>
		<a href="/oauth2/authorization/facebook" style="border: 1px solid gray; border-radius: 5px; width: 200px; margin-bottom: 10px;"><img src="img/facebook.png" style="width: 25px;"/>페이스북 로그인</a>
		<a href="/oauth2/authorization/naver" style="border: 1px solid gray; border-radius: 5px; width: 200px; margin-bottom: 10px;"><img src="img/naver.png" style="width: 25px;"/>네이버 로그인</a>
		<a href="/oauth2/authorization/kakao" style="border: 1px solid gray; border-radius: 5px; width: 200px; margin-bottom: 10px;"><img src="img/kakao.png" style="width: 25px;"/>카카오 로그인</a>
	</div>
	
	</div>
	
</body>
</html>