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
import com.entity.Scarp;
import com.github.pagehelper.Page;
import com.service.ScarpService;
import com.util.VeDate;

@RestController //定义为控制器 返回JSON类型数据
@RequestMapping(value = "/scarp", produces = "application/json; charset=utf-8")// 设置请求路径
@CrossOrigin // 允许跨域访问其资源
public class ScarpController extends BaseController {

	@Autowired // @Autowired的作用是自动注入依赖的ServiceBean
	private ScarpService scarpService;

	// 预处理 获取基础参数
	@GetMapping(value = "createScarp.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> createScarp() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sno", "S" + VeDate.getStringDatex());
		return map;
	}

	// 新增设备报废
	@PostMapping(value = "insertScarp.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> insertScarp(@RequestBody String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Scarp scarp = new Scarp();
		scarp.setSno(obj.getString("sno")); //  为报废单号赋值
		scarp.setEquipid(obj.getString("equipid")); //  为设备赋值
		scarp.setReason(obj.getString("reason")); //  为报废原因赋值
		scarp.setAddtime(obj.getString("addtime")); //  为报废日期赋值
		scarp.setManager(obj.getString("manager")); //  为经手人赋值
		scarp.setMemo(obj.getString("memo")); //  为备注赋值
		int num = this.scarpService.insertScarp(scarp);
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

	// 按主键删除一个设备报废
	@GetMapping(value = "deleteScarp.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteScarp(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.scarpService.deleteScarp(id);
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

	// 按主键批量删除设备报废
	@PostMapping(value = "deleteScarpByIds.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteScarpByIds(@RequestBody String[] ids) {
		int num = 0;
		for (String scarpid : ids) {
			num += this.scarpService.deleteScarp(scarpid);
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

	// 修改设备报废
	@PostMapping(value = "updateScarp.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> updateScarp(@RequestBody String jsonStr) {
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Scarp scarp = this.scarpService.getScarpById(obj.getString("scarpid")); // 获取object中scarpid字段
		scarp.setSno(obj.getString("sno")); //  为报废单号赋值
		scarp.setEquipid(obj.getString("equipid")); //  为设备赋值
		scarp.setReason(obj.getString("reason")); //  为报废原因赋值
		scarp.setAddtime(obj.getString("addtime")); //  为报废日期赋值
		scarp.setManager(obj.getString("manager")); //  为经手人赋值
		scarp.setMemo(obj.getString("memo")); //  为备注赋值

		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.scarpService.updateScarp(scarp);
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

	// 查询全部设备报废数据 在下拉菜单中显示
	@GetMapping(value = "getAllScarp.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public List<Scarp> getAllScarp() {
		return this.scarpService.getAllScarp();
	}

	// 通过AJAX在表格中显示设备报废数据
	@GetMapping(value = "getScarpByPage.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> getScarpByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
		// 定义一个Map对象 用来返回数据
		Map<String, Object> map = new HashMap<String, Object>();
		Page<Scarp> pager = com.github.pagehelper.PageHelper.startPage(page, limit);// 定义当前页和分页条数
		List<Scarp> list = this.scarpService.getAllScarp();
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

	// 按主键查询设备报废数据
	@GetMapping(value = "getScarpById.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Scarp getScarpById(String id) {
		Scarp scarp = this.scarpService.getScarpById(id);
		return scarp;
	}

}


