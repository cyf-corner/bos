package top.flyroc.bos.service;

import top.flyroc.bos.domain.User;
import top.flyroc.bos.utils.PageBean;

public interface IUserService {

	public User login(User model);

	public void updatePwd(String id, String password);

	public void save(User model, String[] roleIds);

	public void pageQuery(PageBean pageBean);

}
