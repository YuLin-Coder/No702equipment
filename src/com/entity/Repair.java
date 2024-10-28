package com.entity;

import com.util.VeDate;
import com.alibaba.fastjson.JSONObject;

// 设备维护表的实体类
public class Repair {
	private String repairid = "R"+VeDate.getStringId(); // 生成主键编号
	private String rno; // 维护单号
	private String equipid; // 设备
	private String reason; // 维护原因
	private String price; // 维护花费
	private String addtime; // 维护日期
	private String manager; // 经手人
	private String memo; // 备注
	private String equipname; // 映射数据
	private Equip equip;// 多对一映射类
	


	public String getRepairid() {
		return repairid;
	}

	public void setRepairid(String repairid) {
		this.repairid = repairid;
	}

	public String getRno() {
		return rno;
	}

	public void setRno(String rno) {
		this.rno = rno;
	}

	public String getEquipid() {
		return equipid;
	}

	public void setEquipid(String equipid) {
		this.equipid = equipid;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getEquipname() {
		return equipname;
	}

	public void setEquipname(String equipname) {
		this.equipname = equipname;
	}

	public Equip getEquip() {
		return equip;
	}

	public void setEquip(Equip equip) {
		this.equip = equip;
	}

	// 重载方法 生成JSON类型字符串 
	@Override
	public String toString() {
		return this.toJsonString();
	}

	//直接转换成JSON字符串
	private String toJsonString() {
		JSONObject jsonString = new JSONObject();
		jsonString.put("repairid", this.repairid); // 主键编号
		jsonString.put("rno", this.rno); // 维护单号
		jsonString.put("equipid", this.equipid); // 设备
		jsonString.put("reason", this.reason); // 维护原因
		jsonString.put("price", this.price); // 维护花费
		jsonString.put("addtime", this.addtime); // 维护日期
		jsonString.put("manager", this.manager); // 经手人
		jsonString.put("memo", this.memo); // 备注
		jsonString.put("Equip", this.equip); // 多对一映射类
		jsonString.put("equipname", this.equipname); // 映射数据
		return jsonString.toString();
	}




}




