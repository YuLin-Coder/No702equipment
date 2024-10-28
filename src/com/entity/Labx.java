package com.entity;

import com.util.VeDate;
import com.alibaba.fastjson.JSONObject;

// 实验室表的实体类
public class Labx {
	private String labxid = "L"+VeDate.getStringId(); // 生成主键编号
	private String labxname; // 实验室名称
	private String manager; // 负责人
	private String contact; // 联系方式
	private String address; // 实验室地址
	private String addtime; // 创建日期
	private String memo; // 备注
	


	public String getLabxid() {
		return labxid;
	}

	public void setLabxid(String labxid) {
		this.labxid = labxid;
	}

	public String getLabxname() {
		return labxname;
	}

	public void setLabxname(String labxname) {
		this.labxname = labxname;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	// 重载方法 生成JSON类型字符串 
	@Override
	public String toString() {
		return this.toJsonString();
	}

	//直接转换成JSON字符串
	private String toJsonString() {
		JSONObject jsonString = new JSONObject();
		jsonString.put("labxid", this.labxid); // 主键编号
		jsonString.put("labxname", this.labxname); // 实验室名称
		jsonString.put("manager", this.manager); // 负责人
		jsonString.put("contact", this.contact); // 联系方式
		jsonString.put("address", this.address); // 实验室地址
		jsonString.put("addtime", this.addtime); // 创建日期
		jsonString.put("memo", this.memo); // 备注
		return jsonString.toString();
	}




}




