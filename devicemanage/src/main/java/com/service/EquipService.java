package com.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PrimaryDeviceDao;
import com.model.Equipment;
@Service
@Transactional
public class EquipService {
	@Autowired
	private PrimaryDeviceDao equipDao;
	
	public ArrayList<Equipment> getEquip(String type, String content,int start, int end){
		ArrayList<Equipment> equ=null;
		if(content=="") {
			equ = equipDao.getEquipmentAll(start, end);
		}else {
		switch(type) {
		case "equ_id":equ=equipDao.getEquipmentId(content, start, end);break;
		case "equ_name":equ=equipDao.getEquipmentName("%"+content+"%", start, end);break;
		case "equ_type":equ=equipDao.getEquipmentType("%"+content+"%", start, end);break;
		}
		}
		return equ;
	}
	public int getEquipSize(String type, String content) {
		int total = 0;
		if(content=="") {
			 total = equipDao.getEquipmentAllSize();
		}else {
		switch(type) {
		case "equ_id":total=equipDao.getEquipmentIdSize(content);break;
		case "equ_name":total=equipDao.getEquipmentNameSize("%"+content+"%");break;
		case "equ_type":total=equipDao.getEquipmentTypeSize("%"+content+"%");break;
		}
		}
		return total;
	}
}
