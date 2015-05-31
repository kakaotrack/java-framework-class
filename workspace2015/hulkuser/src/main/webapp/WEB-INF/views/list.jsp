<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>사용자 등록</title>
	<link href="/menu.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div id="Header">
		사용자 관리
	</div>
	<div id="Menu">
		<a href="list">목록보기</a><br/>
		<a href="create.jeju">등록하기</a>
	</div>
	<div id="Content">
		<table>
			<caption>사용자 목록</caption>
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.id } </td>
					<td>${user.name } </td>
					<td><a href="modify?id=${user.id}">수정</a></td>
					<td><a href="remove?id=${user.id}">삭제</a></td>
				</tr>
				</c:forEach>
			</tbody>	
		</table>
	</div>
</body>
</html>