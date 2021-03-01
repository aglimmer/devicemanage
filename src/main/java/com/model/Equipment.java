package com.model;

import java.util.Date;

import org.apache.ibatis.annotations.Update;

public class Equipment {
	private Integer equ_id;
	private Integer fac_id;
	private String equ_name;
	private String equ_type;
	private String equ_purchasedate;
	private String equ_purchaser;
	private float equ_singleprice;
	private String equ_unit;
	private String equ_spec;
	private Integer equ_total;
	private Integer equ_curr;
	private String equ_position;
	private Integer del;
	public Integer getEqu_id() {
		return equ_id;
	}
	
	
	public void setEqu_id(Integer equ_id) {
		this.equ_id = equ_id;
	}
	public Integer getFac_id() {
		return fac_id;
	}
	public void setFac_id(Integer fac_id) {
		this.fac_id = fac_id;
	}
	public String getEqu_name() {
		return equ_name;
	}
	public void setEqu_name(String equ_name) {
		this.equ_name = equ_name;
	}
	public String getEqu_type() {
		return equ_type;
	}
	public void setEqu_type(String equ_type) {
		this.equ_type = equ_type;
	}
	public String getEqu_purchasedate() {
		return equ_purchasedate;
	}
	public void setEqu_purchasedate(String equ_purchasedate) {
		this.equ_purchasedate = equ_purchasedate;
	}
	public String getEqu_purchaser() {
		return equ_purchaser;
	}
	public void setEqu_purchaser(String equ_purchaser) {
		this.equ_purchaser = equ_purchaser;
	}
	public float getEqu_singleprice() {
		return equ_singleprice;
	}
	public void setEqu_singleprice(float equ_singleprice) {
		this.equ_singleprice = equ_singleprice;
	}
	public String getEqu_unit() {
		return equ_unit;
	}
	public void setEqu_unit(String equ_unit) {
		this.equ_unit = equ_unit;
	}
	public String getEqu_spec() {
		return equ_spec;
	}
	public void setEqu_spec(String equ_spec) {
		this.equ_spec = equ_spec;
	}
	public Integer getEqu_total() {
		return equ_total;
	}
	public void setEqu_total(Integer equ_total) {
		this.equ_total = equ_total;
	}
	public Integer getEqu_curr() {
		return equ_curr;
	}
	public void setEqu_curr(Integer equ_curr) {
		this.equ_curr = equ_curr;
	}
	public String getEqu_position() {
		return equ_position;
	}
	public void setEqu_position(String equ_position) {
		this.equ_position = equ_position;
	}
	public Integer getDel() {
		return del;
	}
	public void setDel(Integer del) {
		this.del = del;
	}


	@Override
	public String toString() {
		return "Equipment [equ_id=" + equ_id + ", fac_id=" + fac_id + ", equ_name=" + equ_name + ", equ_type="
				+ equ_type + ", equ_purchasedate=" + equ_purchasedate + ", equ_purchaser=" + equ_purchaser
				+ ", equ_singleprice=" + equ_singleprice + ", equ_unit=" + equ_unit + ", equ_spec=" + equ_spec
				+ ", equ_total=" + equ_total + ", equ_curr=" + equ_curr + ", equ_position=" + equ_position + ", del="
				+ del + "]";
	}
	

}
