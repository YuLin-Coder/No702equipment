package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.LabxDAO;
import com.entity.Labx;
import com.service.LabxService;

@Service("labxService") //
public class LabxServiceImpl implements LabxService {
	@Autowired // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
	private LabxDAO labxDAO;
	@Override // 继承接口的新增实验室表数据 返回值0(失败),1(成功)
	public int insertLabx(Labx labx) {
		return this.labxDAO.insertLabx(labx);
	}

	@Override // 继承接口的更新实验室表数据 返回值0(失败),1(成功)
	public int updateLabx(Labx labx) {
		return this.labxDAO.updateLabx(labx);
	}

	@Override // 继承接口的按主键删除实验室表数据 返回值0(失败),1(成功)
	public int deleteLabx(String labxid) {
		return this.labxDAO.deleteLabx(labxid);
	}

	@Override // 继承接口的批量删除实验室表数据 返回值0(失败),大于0(成功)
	public int deleteLabxByIds(String[] ids) {
		return this.labxDAO.deleteLabxByIds(ids);
	}

	@Override // 继承接口的查询实验室表全部数据
	public List<Labx> getAllLabx() {
		return this.labxDAO.getAllLabx();
	}

	@Override // 继承接口的按条件精确查询实验室表数据
	public List<Labx> getLabxByCond(Labx labx) {
		return this.labxDAO.getLabxByCond(labx);
	}

	@Override // 继承接口的按条件模糊查询实验室表数据
	public List<Labx> getLabxByLike(Labx labx) {
		return this.labxDAO.getLabxByLike(labx);
	}

	@Override // 继承接口的按主键查询实验室表数据 返回Entity实例
	public Labx getLabxById(String labxid) {
		return this.labxDAO.getLabxById(labxid);
	}

}

