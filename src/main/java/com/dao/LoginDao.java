package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.model.Adm;
import com.model.User;

// 抽象接口
public interface LoginDao {
//	select * FROM tb_user where user_id="sky666" and user_passwd="skypw666" and user_type="学生"	skypw666	学生
//	查询用户	
	@Select("select * FROM tb_user where user_id=#{arg0} and user_passwd=#{arg1} and user_type=#{arg2}")
	public User loginUser(String userid, String userpassword, String usertype);

//	查询管理员
	@Select("Select * from tb_admin where adm_id=#{arg0} and adm_passwd=#{arg1}")
	public Adm loginAdm(String admid, String admpasswd);


}
