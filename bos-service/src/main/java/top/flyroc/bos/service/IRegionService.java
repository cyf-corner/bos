package top.flyroc.bos.service;

import java.util.List;

import top.flyroc.bos.domain.Region;
import top.flyroc.bos.utils.PageBean;

public interface IRegionService {

	void saveBatch(List<Region> regionList);

	void pageQuery(PageBean pageBean);

	List<Region> getRegionListByQ(String q);

	List<Region> findAll();

}
