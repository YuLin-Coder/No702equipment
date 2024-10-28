package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.RepairDAO;
import com.entity.Repair;
import com.service.RepairService;

@Service("repairService") //
public class RepairServiceImpl implements RepairService {
	@Autowired // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
	private RepairDAO repairDAO;
	@Override // 继承接口的新增设备维护表数据 返回值0(失败),1(成功)
	public int insertRepair(Repair repair) {
		return this.repairDAO.insertRepair(repair);
	}

	@Override // 继承接口的更新设备维护表数据 返回值0(失败),1(成功)
	public int updateRepair(Repair repair) {
		return this.repairDAO.updateRepair(repair);
	}

	@Override // 继承接口的按主键删除设备维护表数据 返回值0(失败),1(成功)
	public int deleteRepair(String repairid) {
		return this.repairDAO.deleteRepair(repairid);
	}

	@Override // 继承接口的批量删除设备维护表数据 返回值0(失败),大于0(成功)
	public int deleteRepairByIds(String[] ids) {
		return this.repairDAO.deleteRepairByIds(ids);
	}

	@Override // 继承接口的查询设备维护表全部数据
	public List<Repair> getAllRepair() {
		return this.repairDAO.getAllRepair();
	}

	@Override // 继承接口的按条件精确查询设备维护表数据
	public List<Repair> getRepairByCond(Repair repair) {
		return this.repairDAO.getRepairByCond(repair);
	}

	@Override // 继承接口的按条件模糊查询设备维护表数据
	public List<Repair> getRepairByLike(Repair repair) {
		return this.repairDAO.getRepairByLike(repair);
	}

	@Override // 继承接口的按主键查询设备维护表数据 返回Entity实例
	public Repair getRepairById(String repairid) {
		return this.repairDAO.getRepairById(repairid);
	}

}

