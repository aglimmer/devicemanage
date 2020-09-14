package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

public interface FaultDeviceDao {
//	管理查询故障设备及图片详情
	@Select("select fau_id,adm_id,equ_id,user_id,fau_occurdate,fau_occurposition,fau_detail,fau_img,adm_message,adm_answer from tb_faultrecord where adm_id=#{arg0} and adm_del=0 limit #{arg1},#{arg2}")
	public List<Map<String,Object>> faultRecordAdm(String adm_id, int pos1, int pos2);
//	select adm_id,equ_id,user_id,fau_occurdate,fau_occurposition,fau_detail,fau_img from tb_faultrecord where user_id="3182701101" limit 0,10;

//	用户查询故障设备及图片信息
	@Select("select fau_id,adm_id,equ_id,user_id,fau_occurdate,fau_occurposition,fau_detail,fau_img,adm_message,adm_answer from tb_faultrecord where user_id=#{arg0} and user_del=0 limit #{arg1},#{arg2}")
	public List<Map<String,Object>> faultRecordUser(String user_id, int pos1, int pos2);

//	删除故障设备
	@Options(statementType=StatementType.CALLABLE)
	@Update("call pro_delfaultrecord(#{arg0},#{arg1})")
	public int delFault(String fauid, String usertype);

//	回复提交的故障设备问题
	@Update("update tb_faultrecord set adm_message=#{adm_message},adm_answer=#{adm_answer} where fau_id=#{fau_id}")
	public int savefaul(Map<String, Object> p);


	@Insert("insert into tb_faultrecord (adm_id,equ_id,user_id,fau_occurdate,fau_occurposition,fau_detail,fau_img,adm_message) values("+
			"'G0001',#{equ_id},#{user_id},#{fau_occurdate},#{fau_occurposition},#{fau_detail},#{fau_img},'待处理')")
	public int faultInsert(Map<String, Object> param);

}
