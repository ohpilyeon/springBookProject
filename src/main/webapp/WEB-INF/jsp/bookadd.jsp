<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<meta name="viewport" content="width=device-width initial-scale=1">
<link rel="stylesheet" href="<c:url value='/libs/bootstrap-4.4.1-dist/css/bootstrap.min.css'/>">
<title>도서추가</title>
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
    
    
    <div class="container">
    <div class="centor-block" style="padding-top: 20px;">
        <div class="jumbotron" style="padding-top: 20px;">
            <form method="post" action="bookAddAction">
                <!-- <h3 style="text-align: center;">로그인 화면</h3> -->
                <h3 style="text-align: center;">도서추가 화면</h3>
                 <!-- 책 이름 -->
                <div class="form-group ">
                    <input type="text" class="form-control" placeholder="책 이름" 
                           name="bookName" maxlength="20">
                </div>
               
                <!-- 저자  -->
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="저자" 
                           name="author" maxlength="20">
                </div>
                <!-- 출판사  -->
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="출판사" 
                           name="publishingHouse" maxlength="20">
                </div>
                 <!-- 출판년도  -->
                <!-- 년월일 -->
                <div class="form-group">
                     <h6 style="text-align: left;">출판년도 ex)XXXX년XX월XX일
                </div>
                <div class="form-group" >
                	<div class="row"> 
                		<div class="col-md">
                			<input type="text" class="form-control" placeholder="년" 
                           name="year" maxlength="4">
                        </div> 
                		<div class="col-md">
                			<input type="text" class="form-control" placeholder="월" 
                           name="month" maxlength="2">
                        </div> 
                		<div class="col-md">
                			<input type="text" class="form-control" placeholder="일" 
                           name="day" maxlength="2">
                        </div> 
                        <!-- day mi se 00으로 고정 -->
						<!-- 시간 분 초 00으로 고정 -->
                	</div>
				</div>

               
                <!-- 정가  -->
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="정가" 
                           name="price" maxlength="20">
                </div>
                
                
                <input type="submit" class="btn btn-primary form-control" value="도서 추가" >
                <!-- 도서추가를 누르면 currentCount++; -->
                

            </form>
        </div>
    </div>
    </div>
    <script src="<c:url value='/libs/jquery-3.6.0.js'/>"></script>
    <script src="<c:url value='/libs/bootstrap-4.4.1-dist/js/bootstrap.js'/>"></script>
</body>
</html>


