<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
		<meta name="viewport" content="width=device-width initial-scale=1"/>
		<link rel="stylesheet" href="<c:url value='/libs/bootstrap-4.4.1-dist/css/bootstrap.min.css'/>" >
		<title>메인</title>
	</head>
	<body>
		<!-- Navigation -->
		<%String id = (String)session.getAttribute("id");
		/* 비회원  */
    	if(id==null){%>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
		  <div class="container">
		    <a class="navbar-brand" href="#">
		          <img src="http://placehold.it/150x50?text=Logo" alt="">
		        </a>
		    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		          <span class="navbar-toggler-icon"></span>
		        </button>
		    <div class="collapse navbar-collapse" id="navbarResponsive">
		      <ul class="navbar-nav ml-auto">
		        <li class="nav-item active">
		        	<!-- href=프로젝트 이름 -->
		          <a class="nav-link" href="/test1">홈
		                <span class="sr-only">(current)</span>
		              </a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="login">로그인</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="signin">회원가입</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		<div class="container" style="padding-top:100px;">
			<button type="button" class="btn btn-primary btn-lg" onclick="location.href='booktable'">도서검색</button>
		</div>
		<%}else if(id.equals("admin")){%>
		<!-- 관리자 로그인  -->
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
		  <div class="container">
		    <a class="navbar-brand" href="#">
		          <img src="http://placehold.it/150x50?text=Logo" alt="">
		        </a>
		    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		          <span class="navbar-toggler-icon"></span>
		        </button>
		    <div class="collapse navbar-collapse" id="navbarResponsive">
		      <ul class="navbar-nav ml-auto">
		        <li class="nav-item active">
		        	<!-- href=프로젝트 이름 -->
		          <a class="nav-link" href="/test1">홈
		                <span class="sr-only">(current)</span>
		              </a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="userinfo">회원정보</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="logout">로그아웃</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		<!-- 관리자 메뉴들  -->
		<div class="container" style="padding-top:100px;">
			<button type="button" class="btn btn-primary btn-lg" onclick="location.href='adminbook'">도서 관리 </button>
			<button type="button" class="btn btn-primary btn-lg" onclick="location.href='usertable'">회원 관리 </button>
			<button type="button" class="btn btn-primary btn-lg" onclick="location.href='bookadd'">도서 추가 </button>
		</div>
		
		<%}else
		{%>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
		  <div class="container">
		    <a class="navbar-brand" href="#">
		          <img src="http://placehold.it/150x50?text=Logo" alt="">
		        </a>
		    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		          <span class="navbar-toggler-icon"></span>
		        </button>
		    <div class="collapse navbar-collapse" id="navbarResponsive">
		      <ul class="navbar-nav ml-auto">
		        <li class="nav-item active">
		        	<!-- href=프로젝트 이름 -->
		          <a class="nav-link" href="/test1">홈
		                <span class="sr-only">(current)</span>
		              </a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="userinfo">회원정보</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="logout">로그아웃</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		<div class="container" style="padding-top:100px;">
			<button type="button" class="btn btn-primary btn-lg" onclick="location.href='renttable'">대여중인 도서목록(반납)</button>
		</div>
		<div class="container" style="padding-top:100px;">
			<button type="button" class="btn btn-primary btn-lg" onclick="location.href='booktable'">도서 검색/대여</button>
		</div>
		<%} %>
		
			
		<!-- /.container -->
	</body>
	
	 <script src="<c:url value='/libs/jquery-3.6.0.js'/>"></script>
    <script src="<c:url value='/libs/bootstrap-4.4.1-dist/js/bootstrap.js'/>"></script>
</html>








