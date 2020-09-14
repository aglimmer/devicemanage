package com.model;

import java.util.Date;

public class Usingrecord {
	private Integer usi_id;
	private String user_id;
	private Integer equ_id ;
	private String adm_id;
	private String usi_reason;
	private String usi_number;
	private String usi_date;
	private String usi_returndate;
	private String usi_applystatus;
	private String adm_feedbackapply;
	private String usi_returnstatus;
	private String adm_feedbackreturn;
	private int user_del;
	private int adm_del;
	private String equ_name;
	public String getEqu_name() {
		return equ_name;
	}
	public void setEqu_name(String equ_name) {
		this.equ_name = equ_name;
	}
	public Integer getUsi_id() {
		return usi_id;
	}
	public void setUsi_id(Integer usi_id) {
		this.usi_id = usi_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Integer getEqu_id() {
		return equ_id;
	}
	public void setEqu_id(Integer equ_id) {
		this.equ_id = equ_id;
	}
	public String getAdm_id() {
		return adm_id;
	}
	public void setAdm_id(String adm_id) {
		this.adm_id = adm_id;
	}
	public String getUsi_reason() {
		return usi_reason;
	}
	public void setUsi_reason(String usi_reason) {
		this.usi_reason = usi_reason;
	}
	public String getUsi_number() {
		return usi_number;
	}
	public void setUsi_number(String usi_number) {
		this.usi_number = usi_number;
	}
	public String getUsi_date() {
		return usi_date;
	}
	public void setUsi_date(String usi_date) {
		this.usi_date = usi_date;
	}
	public String getUsi_returndate() {
		return usi_returndate;
	}
	public void setUsi_returndate(String usi_returndate) {
		this.usi_returndate = usi_returndate;
	}
	public String getUsi_applystatus() {
		return usi_applystatus;
	}
	public void setUsi_applystatus(String usi_applystatus) {
		this.usi_applystatus = usi_applystatus;
	}
	public String getAdm_feedbackapply() {
		return adm_feedbackapply;
	}
	public void setAdm_feedbackapply(String adm_feedbackapply) {
		this.adm_feedbackapply = adm_feedbackapply;
	}

	public String getUsi_returnstatus() {
		return usi_returnstatus;
	}
	public void setUsi_returnstatus(String usi_returnstatus) {
		this.usi_returnstatus = usi_returnstatus;
	}
	public String getAdm_feedbackreturn() {
		return adm_feedbackreturn;
	}
	public void setAdm_feedbackreturn(String adm_feedbackreturn) {
		this.adm_feedbackreturn = adm_feedbackreturn;
	}
	public int getUser_del() {
		return user_del;
	}
	public void setUser_del(int user_del) {
		this.user_del = user_del;
	}
	public int getAdm_del() {
		return adm_del;
	}
	public void setAdm_del(int adm_del) {
		this.adm_del = adm_del;
	}
}
//	
//	usi_id int auto_increment,
//	user_id varchar(20) not null,
//	equ_id int not null,
//	adm_id varchar(20) not null,
//	usi_reason varchar(100) default '',
//	usi_number int default 1,
//	usi_date date,
//	usi_returndate date,
//
//	usi_applystatus int default -2,
//	adm_feedbackapply varchar(100) default '',
//	adm_message int default -2,
//	usi_returnstatus int default -2,
//	adm_feedbackreturn varchar(100) default '',
//	user_del TINYINT default 0,
//	adm_del TINYINT default 0,
	