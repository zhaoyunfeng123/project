package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mysql.DataBaseConnect;

public class Update {
	public static String upBate(String name,String sex,String employment,String email,String messages,String problem,String account) {
		Connection con = DataBaseConnect.getConnection();
		String udResult = null;
		System.out.println("CHANGE连接成功");
		String sql = "update user set user_name=?,user_sex=?,user_employment=?,user_email=?,user_introduction=?,user_problem=? where user_account=?";
		//创建语句传输对象
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, sex);
			ps.setString(3, employment);
			ps.setString(4, email);
			ps.setString(5, messages);
			ps.setString(6, problem);
			ps.setString(7, account);
			ps.executeUpdate();
			udResult = "success";
			System.out.println("更新信息成功");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("更新信息失败");
		}finally {
			DataBaseConnect.close(con);
		}
		return udResult;
	}
}
