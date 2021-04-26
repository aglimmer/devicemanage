package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

import com.model.Equipment;
import com.model.Usingrecord;

/**
 * @author Lenovo
 *
 */
public interface PrimaryDeviceDao {

	/**
	 * @param equ_id
	 * @param start
	 * @param end
	 * @return	ArrayList Equipment
	 */
	@Select("select * from tb_equipment where equ_id=#{arg0} and del=0 limit #{arg1},#{arg2}")
	public ArrayList<Equipment> getEquipmentId(String equ_id, int start, int end);
	
	
	
	/**	
	 * 查设备ID
	 * @param equ_id
	 * @return	int 总数量
	 */
	@Select("select count(*) from tb_equipment where equ_id=#{arg0} and del=0")
	public int getEquipmentIdSize(String equ_id);
	

	/** 
	 * 查设备类型type
	 * @param equ_type
	 * @param start
	 * @param end
	 * @return
	 */
	@Select("select * from tb_equipment where equ_type like #{arg0} and del=0 limit #{arg1},#{arg2}")
	public ArrayList<Equipment> getEquipmentType(String equ_type, int start, int end);

	/**
	 * 查设备类型type数量
	 * @param equ_type
	 * @param start
	 * @param end
	 * @return
	 */
	@Select("select count(*) from tb_equipment where equ_type like #{arg0} and del=0")
	public int getEquipmentTypeSize(String equ_type);
	
	
	/**
	 * 查设备名
	 * @param equ_name
	 * @param start
	 * @param end
	 * @return
	 */
	@Select("select * from tb_equipment where equ_name like #{arg0} and del=0 limit #{arg1},#{arg2}")
	public ArrayList<Equipment> getEquipmentName(String equ_name, int start, int end);

	/**
	 * 查设备名数量
	 * @param equ_name
	 * @param start
	 * @param end
	 * @return
	 */
	@Select("select count(*) from tb_equipment where equ_name like #{arg0} and del=0")
	public int getEquipmentNameSize(String equ_name);
	
	/**
	 * 查所有设备
	 * @param start
	 * @param end
	 * @return
	 */
	@Select("select * from tb_equipment where del=0 limit #{arg0},#{arg1}")
	public ArrayList<Equipment> getEquipmentAll(int start, int end);

	/**
	 * 查所有设备数量
	 * @param start
	 * @param end
	 * @return
	 */

	@Select("select count(*) from tb_equipment where del=0")
	public int getEquipmentAllSize();
	
//	call pro_delequip(2,"G0001",3,@res);
	@Delete("call pro_delequip(#{user_type},#{adm_id},#{equ_id},#{result,mode=OUT,jdbcType=INTEGER})")
	@Options(statementType=StatementType.CALLABLE)
	public int delEquipment(Map<String, Object> p);
	

	
	@Update("update tb_equipment set "+
	"equ_name=#{p.equ_name},equ_type=#{p.equ_type},equ_purchasedate=#{p.equ_purchasedate},equ_purchaser=#{p.equ_purchaser},"+
	"equ_singleprice=#{p.equ_singleprice},equ_unit=#{p.equ_unit},equ_spec=#{p.equ_spec},equ_total=#{p.equ_total},"+
	"equ_curr=#{p.equ_curr},equ_position=#{p.equ_position} where equ_id=#{p.equ_id}")
	public int modifyEquip(@Param("p") Equipment equ);
	
	@Select("select equ_type,count(*) as equ_total from tb_equipment group by equ_type limit #{arg0},#{arg1}")
	public ArrayList<Equipment> queryAllType(int start, int end);
	
	@Select("select equ_id,equ_name,equ_unit,equ_spec from tb_equipment where equ_type = #{arg0} limit #{arg1},#{arg2}")
	public ArrayList<Equipment> querySpecType(String equ_type, int start, int end);
	


	/**
	 * 添加设备 
	 * @param ob
	 * @return
	 * equ_name varchar(20),
	 */
	@Select("call pro_insertequip(#{equ_name},#{user_type},#{equ_purchasedate},#{equ_purchaser},"+
			"#{equ_singleprice},#{equ_unit},#{equ_spec},#{equ_total},#{equ_curr},#{equ_position},"+
			"#{fac_name},#{fac_addr},#{fac_phone},#{result,mode=OUT,jdbcType=INTEGER})")
	@Options(statementType=StatementType.CALLABLE)
	public void addEqu(Map<String, Object> ob);
	

	
	@Select("select fac_id,fac_name,fac_addr,fac_phone from tb_factory where fac_id = #{arg0}")
	public Map<String,Object> getFactory(int id);
	
}
