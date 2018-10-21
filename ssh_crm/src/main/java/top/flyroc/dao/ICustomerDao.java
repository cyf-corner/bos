package top.flyroc.dao;

import java.util.List;

import top.flyroc.domain.Customer;

public interface ICustomerDao extends IBaseDao<Customer> {

	Customer getCustomerByName(String cust_name);

	List<Object[]> getIndustryCount();

}
