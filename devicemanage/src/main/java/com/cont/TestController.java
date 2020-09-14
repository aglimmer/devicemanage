package com.cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-09-11
 */

@RestController
public class TestController {

    @Autowired
     HttpSession session;

    public TestController() {

    }
    @RequestMapping("/testsecond.ano")
    public String testSecond(){
        Object msg = session.getAttribute("msg");
        System.out.println("session-msg="+msg);
        return "session中值："+msg.toString();

    }

    @RequestMapping("/testmsg.ano")
    public String testMessage(String msg){
        System.out.println("msg = " + msg);
        session.setAttribute("msg",msg);
        return "请求成功！<a href=\'testsecond.ano\'>获取</a>";

    }
}
