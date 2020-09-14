package com.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-09-12
 */
public interface RepairDeviceDao {

    //	查询设备修理记录
    @Select("select rep_id,equ_id,adm_id,rep_reason,rep_person,rep_cost,rep_date,rep_result from tb_repairrecord limit #{arg0},#{arg1}")
    public List<Map<String,Object>> repairRecord(int pos, int size);

    //	插入一条修理记录
    @Insert("insert into tb_repairrecord(equ_id,adm_id,rep_reason,rep_person,rep_cost,rep_date,rep_result)values(" +
            "#{equ_id},#{adm_id},#{rep_reason},#{rep_person},#{rep_cost},#{rep_date},#{rep_result})")
    public int repair(Map<String, Object> p);
}
