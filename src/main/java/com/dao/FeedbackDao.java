package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface FeedbackDao {
	
	@Insert("insert into tb_feedback(user_id,fee_question,fee_detail,adm_message,adm_answer) values("+
	"#{user_id},#{fee_question},#{fee_detail},#{adm_message},#{adm_answer})")
	public int insertAdvice(Map<String, Object> p);
	
	@Select("select fee_id,user_id,fee_question,fee_detail,adm_message,adm_answer from tb_feedback limit #{arg0},#{arg1}")
	public List<Map<String,Object>> adviceRecord(int pos, int size);
	
	@Update("update tb_feedback set adm_answer=#{arg0},adm_message='已查收'  where fee_id=#{arg1}")
	public int dealAdvice(String adm_answer, int fee_id);
	
	@Delete("delete from tb_feedback where fee_id=#{arg0}")
	public int delAdvice(int fee_id);

}
