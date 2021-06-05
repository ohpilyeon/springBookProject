<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<meta name="viewport" content="width=device-width initial-scale=1"/>
<link rel="stylesheet" href="<c:url value='/libs/bootstrap-4.4.1-dist/css/bootstrap.min.css'/>">

<script >
	function showPopup() 
	{ 
			window.open("showpw", "showpw", "width=400, height=300, left=100, top=50");
			/* window.open("url", "name", "window set size"); */
	}
 </script>
 
<title>비밀번호 찾기</title>
</head>
<body>
    <!-- Navigation -->
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
    
    
    <div class="container">
    <div class="centor-block" style="padding-top: 20px;">
        <div class="jumbotron" style="padding-top: 20px;">
            <form method="post" action="login">
                <!-- <h3 style="text-align: center;">로그인 화면</h3> -->
                <h3 style="text-align: center;">비밀번호 찾기</h3>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="아이디" 
                           name="id" maxlength="20">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="핸드폰 번호" 
                           name="phonenumber" maxlength="20">
                </div>
                <input type="submit" class="btn btn-primary form-control" onclick="showPopup()" value="비밀번호 찾기" >
            </form>
        </div>
    </div>
    <div class="col-lg-4"></div>
    </div>
    <script src="<c:url value='/libs/jquery-3.6.0.js'/>"></script>
    <script src="<c:url value='/libs/bootstrap-4.4.1-dist/js/bootstrap.js'/>"></script>
</body>
</html>





