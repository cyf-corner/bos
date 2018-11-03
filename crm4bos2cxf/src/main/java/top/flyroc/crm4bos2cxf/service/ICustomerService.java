package top.flyroc.crm4bos2cxf.service;

import java.util.List;
import javax.jws.WebService;
import top.flyroc.crm4bos2cxf.domain.Customer;

@WebService
public interface ICustomerService {

	public List<Customer> findAll();

	public List<Customer> findListNotAssociation();

	public List<Customer> findListHasAssociation(String decidedzoneId);

	public void assigncustomerstodecidedzone(String decidedzoneId, List<Integer> ids);

	public Customer findCustomerByTelephone(String telephone);

	public String findDecidedzoneIdByAddress(String address);

}
