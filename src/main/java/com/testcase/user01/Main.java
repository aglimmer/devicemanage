package com.testcase.user01;

import com.mysql.jdbc.Connection;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Main {

    private static SqlSession getSqlSession() {
        String resource = "com/testcase/user01/user-mapper.xml";
        //从类加载器中获取IO流
        InputStream is = Main.class.getClassLoader().getResourceAsStream(resource);
        //每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为核心的
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //设置自动提交
        SqlSession sqlSession = factory.openSession(true);
        return sqlSession;
    }

    /**
     * 登录测试
     **/
    public static void login() {
        SqlSession sqlSession = getSqlSession();
        //得到ResuserMapper接口的实现类对象，ResuserMapper接口的实现类对象由sqlSession.getMapper(ResuserMapper.class)动态构建出来
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String userid = "sky666";
        String userpw = "skypw666";
        String usertype = "学生";
        UserEntity user = mapper.loginUser(userid, userpw, usertype);
        if (user != null) {
            System.out.println("yes");
            System.out.println(user.getUserId() + "\t" + user.getUserEmail());
        } else {
            System.out.println("参数错误或没有找到该用户");
        }
    }

    /**
     * 测试连接是否正常
     **/
    public static void connect() {
        Connection conn = null;
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/devicemanage?" +
                    "user=root&password=666666&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        System.out.println("连接成功！");

    }
    public static void getAllUserTest() {
        SqlSession sqlSession = getSqlSession();
        List<UserEntity> userEntityList = sqlSession.getMapper(UserMapper.class).getAll();
        userEntityList.forEach(obj -> System.out.println(obj));
    }

    public static void main(String[] args) {
        getAllUserTest();
    }

}
