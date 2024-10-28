package com.entity;

import com.util.VeDate;
import com.alibaba.fastjson.JSONObject;

// 设备表的实体类
public class Equip {
	private String equipid = "E" + VeDate.getStringId(); // 生成主键编号
	private String eno; // 设备号
	private String equipname; // 设备名称
	private String cateid; // 设备类型
	private String labxid; // 所在实验室
	private String useinfo; // 设备作用
	private String productor; // 生产厂商
	private String price; // 采购金额
	private String buydate; // 采购日期
	private String manager; // 负责人
	private String memo; // 备注
	private String catename; // 映射数据
	private String labxname; // 映射数据
	private Cate cate;// 多对一映射类
	private Labx labx;// 多对一映射类

	public String getEquipid() {
		return equipid;
	}

	public void setEquipid(String equipid) {
		this.equipid = equipid;
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getEquipname() {
		return equipname;
	}

	public void setEquipname(String equipname) {
		this.equipname = equipname;
	}

	public String getCateid() {
		return cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getLabxid() {
		return labxid;
	}

	public void setLabxid(String labxid) {
		this.labxid = labxid;
	}

	public String getUseinfo() {
		return useinfo;
	}

	public void setUseinfo(String useinfo) {
		this.useinfo = useinfo;
	}

	public String getProductor() {
		return productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBuydate() {
		return buydate;
	}

	public void setBuydate(String buydate) {
		this.buydate = buydate;
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

	public String getCatename() {
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public String getLabxname() {
		return labxname;
	}

	public void setLabxname(String labxname) {
		this.labxname = labxname;
	}

	public Cate getCate() {
		return cate;
	}

	public void setCate(Cate cate) {
		this.cate = cate;
	}

	public Labx getLabx() {
		return labx;
	}

	public void setLabx(Labx labx) {
		this.labx = labx;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return this.toJsonString();
	}

	// 直接转换成JSON字符串
	private String toJsonString() {
		JSONObject jsonString = new JSONObject();
		jsonString.put("equipid", this.equipid); // 主键编号
		jsonString.put("eno", this.eno); // 设备号
		jsonString.put("equipname", this.equipname); // 设备名称
		jsonString.put("cateid", this.cateid); // 设备类型
		jsonString.put("labxid", this.labxid); // 所在实验室
		jsonString.put("useinfo", this.useinfo); // 设备作用
		jsonString.put("productor", this.productor); // 生产厂商
		jsonString.put("price", this.price); // 采购金额
		jsonString.put("buydate", this.buydate); // 采购日期
		jsonString.put("manager", this.manager); // 负责人
		jsonString.put("memo", this.memo); // 备注
		jsonString.put("Cate", this.cate); // 多对一映射类
		jsonString.put("Labx", this.labx); // 多对一映射类
		jsonString.put("catename", this.catename); // 映射数据
		jsonString.put("labxname", this.labxname); // 映射数据
		return jsonString.toString();
	}

}
