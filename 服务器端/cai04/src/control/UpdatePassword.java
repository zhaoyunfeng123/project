package control;

import java.sql.Connection;
import java.sql.PreparedStatement;

import mysql.DataBaseConnect;

public class UpdatePassword {
	public static boolean updatePassword (String userPassword,String userAccount) {
		Connection con = DataBaseConnect.getConnection();
		boolean result = false;
		System.out.println("CHANGE连接成功");
		String sql=" update user set user_password=? WHERE user_account=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userPassword);
				ps.setString(2, userAccount);
				ps.execute();
				result = true;
				System.out.println("修改密码成功");
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("修改查询失败");
			}finally {
				DataBaseConnect.close(con);
			}
			return result;
	}
}


