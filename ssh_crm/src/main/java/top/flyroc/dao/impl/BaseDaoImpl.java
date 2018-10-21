package top.flyroc.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import top.flyroc.dao.IBaseDao;
import top.flyroc.vo.PageBean;

/*
 * 在接口实现类仍旧保留泛型
 */
@SuppressWarnings("all")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {

	private Class clazz;// 用于接收运行期泛型类

	public BaseDaoImpl() {// 此段代码最终在其子类中执行，其实获得最终的泛型类型仍是此类实际的泛型类型
		// 获得当前类型的带有泛型类型的父类
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		// 获得运行期的泛型类型
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}

	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public void delete(Serializable id) {
		T t = this.getById(id);
		getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public T getById(Serializable id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());// 设置查询的聚合函数
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		dc.setProjection(null);// 用完后清空聚合函数
		if (list != null && list.size() > 0) {
			Long count = list.get(0);
			return count.intValue();
		} else {
			return null;
		}
	}

	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer startIndex, Integer pageSize) {
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, startIndex, pageSize);
		return list;
	}

}
