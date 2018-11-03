package top.flyroc.bos.web.interceptor;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import top.flyroc.bos.domain.User;

/*
 * 此处继承MethodFilterInterceptor
 * 是因为这样可以更好的指定特定的方法不拦截
 * 从而实现校验用户登陆的功能
 */
public class LoginInterceptor extends MethodFilterInterceptor {

	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// ActionProxy proxy = invocation.getProxy();
		// String actionName = proxy.getActionName();
		// String namespace = proxy.getNamespace();
		// String url = namespace + actionName;
		// System.out.println(url);
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		if (user == null) {// 未登陆，跳转到登陆页面

			return "login";
		}

		// 已登陆，放行
		return invocation.invoke();
	}

}
