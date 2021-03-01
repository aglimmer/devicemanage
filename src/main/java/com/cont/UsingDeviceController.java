package com.cont;


import com.dao.PrimaryDeviceDao;
import com.dao.UsingDeviceDao;
import com.google.gson.Gson;
import com.model.User;
import com.model.Usingrecord;
import com.service.UsingDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-09-11
 */
@Controller
public class UsingDeviceController {


    @Autowired
    UsingDeviceService usingDeviceService;


//    借用设备
    @ResponseBody
    @RequestMapping("/borrowequ.do")
    public String borrowEqu(@RequestParam Map<String,Object> map) {
        System.out.println(map);
        String res = usingDeviceService.borrowDeviceSimple(map);
        return res;
    }

//    回复使用申请
    @ResponseBody
    @RequestMapping("/dealusi.do")
    public String dealusi(@RequestParam Map<String,Object> obj) {
        return usingDeviceService.dealusiSample(obj);
    }

//  删除使用申请
    @ResponseBody
    @RequestMapping("/delusingrecord.do")
    public String delusingrecord(@RequestParam Map<String,Object> obj) {
        return usingDeviceService.delusingrecordSample(obj);
    }


//    归还使用的设备
    @ResponseBody
    @RequestMapping("/giveback.do")
    public String giveBack(@RequestParam("usi_id") String usi_id){
        return usingDeviceService.giveBackSample(usi_id);
    }

    //	查询设备使用情况
    @ResponseBody
    @RequestMapping("/usirecord.do")
    public String usiRecord(@RequestParam Map<String,Object> map){
        return usingDeviceService.usiRecordSimple(map);
    }

}

