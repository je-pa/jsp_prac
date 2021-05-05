<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List</h1>
	<div><a href="/write">글쓰기</a></div>
	<table>
		<tr><th>no</th><th>제목</th><th>작성일</th>	</tr>
		<c:forEach items="${list}" var="item">
			<tr onclick="moveToDetail(${item.iboard})">
				<td>${item.iboard }</td>
				<td>${item.title }</td>
				<td>${item.regdt }</td>
			</tr>
		</c:forEach>
	</table>
	<script>
			function moveToDetail(iboard){
				location.href='/detail?iboard='+iboard;
			}
	</script>
</body>
</html>