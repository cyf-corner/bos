package top.flyroc.bos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.flyroc.bos.dao.IRegionDao;
import top.flyroc.bos.domain.Region;
import top.flyroc.bos.service.IRegionService;
import top.flyroc.bos.utils.PageBean;

@Service
@Transactional
public class RegionServiceImpl implements IRegionService {

	@Autowired
	private IRegionDao regionDao;

	/*
	 * 区域批量保存
	 */
	public void saveBatch(List<Region> regionList) {
		for (Region region : regionList) {
			regionDao.saveOrUpdate(region);
		}
	}

	public void pageQuery(PageBean pageBean) {
		regionDao.pageQuery(pageBean);
	}

	public List<Region> getRegionListByQ(String q) {
		return regionDao.getRegionListByQ(q);
	}

	public List<Region> findAll() {
		return regionDao.findAll();
	}

}
