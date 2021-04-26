package com.testcase.user;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 查询测试
 **/
public class Main {
	private static UserTestMapper getUserTestMapper(){
		String resource = "user-test-config.xml";
		InputStream is = Main.class.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession=factory.openSession(true);
		UserTestMapper userTestMapper = sqlSession.getMapper(UserTestMapper.class);
		return userTestMapper;
	}
	public static void getAllUserTest() {
		List<UserTest> users = getUserTestMapper().getAll();
		users.forEach(obj-> System.out.println(obj));
	}
	public static void loginTest(){
		UserTest userTest = getUserTestMapper().login("user01","pw666666");
		System.out.println(userTest);
	}

	public  static  void deleteUserTest(){
		int res = getUserTestMapper().deleteUser("user01","pw666666");
		System.out.println(res);
	}
	public static void addUserTest(){

		int res = getUserTestMapper().insertUser("user01","123456");
		System.out.println(res);
	}
	public static  void updateUserTest(){
		int res = getUserTestMapper().updateUserPassword("user01","pw666666");
		System.out.println(res);
	}

	
	public static void gsonTest() {
		List<UserTest> userTests = getUserTestMapper().getAll();
		Gson gson = new Gson();
		String json = gson.toJson(userTests);
		System.out.println("json："+json);
		JsonParser parser = new JsonParser();
		JsonArray arr = new JsonArray();
		JsonArray jsonArray =parser.parse(json).getAsJsonArray();
		for(int i=0;i<jsonArray.size();i++) {
			JsonElement jelem = jsonArray.get(i);
			arr.add(jelem);
			//转为jsonobject
			//JsonObject obj = jelem.getAsJsonObject();
		}
		System.out.println(gson.toJson(arr));
	}
//	public static void main(String[] args) {
////		getAllUserTest();
//		loginTest();
//		deleteUserTest();
//		addUserTest();
//		updateUserTest();
//		gsonTest();
//	}

}
