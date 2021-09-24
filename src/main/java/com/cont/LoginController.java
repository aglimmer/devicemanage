package com.cont;


import com.model.Adm;
import com.model.User;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	HttpSession session;

	@Autowired
	private LoginService loginService;

	@Autowired
	private HttpServletRequest request;


	@ResponseBody
	@RequestMapping("/url.ano")
	public String getBaseUrl() {
		//String uri = request.getRequestURI();
		//输出：/devicemanage/url.ano
		System.out.println(request.getRequestURL());
		//输出：http://localhost:8080/devicemanage/url.ano
		//System.out.println("path="+request.getContextPath());
		//输出：/devicemanage
		String baseURL = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort()
				+ request.getContextPath();
		System.out.println("请求的基本路基：" + baseURL);
		return baseURL;
	}

	//	首次登陆
	@ResponseBody
	@RequestMapping("/login.ano")
	public String loginCont(String userid, String userpw, String usertype, String varifycode) {
		System.out.println(userid + "\t" + userpw + "\t" + usertype + "\t" + varifycode);
		String oricode = null;

		try {
			oricode = session.getAttribute("varifycode").toString();
		} catch (NullPointerException e) {
			return "error";
		}
//		验证码不正确
		if (!varifycode.equalsIgnoreCase(oricode)) {
			System.out.println("验证码错误");
			return "error1";
		}
		System.out.println("session-userid:" + session.getAttribute("userid"));
		System.out.println("session-usertype:" + session.getAttribute("usertype"));
//		将用户信息保存到session
		session.setAttribute("userid", userid);
		session.setAttribute("userpw", userpw);
		int status = 1;
		if (usertype.equals("管理员")) {
			status = 2;
			session.setAttribute("usertype", "2");
		} else {
			session.setAttribute("usertype", "1");
		}
		boolean successful = false;
//		用户类型
		if (status == 1) {
//			System.out.println("用户：" + userid + "\t" + userpw + "\t" + usertype);
			User user = loginService.loginUserImp(userid, userpw, usertype);
			if (user != null) {
				System.out.println("登录成功");
				successful = true;
			} else {
				System.out.println("用户名或密码有误");
				return "error2";
			}
		}
		Adm adm = loginService.loginAdmImp(userid, userpw);
		if (adm != null) {
			System.out.println("登录成功");
			successful = true;
		}
		if (successful) {
			return "success";
		}
		return "error2";
	}

	@ResponseBody
	@RequestMapping("/checkdeal.ano")
	public String checkSecurityCode(@RequestParam("security") String securityCode) {
//		String chstr = request.getParameter("security");
		System.out.println("验证码：" + securityCode);
		String safeCode = request.getSession().getAttribute("varifycode").toString();
		System.out.println("正确的验证码：" + safeCode);
		if (securityCode.equalsIgnoreCase(safeCode)) {
			System.out.println("success");
			return "success";
		} else {
			System.out.println("error");
			return "error";
		}
	}
}
