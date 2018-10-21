package top.flyroc.web.interceptor;

/*
 * 用户是否登陆校验拦截器
 */
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Object user = session.get("user");
		if (user == null) {
			return "toLogin";
		} else {
			// 放行
			return invocation.invoke();
		}
	}

}
