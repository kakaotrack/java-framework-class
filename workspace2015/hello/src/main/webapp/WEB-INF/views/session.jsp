<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	name :${user.getName()}
	password :${user.getPassword()}
</h1>

</body>
</html>
