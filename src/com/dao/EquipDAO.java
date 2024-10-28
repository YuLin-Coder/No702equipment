package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Equip;

@Repository("equipDAO") // Repository标签定义数据库连接的访问 Spring中直接扫描加载
@Mapper // 不需要在spring配置中设置扫描地址 spring将动态的生成Bean后注入到EquipServiceImpl中
public interface EquipDAO {

	/**
	* EquipDAO 接口 可以按名称直接调用equip.xml配置文件的SQL语句
	*/

	// 插入设备表数据 调用mapper包equip.xml里的insertEquip配置 返回值0(失败),1(成功)
	public int insertEquip(Equip equip);

	// 更新设备表数据 调用mapper包equip.xml里的updateEquip配置 返回值0(失败),1(成功)
	public int updateEquip(Equip equip);

	// 按主键删除设备表数据 调用mapper包equip.xml里的deleteEquip配置 返回值0(失败),1(成功)
	public int deleteEquip(String equipid);

	// 批量删除设备表数据 调用mapper包equip.xml里的deleteEquipByIds配置 返回值0(失败),大于0(成功)
	public int deleteEquipByIds(String[] ids);

	// 查询设备表全部数据 调用mapper包equip.xml里的getAllEquip配置 返回List<Equip>类型的数据
	public List<Equip> getAllEquip();

	// 按照Equip类里面的值精确查询 调用mapper包equip.xml里的getEquipByCond配置 返回List<Equip>类型的数据
	public List<Equip> getEquipByCond(Equip equip);

	// 按照Equip类里面的值模糊查询 调用mapper包equip.xml里的getEquipByLike配置 返回List<Equip>类型的数据
	public List<Equip> getEquipByLike(Equip equip);

	// 按主键查询设备表返回单一的Equip实例 调用mapper包equip.xml里的getEquipById配置
	public Equip getEquipById(String equipid);

}


