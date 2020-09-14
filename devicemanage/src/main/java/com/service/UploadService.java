package com.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;



@Service
public class UploadService {
	
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
//		生成一个文件名
		String fileName = formatter.format(LocalDateTime.now());
//		设置图片保存路径
		String imgFilePath = "E:\\JavaWeb\\EquipManage\\upload\\"+fileName+"."+imgtype;
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
		return imgFilePath;

	 }
	
	
	
	 	
//	 	解析路径读取图片到前端
	 	public String imgToBase64(String imageFile) {
//	 		String filePath = "C:\\Users\\Lenovo\\Pictures\\06dd54ddf31d6e3eda1427bee4575ae8.jpg";
//			String info = ImageToBase64(filePath);
			String msg = null;
	
	 		
	 		int pos = imageFile.lastIndexOf(".")+1;
	 		String fileType = imageFile.substring(pos);
	 		
	         InputStream in = null;
	         byte[] data = null;

	         // 读取图片字节数组
	         try {
	             in = new FileInputStream(imageFile);
//	             in.available()计算字节大小
	             data = new byte[in.available()];
//	             InputStream把数据读取到字节数组中
	             in.read(data);
	             in.close();
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
	         // 对字节数组Base64编码
	         BASE64Encoder encoder = new BASE64Encoder();
	         if (data != null) {
//	         	 返回Base64编码过的字节数组字符串
	         	String res = "data:image/"+fileType+";Base64,"+encoder.encode(data);
	         	
	             return "data:image/jpeg;base64," + encoder.encode(data);
	         }
	         return null;
	     }
	 

}
