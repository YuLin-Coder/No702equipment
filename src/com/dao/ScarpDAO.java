package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Scarp;

@Repository("scarpDAO") // Repository标签定义数据库连接的访问 Spring中直接扫描加载
@Mapper // 不需要在spring配置中设置扫描地址 spring将动态的生成Bean后注入到ScarpServiceImpl中
public interface ScarpDAO {

	/**
	* ScarpDAO 接口 可以按名称直接调用scarp.xml配置文件的SQL语句
	*/

	// 插入设备报废表数据 调用mapper包scarp.xml里的insertScarp配置 返回值0(失败),1(成功)
	public int insertScarp(Scarp scarp);

	// 更新设备报废表数据 调用mapper包scarp.xml里的updateScarp配置 返回值0(失败),1(成功)
	public int updateScarp(Scarp scarp);

	// 按主键删除设备报废表数据 调用mapper包scarp.xml里的deleteScarp配置 返回值0(失败),1(成功)
	public int deleteScarp(String scarpid);

	// 批量删除设备报废表数据 调用mapper包scarp.xml里的deleteScarpByIds配置 返回值0(失败),大于0(成功)
	public int deleteScarpByIds(String[] ids);

	// 查询设备报废表全部数据 调用mapper包scarp.xml里的getAllScarp配置 返回List<Scarp>类型的数据
	public List<Scarp> getAllScarp();

	// 按照Scarp类里面的值精确查询 调用mapper包scarp.xml里的getScarpByCond配置 返回List<Scarp>类型的数据
	public List<Scarp> getScarpByCond(Scarp scarp);

	// 按照Scarp类里面的值模糊查询 调用mapper包scarp.xml里的getScarpByLike配置 返回List<Scarp>类型的数据
	public List<Scarp> getScarpByLike(Scarp scarp);

	// 按主键查询设备报废表返回单一的Scarp实例 调用mapper包scarp.xml里的getScarpById配置
	public Scarp getScarpById(String scarpid);

}


