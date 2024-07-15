<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webapp/WEB-INF/views/member.jsp</title>
</head>
<body>
	<div class="container">
		<h2>회원 1명의 정보</h2>
			<p>번호 : <strong>${requestScope.dto.getNum() }</strong></p>
			<p>이름 : <strong>${dto.getName() }</strong></p>
			<p>주소 : <strong>${dto.getAddr() }</strong></p>
	</div>
</body>
</html>