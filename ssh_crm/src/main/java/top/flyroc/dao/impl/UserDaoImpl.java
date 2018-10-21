package top.flyroc.dao.impl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import top.flyroc.dao.IUserDao;
import top.flyroc.domain.User;

@SuppressWarnings("all")
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

	@Override
	public User getByUserCode(final String user_code) {
		/*
		 * Criteria
		 */
//		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
//		dc.add(Restrictions.eq("user_code", user_code));
//		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
//
//		if (list != null && list.size() > 0) {
//			return list.get(0);
//		} else {
//			return null;
//		}
		/*
		 * HQL
		 */
		return getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				String hql = "from User where user_code = ? ";
				Query query = session.createQuery(hql);
				query.setParameter(0, user_code);
				User user = (User) query.uniqueResult();
				return user;
			}
		});
	}

}
