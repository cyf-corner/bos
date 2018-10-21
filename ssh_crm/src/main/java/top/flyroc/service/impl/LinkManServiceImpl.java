package top.flyroc.service.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import top.flyroc.dao.ILinkManDao;
import top.flyroc.domain.LinkMan;
import top.flyroc.service.ILinkManService;
import top.flyroc.vo.PageBean;

public class LinkManServiceImpl implements ILinkManService {

	private ILinkManDao linkmanDao;

	@Override
	public PageBean getPageBean(DetachedCriteria dcriteria, Integer currentPage, Integer pageSize) {
		Integer totalCount = linkmanDao.getTotalCount(dcriteria);
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);

		List<LinkMan> list = linkmanDao.getPageList(dcriteria, pageBean.getStartIndex(), pageBean.getPageSize());
		pageBean.setList(list);

		return pageBean;
	}

	public void setLinkmanDao(ILinkManDao linkmanDao) {
		this.linkmanDao = linkmanDao;
	}

	@Override
	public void saveOrUpdate(LinkMan linkMan) {
		linkmanDao.saveOrUpdate(linkMan);
	}

	@Override
	public LinkMan getLinkManById(Long lkm_id) {
		LinkMan lm = linkmanDao.getById(lkm_id);
		return lm;
	}

	@Override
	public void delete(LinkMan lm) {
		linkmanDao.delete(lm);
	}

}
