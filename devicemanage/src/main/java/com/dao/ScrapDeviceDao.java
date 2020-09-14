package com.dao;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;
import java.util.Map;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-09-12
 */
public interface ScrapDeviceDao {
    //	报废设备添加报废记录中
//	pro_scrap(admid varchar(20),equid int,scrreason varchar(100),scrdate date,out result int)
    @Options(statementType= StatementType.CALLABLE)
    @Update("call pro_scrap(#{adm_id},#{equ_id},#{scr_reason},#{scr_date},#{result,mode=OUT,jdbcType=INTEGER})")
    public void scrap(Map<String, Object> p);


    //	查询报废记录
    @Select("select scr_id,adm_id,equ_id,scr_reason,scr_date from tb_scraprecord limit #{arg0},#{arg1}")
    public List<Map<String,Object>> scrapRecord(int pos, int size);
}
