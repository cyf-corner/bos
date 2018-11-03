package top.flyroc.bos.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.flyroc.bos.dao.IRoleDao;
import top.flyroc.bos.domain.Function;
import top.flyroc.bos.domain.Role;
import top.flyroc.bos.service.IRoleService;
import top.flyroc.bos.utils.PageBean;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleDao roleDao;

	public void save(Role model, String functionIds) {
		// 多对多关系，关系的表达不需要由单个表来表达，因此直接保存。
		roleDao.save(model);
		if (StringUtils.isNotBlank(functionIds)) {
			String[] fIds = functionIds.split(",");
			for (String functionId : fIds) {
				// 手动构造一个权限对象，设置id，对象状态为托管状态
				Function function = new Function(functionId);
				// 角色关联权限，此时要确保角色这边没有放弃关系的维护，比如设置了：inverse="true"
				model.getFunctions().add(function);
			}
		}
	}

	public void pageQuery(PageBean pageBean) {
		roleDao.pageQuery(pageBean);
	}

	public List<Role> findAll() {
		return roleDao.findAll();
	}

}
