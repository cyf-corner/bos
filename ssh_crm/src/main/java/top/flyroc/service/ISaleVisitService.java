package top.flyroc.service;

import org.hibernate.criterion.DetachedCriteria;
import top.flyroc.domain.SaleVisit;
import top.flyroc.vo.PageBean;

public interface ISaleVisitService {
	// 保存客户拜访记录
	void save(SaleVisit saleVisit);

	// 客户拜访记录的分页列表
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	// 根据id获得客户对象
	SaleVisit getById(String visit_id);

	void update(SaleVisit saleVisit);

}
