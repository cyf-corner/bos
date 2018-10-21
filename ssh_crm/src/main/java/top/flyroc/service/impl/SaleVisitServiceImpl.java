package top.flyroc.service.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import top.flyroc.dao.ISaleVisitDao;
import top.flyroc.domain.SaleVisit;
import top.flyroc.service.ISaleVisitService;
import top.flyroc.vo.PageBean;

public class SaleVisitServiceImpl implements ISaleVisitService {

	private ISaleVisitDao svd;

	@Override
	public void save(SaleVisit saleVisit) {
		svd.save(saleVisit);
	}

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// 1 调用Dao查询总记录数
		Integer totalCount = svd.getTotalCount(dc);
		// 2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		// 3 调用Dao查询分页列表数据

		List<SaleVisit> list = svd.getPageList(dc, pb.getStartIndex(), pb.getPageSize());
		// 4 列表数据放入pageBean中.并返回
		pb.setList(list);
		return pb;
	}

	@Override
	public SaleVisit getById(String visit_id) {
		return svd.getById(visit_id);
	}

	public void setSvd(ISaleVisitDao svd) {
		this.svd = svd;
	}

	@Override
	public void update(SaleVisit saleVisit) {
		svd.update(saleVisit);
	}

}
