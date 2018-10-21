package test;

import javax.annotation.Resource;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.flyroc.domain.Customer;
import top.flyroc.service.ICustomerService;
import top.flyroc.vo.PageBean;

@RunWith(SpringJUnit4ClassRunner.class) // 帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml") // 指定创建容器时，使用哪个配置文件
public class Demo {

	@Resource(name = "customerService")
	private ICustomerService customerService;

	@Test
	public void fun() {
		DetachedCriteria dcriteria = DetachedCriteria.forClass(Customer.class);
		dcriteria.add(Restrictions.like("cust_name", "%" + "" + "%"));
		PageBean pageBean = customerService.getPageBean(dcriteria, 1, 3);
		System.out.println(pageBean.getTotalCount());
	}

	@Test
	public void fun1() {
		int i = (int) Math.ceil(1.0 * 7 / 3);
		System.out.println(i);
	}

	@Test
	public void fun2() {
		PageBean pageBean = new PageBean(null, 7, null);
		System.out.println(pageBean.getCurrentPage());
		System.out.println(pageBean.getPageSize());
	}

}
