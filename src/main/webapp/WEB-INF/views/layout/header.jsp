<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!-- property = 가져올 변수명 => 유저컨트롤러의 get.principal()과 같은 뜻 -->
<!-- var = 사용할 변수명 -->
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html>
<head>

<meta charset="EUC-KR">
<title>당근마켓</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<body>

	<!-- empty로 null이나 공백 확인 -->
	<c:choose>
		<c:when test="${empty principal}">
			<nav class="navbar navbar-expand-sm" style="background-color: #FFFFFF;">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="/" style="color: #FF8A3D;"><img src="${pageContext.request.contextPath}/img/carrotlogo.svg"/></a></li>
					<li class="nav-item"><a class="nav-link" href="/loginForm" style="color: gray;">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="/joinForm" style="color: gray;">회원가입</a></li>
				</ul>
			</nav>
		</c:when>
		<c:otherwise>
			<nav class="navbar navbar-expand-sm" style="background-color: #FFFFFF;">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="/"><img src="${pageContext.request.contextPath}/img/carrotlogo.svg"/></a></li>
					<li class="nav-item"><a class="nav-link" href="/post/saveForm" style="color: #FF8A3D;">글쓰기</a></li>
					<li class="nav-item"><a class="nav-link" href="/user/${principal.user.id}" style="color: #FF8A3D;">회원정보보기</a></li>
					<li class="nav-item"><a class="nav-link" href="/logout" style="color: #FF8A3D;">로그아웃</a></li>
				</ul>
			</nav>
		</c:otherwise>
	</c:choose>
	<br />