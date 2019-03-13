package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.CaiBean;
import mysql.DataBaseConnect;

public class CaiDao {
	/**
	 * 查询所有菜类
	 */
	public List<CaiBean> getAllCai() {
		List<CaiBean> caiList = new ArrayList<CaiBean>();
		Connection conn = DataBaseConnect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "select cai_id,cai_name,cai_class,cai_image_url,cai_raw,cai_operandi from rs_cai";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CaiBean caiBean = new CaiBean(
						rs.getInt("cai_id"), 
						rs.getString("cai_name"),
						rs.getString("cai_class"),
						rs.getString("cai_image_url"),
						rs.getString("cai_raw"),
						rs.getString("cai_operandi"));
				caiList.add(caiBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return caiList;
	}
}
