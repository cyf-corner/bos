package top.flyroc.bos.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import top.flyroc.bos.dao.IRegionDao;
import top.flyroc.bos.dao.base.impl.BaseDaoImpl;
import top.flyroc.bos.domain.Region;

/*
 * 从接口中(IBaseDao)拿到方法的声明
 * 从父类中(BaseDaoImpl)拿到方法的实现
 */
@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements IRegionDao {

	public List<Region> getRegionListByQ(String q) {
		String hql = "FROM Region r WHERE r.shortcode LIKE ? "
				+ "	OR r.citycode LIKE ? OR r.province LIKE ? "
				+ "OR r.city LIKE ? OR r.district LIKE ?";
		List<Region> list = (List<Region>) this.getHibernateTemplate().find(hql, "%" + q + "%", "%" + q + "%", "%" + q + "%", "%" + q + "%", "%" + q + "%");
		return list;
	}

}
