package com.kita.board.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kita.board.DBUtils;

public class UserDAO {
	public static UserVO selUser(UserVO param) {
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		UserVO result = null;
		String sql = "SELECT iuser, uid, upw, unm FROM t_user WHERE uid=?";
		try {
			con= DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs=ps.executeQuery();
			if(rs.next()) {
				result=new UserVO();
				result.setIuser(rs.getInt("iuser"));
				result.setUid(rs.getString("uid"));
				result.setUpw(rs.getString("upw"));
				result.setUnm(rs.getString("unm"));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	public static int joinUser(UserVO param) {
		Connection con =null;
		PreparedStatement ps =null;

		String sql = "INSERT INTO t_user (uid,upw,unm,gender) VALUES (?,?,?,?)";
		try {
			con= DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			ps.setInt(4, param.getGender());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
}
