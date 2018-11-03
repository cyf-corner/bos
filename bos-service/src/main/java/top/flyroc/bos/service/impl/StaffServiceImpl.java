package top.flyroc.bos.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.flyroc.bos.dao.IStaffDao;
import top.flyroc.bos.domain.Staff;
import top.flyroc.bos.service.IStaffService;
import top.flyroc.bos.utils.PageBean;

@Service
@Transactional
public class StaffServiceImpl implements IStaffService {
	@Autowired
	private IStaffDao staffDao;

	public void save(Staff model) {
		staffDao.save(model);
	}

	public void update(Staff staff) {
		staffDao.update(staff);
	}

	@Transactional(readOnly = true) // 没有事务
	public Staff findById(String id) {

		return staffDao.findById(id);
	}

	public void deleteBatch(String ids) {// "1,2,3,4,..."
		if (StringUtils.isNotBlank(ids)) {
			String[] staffIds = ids.split(",");
			for (String id : staffIds) {
				staffDao.executeUpdate("staff.delete", id);
			}
		}
	}

	public void pageQuery(PageBean pageBean) {
		staffDao.pageQuery(pageBean);
	}

	/*
	 *  查询所有未删除的取派员
	 */
	public List<Staff> findListNotDelete() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
		//添加过滤条件，deltag等于0
		detachedCriteria.add(Restrictions.eq("deltag", "0"));
		//detachedCriteria.add(Restrictions.ne("deltag", "1"));
		return staffDao.findByCriteria(detachedCriteria);
	}

}
