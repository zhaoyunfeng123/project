package control;

import java.sql.Connection;
import java.sql.PreparedStatement;

import mysql.DataBaseConnect;

public class ForgetPassword {
	public static boolean forgetPassword (String userAccount,String problem,String newPassword) {
		Connection con = DataBaseConnect.getConnection();
		boolean result = false;
		System.out.println("CHANGE连接成功");
		String sql=" select * from user WHERE user_account=? AND user_problem=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userAccount);
			ps.setString(2, problem);
			ps.execute();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseConnect.close(con);
		}
		if(result) {
			String account = userAccount;
			String password = newPassword;
			UpdatePassword.updatePassword(password,account);
		}
		return result;
	}
}