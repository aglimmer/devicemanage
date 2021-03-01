package com.cont;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.PrimaryDeviceDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.Equipment;
import com.model.User;
import com.model.Usingrecord;
import com.service.EquipService;
import com.service.UploadService;

@Controller
public class PrimaryDeviceController {

	public static Logger logger = LoggerFactory.getLogger(PrimaryDeviceController.class);

	@Autowired
	EquipService equipService;
	
	@Autowired
	private PrimaryDeviceDao equipDao;


//	根据设备类型查询
	@ResponseBody
	@RequestMapping("/searchequ.do")
	public String getEquip(String type,String content, String start, String end) {
		logger.info("类型名："+type+"\t内容："+content+"\t起始："+start+"\t结束："+end);
//		System.out.println("类型名："+type+"\t内容："+content+"\t起始："+start+"\t结束："+end);
		ArrayList<Equipment> alst = equipService.getEquip(type, content, Integer.parseInt(start), Integer.parseInt(end));
		Gson gson = new Gson();
		String json = gson.toJson(alst);
		logger.info("返回的json字符串"+json);
//		System.out.println("返回的json字符串"+json);
		return json;
		
	}
//	获取设备总量大小
	@ResponseBody
	@RequestMapping("/searchinit.do")
	public String getEquipSize(String type,String content) {
		int total = equipService.getEquipSize(type,content);
//		System.out.println("搜索设备信息的数量："+total);
		logger.info("搜索设备信息的数量："+total);
		Gson gson = new Gson();
		String nstr =  gson.toJson(total);
		return nstr;
	}

//	修改设备信息
	@ResponseBody
	@RequestMapping("/modifyequ.do")
	public String modifyEquipment(Equipment equ) {
		logger.info("修改设备信息注入参数："+equ.toString());
//		System.out.println("修改设备信息注入参数："+equ.toString());
		 int res =equipDao.modifyEquip(equ);
		 return String.valueOf(res);
		 
	}
//	根据设备分类查询设备
	@ResponseBody
	@RequestMapping("/querytype.do")
	public String queryAllType(int start,int end) {
		ArrayList<Equipment> equ = equipDao.queryAllType(start,end);
		logger.info("EquipController.queryAllType():"+equ.size());
//		System.out.println("EquipController.queryAllType():"+equ.size());
		Gson gson = new Gson();
		String json = gson.toJson(equ);
		return json;
	}
//	根据设备具体信息查询设备
	@ResponseBody
	@RequestMapping("/spectype.do")
	public String querySpecType(String equ_type,int start,int end) {
		
//		System.out.println("同类型详细设备："+equ_type+"\t"+start+"\t"+end);
		logger.info("同类型详细设备："+equ_type+"\t"+start+"\t"+end);
		
		ArrayList<Equipment> equ = equipDao.querySpecType(equ_type,start,end);
		logger.info("返回数量："+equ.size());
//		System.out.println("返回数量："+equ.size());
		Gson gson = new Gson();
		String json = gson.toJson(equ);
		return json;
	}
//	删除设备
	@ResponseBody
	@RequestMapping("/delequip.do")
	public String delEquipment(@RequestParam Map<String,Object> obj) {
		obj.put("result", 0);
		equipDao.delEquipment(obj);
		String ss = obj.get("result").toString();
		System.out.println("EquipController.delEquipment()");
		return new Gson().toJson(ss);
	}

//	添加基本设备
	@ResponseBody
	@RequestMapping("/addequ.do")
	public String addEqu(@RequestParam Map<String,Object> ob) {
		logger.info("数量："+ob.size());
		ob.put("result",0);
		ob.forEach((kk,vv)->{
			if(vv==null) {
				logger.info(kk+"\tnull");
			}else {
				logger.info(kk+"\t"+vv.toString());
			}
			
		});
		
		String res = "0";
		try {
		equipDao.addEqu(ob);
		res =String.valueOf(ob.get("result"));
		logger.info("添加结果："+ob.get("result"));
//		捕获所有异常
		}catch(Exception e) {
			e.printStackTrace();
			logger.info("添加失败："+e.getMessage());
		}
		return res;
	}

//	查询厂家信息
	@ResponseBody
	@RequestMapping("/factinfo.do")
	public String factInfo(int id) {
		Map<String,Object> res = equipDao.getFactory(id);
		Gson gson = new Gson();
		String ss = gson.toJson(res);
		logger.info(ss);
		return ss;
	}
}
