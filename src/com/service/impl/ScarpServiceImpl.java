package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ScarpDAO;
import com.entity.Scarp;
import com.service.ScarpService;

@Service("scarpService") //
public class ScarpServiceImpl implements ScarpService {
	@Autowired // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
	private ScarpDAO scarpDAO;
	@Override // 继承接口的新增设备报废表数据 返回值0(失败),1(成功)
	public int insertScarp(Scarp scarp) {
		return this.scarpDAO.insertScarp(scarp);
	}

	@Override // 继承接口的更新设备报废表数据 返回值0(失败),1(成功)
	public int updateScarp(Scarp scarp) {
		return this.scarpDAO.updateScarp(scarp);
	}

	@Override // 继承接口的按主键删除设备报废表数据 返回值0(失败),1(成功)
	public int deleteScarp(String scarpid) {
		return this.scarpDAO.deleteScarp(scarpid);
	}

	@Override // 继承接口的批量删除设备报废表数据 返回值0(失败),大于0(成功)
	public int deleteScarpByIds(String[] ids) {
		return this.scarpDAO.deleteScarpByIds(ids);
	}

	@Override // 继承接口的查询设备报废表全部数据
	public List<Scarp> getAllScarp() {
		return this.scarpDAO.getAllScarp();
	}

	@Override // 继承接口的按条件精确查询设备报废表数据
	public List<Scarp> getScarpByCond(Scarp scarp) {
		return this.scarpDAO.getScarpByCond(scarp);
	}

	@Override // 继承接口的按条件模糊查询设备报废表数据
	public List<Scarp> getScarpByLike(Scarp scarp) {
		return this.scarpDAO.getScarpByLike(scarp);
	}

	@Override // 继承接口的按主键查询设备报废表数据 返回Entity实例
	public Scarp getScarpById(String scarpid) {
		return this.scarpDAO.getScarpById(scarpid);
	}

}

