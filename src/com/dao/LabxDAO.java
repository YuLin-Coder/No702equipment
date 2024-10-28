package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Labx;

@Repository("labxDAO") // Repository标签定义数据库连接的访问 Spring中直接扫描加载
@Mapper // 不需要在spring配置中设置扫描地址 spring将动态的生成Bean后注入到LabxServiceImpl中
public interface LabxDAO {

	/**
	* LabxDAO 接口 可以按名称直接调用labx.xml配置文件的SQL语句
	*/

	// 插入实验室表数据 调用mapper包labx.xml里的insertLabx配置 返回值0(失败),1(成功)
	public int insertLabx(Labx labx);

	// 更新实验室表数据 调用mapper包labx.xml里的updateLabx配置 返回值0(失败),1(成功)
	public int updateLabx(Labx labx);

	// 按主键删除实验室表数据 调用mapper包labx.xml里的deleteLabx配置 返回值0(失败),1(成功)
	public int deleteLabx(String labxid);

	// 批量删除实验室表数据 调用mapper包labx.xml里的deleteLabxByIds配置 返回值0(失败),大于0(成功)
	public int deleteLabxByIds(String[] ids);

	// 查询实验室表全部数据 调用mapper包labx.xml里的getAllLabx配置 返回List<Labx>类型的数据
	public List<Labx> getAllLabx();

	// 按照Labx类里面的值精确查询 调用mapper包labx.xml里的getLabxByCond配置 返回List<Labx>类型的数据
	public List<Labx> getLabxByCond(Labx labx);

	// 按照Labx类里面的值模糊查询 调用mapper包labx.xml里的getLabxByLike配置 返回List<Labx>类型的数据
	public List<Labx> getLabxByLike(Labx labx);

	// 按主键查询实验室表返回单一的Labx实例 调用mapper包labx.xml里的getLabxById配置
	public Labx getLabxById(String labxid);

}


