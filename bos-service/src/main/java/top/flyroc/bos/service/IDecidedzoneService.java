package top.flyroc.bos.service;

import java.util.List;

import top.flyroc.bos.domain.Decidedzone;
import top.flyroc.bos.domain.Subarea;
import top.flyroc.bos.utils.PageBean;

public interface IDecidedzoneService {

	public void save(Decidedzone model, String[] subareaid);

	public void pageQuery(PageBean pageBean);

	public List<Subarea> findHasAssociationSubarea(String id);

}
