package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Labx;
@Service("labxService") // 自动注册到Spring容器，不需要再在xml文件定义bean
public interface LabxService {
	// 插入实验室表数据 调用labxDAO里的insertLabx配置
	public int insertLabx(Labx labx);

	// 更新实验室表数据 调用labxDAO里的updateLabx配置
	public int updateLabx(Labx labx);

	// 按主键删除实验室表数据 调用labxDAO里的deleteLabx配置
	public int deleteLabx(String labxid);

	// 批量删除实验室表数据 调用mapper包labx.xml里的deleteLabxByIds配置 返回值0(失败),大于0(成功)
	public int deleteLabxByIds(String[] ids);

	// 查询全部数据 调用labxDAO里的getAllLabx配置
	public List<Labx> getAllLabx();

	// 按照Labx类里面的字段名称精确查询 调用labxDAO里的getLabxByCond配置
	public List<Labx> getLabxByCond(Labx labx);

	// 按照Labx类里面的字段名称模糊查询 调用labxDAO里的getLabxByLike配置
	public List<Labx> getLabxByLike(Labx labx);

	// 按主键查询表返回单一的Labx实例 调用labxDAO里的getLabxById配置
	public Labx getLabxById(String labxid);

}

