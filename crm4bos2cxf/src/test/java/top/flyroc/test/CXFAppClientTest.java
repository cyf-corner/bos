package top.flyroc.test;

import java.util.List;
import top.flyroc.received4server.Customer;
import top.flyroc.received4server.CustomerServiceImplService;
import top.flyroc.received4server.ICustomerService;

/*
 * 1、用wsimport或者CXF提供的wsdl2java生成本地代码，我们只用拿到接口就可以了(IHelloService.java)
 * wsimport -s . -p top.flyroc.也可以用CXF提供的wsdl2javac生成接口文档 http://127.0.0.1/CXF_server/service/cxfService?wsdl
 * 2、配置文件
 * 3、注意导包错误
 */
public class CXFAppClientTest {
	public static void main(String[] args) {
		CustomerServiceImplService csis = new CustomerServiceImplService();
		ICustomerService proxy = csis.getCustomerServiceImplPort();
		List<Customer> list = proxy.findAll();
		for (Customer c : list) {
			System.out.println(c.getName());
		}
	}
}
