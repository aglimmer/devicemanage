package com.testcase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DBConnectTest {
	private Connection conn = null;
	private StringBuilder error = new StringBuilder();
	
	public static void main(String[]args) {
		DBConnectTest p = new DBConnectTest();
		Connection con = p.getConnect();
	}
	public DBConnectTest() {}
	public void close() {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Connect关闭出现异常...");
				e.printStackTrace();
				
			}
		}
		
	}
	public Connection getConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			error.append("服务器异常：\n"+"加载驱动失败...\n");
			System.out.println(error.toString());
//			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost/devicemanage?useUnicode=true&characterEncoding=utf8";
		try {//666666
			conn =  DriverManager.getConnection(url,"root","666666");//wzAB!_111222
			System.out.println("Connect.getConnect():连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			error.append("连接数据库失败...\n");
			System.out.println(error.toString());
//			e.printStackTrace();
		}
		return conn;
		
	}
	public void test(Connection conn) {
		String sql = "select * from book where isbn=?";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, 10);
			java.sql.ResultSet set = pre.executeQuery();
			while(set.next()) {
				System.out.println("book:"+set.getString(2));
			}
			if(pre!=null) {
				pre.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
