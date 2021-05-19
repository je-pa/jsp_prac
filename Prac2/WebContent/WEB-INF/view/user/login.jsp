<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div class="errMsg">${errMsg }</div>
		<div>
			<form action="login" method="post">
 				<div><input type ="text" name="uid" placeholder="아이디"></div>
 				<div><input type ="password" name="upw" placeholder="비밀번호"></div>			
 				<div><input type="submit" value="Login"></div>
			</form>
		</div>
		<div>
			<a href="join">회원가입</a>
		</div>
	</div>
</body>
</html>