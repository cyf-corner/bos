package top.flyroc.bos.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.flyroc.bos.dao.IDecidedzoneDao;
import top.flyroc.bos.dao.ISubareaDao;
import top.flyroc.bos.domain.Decidedzone;
import top.flyroc.bos.domain.Subarea;
import top.flyroc.bos.service.IDecidedzoneService;
import top.flyroc.bos.utils.PageBean;

@Service
@Transactional
public class DecidedzoneServiceImpl implements IDecidedzoneService {

	@Autowired
	private IDecidedzoneDao decidedzoneDao;
	@Autowired
	private ISubareaDao subareaDao;

	/*
	 * 添加定区，同时关联分区
	 */
	public void save(Decidedzone model, String[] subareaid) {
		decidedzoneDao.save(model);
		for (String id : subareaid) {
			Subarea subarea = subareaDao.findById(id);
			// model.getSubareas().add(subarea);一方（定区）已经放弃维护外键权利，只能由多方（分区）负责维护
			subarea.setDecidedzone(model);// 分区关联定区
		}
	}

	public void pageQuery(PageBean pageBean) {
		decidedzoneDao.pageQuery(pageBean);
	}

	@Override
	public List<Subarea> findHasAssociationSubarea(String id) {
		DetachedCriteria dc = DetachedCriteria.forClass(Subarea.class);
		dc.add(Restrictions.eq("decidedzone.id", id));
		return subareaDao.findByCriteria(dc);
	}
}
