package top.flyroc.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import top.flyroc.dao.IBaseDao;
import top.flyroc.dao.ICustomerDao;
import top.flyroc.domain.Customer;
import top.flyroc.domain.User;
import top.flyroc.vo.PageBean;

@SuppressWarnings("all")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements ICustomerDao {

	@Override
	public Customer getCustomerByName(String cust_name) {
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		dc.add(Restrictions.eq("cust_name", cust_name));
		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dc);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Object[]> getIndustryCount() {
		List<Object[]> list = getHibernateTemplate().execute(new HibernateCallback<List>() {
			/*
			 * 原生SQL查询
			 * 查询结果预测:
			 * {['教育培训',2],['酒店旅游',1],[.,.],...}
			 */
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				String sql = "SELECT dict_item_name,COUNT(*) total FROM cst_customer c,base_dict bd WHERE c.cust_industry = bd.dict_id GROUP BY c.cust_industry";
				SQLQuery query = session.createSQLQuery(sql);

				return query.list();
			}
		});

		return list;
	}

	// @Override
	// /*
	// * 查询总客户数量
	// */
	// public Integer getTotalCount(DetachedCriteria dcriteria) {
	// dcriteria.setProjection(Projections.rowCount());// 设置查询的聚合函数
	// List<Long> list = (List<Long>)
	// getHibernateTemplate().findByCriteria(dcriteria);
	// dcriteria.setProjection(null);// 清空之前设置查询的聚合函数
	//
	// if (list != null && list.size() > 0) {
	// Long count = list.get(0);
	// return count.intValue();
	// } else {
	// return null;
	// }
	// }
	//
	// @Override
	// /*
	// * 查询客户列表(分页列表数据)
	// */
	// public List<Customer> getCustomerList(DetachedCriteria dcriteria, PageBean
	// pageBean) {
	// List<Customer> customerList = new ArrayList<>();
	// customerList = (List<Customer>)
	// getHibernateTemplate().findByCriteria(dcriteria, pageBean.getStartIndex(),
	// pageBean.getPageSize());
	// return customerList;
	// }

}
