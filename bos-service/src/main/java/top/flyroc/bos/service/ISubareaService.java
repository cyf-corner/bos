package top.flyroc.bos.service;

import java.util.List;
import top.flyroc.bos.domain.Subarea;
import top.flyroc.bos.utils.PageBean;

public interface ISubareaService {

	void pageQuery(PageBean pageBean);

	List<Subarea> findAll();

	void save(Subarea model);

	List<Subarea> findListNotAssociation();

}
