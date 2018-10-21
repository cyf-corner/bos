package top.flyroc.service;

import org.hibernate.criterion.DetachedCriteria;

import top.flyroc.domain.LinkMan;
import top.flyroc.vo.PageBean;

public interface ILinkManService {

	PageBean getPageBean(DetachedCriteria dcriteria, Integer currentPage, Integer pageSize);

	void saveOrUpdate(LinkMan linkMan);

	LinkMan getLinkManById(Long cust_id);

	void delete(LinkMan lm);

}
