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
import com.entity.Labx;
import com.github.pagehelper.Page;
import com.service.LabxService;
import com.util.VeDate;

@RestController //定义为控制器 返回JSON类型数据
@RequestMapping(value = "/labx", produces = "application/json; charset=utf-8")// 设置请求路径
@CrossOrigin // 允许跨域访问其资源
public class LabxController extends BaseController {

	@Autowired // @Autowired的作用是自动注入依赖的ServiceBean
	private LabxService labxService;

	// 预处理 获取基础参数
	@GetMapping(value = "createLabx.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> createLabx() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("today", VeDate.getStringDateShort());
		return map;
	}

	// 新增实验室
	@PostMapping(value = "insertLabx.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> insertLabx(@RequestBody String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Labx labx = new Labx();
		labx.setLabxname(obj.getString("labxname")); //  为实验室名称赋值
		labx.setManager(obj.getString("manager")); //  为负责人赋值
		labx.setContact(obj.getString("contact")); //  为联系方式赋值
		labx.setAddress(obj.getString("address")); //  为实验室地址赋值
		labx.setAddtime(VeDate.getStringDateShort()); // 为创建日期赋值 
		labx.setMemo(obj.getString("memo")); //  为备注赋值
		int num = this.labxService.insertLabx(labx);
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

	// 按主键删除一个实验室
	@GetMapping(value = "deleteLabx.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteLabx(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.labxService.deleteLabx(id);
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

	// 按主键批量删除实验室
	@PostMapping(value = "deleteLabxByIds.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteLabxByIds(@RequestBody String[] ids) {
		int num = 0;
		for (String labxid : ids) {
			num += this.labxService.deleteLabx(labxid);
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

	// 修改实验室
	@PostMapping(value = "updateLabx.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> updateLabx(@RequestBody String jsonStr) {
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Labx labx = this.labxService.getLabxById(obj.getString("labxid")); // 获取object中labxid字段
		labx.setLabxname(obj.getString("labxname")); //  为实验室名称赋值
		labx.setManager(obj.getString("manager")); //  为负责人赋值
		labx.setContact(obj.getString("contact")); //  为联系方式赋值
		labx.setAddress(obj.getString("address")); //  为实验室地址赋值
		labx.setMemo(obj.getString("memo")); //  为备注赋值

		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.labxService.updateLabx(labx);
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

	// 查询全部实验室数据 在下拉菜单中显示
	@GetMapping(value = "getAllLabx.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public List<Labx> getAllLabx() {
		return this.labxService.getAllLabx();
	}

	// 通过AJAX在表格中显示实验室数据
	@GetMapping(value = "getLabxByPage.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> getLabxByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
		// 定义一个Map对象 用来返回数据
		Map<String, Object> map = new HashMap<String, Object>();
		Page<Labx> pager = com.github.pagehelper.PageHelper.startPage(page, limit);// 定义当前页和分页条数
		List<Labx> list = this.labxService.getAllLabx();
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

	// 按主键查询实验室数据
	@GetMapping(value = "getLabxById.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Labx getLabxById(String id) {
		Labx labx = this.labxService.getLabxById(id);
		return labx;
	}

}


