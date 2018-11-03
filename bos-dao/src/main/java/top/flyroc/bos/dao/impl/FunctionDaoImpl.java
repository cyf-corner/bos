package top.flyroc.bos.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import top.flyroc.bos.dao.IFunctionDao;
import top.flyroc.bos.dao.base.impl.BaseDaoImpl;
import top.flyroc.bos.domain.Function;

@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements IFunctionDao {

	public List<Function> findAll() {
		// 这里找到所有根节点，通过Function类中的子节点属性，设置懒加载为false，那么同时可以获取到子节点的数据。
		String hql = "FROM Function f WHERE f.parentFunction IS NULL ORDER BY f.zindex";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);

		return list;
	}

	public List<Function> findFunctionListByUserId(String id) {
		String hql = "SELECT DISTINCT f FROM Function f LEFT OUTER JOIN f.roles r LEFT OUTER JOIN r.users u WHERE u.id = ?";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql, id);

		return list;
	}

	public List<Function> findAllMenu() {
		String hql = "FROM Function f WHERE f.generatemenu = '1' ORDER BY f.zindex DESC";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);

		return list;
	}

	public List<Function> findMenuByUserId(String id) {
		String hql = "SELECT DISTINCT f FROM Function f LEFT OUTER JOIN f.roles r LEFT OUTER JOIN r.users u WHERE u.id = ? AND f.generatemenu = '1' ORDER BY f.index DESC";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql, id);

		return list;
	}

}
