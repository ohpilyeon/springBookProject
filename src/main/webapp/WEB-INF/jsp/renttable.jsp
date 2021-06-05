<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	
	<!-- booktable  -->
	<meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.css"/> 
	<!-- nav 적용이 안됨  -->
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<meta name="viewport" content="width=device-width initial-scale=1"/>
	<link rel="stylesheet" href="<c:url value='/libs/bootstrap-4.4.1-dist/css/bootstrap.min.css'/>">
	    
    <script src="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.js"></script>
    <script>
        jQuery(function($){
            $("#foo-table").DataTable();
        });
    </script>
    
    
    <title>도서정보 </title>
</head>
<body>
 <!-- Navigation -->
 		<div class="container">
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
		          <a class="nav-link" href="/TermProject-1">홈
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
	</div>
	
	<div class="container">
	    <table id="" class="table table-bordered">
			<thead>
				<tr>
					<th>책 이름</th>
					<th>대여한 날짜</th>
					<th>반납 예정 날짜</th>
					<th>반납</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="rentDto" items="${rentList}">
					<tr>
						<td>${rentDto.bookName}</td>
						<td>${rentDto.rentDate}</td>
						<td>${rentDto.returnDate}</td>
						<td><button type="button" onclick="" class="btn btn-danger">반납</button></td>
					</tr>
				</c:forEach>
			</tbody>
	    </table>
    </div>
</body>
	<script src="<c:url value='/libs/jquery-3.6.0.js'/>"></script>
    <script src="<c:url value='/libs/bootstrap-4.4.1-dist/js/bootstrap.js'/>"></script>
</html>