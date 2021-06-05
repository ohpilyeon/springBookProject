<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<!-- booktable  -->
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.css" />
<!-- nav 적용이 안됨  -->
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<meta name="viewport" content="width=device-width initial-scale=1" />
<link rel="stylesheet"
	href="<c:url value='/libs/bootstrap-4.4.1-dist/css/bootstrap.min.css'/>">

<script
	src="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.js"></script>
<script>
	jQuery(function($) {
		$("#foo-table").DataTable();
	});
</script>


<title></title>
</head>
<body>
	<!-- Navigation -->
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
			<div class="container">
				<a class="navbar-brand" href="#"> <img
					src="http://placehold.it/150x50?text=Logo" alt="">
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item active">
							<!-- href=프로젝트 이름 --> <a class="nav-link" href="/test1">홈 <span
								class="sr-only">(current)</span>
						</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="login">로그인</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="signin">회원가입</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<div class="container">
		<table id="foo-table" class="table table-bordered">
			<thead>
				<tr>
					<th>책 이름</th>
					<th>저자 명</th>
					<th>출판사</th>
					<th>출판년도</th>
					<th>정가</th>
					<th>남은 권수</th>
					<th>대여한 권수</th>
					<th>대여</th>
					<th>반납</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bookDto" items="${bookList}">
					<tr>
						<td>${bookDto.bookName}</td>
						<td>${bookDto.author}</td>
						<td>${bookDto.publishingHouse}</td>
						<td>${bookDto.publicationDate}</td>
						<td>${bookDto.price}</td>
						<td>${bookDto.currentCount}</td>
						<td>${bookDto.rentCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="<c:url value='/libs/jquery-3.6.0.js'/>"></script>
	<script
		src="<c:url value='/libs/bootstrap-4.4.1-dist/js/bootstrap.js'/>"></script>
</body>
</html>