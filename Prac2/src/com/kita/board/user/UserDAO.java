package com.kita.board.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kita.board.DBUtils;

public class UserDAO {
	public static void joinUser(UserEntity param) {
		Connection con =null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO p_user (unm,uid,upw,gender) VALUES (?,?,?,?)";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, param.getUnm());
			ps.setString(2, param.getUid());
			ps.setString(3, param.getUpw());
			ps.setInt(4, param.getGender());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
	}
	public static int idChk(String id) {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT uid FROM p_user WHERE uid=?";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, id.trim());
			rs=ps.executeQuery();
			if(rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static UserEntity selUser(UserEntity param) {
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		UserEntity result = null;
		String sql = "SELECT iuser, uid, upw, unm,profileImg FROM p_user WHERE uid=?";
		try {
			con= DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs=ps.executeQuery();
			if(rs.next()) {
				result=new UserEntity();
				result.setIuser(rs.getInt("iuser"));
				result.setUid(rs.getString("uid"));
				result.setUpw(rs.getString("upw"));
				result.setUnm(rs.getString("unm"));
				result.setProfileImg(rs.getString("profileImg"));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
}
