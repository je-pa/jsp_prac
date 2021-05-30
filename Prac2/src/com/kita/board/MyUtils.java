package com.kita.board;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kita.board.user.UserEntity;

public class MyUtils {
	public static void openJSP(String title, String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("title", title);
		request.setAttribute("jsp", jsp);
		request.getRequestDispatcher("/WEB-INF/view/template.jsp").forward(request, response);
	}
	public static UserEntity getLoginUser(HttpServletRequest request) {
		if(request==null) {return null;}
		return (UserEntity)request.getSession().getAttribute("loginUser");
	}
	public static int getLoginUserPK(HttpServletRequest request) {
		return getLoginUser(request).getIuser();
	}
	public static int stringToInt(String str) {
		try {
			return Integer.parseInt(str);
		}catch(Exception e){
			return 0;
		}
	}
	public static int getParamInt(String key, HttpServletRequest request) {
		return stringToInt(request.getParameter(key));
	}
}
