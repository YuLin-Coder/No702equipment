package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Scarp;
@Service("scarpService") // 自动注册到Spring容器，不需要再在xml文件定义bean
public interface ScarpService {
	// 插入设备报废表数据 调用scarpDAO里的insertScarp配置
	public int insertScarp(Scarp scarp);

	// 更新设备报废表数据 调用scarpDAO里的updateScarp配置
	public int updateScarp(Scarp scarp);

	// 按主键删除设备报废表数据 调用scarpDAO里的deleteScarp配置
	public int deleteScarp(String scarpid);

	// 批量删除设备报废表数据 调用mapper包scarp.xml里的deleteScarpByIds配置 返回值0(失败),大于0(成功)
	public int deleteScarpByIds(String[] ids);

	// 查询全部数据 调用scarpDAO里的getAllScarp配置
	public List<Scarp> getAllScarp();

	// 按照Scarp类里面的字段名称精确查询 调用scarpDAO里的getScarpByCond配置
	public List<Scarp> getScarpByCond(Scarp scarp);

	// 按照Scarp类里面的字段名称模糊查询 调用scarpDAO里的getScarpByLike配置
	public List<Scarp> getScarpByLike(Scarp scarp);

	// 按主键查询表返回单一的Scarp实例 调用scarpDAO里的getScarpById配置
	public Scarp getScarpById(String scarpid);

}

