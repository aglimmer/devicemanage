package com.dao;

import com.model.Usingrecord;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;
import java.util.Map;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-09-11
 */
public interface UsingDeviceDao {

    @Update("update tb_usingrecord set usi_returnstatus='待处理' where usi_id=#{arg0}")
    public int giveBack(String uri_id);

    /**
     *  用户、管理员查看设备使用申请详情
     * @param ob
     * @return
     */
    @Select("call pro_usingrecord(#{user_type},#{user_id},#{start},#{size})")
    @Options(statementType= StatementType.CALLABLE)
    public List<Usingrecord> usiRecordInfo(Map<String, Object> ob);


    /**
     * 删除使用记录
     * deltype int,usiid int,out result int
     * @param ob
     * @return
     */
    @Select("call pro_delusingrecord(#{user_type},#{usi_id},#{result,mode=OUT,jdbcType=INTEGER})")
    @Options(statementType=StatementType.CALLABLE)
    public void delusingrecord(Map<String, Object> ob);

    /**
     * 管理员处理使用申请
     * 参数：记录编号、设备编号、借用数量、申请状态、申请处理结果、归还状态、归还处理结果
     *
     * @param param
     * @return
     */
    @Update("call pro_admdealusi(#{usi_id},#{equ_id},#{usi_number},#{usi_applystatus},#{adm_feedbackapply},#{usi_returnstatus},#{adm_feedbackreturn},#{result,mode=OUT,jdbcType=INTEGER})")
    @Options(statementType=StatementType.CALLABLE)
    public void admdealusi(Map<String, Object> param);

    /**
     * 申请设备使用
     * @param mp
     */
//	@Results({@Result(column="result", property="result", jdbcType= JdbcType.INTEGER)})
    @Select("call pro_borrowequ(#{user_id},#{equ_id},#{usi_reason},#{usi_size},#{usi_date},#{usi_day},#{result,mode=OUT,jdbcType=INTEGER})")
    @Options(statementType=StatementType.CALLABLE)
    public void borrowEquipment(Map<String, Object> mp);
}
