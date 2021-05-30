<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>리스트</h1>
<table>
	<tr><th>no</th><th>title</th><th>작성자</th><th>작성일</th></tr>
	<c:forEach var="item" items="${requestScope.list }">
	
	</c:forEach>
</table>