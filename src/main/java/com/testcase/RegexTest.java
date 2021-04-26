package com.testcase;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) throws MalformedURLException {
        patternTest();
    }

    public static void patternTest() {
        Set<String> set = new HashSet<String>();
        String regex = "/[\\w\\d_-]*.html";
        List list = Arrays.asList("/aaaa.html", "/img-hello.html", "/123.html", "/W-923-a.html", "/img_upload.do", "/img_upload/index.html");
        set.addAll(list);
        set.forEach(str -> {
            boolean res = Pattern.matches(regex, str);
            if (res) {
                System.out.println(str + "能与" + regex + "匹配");
            } else {
                System.out.println(str + "无法与" + regex + "匹配");
            }
        });
    }

}
