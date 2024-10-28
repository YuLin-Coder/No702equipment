package com.entity;

import com.util.VeDate;
import com.alibaba.fastjson.JSONObject;

// 设备报废表的实体类
public class Scarp {
	private String scarpid = "S" + VeDate.getStringId(); // 生成主键编号
	private String sno; // 报废单号
	private String equipid; // 设备
	private String reason; // 报废原因
	private String addtime; // 报废日期
	private String manager; // 经手人
	private String memo; // 备注
	private String equipname; // 映射数据
	private Equip equip;// 多对一映射类

	public String getScarpid() {
		return scarpid;
	}

	public void setScarpid(String scarpid) {
		this.scarpid = scarpid;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
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

	// 直接转换成JSON字符串
	private String toJsonString() {
		JSONObject jsonString = new JSONObject();
		jsonString.put("scarpid", this.scarpid); // 主键编号
		jsonString.put("sno", this.sno); // 报废单号
		jsonString.put("equipid", this.equipid); // 设备
		jsonString.put("reason", this.reason); // 报废原因
		jsonString.put("addtime", this.addtime); // 报废日期
		jsonString.put("manager", this.manager); // 经手人
		jsonString.put("memo", this.memo); // 备注
		jsonString.put("Equip", this.equip); // 多对一映射类
		jsonString.put("equipname", this.equipname); // 映射数据
		return jsonString.toString();
	}

}
