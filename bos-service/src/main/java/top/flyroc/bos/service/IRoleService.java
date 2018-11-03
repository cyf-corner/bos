package top.flyroc.bos.service;

import java.util.List;

import top.flyroc.bos.domain.Role;
import top.flyroc.bos.utils.PageBean;

public interface IRoleService {

	void save(Role model, String functionIds);

	void pageQuery(PageBean pageBean);

	List<Role> findAll();

}
