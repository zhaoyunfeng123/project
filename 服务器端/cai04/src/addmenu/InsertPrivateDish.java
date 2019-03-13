package addmenu;

import java.sql.Connection;
import java.sql.PreparedStatement;

import mysql.DataBaseConnect;

public class InsertPrivateDish {
	public static boolean insertPrivateDish (String userAccount,String dishName,String raw,String method) {
		Connection con = DataBaseConnect.getConnection();
		boolean result = false;
		System.out.println("CHANGE连接成功");
		String sql="INSERT INTO pd_cai(account,dishname,raw,method) values(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userAccount);
			ps.setString(2, dishName);
			ps.setString(3, raw);
			ps.setString(4, method);
			ps.execute();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("添加失败");
		}finally {
			DataBaseConnect.close(con);
		}
		return result;
	}
}