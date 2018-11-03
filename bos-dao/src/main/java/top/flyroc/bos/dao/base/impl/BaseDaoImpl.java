package top.flyroc.bos.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import top.flyroc.bos.dao.base.IBaseDao;
import top.flyroc.bos.utils.PageBean;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {

	private Class<T> entityClass;// 用于接收运行时class对象

	public BaseDaoImpl() {// 子类UserDaoImpl实例化时，会调用父类BaseDaoImpl的构造函数，由此可以获得运行时Class对象
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		entityClass = (Class<T>) actualTypeArguments[0];
	}

	@Resource // 根据类型注入spring工厂中的会话工厂对象sessionFactory
	public void SetMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
	}

	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	public T findById(Serializable id) {

		return getHibernateTemplate().get(entityClass, id);
	}

	public List<T> findAll() {
		String hql = "FROM " + entityClass.getSimpleName();

		return (List<T>) getHibernateTemplate().find(hql);
	}

	public void executeUpdate(String queryName, Object... objects) {// password id
		Session session = this.getSessionFactory().getCurrentSession();// 获得与当前线程绑定的session对象
		Query query = session.getNamedQuery(queryName);// user.updatePassword
		int i = 0;
		for (Object object : objects) {
			// 为HQL语句中的？赋值
			query.setParameter(i++, object);
		}
		// 执行更新
		query.executeUpdate();
	}

	/*
	 * 通用分页方法====>完成对pageBean的封装，返回到action
	 */
	public void pageQuery(PageBean pageBean) {
		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();
		DetachedCriteria dc = pageBean.getDetachedCriteria();

		// 查询total--总数据量
		dc.setProjection(Projections.rowCount());// 设置聚合函数====>指定hibernate框架发出sql的形式---->select count(*) from bc_staff
		List<Long> countList = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		Long count = countList.get(0);
		pageBean.setTotal(count.intValue());

		// 查询rows--当前页需要展示的数据集合
		dc.setProjection(null);// 指定hibernate框架发出sql的形式---->select * from bc_staff

		/*
		 * 指定hibernate框架封装对象的方式
		 * Criteria中默认使用的 ResultTransformer实现策略是 ROOT_ENTITY；
		 * 但是当调用了方法setProjection后，会隐式地将策略设置为 PROJECTION。
		 */
		dc.setResultTransformer(DetachedCriteria.ROOT_ENTITY);

		int firstResult = (currentPage - 1) * pageSize;
		int maxResults = pageSize;
		List rows = this.getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
		pageBean.setRows(rows);
	}

	public List<T> findByCriteria(DetachedCriteria detachedCriteria) {
		return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}

}
