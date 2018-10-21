package top.flyroc.service.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import top.flyroc.dao.ICustomerDao;
import top.flyroc.domain.Customer;
import top.flyroc.service.ICustomerService;
import top.flyroc.vo.PageBean;

public class CustomerServiceImpl implements ICustomerService {

	private ICustomerDao customerDao;

	@Override
	public PageBean getPageBean(DetachedCriteria dcriteria, Integer currentPage, Integer pageSize) {
		Integer totalCount = customerDao.getTotalCount(dcriteria);
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);

		List<Customer> list = customerDao.getPageList(dcriteria, pageBean.getStartIndex(), pageBean.getPageSize());
		pageBean.setList(list);

		return pageBean;
	}

	@Override
	public void save(Customer customer) {
		// 维护Customer与数据字典对象的关系，由于struts2参数封装，会将参数封装到数据字典的id属性，那么我们无需手动维护关系，因此可直接调用Dao保存客户信息
		customerDao.save(customer);
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public Customer getCustomerById(Long cust_id) {
		Customer c = customerDao.getById(cust_id);
		return c;
	}

	@Override
	public void delete(Customer c) {
		customerDao.delete(c);
	}

	@Override
	public Customer getCustomerByName(String cust_name) {
		Customer c = customerDao.getCustomerByName(cust_name);
		return c;
	}
	
	@Override
	public List<Object[]> getIndustryCount() {
		return customerDao.getIndustryCount();
	}

	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

}
