package com.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import com.model.Adm;
import com.model.User;

//使用全注解，则不需要User1Mapper.xml
public interface User1Interface {
		//使用@Select注解指明getAll方法要执行的SQL
		@Select("select * from tb_user")
		public List<User1> getAll();
		
		@Select("select * from tb_user where name=#{name} and sex=#{sex}")
		public User1 login(@Param("name") String name, @Param("sex") String sex);
		
		@Select("call pro_selectuser(#{username},#{userid})")
		@Options(statementType=StatementType.CALLABLE)
		public List<User1> pro_test(@Param("username") String pname, @Param("userid") int userid);
	
//		存储过程调用
//		注： Parameter 'arg' not found. Available parameters are [arg1, arg0, param1, param2]
//		@Select("call pro_selectuser(#{arg0},#{arg1})")
		@Select("call pro_selectuser(#{param1},#{param2})")
		@Options(statementType=StatementType.CALLABLE)
		public List<User1> pro_selectuser(String pname, int userid);
		
		@Insert("call pro_insertuser(#{arg0},#{arg1},#{arg2})")
		@Options(statementType=StatementType.CALLABLE)
		public int pro_insertuser(String name, int age, String sex);
		
		@Delete("call pro_deluser(#{arg0})")
		@Options(statementType=StatementType.CALLABLE)
		public int pro_deluser(int id);
		
		@Update("call pro_updateuser(#{arg0},#{arg1},#{arg2},#{arg3})")
		@Options(statementType=StatementType.CALLABLE)
		public int pro_updateuser(int id, String name, int age, String sex);
		
}

