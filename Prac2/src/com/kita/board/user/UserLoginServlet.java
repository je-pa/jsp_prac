package com.kita.board.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.kita.board.MyUtils;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("로그인", "user/login", request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserEntity param = new UserEntity();
		param.setUid(request.getParameter("uid"));
		UserEntity result = UserDAO.selUser(param);
		
		if(result==null) {
			request.setAttribute("errMsg", "아이디없음");
		}else if(BCrypt.checkpw(request.getParameter("upw"),result.getUpw() )) {
			result.setUpw(null);
			request.getSession().setAttribute("loginUser", result);
			response.sendRedirect("/board/list");	
			return;
		}else {
			request.setAttribute("errMsg", "비밀번호틀림");
		}
		doGet(request, response);
	}

}
