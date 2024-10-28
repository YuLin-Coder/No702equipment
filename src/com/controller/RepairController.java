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
import com.entity.Repair;
import com.github.pagehelper.Page;
import com.service.RepairService;
import com.util.VeDate;

@RestController // 定义为控制器 返回JSON类型数据
@RequestMapping(value = "/repair", produces = "application/json; charset=utf-8") // 设置请求路径
@CrossOrigin // 允许跨域访问其资源
public class RepairController extends BaseController {

	@Autowired // @Autowired的作用是自动注入依赖的ServiceBean
	private RepairService repairService;

	// 预处理 获取基础参数
	@GetMapping(value = "createRepair.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> createRepair() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rno", "R" + VeDate.getStringDatex());
		return map;
	}

	// 新增设备维护
	@PostMapping(value = "insertRepair.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> insertRepair(@RequestBody String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Repair repair = new Repair();
		repair.setRno(obj.getString("rno")); // 为维护单号赋值
		repair.setEquipid(obj.getString("equipid")); // 为设备赋值
		repair.setReason(obj.getString("reason")); // 为维护原因赋值
		repair.setPrice(obj.getString("price")); // 为维护花费赋值
		repair.setAddtime(obj.getString("addtime")); // 为维护日期赋值
		repair.setManager(obj.getString("manager")); // 为经手人赋值
		repair.setMemo(obj.getString("memo")); // 为备注赋值
		int num = this.repairService.insertRepair(repair);
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

	// 按主键删除一个设备维护
	@GetMapping(value = "deleteRepair.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteRepair(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.repairService.deleteRepair(id);
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

	// 按主键批量删除设备维护
	@PostMapping(value = "deleteRepairByIds.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteRepairByIds(@RequestBody String[] ids) {
		int num = 0;
		for (String repairid : ids) {
			num += this.repairService.deleteRepair(repairid);
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

	// 修改设备维护
	@PostMapping(value = "updateRepair.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> updateRepair(@RequestBody String jsonStr) {
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Repair repair = this.repairService.getRepairById(obj.getString("repairid")); // 获取object中repairid字段
		repair.setRno(obj.getString("rno")); // 为维护单号赋值
		repair.setEquipid(obj.getString("equipid")); // 为设备赋值
		repair.setReason(obj.getString("reason")); // 为维护原因赋值
		repair.setPrice(obj.getString("price")); // 为维护花费赋值
		repair.setAddtime(obj.getString("addtime")); // 为维护日期赋值
		repair.setManager(obj.getString("manager")); // 为经手人赋值
		repair.setMemo(obj.getString("memo")); // 为备注赋值

		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.repairService.updateRepair(repair);
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

	// 查询全部设备维护数据 在下拉菜单中显示
	@GetMapping(value = "getAllRepair.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public List<Repair> getAllRepair() {
		return this.repairService.getAllRepair();
	}

	// 通过AJAX在表格中显示设备维护数据
	@GetMapping(value = "getRepairByPage.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> getRepairByPage(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer limit) {
		// 定义一个Map对象 用来返回数据
		Map<String, Object> map = new HashMap<String, Object>();
		Page<Repair> pager = com.github.pagehelper.PageHelper.startPage(page, limit);// 定义当前页和分页条数
		List<Repair> list = this.repairService.getAllRepair();
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

	// 按主键查询设备维护数据
	@GetMapping(value = "getRepairById.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Repair getRepairById(String id) {
		Repair repair = this.repairService.getRepairById(id);
		return repair;
	}

}
