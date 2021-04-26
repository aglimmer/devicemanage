package com.testcase;

import java.nio.charset.Charset;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-09-11
 */
public class CharsetTest {
    public CharsetTest() {

    }

    public static void main(String[] args) {
        //查看当前系统的字符编码方式
        System.out.println(Charset.defaultCharset().name());
        //查看当前系统的编码方式
        System.out.println(System.getProperty("file.encoding"));
        System.out.println();

    }
}
