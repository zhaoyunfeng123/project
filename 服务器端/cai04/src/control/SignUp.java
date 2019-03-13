package control;

import java.sql.Connection;
import java.sql.PreparedStatement;

import mysql.DataBaseConnect;

public class SignUp {
	public static boolean signUp(String userAccount,String userName,String userPassword) {
		Connection con = DataBaseConnect.getConnection();
		System.out.println("CHANGE连接成功");
			try {
				String sex = "man";
		        String employment = "我的职业";
		        String email="我的邮箱";
		        String message="既然要吃，就要吃胖！Ψ(￣∀￣)Ψ";
		        String problem = "我的密保问题";
				String sql="INSERT INTO user (user_account,user_name,user_password) values(?,?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, userAccount);
				ps.setString(2, userName);
				ps.setString(3, userPassword);
				ps.executeUpdate();
				con.close();
				System.out.println("数据插入成功"); 
				Update.upBate(userName, sex, employment, email, message, problem, userAccount);
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
			
		return true;
	}

}
