package top.flyroc.service;

import top.flyroc.domain.User;

public interface IUserService {

	/*
	 * 用户登陆
	 */
	User getUserByCodePassword(User user);

	/*
	 * 用户注册
	 */
	void saveUser(User u);

}
