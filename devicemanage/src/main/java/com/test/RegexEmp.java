package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class RegexEmp {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("https://www.icourse163.org/home.htm?userId=1017481282");
	
		try {
			InputStream stream = url.openStream();
			InputStreamReader isr = new InputStreamReader(stream,"utf-8");
			BufferedReader br = new BufferedReader(isr);
			StringBuilder sb = new StringBuilder();
			String temp;
			String ss = "<p style=\"background-color: #366AB3; font:bold;padding:8px 8px;width:100%;color:white;\">你的建议</p>";
			System.out.println(ss);
//			while()
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
