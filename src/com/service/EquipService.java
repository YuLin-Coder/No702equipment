package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Equip;
@Service("equipService") // 自动注册到Spring容器，不需要再在xml文件定义bean
public interface EquipService {
	// 插入设备表数据 调用equipDAO里的insertEquip配置
	public int insertEquip(Equip equip);

	// 更新设备表数据 调用equipDAO里的updateEquip配置
	public int updateEquip(Equip equip);

	// 按主键删除设备表数据 调用equipDAO里的deleteEquip配置
	public int deleteEquip(String equipid);

	// 批量删除设备表数据 调用mapper包equip.xml里的deleteEquipByIds配置 返回值0(失败),大于0(成功)
	public int deleteEquipByIds(String[] ids);

	// 查询全部数据 调用equipDAO里的getAllEquip配置
	public List<Equip> getAllEquip();

	// 按照Equip类里面的字段名称精确查询 调用equipDAO里的getEquipByCond配置
	public List<Equip> getEquipByCond(Equip equip);

	// 按照Equip类里面的字段名称模糊查询 调用equipDAO里的getEquipByLike配置
	public List<Equip> getEquipByLike(Equip equip);

	// 按主键查询表返回单一的Equip实例 调用equipDAO里的getEquipById配置
	public Equip getEquipById(String equipid);

}

