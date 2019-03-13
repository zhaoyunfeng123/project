package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.CaiBean;
import mysql.DataBaseConnect;
/**
 * 查询all_cai表中相应内容
 * */
public class SelectDao {
	public static void select(String search) {
		List<CaiBean> list = new ArrayList<CaiBean>();
		Connection conn = DataBaseConnect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "select * from all_cai where cai_class =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CaiBean caiBean = new CaiBean();
				caiBean.setCaiName(rs.getString(2));
				caiBean.setCaiClass(rs.getString(3));
				caiBean.setCaiImageUrl(rs.getString(4));
				caiBean.setCaiRaw(rs.getString(5));
				caiBean.setCaiOperandi(rs.getString(6));
				list.add(caiBean);
				InsertDao.insert(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql1 = "select * from all_cai where cai_name =?";
		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, search);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CaiBean caiBean = new CaiBean();
				caiBean.setCaiName(rs.getString(2));
				caiBean.setCaiClass(rs.getString(3));
				caiBean.setCaiImageUrl(rs.getString(4));
				caiBean.setCaiRaw(rs.getString(5));
				caiBean.setCaiOperandi(rs.getString(6));
				list.add(caiBean);
				InsertDao.insert(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
