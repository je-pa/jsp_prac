package com.kit.first;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	public static List<BoardVO> selBoardList(){
		List<BoardVO> list = new ArrayList<>();
		Connection con = null;;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT iboard, title, regdt FROM p_board";
		try {
			con=DBUtils.getCon(); //연결
			ps = con.prepareStatement(sql); //준비
			
			rs=ps.executeQuery(); //실행결과 담기
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIboard(rs.getInt("iboard"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	}
	
	public static BoardVO selBoard(int iboard) {
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		String sql="SELECT iboard, title, regdt, ctnt from p_board where iboard=?";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, iboard);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setTitle(rs.getString("title"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIboard(rs.getInt("iboard"));
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		
		return null;
	}
	
	public static void insertBoard(BoardVO vo) {
		Connection con =null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO p_board (title, ctnt) VALUES (?,?)";
		
		try {
			con=DBUtils.getCon();//다리
			ps=con.prepareStatement(sql);//다리위에 있는 트럭
			
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			
			ps.executeUpdate();//출발
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}

	}

	public static void delBoard(BoardVO vo) {
		Connection con =null;
		PreparedStatement ps=null;
		String sql = "DELETE FROM p_board WHERE iboard=?";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, vo.getIboard());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
	}
	
	public static void updBoard(BoardVO vo) {
		Connection con =null;
		PreparedStatement ps=null;
		String sql = "UPDATE p_board SET title=?,ctnt=? WHERE iboard=?";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			
			ps.setString(1,vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
	}
	
}
