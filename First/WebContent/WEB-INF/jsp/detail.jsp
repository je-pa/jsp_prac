<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/del?iboard=${vo.iboard }">삭제</a>
	<a href="/mod?iboard=${vo.iboard }">수정</a>
	<div>제목 : ${vo.title}</div>
	<div>작성일 : ${vo.regdt}</div>
	<div>내용 : ${vo.ctnt}</div>
</body>
</html>