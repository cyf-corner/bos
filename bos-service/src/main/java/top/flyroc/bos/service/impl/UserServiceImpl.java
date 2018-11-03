package top.flyroc.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.flyroc.bos.dao.IUserDao;
import top.flyroc.bos.domain.Role;
import top.flyroc.bos.domain.User;
import top.flyroc.bos.service.IUserService;
import top.flyroc.bos.utils.MD5Utils;
import top.flyroc.bos.utils.PageBean;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	/*
	 * 用户登陆
	 */
	public User login(User model) {
		String password = MD5Utils.md5(model.getPassword());
		User user = userDao.findUserByUsernameAndPassword(model.getUsername(), password);

		return user;
	}

	/*
	 * 用户修改密码
	 */
	public void updatePwd(String id, String password) {
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.updatepassword", password, id);
	}

	/*
	 * 添加用户
	 */
	public void save(User model, String[] roleIds) {
		String password = model.getPassword();
		model.setPassword(MD5Utils.md5(password));
		userDao.save(model);

		// 维护与角色的关系
		if (roleIds != null && roleIds.length > 0) {
			for (String roleId : roleIds) {
				// 手动构造托管对象
				Role role = new Role(roleId);
				// 用户对象关联角色对象
				model.getRoles().add(role);
			}
		}
	}

	public void pageQuery(PageBean pageBean) {
		userDao.pageQuery(pageBean);
	}

}
