package com.cont;

import com.dao.RepairDeviceDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
public class RepairDeviceController {
    @Autowired
    RepairDeviceDao repairDeviceDao;


//    查询修理记录
    @ResponseBody
    @RequestMapping("/recordrepair.do")
    public String recordRecord(int pos,int size) {
        List<Map<String,Object>> res = repairDeviceDao.repairRecord(pos,size);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        System.out.println("FaultController.recordRecord()");
        return gson.toJson(res);
    }

//    添加修理记录
    @ResponseBody
    @RequestMapping("/repair.do")
    public String repair(@RequestParam Map<String,Object> p) {
        int x = repairDeviceDao.repair(p);
        System.out.println("repair.repair():"+x);
        return new Gson().toJson(x);
    }

}
