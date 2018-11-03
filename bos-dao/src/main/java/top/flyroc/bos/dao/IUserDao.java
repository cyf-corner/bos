package top.flyroc.bos.dao;

import top.flyroc.bos.dao.base.IBaseDao;
import top.flyroc.bos.domain.User;

public interface IUserDao extends IBaseDao<User> {

	public User findUserByUsernameAndPassword(String username, String password);

	public User findUserByUsername(String username);

}
