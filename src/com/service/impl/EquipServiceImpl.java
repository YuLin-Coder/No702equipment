package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.EquipDAO;
import com.entity.Equip;
import com.service.EquipService;

@Service("equipService") //
public class EquipServiceImpl implements EquipService {
	@Autowired // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
	private EquipDAO equipDAO;
	@Override // 继承接口的新增设备表数据 返回值0(失败),1(成功)
	public int insertEquip(Equip equip) {
		return this.equipDAO.insertEquip(equip);
	}

	@Override // 继承接口的更新设备表数据 返回值0(失败),1(成功)
	public int updateEquip(Equip equip) {
		return this.equipDAO.updateEquip(equip);
	}

	@Override // 继承接口的按主键删除设备表数据 返回值0(失败),1(成功)
	public int deleteEquip(String equipid) {
		return this.equipDAO.deleteEquip(equipid);
	}

	@Override // 继承接口的批量删除设备表数据 返回值0(失败),大于0(成功)
	public int deleteEquipByIds(String[] ids) {
		return this.equipDAO.deleteEquipByIds(ids);
	}

	@Override // 继承接口的查询设备表全部数据
	public List<Equip> getAllEquip() {
		return this.equipDAO.getAllEquip();
	}

	@Override // 继承接口的按条件精确查询设备表数据
	public List<Equip> getEquipByCond(Equip equip) {
		return this.equipDAO.getEquipByCond(equip);
	}

	@Override // 继承接口的按条件模糊查询设备表数据
	public List<Equip> getEquipByLike(Equip equip) {
		return this.equipDAO.getEquipByLike(equip);
	}

	@Override // 继承接口的按主键查询设备表数据 返回Entity实例
	public Equip getEquipById(String equipid) {
		return this.equipDAO.getEquipById(equipid);
	}

}

