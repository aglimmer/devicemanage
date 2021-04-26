package com.testcase.user;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

//使用全注解，则不需要User1Mapper.xml
public interface UserTestMapper {
		//使用@Select注解指明getAll方法要执行的SQL
		@Select("select * from user_test")
		public List<UserTest> getAll();
		
		@Select("select * from user_test where username=#{username} and password=#{password} limit 0,1")
		public UserTest login(@Param("username") String username, @Param("password") String password);
		
		@Select("call pro_user_test_find(#{username},#{password})")
		@Options(statementType=StatementType.CALLABLE)
		public UserTest findUser(@Param("username") String username, @Param("password") String password);
	
		/**
		 * 存储过程调用，参数注入使用占位符:
		 * 注： Parameter 'arg' not found. Available parameters are [arg1, arg0, param1, param2]
		 **/
		@Insert("call pro_user_test_insert(#{arg0},#{arg1})")
		@Options(statementType=StatementType.CALLABLE)
		public int insertUser(String username,String password);
		
		@Delete("call pro_user_test_delete(#{arg0},#{arg1})")
		@Options(statementType=StatementType.CALLABLE)
		public int deleteUser(String username,String password);
		
		@Update("call pro_user_test_update_password(#{param1},#{param2})")
		@Options(statementType=StatementType.CALLABLE)
		public int updateUserPassword(String username,String password);
		
}

