package com.kita.board.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.kita.board.MyUtils;

@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("회원가입", "user/join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserEntity param = new UserEntity();
		param.setUnm(request.getParameter("unm"));
		param.setUid(request.getParameter("uid"));
		param.setUpw(BCrypt.hashpw(request.getParameter("upw"), BCrypt.gensalt()));
		param.setGender(MyUtils.getParamInt("gender", request));
		UserDAO.joinUser(param);
		response.sendRedirect("login");
	}

}
