<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show password</title>
</head>
<body>
	<div class="container">
		<ul>
			<li>User Password: ${userDto.password}</li>
			<%String id = (String) session.getAttribute(""); 
			String phonenumber= (String) session.getAttribute("");%>
			<c:forEach var="userDto" items="${userList}">
				<!-- 아래와 같은 조건문을 만들고 싶습니다. -->
				<!-- if(id.equal(userDto.id)&&phonenumber.equal(userDto.phonenumber)) -->
				<li>User Password: ${userDto.password}</li>
				
			</c:forEach>
		</ul>		
	</div>

	
</body>
</html>