package com.testcase;

import com.testcase.user01.Main;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author WangZeng
 * @Date 2021-04-26 23:18
 */
public class FileStreamTest {

    /**
     * 测试从classpath（resources)下加载资源
     **/
    public static void readFileAsStream() {
        // getContextClassLoader().getResourceAsStream()默认从classpath中找文件，文件放在resources目录下，name不能带“/”，否则会抛空指针
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-config.xml");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(stream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
        try {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeProjectResourceTest() {
        String basePath = Thread.currentThread().getContextClassLoader().getResource("images").getPath();
        try {
            String fileName = "hello.txt";
            String filePath = basePath + "/" + fileName;
            System.out.println("path=" + basePath);
            //E:/GitSpace/github_space/devicemanage/target/classes/images
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(basePath + "/" + fileName)));
            //bufferedWriter.write("覆盖写入一行字符串");
            bufferedWriter.write("覆盖方式写入一行字符串123456");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendWriteFileByBufferedWriter() {
        String filePath = "E:\\GitSpace\\github_space\\devicemanage\\src\\main\\resources\\images\\test.txt";
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));//true,则追加写入text文本
            String date = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss.SSS").format(new Date());
            bufferedWriter.write(date + " 追加写入一行记录");
            //bufferedWriter.write("\r\n");//换行
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void randomAccessFileTest() {
        String filePath = "C:\\Users\\Lenovo\\Desktop\\test\\text.txt";
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
            long fileLength = randomAccessFile.length();
            randomAccessFile.seek(fileLength);
            String content = new Date().toString()+"追加写入一行数据\n";
            randomAccessFile.writeUTF(content);
            randomAccessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "r");
            String line = null;
            try {
                //写入时使用writeUTF，读取时就需要使用readUTF，否则乱码
                line = randomAccessFile.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("读取一行数据："+line);
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readProjectResourcesTest() {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("images/test.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        try {
            line = bufferedReader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void getProjectPathTest() {
        String classesPath = Main.class.getResource("/").getPath();
        System.out.println("classesPath=" + classesPath);
        //输出：classesPath=/E:/GitSpace/github_space/devicemanage/target/classes/
        try {
            String path = ResourceUtils.getURL("classpath:").getPath();
            System.out.println("classesPath-2=" + path);
            //输出：classesPath-2=/E:/GitSpace/github_space/devicemanage/target/classes/
            File file = new File(path).getParentFile().getParentFile();
            System.out.println("projectRootPath=" + file.getAbsolutePath());
            //输出：projectRootPath=E:\GitSpace\github_space\devicemanage
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试从当前包下加载资源
     **/
    public static void readFileAsStreamTest() {
        // class.getResourceAsStream()指定一个文件名，用于读取当前包下的一个文件
        InputStream stream = Main.class.getResourceAsStream("user-mapper.xml");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(stream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
        try {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileStreamTest() {
        // 创建文件对象
        File file = new File("io_file/temp.txt");
        if (!file.exists()) {
            //不存在则创建,不要使用file.mkdirs(),不然创建的temp.txt就变成文件夹了
            ////默认项目根目录下
            file.getParentFile().mkdirs();
            System.out.println("创建文件夹");
        }
        try {
            //文件写入：创建文件输出流，追加写入
            FileOutputStream out = new FileOutputStream(file,true);
            String text = "梦想天空：dream of flying the sky";
            // 创建byte型数组，text.getBytes("utf-8")设置所用文件的编码
            byte bytes[] = text.getBytes();
            // 将数组中信息写入到文件中
            out.write(bytes);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //读取文件： 创建文件输入流
            FileInputStream in = new FileInputStream(file);
            byte byt[] = new byte[1024];
            int len = -1;
            // 将文件中信息输出
            while((len = in.read(byt))!= -1){
                System.out.println(new String(byt, 0, len));
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void outputStreamWriterAndReaderTest() {

        File file = new File("C:\\Users\\Lenovo\\Desktop\\test\\text.txt");
        //文件写入
        try {
            OutputStreamWriter outputStreamWriter = null;
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            try {
                String content = "文本中的一行记录";
                bufferedWriter.write(content);
                System.out.println("正在写入：" + content);
                //bufferedWriter.newLine();
                bufferedWriter.flush();
                bufferedWriter.close();
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //文件读取
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println("正在读取："+line);
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static void fileReaderAndWriter(){
        // 创建文件对象
        File file = new File("io_file/temp.txt");
        try {
            // 创建FileWriter对象
            FileWriter fileWriter = new FileWriter(file,true);
            String text = "梦想天空：dream of flying the sky";
            // 将信息写入磁盘文件
            fileWriter.write(text);
            fileWriter.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        try {
            // 创建FileReader对象
            FileReader fileReader = new FileReader(file);
            // 创建char型数组
            char cstr[] = new char[1024];
            // 将字节读入数组
            int len = fileReader.read(cstr);
            System.out.println(new String(cstr, 0, len));
            fileReader.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    public static void inputStreamToOutputStreamTest(){
        File inputFile = new File("C:\\Users\\Lenovo\\Desktop\\test\\text.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            File outFile = new File("C:\\Users\\Lenovo\\Desktop\\test\\output.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            byte []buff = new byte[1024];
            int len = -1;
            while((len=bufferedInputStream.read(buff))!=-1){
                bufferedOutputStream.write(buff,0,len);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        getProjectPathTest();
//        readProjectResourcesTest();
//        writeProjectResourceTest();
//        randomAccessFileTest();
        inputStreamToOutputStreamTest();
//        appendWriteFileByBufferedWriter();
//        outputStreamWriterAndReaderTest();
    }
}
