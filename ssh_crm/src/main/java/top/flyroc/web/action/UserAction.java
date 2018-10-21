package top.flyroc.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import top.flyroc.domain.User;
import top.flyroc.service.IUserService;

@SuppressWarnings("all")
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	private IUserService userService;

	public String login() throws Exception {
		User u = userService.getUserByCodePassword(user);
		ActionContext.getContext().getSession().put("user", u);
		return "toHome";// 重定向到项目首页
	}

	public String regist() throws Exception {
		// 1 调用Service保存注册用户
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		// 2 重定向到登陆页面
		return "toLogin";
	}

	@Override
	public User getModel() {
		return user;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
