package com.cont;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.dao.ScrapDeviceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.FaultDeviceDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.service.UploadService;

@Controller
public class ScrapDeviceController {

	
	@Autowired
	ScrapDeviceDao scrapDeviceDao;


	@ResponseBody
	@RequestMapping("/scrap.do")
	public String scrap(@RequestParam Map<String,Object> p) {
		p.put("result", 0);
		scrapDeviceDao.scrap(p);
		String x = p.get("result").toString();
		System.out.println("scrap():"+x);
		return new Gson().toJson(x);
	}
	@ResponseBody
	@RequestMapping("/recordscrap.do")
	public String scrapRecord(int pos,int size) {
		List<Map<String,Object> >res = scrapDeviceDao.scrapRecord(pos,size);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		System.out.println("FaultController.scrapRecord()");
		return gson.toJson(res);
	}

	
}
