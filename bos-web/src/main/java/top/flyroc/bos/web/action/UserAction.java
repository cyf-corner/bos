package top.flyroc.bos.web.action;

import java.io.IOException;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.flyroc.bos.domain.User;
import top.flyroc.bos.service.IUserService;
import top.flyroc.bos.utils.MD5Utils;
import top.flyroc.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	private String checkcode;

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	@Autowired
	private IUserService userService;

	/*
	 * 用户登陆
	 */
	public String login() {
		String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		if (StringUtils.isNotBlank(validatecode) && validatecode.equals(checkcode)) {// 验证码正确

			// 使用shiro框架提供的正确方式进行认证
			Subject subject = SecurityUtils.getSubject();// 获得当前用户对象，现在状态为"未认证"
			// 输入的用户名密码令牌
			AuthenticationToken token = new UsernamePasswordToken(model.getUsername(),
					MD5Utils.md5(model.getPassword()));

			try {
				subject.login(token);// 用于无返回值，因此放入try、catch语句中控制程序流程

				User user = (User) subject.getPrincipal();
				ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
			} catch (Exception e) {
				e.printStackTrace();

				return LOGIN;
			}

			return "home";
		} else {// 验证码错误
			this.addActionError("输入的验证码错误！");

			return LOGIN;
		}
	}

	/*
	 * 用户添加
	 */

	private String[] roleIds;// 属性驱动

	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}

	public String add() {
		userService.save(model, roleIds);

		return "list";
	}

	/*
	 * 用户分页显示
	 */
	public String pageQuery() {
		userService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[] { "noticebills", "roles" });

		return NONE;
	}

	/*
	 * 用户注销
	 */
	public String logout() {
		ServletActionContext.getRequest().getSession().invalidate();

		return LOGIN;
	}

	public String updatePwd() throws IOException {
		String flag = "1";
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		try {
			userService.updatePwd(user.getId(), model.getPassword());
		} catch (Exception e) {
			flag = "0";
			e.printStackTrace();
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(flag);

		return NONE;
	}
}
