package top.flyroc.bos.realm;

import java.util.List;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import top.flyroc.bos.dao.IFunctionDao;
import top.flyroc.bos.dao.IUserDao;
import top.flyroc.bos.domain.Function;
import top.flyroc.bos.domain.User;

public class BOSRealm extends AuthorizingRealm {

	@Autowired
	private IUserDao userDao;
	@Autowired
	private IFunctionDao functionDao;

	/*
	 * 认证
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken mytoken = (UsernamePasswordToken) token;
		String username = mytoken.getUsername();// 用户输入的姓名
		User user = userDao.findUserByUsername(username);
		if (user == null) {// 用户名不存在

			return null;
		}

		// 查到了用户，由框架对比数据库中的密码和页面提交的是否一致
		AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());

		return info;
	}

	/*
	 * 授权
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 为用户授权
		// info.addStringPermission("staff-list");

		/*
		 * 两种拿到当前用户对象的方法
		 */
		// User user1 = (User) SecurityUtils.getSubject().getPrincipal();
		// User user2 = (User) principals.getPrimaryPrincipal();

		User user = (User) SecurityUtils.getSubject().getPrincipal();
		// 根据当前用户查询其对应的权限数据
		List<Function> list = null;
		if (user.getUsername().equals("cyf")) {// 超级管理员用户，直接查询所有权限数据
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Function.class);
			list = functionDao.findByCriteria(detachedCriteria);
		} else {
			list = functionDao.findFunctionListByUserId(user.getId());
		}

		for (Function function : list) {
			info.addStringPermission(function.getCode());
		}

		return info;
	}

}
