package top.flyroc.bos.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import top.flyroc.bos.dao.IUserDao;
import top.flyroc.bos.dao.base.impl.BaseDaoImpl;
import top.flyroc.bos.domain.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

	public User findUserByUsernameAndPassword(String username, String password) {
		String hql = " FROM User where username = ? AND password = ?";
		// String hql = "FROM User u WHERE u.username = ? AND u.password = ?";
		List<User> list = (List<User>) getHibernateTemplate().find(hql, username, password);

		if (list != null && list.size() > 0) {

			return list.get(0);
		}

		return null;
	}

	public User findUserByUsername(String username) {
		String hql = " FROM User where username = ?";
		List<User> list = (List<User>) getHibernateTemplate().find(hql, username);

		if (list != null && list.size() > 0) {

			return list.get(0);
		}

		return null;
	}

}
