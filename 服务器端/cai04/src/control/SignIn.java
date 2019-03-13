package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import mysql.DataBaseConnect;

public class SignIn {
	public static List<User> signIn (String userAccount,String userPassword) {
		Connection con = DataBaseConnect.getConnection();
		List<User> list = new ArrayList<>();
		System.out.println("CHANGE连接成功");
			try {
				String sql=" SELECT * FROM user WHERE user_account=? AND user_password=?";
				PreparedStatement ps = con.prepareStatement(sql);
				//验证账号和密码的值是否存在且匹配
				ps.setString(1, userAccount);
				ps.setString(2, userPassword);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					String userName = rs.getString(3);
					String userSex = rs.getString(5);
					String userEmployment = rs.getString(6);
					String userEmail = rs.getString(7);
					String userIntroduction = rs.getString(8);
					String problem = rs.getString(10);
					User user = new User();
					user.setName(userName);
					user.setSex(userSex);
					user.setEmployment(userEmployment);
					user.setEmail(userEmail);
					user.setMessage(userIntroduction);
					user.setProblem(problem);
					list.add(user);
					System.out.println("查询信息成功");
					return list;
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("查询信息失败");
			}finally {
				DataBaseConnect.close(con);
			}
			return list;
	}
}


