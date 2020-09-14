package com.test;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.PrimaryDeviceDao;
import com.dao.LoginDao;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.model.Equipment;
import com.model.User;
import com.mysql.jdbc.Connection;



public class User1Main {
	public static void userInterface() {
		String resource = "com/test/user1-config.xml";
		//得到IO流
		InputStream is = User1Main.class.getClassLoader().getResourceAsStream(resource);
		//每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为核心的
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//得到session
		SqlSession sqlSession=factory.openSession(true);		//true  自动提交
		
		//得到ResuserMapper接口的实现类对象，ResuserMapper接口的实现类对象由sqlSession.getMapper(ResuserMapper.class)动态构建出来
		User1Interface mapper = sqlSession.getMapper(User1Interface.class);
		
		
//		查询
		List<User1> lstUsers = mapper.getAll();
		System.out.println("User："+lstUsers.get(0).getName()+"\t"+lstUsers.get(0).getSex());
		//使用SqlSession执行完SQL之后需要关闭SqlSession
		
		String name="蔡建伟";
		String sex = "男";
		User1 user = mapper.login(name, sex);
		System.out.print("带参数查询："+user.getName()+"\n"+user.getSex()+"\t"+user.getAge());
		
		sqlSession.close();
//		return mapper;
	}
	public static void login(){
		String resource = "com/test/user1-config.xml";
		//得到IO流
		InputStream is = User1Main.class.getClassLoader().getResourceAsStream(resource);
		//每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为核心的
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//得到session
		SqlSession sqlSession=factory.openSession(true);		//true  自动提交
		
		//得到ResuserMapper接口的实现类对象，ResuserMapper接口的实现类对象由sqlSession.getMapper(ResuserMapper.class)动态构建出来
		LoginDao mapper = sqlSession.getMapper(LoginDao.class);
		String userid = "sky666";
		String userpw = "skypw666";
		String usertype="学生1";
		User user = mapper.loginUser(userid, userpw, usertype);
		if(user!=null) {
			System.out.println("yes");
			System.out.println(user.getUser_id()+"\t"+user.getUser_email());
		}
		
		
		
	}
	static String resource = "com/test/user1-config.xml";
	//得到IO流
	static InputStream is = User1Main.class.getClassLoader().getResourceAsStream(resource);
	//每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为核心的
	static SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
	static //得到session
	SqlSession sqlSession=factory.openSession(true);		//true  自动提交
	static //得到ResuserMapper接口的实现类对象，ResuserMapper接口的实现类对象由sqlSession.getMapper(ResuserMapper.class)动态构建出来
            PrimaryDeviceDao mapper = sqlSession.getMapper(PrimaryDeviceDao.class);
	
	public static void equipId() {
		String type="all";
		int start=0;
		int end=10;
		ArrayList<Equipment> alst = mapper.getEquipmentAll(start, end);
//		Equipment equ = alst.get(0);
	
		System.out.println("User1Main.equipId()"+alst.size());
		Gson gson = new Gson();
		String json = gson.toJson(alst);
		System.out.println("json："+json);
		JsonParser parser = new JsonParser();
		JsonArray arr = new JsonArray();
		
	
		JsonArray other =parser.parse(json).getAsJsonArray();
		for(int i=0;i<other.size();i++) {
			JsonElement jelem = other.get(i);
			arr.add(jelem);
//			System.out.println(jelem.toString());
//			转为jsonobject
			JsonObject obj = jelem.getAsJsonObject();
//			System.out.println(obj.get("equ_name").getAsString());
//			String info = obj.getAsString();
//			System.out.println(obj.toString());
//			转为对象
//			Equipment p = gson.fromJson(jelem, Equipment.class);
//			System.out.println(p);
			
			
		}
		System.out.println(gson.toJson(arr));
//		if(alst.size()!=0) {
//			System.out.println("yes");
//			System.out.println(alst.get(0).getEqu_id()+"\t"+alst.get(0).getEqu_name());
//		}
		
		
		
	}
	public static void equipSize() {
		int total = mapper.getEquipmentAllSize();
//		int total = mapper.getEquipmentTypeSize("%通用%");
//		int total = mapper.getEquipmentNameSize("%装置%");
//		int total = mapper.getEquipmentIdSize("22");
		System.out.println("User1Main.euqidSize():"+total);
		
	}
	
//	delimiter $$
//	create procedure pro_queryequ( equtype varchar(20),out snt int)
//	begin
//	select count(*) into snt from tb_equipment;
//	select * from tb_equipment where equ_type like equtype limit 0,5;
//	end
//	$$
//	delimiter ;
//
//	call pro_queryequ("%通用电工%",@cnt);
//	select @cnt;
//

//	public static void proquery() {
//		System.out.println("EquipController.queryInfo()");
//		Map<String, Object> map = new HashMap<>();
//		map.put("equ_type", "%通用电工%");
//		List<Equipment> astr = mapper.queryAllInfo(map);
//		System.out.println("test:"+map.get("result"));
//		for(int i=0;i<astr.size();i++) {
//			System.out.println("equip:"+astr.get(i).toString());
//		}
//	}
	public static void connect() {
		Connection conn = null;
		try {
		    conn =	(Connection) DriverManager.getConnection("jdbc:mysql://localhost/test?" +
		                                   "user=root&password=666666&serverTimezone=UTC");
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
	}
	public static void main(String[] args) {
		//mybatis的资源配置文件
		String ss="1";
		System.out.println("User1Main.main()："+ss.equals("1"));
		connect();
		//执行查询操作，将查询结果自动封装成List<User>返回
//		login();
//		equipId();
//		equipSize();
//		proquery();
		
//		System.out.println(lstUsers);
}

}
