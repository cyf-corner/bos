package top.flyroc.bos.dao;

import java.util.List;
import top.flyroc.bos.dao.base.IBaseDao;
import top.flyroc.bos.domain.Region;

public interface IRegionDao extends IBaseDao<Region> {

	List<Region> getRegionListByQ(String q);

}
