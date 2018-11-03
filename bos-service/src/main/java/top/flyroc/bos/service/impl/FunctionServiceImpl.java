package top.flyroc.bos.service.impl;

import java.util.List;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.flyroc.bos.dao.IFunctionDao;
import top.flyroc.bos.domain.Function;
import top.flyroc.bos.domain.User;
import top.flyroc.bos.service.IFunctionService;
import top.flyroc.bos.utils.PageBean;

@Service
@Transactional
public class FunctionServiceImpl implements IFunctionService {

	@Autowired
	private IFunctionDao functionDao;

	public List<Function> findAll() {
		return functionDao.findAll();
	}

	public void save(Function model) {
		Function parentFunction = model.getParentFunction();
		// 这里由于此字段自关联，因此不能为""空串，因此要进行判断
		// 第一个判断是为了防止用户恶意通过get方式(伪造表单无parentFunction.id的参数，即此值为null，那么右侧parentFunction.getId()就会出异常)进行提交
		if (parentFunction != null && parentFunction.getId().equals("")) {
			model.setParentFunction(null);
		}
		functionDao.save(model);
	}

	public void pageQuery(PageBean pageBean) {
		functionDao.pageQuery(pageBean);
	}

	public List<Function> findMenu() {
		List<Function> list = null;
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		if (user.getUsername().equals("cyf")) {
			list = functionDao.findAllMenu();
		} else {
			list = functionDao.findMenuByUserId(user.getId());
		}

		return list;
	}

}
