<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<meta name="viewport" content="width=device-width initial-scale=1">
<link rel="stylesheet" href="<c:url value='/libs/bootstrap-4.4.1-dist/css/bootstrap.min.css'/>">
<title>회원정보</title>
</head>
<body>
    <!-- Navigation -->
		<%String id = (String)session.getAttribute("id");
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
		<%}else{%>
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
		<%} %>
    
    
    <div class="container">
    <div class="centor-block" style="padding-top: 20px;">
        <div class="jumbotron" style="padding-top: 20px;">
            <form method="post" action="reuserinfo">
                <h3 style="text-align: center;">회원정보</h3>
                 <!-- 아이디 -->
                <div class="form-group ">
                    <input type="text" class="form-control" name="id" readonly value="${id}">
                </div>
                <!-- 이름  -->
                <div class="form-group">
                    <input type="text" class="form-control" name="name" readonly value="${name}">
                </div>
                <!-- 핸드폰번호  -->
                <div class="form-group">
                    <input type="text" class="form-control" name="phonenumber" readonly value="${phoneNumber}">
                </div>
                <!-- 이메일  -->
                <div class="form-group">
                    <input type="text" class="form-control" name="email" readonly value="${email}">
                </div>
                <div class="form-group">
                	<input type="submit" class="btn btn-primary form-control" value="수정하기" >    
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-danger form-control" value="탈퇴하기" >
                </div>
            </c>
            </form>
        </div>
    </div>
    </div>
    <script src="<c:url value='/libs/jquery-3.6.0.js'/>"></script>
    <script src="<c:url value='/libs/bootstrap-4.4.1-dist/js/bootstrap.js'/>"></script>
</body>
</html>





