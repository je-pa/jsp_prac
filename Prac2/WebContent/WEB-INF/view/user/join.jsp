<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>join</h1>
	<div>
		<form action="join" method="post">
			<div><input type="text" name="uid" placeholder="아이디"></div>
			<div><input type="password" name="upw" placeholder="비밀번호"></div>
			<div><input type="text" name="unm" placeholder="이름"></div>
			<div>성별 : 
				<label>여성<input type="radio" name="gender" value="0" checked></label>
				<label>남성<input type="radio" name="gender" value="1" checked></label> 
			</div>
			<div><input type="submit" value="회원가입"></div>
		</form>
	</div>

</body>
</html>