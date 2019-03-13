package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import bean.CaiBean;
import mysql.DataBaseConnect;
/**
 * 查询结果插入all_cai表
 * */
public class InsertDao {
	public static void insert(List<CaiBean> list) {
		Connection con = DataBaseConnect.getConnection();
		System.out.println("CHANGE连接成功");
		String name = null;String caiClass = null;String imgUrl = null;String raw = null;String operandi = null;
			try {
				String sql="INSERT INTO rs_cai(cai_name,cai_class,cai_image_url,cai_raw,cai_operandi) values(?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				for(CaiBean caiBean : list) {
					name = caiBean.getCaiName();
					caiClass = caiBean.getCaiClass();
					imgUrl = caiBean.getCaiImageUrl();
					raw = caiBean.getCaiRaw();
					operandi = caiBean.getCaiOperandi();
				}
				ps.setString(1, name);
				ps.setString(2, caiClass);
				ps.setString(3, imgUrl);
				ps.setString(4, raw);
				ps.setString(5, operandi);
				ps.executeUpdate();
				con.close();
				System.out.println("InsertDao---数据插入成功"); 
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}
