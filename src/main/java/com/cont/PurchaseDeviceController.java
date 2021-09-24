package com.cont;

import com.dao.PurchaseDeviceDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-09-12
 */
@Controller
public class PurchaseDeviceController {
    @Autowired
    PurchaseDeviceDao purchaseDeviceDao;
    @ResponseBody
    @RequestMapping("/admpurrecord.do")
    public String admpurrecord() {
//		Gson gson = new Gson();
        List<Map<String,Object>> obj = purchaseDeviceDao.purRecord();
        for(int i=0;i<obj.size();i++) {
            Map<String,Object> p = obj.get(i);
            p.forEach((k,v)->{
                System.out.println(k+"\t"+v.toString());
            });
        }
//		JsonArray json = new JsonArray();
        //转换日期格式，也可以new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        System.out.println(gson.toJson(obj));
        return gson.toJson(obj);
    }


    @ResponseBody
    @RequestMapping("/userpurrecord.do")
    public String userpurrecord(String userid) {
        System.out.println("userid = " + userid);
        List<Map<String,Object>> obj = purchaseDeviceDao.userpurrecord(userid);
        //转换日期格式，也可以new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        System.out.println(gson.toJson(obj));
        return gson.toJson(obj);
    }
    @ResponseBody
    @RequestMapping("/savepurchase.do")
    public String userpurrecord(@RequestParam Map<String,Object> obj) {
        obj.forEach((k,v)->{
            System.out.println(k+"\t"+v.toString());
        });
        int res = purchaseDeviceDao.savePurchase(obj);
        return String.valueOf(res);
    }


    @ResponseBody
    @RequestMapping("/buyequ.do")
    public String buyequ(@RequestParam Map<String,Object> obj) {
        obj.forEach((k,v)->{
            System.out.println(k+"\t"+v.toString());
        });
        int res = purchaseDeviceDao.sendPurchase(obj);
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println();

    }
}
