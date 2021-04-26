package com.service;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;



@Service
public class UploadService {

	//默认使用classes目录下的images文件夹保存上传的图片
	//java在编译后会把resources文件夹下的子文件添加到 classes目录下
	private String imageFolder = "images";

	public  String getResourcesBasePath() {
		//获取resources路径下images文件夹的路径，路径结尾没有/
		final String basePath = Thread.currentThread().getContextClassLoader().getResource(imageFolder).getPath();
		return basePath;
	}

	
	 public String saveImg(String image) {
// 		文件头部信息形式
//		String header = "data:image/jpeg;base64,";
		String header = "data:image/";
//		找不到以字符串 header，说明不是图片
		if (!image.startsWith(header)) {
			return "无图片";
		}
		int pos = image.indexOf(";");
		String imgtype = image.substring(header.length(),pos);
		System.out.println("图片类型："+imgtype);
// 		去掉头部
		image = image.substring(image.indexOf(",")+1);
		System.out.println("去除头部："+image);
		BASE64Decoder decoder = new BASE64Decoder();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmssSSS");
//		生成一个文件名
		String fileName = formatter.format(LocalDateTime.now())+"."+imgtype;
//		图片保存路径
		String imgFilePath = getResourcesBasePath()+File.separator+fileName;
		try {
			// 对字节数组字符串进行Base64解码并生成图片
			byte[] decodedBytes = decoder.decodeBuffer(image);
			FileOutputStream out = new FileOutputStream(imgFilePath);
//			把图片写入文件
			out.write(decodedBytes);
			out.close();
		} catch (Exception e) {
			System.out.println("发生异常");
//			返回json类型
			return null;
//			e.printStackTrace();
		}
//		返回文件路径
		return fileName;
	 }
	 	
		/**
		 * 解析路径读取图片到前端
		 **/
	 	public String imgToBase64(String imageFileName) {
			String msg = null;
	 		int pos = imageFileName.lastIndexOf(".")+1;
	 		String fileType = imageFileName.substring(pos);
	         InputStream in = null;
	         byte[] data = null;
	         String filePath = getResourcesBasePath()+File.separator+imageFileName;
	         // 读取图片字节数组
	         try {
	             in = new FileInputStream(filePath);
	             //in.available()计算字节大小
	             data = new byte[in.available()];
	             //InputStream把数据读取到字节数组中
	             in.read(data);
	             in.close();
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
	         // 对字节数组Base64编码
	         BASE64Encoder encoder = new BASE64Encoder();
	         if (data != null) {
	         	 //返回Base64编码过的字节数组字符串
	         	String res = "data:image/"+fileType+";Base64,"+encoder.encode(data);
	         	
	             return "data:image/jpeg;base64," + encoder.encode(data);
	         }
	         return null;
	     }
	 

}
