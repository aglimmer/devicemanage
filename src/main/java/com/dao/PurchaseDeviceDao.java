package com.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-09-12
 */
public interface PurchaseDeviceDao {

    /**
     * 插入购买记录
     * @param param
     * @return
     */
    @Insert("insert into tb_purchase(user_id,equ_name,pur_purchasenumber,pur_price,pur_applyreason,pur_applydate,adm_dealstatus) values "+
            "(#{user_id},#{equ_name},#{pur_purchasenumber},#{pur_price},#{pur_applyreason},now(),'待处理')")
    public int sendPurchase(Map<String, Object> param);

    /**
     * 查询 购买申请记录
     * @return
     */
    @Select("select * from tb_purchase order by pur_applydate desc")
    public List<Map<String,Object>> purRecord();


    /**
     * 查询购买申请记录
     * @param userid
     * @return
     */
    @Select("select * from tb_purchase where user_id=#{arg0} order by pur_applydate desc")
    public List<Map<String, Object>> userpurrecord(String userid);

    /**
     * 保存购买记录
     * @param param
     * @return
     */
    @Update("update tb_purchase set user_id=#{user_id},equ_name=#{equ_name},pur_applyreason=#{pur_applyreason},"+
            "pur_purchasenumber=#{pur_purchasenumber},pur_price=#{pur_price},pur_applydate=#{pur_applydate},"+
            "adm_dealstatus=#{adm_dealstatus},adm_reply=#{adm_reply} where pur_id=#{pur_id}")
    public int savePurchase(Map<String, Object> param);


}
