package com.cont;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.FeedbackDao;
import com.google.gson.Gson;

@Controller
public class FeedbackController {
	@Autowired
	FeedbackDao adviceDao;
	@ResponseBody
	@RequestMapping("/advice.do")
	public String adviceRecord(int pos,int size) {
		List<Map<String,Object> >res = adviceDao.adviceRecord(pos, size);
		Gson gson = new Gson();
		System.out.println("AdviceController.recordRecord()");
		return gson.toJson(res);
	}
	
	@ResponseBody
	@RequestMapping("/addadvice.do")
	public String addAdvice(@RequestParam Map<String,Object> p) {
		int res = adviceDao.insertAdvice(p);
		Gson gson = new Gson();
		System.out.println("AdviceController.addAdvice()");
		return gson.toJson(res);
	}
	
	@ResponseBody
	@RequestMapping("/dealadvice.do")
	public String dealAdvice(String adm_answer,int fee_id) {
		int res = adviceDao.dealAdvice(adm_answer, fee_id);
		Gson gson = new Gson();
		System.out.println("AdviceController.dealAdvice()");
		return gson.toJson(res);
	}

	@ResponseBody
	@RequestMapping("/deladvice.do")
	public String delAdvice(int fee_id) {
		int res = adviceDao.delAdvice(fee_id);
		Gson gson = new Gson();
		System.out.println("AdviceController.delAdvice()");
		return gson.toJson(res);
	}

}
