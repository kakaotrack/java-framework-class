<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>사용자 등록</title>
	<link href="/menu.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>

	<div id="Content">
		<form action="create" method="post">
			<fieldset>
				<legend>hello</legend>
				<p>
					<label>name</label>
					<input type="text" name="name" value="${helloModel.name }"/>
				</p>
				<p>
					<label>hello</label>
					<input type="name" name="hello" value="${helloModel.hello }"/>
				</p>

				<p>
					<input type="submit" value="등록" />
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>