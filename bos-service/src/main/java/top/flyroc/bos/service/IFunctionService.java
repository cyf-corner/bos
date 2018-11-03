package top.flyroc.bos.service;

import java.util.List;
import top.flyroc.bos.domain.Function;
import top.flyroc.bos.utils.PageBean;

public interface IFunctionService {

	List<Function> findAll();

	void save(Function model);

	void pageQuery(PageBean pageBean);

	List<Function> findMenu();

}
