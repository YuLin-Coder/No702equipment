package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.entity.Equip;
import com.github.pagehelper.Page;
import com.service.EquipService;
import com.util.VeDate;

@RestController //定义为控制器 返回JSON类型数据
@RequestMapping(value = "/equip", produces = "application/json; charset=utf-8")// 设置请求路径
@CrossOrigin // 允许跨域访问其资源
public class EquipController extends BaseController {

	@Autowired // @Autowired的作用是自动注入依赖的ServiceBean
	private EquipService equipService;

	// 预处理 获取基础参数
	@GetMapping(value = "createEquip.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> createEquip() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("eno", "E" + VeDate.getStringDatex());
		return map;
	}

	// 新增设备
	@PostMapping(value = "insertEquip.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> insertEquip(@RequestBody String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Equip equip = new Equip();
		equip.setEno(obj.getString("eno")); //  为设备号赋值
		equip.setEquipname(obj.getString("equipname")); //  为设备名称赋值
		equip.setCateid(obj.getString("cateid")); //  为设备类型赋值
		equip.setLabxid(obj.getString("labxid")); //  为所在实验室赋值
		equip.setUseinfo(obj.getString("useinfo")); //  为设备作用赋值
		equip.setProductor(obj.getString("productor")); //  为生产厂商赋值
		equip.setPrice(obj.getString("price")); //  为采购金额赋值
		equip.setBuydate(obj.getString("buydate")); //  为采购日期赋值
		equip.setManager(obj.getString("manager")); //  为负责人赋值
		equip.setMemo(obj.getString("memo")); //  为备注赋值
		int num = this.equipService.insertEquip(equip);
		if (num > 0) {
			map.put("success", true);
			map.put("code", num);
			map.put("message", "保存成功");
		} else {
			map.put("success", false);
			map.put("code", num);
			map.put("message", "保存失败");
		}
		return map;
	}

	// 按主键删除一个设备
	@GetMapping(value = "deleteEquip.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteEquip(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.equipService.deleteEquip(id);
		if (num > 0) {
			map.put("success", true);
			map.put("code", num);
			map.put("message", "删除成功");
		} else {
			map.put("success", false);
			map.put("code", num);
			map.put("message", "删除失败");
		}
		return map;
	}

	// 按主键批量删除设备
	@PostMapping(value = "deleteEquipByIds.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteEquipByIds(@RequestBody String[] ids) {
		int num = 0;
		for (String equipid : ids) {
			num += this.equipService.deleteEquip(equipid);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (num > 0) {
			map.put("success", true);
			map.put("code", num);
			map.put("message", "删除成功");
		} else {
			map.put("success", false);
			map.put("code", num);
			map.put("message", "删除失败");
		}
		return map;
	}

	// 修改设备
	@PostMapping(value = "updateEquip.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> updateEquip(@RequestBody String jsonStr) {
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Equip equip = this.equipService.getEquipById(obj.getString("equipid")); // 获取object中equipid字段
		equip.setEno(obj.getString("eno")); //  为设备号赋值
		equip.setEquipname(obj.getString("equipname")); //  为设备名称赋值
		equip.setCateid(obj.getString("cateid")); //  为设备类型赋值
		equip.setLabxid(obj.getString("labxid")); //  为所在实验室赋值
		equip.setUseinfo(obj.getString("useinfo")); //  为设备作用赋值
		equip.setProductor(obj.getString("productor")); //  为生产厂商赋值
		equip.setPrice(obj.getString("price")); //  为采购金额赋值
		equip.setBuydate(obj.getString("buydate")); //  为采购日期赋值
		equip.setManager(obj.getString("manager")); //  为负责人赋值
		equip.setMemo(obj.getString("memo")); //  为备注赋值

		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.equipService.updateEquip(equip);
		if (num > 0) {
			map.put("success", true);
			map.put("code", num);
			map.put("message", "修改成功");
		} else {
			map.put("success", false);
			map.put("code", num);
			map.put("message", "修改失败");
		}
		return map;
	}

	// 查询全部设备数据 在下拉菜单中显示
	@GetMapping(value = "getAllEquip.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public List<Equip> getAllEquip() {
		return this.equipService.getAllEquip();
	}

	// 通过AJAX在表格中显示设备数据
	@GetMapping(value = "getEquipByPage.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> getEquipByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
		// 定义一个Map对象 用来返回数据
		Map<String, Object> map = new HashMap<String, Object>();
		Page<Equip> pager = com.github.pagehelper.PageHelper.startPage(page, limit);// 定义当前页和分页条数
		List<Equip> list = this.equipService.getAllEquip();
		// 返回的map中定义数据格式
		map.put("count", pager.getTotal());
		map.put("total", list.size());
		map.put("data", list);
		map.put("code", 0);
		map.put("msg", "");
		map.put("page", page);
		map.put("limit", limit);
		return map;
	}

	// 按主键查询设备数据
	@GetMapping(value = "getEquipById.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Equip getEquipById(String id) {
		Equip equip = this.equipService.getEquipById(id);
		return equip;
	}

}


