<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정</h1>
	<form action="mod" method="post">
		<div><input type="text" name="title" value="${vo.title }"></div>
		<div><textarea name="ctnt" cols="10" rows="10">${vo.ctnt }</textarea></div>
		<input type="hidden" name="iboard" value="${param.iboard }">
		<input type="submit" value="수정하기">
	</form>

</body>
</html>