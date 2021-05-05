package com.kit.first;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		BoardVO vo = BoardDAO.selBoard(Integer.parseInt(iboard));
		
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/WEB-INF/jsp/mode.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		BoardVO vo = new BoardVO();
		vo.setIboard(Integer.parseInt(iboard));
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		BoardDAO.updBoard(vo);
		
		response.sendRedirect("list");
	}

}
