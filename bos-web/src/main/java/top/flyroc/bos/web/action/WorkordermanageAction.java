package top.flyroc.bos.web.action;

import java.io.IOException;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.flyroc.bos.domain.Workordermanage;
import top.flyroc.bos.service.IWorkordermanageService;
import top.flyroc.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class WorkordermanageAction extends BaseAction<Workordermanage> {

	@Autowired
	private IWorkordermanageService workordermangeService;

	/*
	 * 添加工作单
	 */
	public String add() throws IOException {
		String flag = "1";// 定义该变量记录快速工作单是否保存成功
		try {
			workordermangeService.save(model);
		} catch (Exception e) {
			e.printStackTrace();
			flag = "0";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(flag);

		return NONE;
	}
}
