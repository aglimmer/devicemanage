package com.cont;

import com.dao.FaultDeviceDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-09-12
 */
@Controller
public class FaultDeviceController {

    @Autowired
    HttpSession session;

    @Autowired
    UploadService upload;

    @Autowired
    FaultDeviceDao faultDeviceDao;

    //	查询故障设备
    @ResponseBody
    @RequestMapping("/faultinfo.do")
    public String getFaultinfo(String adm_id,int pos1,int pos2) {
        List<Map<String,Object>> ob = null;
        String usertype = null;
        try {
//		1:用户	2：管理员
            usertype = session.getAttribute("usertype").toString();
            System.out.println("session-usertype:"+usertype);
        }catch(NullPointerException e) {
            System.out.println("FaultController.getFaultinfo():"+"用户没有登录");
            return new Gson().toJson(null);
        }

        if(usertype.equals("1")) {
//		用户查询
            ob = faultDeviceDao.faultRecordUser(adm_id, pos1, pos2);
        }else {
//		管理员查询
            ob = faultDeviceDao.faultRecordAdm(adm_id, pos1, pos2);
        }

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String res = gson.toJson(ob);
        System.out.println("FaultController.getFaultinfo():"+res);
        return res;
    }
    //	删除故障设备
    @ResponseBody
    @RequestMapping("/delfau.do")
    public String getFaultinfo2(String fauid,String usertype) {
        System.out.println("FaultController.getFaultinfo2():"+fauid+"\t"+usertype);
        faultDeviceDao.delFault(fauid,usertype);
        System.out.println("删除结果成功");
        return "\"删除成功\"";
    }
    @ResponseBody
    @RequestMapping("/getimg.do")
    public String getImgInfo(String fau_img) {
        System.out.println("FaultController.getImgInfo()："+fau_img);
        String img = upload.imgToBase64(fau_img);
//		 Gson gson = new Gson();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        return gson.toJson(img);
    }
    //	故障问题上传图片
    @ResponseBody
    @RequestMapping("/faultup.do")
    public String faultup(@RequestParam Map<String,Object> obj) {
//		obj.forEach((k,v)->{
//			System.out.println(k+"\t"+v.toString());
//		});
        String filepath = upload.saveImg(obj.get("fau_img").toString());
        System.out.println("图片保存路径："+filepath);
        obj.put("fau_img", filepath);
        int n = faultDeviceDao.faultInsert(obj);
        String res = String.valueOf(n);
        return res;
    }
    //	保存故障设备
    @ResponseBody
    @RequestMapping("/savefaul.do")
    public String savefaul(@RequestParam Map<String,Object> p) {
        int x = faultDeviceDao.savefaul(p);
        System.out.println("FaultController.savefaul():"+x);
        return new Gson().toJson(x);
    }
}
