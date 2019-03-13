package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接
 */
public class DataBaseConnect {
	//加载驱动路径
	static{
		try {
			//mysql-connector-java-5.1.6版本 
			Class.forName("com.mysql.jdbc.Driver");
			//mysql-connector-java-8.0.13版本
			//Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("成功加载驱动");
		} catch (ClassNotFoundException e) {
			System.out.println("error：Class.forName");
			e.printStackTrace();
		}
	}
	/**打开数据库*/
	public static Connection getConnection(){
		//数据库地址
		//mysql-connector-java-5.1.6版本 
		String url="jdbc:mysql://localhost:3306/cai";
		//mysql-connector-java-8.0.13版本
		//String url="jdbc:mysql://localhost:3306/cai?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
		
		//访问数据库的用户名
		String mysqlUser = "root";
		//访问数据库的用户密码     
		String mysqlPassword = "";
		Connection conn = null;
		try {
			//连接数据库
			conn = DriverManager.getConnection(url,mysqlUser,mysqlPassword);
			System.out.println("成功连接数据库！");
			return conn;
		} catch (SQLException e) {
			System.out.println("连接数据库失败！");
			e.printStackTrace();
			return null;
		}
	}
	/**关闭数据库*/
	public static void close(Connection conn){
		try{
			if(conn!=null){
				conn.close();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String agrs[]) {
		DataBaseConnect.getConnection();
	}
}
