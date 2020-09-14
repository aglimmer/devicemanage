package com.service;

import com.dao.UsingDeviceDao;
import com.google.gson.Gson;
import com.model.User;
import com.model.Usingrecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-09-12
 */


@Service
public class UsingDeviceService {

    @Autowired
    UsingDeviceDao usingDeviceDao;

    @Autowired
    HttpSession session;

    @Transactional
    public String borrowDeviceSimple(Map<String,Object> map){
        map.put("result",null);
        usingDeviceDao.borrowEquipment(map);
//        System.out.println("result = " + map.get("result"));
        return  String.valueOf(map.get("result"));
    }
    @Transactional
    public String dealusiSample(Map<String,Object> obj) {
        obj.forEach((k,v)->{
            System.out.println(k+"\t"+v.toString());
        });
        obj.put("result", null);
        usingDeviceDao.admdealusi(obj);
        String res = String.valueOf(obj.get("result"));
        return res;
    }
    @Transactional
    public String giveBackSample(String usi_id){
        System.out.println("usi_id = " + usi_id);
        String res = String.valueOf(usingDeviceDao.giveBack(usi_id));
//        System.out.println("res = " + res);
        return res;
    }


    @Transactional
    public String delusingrecordSample( Map<String,Object> obj) {
        obj.forEach((k,v)->{
            System.out.println(k+"\t"+v.toString());
        });
        obj.put("result", null);
        usingDeviceDao.delusingrecord(obj);
        String res = String.valueOf(obj.get("result"));
        return res;
    }

//    查询使用记录
    public String usiRecordSimple(Map<String,Object> map){
        System.out.println("usiRecordSimple() map = " + map);
        try {
            String usertype = session.getAttribute("usertype").toString();
            map.put("user_type", usertype);

        }catch(NullPointerException e) {
//			System.out.println("EquipController.usiRecord():"+e.getMessage());
            System.out.println("异常信息 = " + e.getCause());
            map.put("user_type", 1);
        }
        List<Usingrecord> astr = usingDeviceDao.usiRecordInfo(map);
//		System.out.println("EquipController.usiRecord():"+astr.size());
        Gson gson = new Gson();
        return gson.toJson(astr);
    }
}
