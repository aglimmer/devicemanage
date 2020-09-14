package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestCont {
	
	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("hello world");
		return "test/hello";
	}

}
