package com.testcase.user01;//package com.test.user2;

import org.apache.ibatis.annotations.Select;

import java.util.List;

//使用全注解，则不需要UserMapper.xml
public interface UserMapper {
    //使用@Select注解指明getAll方法要执行的SQL
    @Select("select * from tb_user")
    public List<UserEntity> getAll();

    @Select("select * FROM tb_user where user_id=#{arg0} and user_passwd=#{arg1} and user_type=#{arg2}")
    public UserEntity loginUser(String userid, String userpassword, String usertype);
}

