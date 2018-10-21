package top.flyroc.dao;

import top.flyroc.domain.User;

public interface IUserDao extends IBaseDao<User> {

	User getByUserCode(String user_code);

}
