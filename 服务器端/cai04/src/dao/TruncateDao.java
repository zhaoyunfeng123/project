package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import mysql.DataBaseConnect;
/**
 * 清空rs_cai表中的数据
 * */
public class TruncateDao {//truncate table 
	public static void truncate() {
		Connection conn = DataBaseConnect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "truncate table rs_cai";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
			System.out.println("删除数据成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}