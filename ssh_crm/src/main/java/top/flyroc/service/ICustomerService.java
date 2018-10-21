package top.flyroc.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import top.flyroc.domain.Customer;
import top.flyroc.vo.PageBean;

public interface ICustomerService {

	PageBean getPageBean(DetachedCriteria dcriteria, Integer currentPage, Integer pageSize);

	void save(Customer customer);

	Customer getCustomerById(Long cust_id);

	void update(Customer customer);

	void delete(Customer c);

	Customer getCustomerByName(String cust_name);

	List<Object[]> getIndustryCount();

}
