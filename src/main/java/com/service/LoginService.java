package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LoginDao;
import com.model.Adm;
import com.model.User;

//该类用于包装抽象接口，用于调用接口中的方法
@Service
public class LoginService {
    @Autowired
    private LoginDao logindao;

    //	管理员登录
    public Adm loginAdmImp(String admid, String admpasswd) {
        return logindao.loginAdm(admid, admpasswd);
    }

    //	用户登录
    public User loginUserImp(String userid, String userpw, String usertype) {
        return logindao.loginUser(userid, userpw, usertype);


    }
}
