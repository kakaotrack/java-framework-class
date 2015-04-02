<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>사용자 수정</title>
	<link href="/menu.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div id="Header">
		사용자 관리
	</div>
	<div id="Menu">
		<a href="list.jsp">목록보기</a><br/>
		<a href="create.jsp">수정하기</a>
	</div>
	<div id="Content">
		<form action="save" method="POST">
			<fieldset>
				<legend>사용자 등록</legend>
				<p>
					<label>아이디</label>
					<input type="text" name="id" value="${user.id}"/>
				</p>
				<p>
					<label>이름</label>
					<input type="name" name="name" value="${user.name }"/>
				</p>
				<p>
					<label>암호</label>
					<input type="password" name="password" value="${user.password }" />
				</p>
				<p>
					<input type="submit" value="수정" />
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>
