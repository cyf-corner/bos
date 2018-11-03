package top.flyroc.crm4bos2cxf.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;
import top.flyroc.crm4bos2cxf.domain.Customer;
import top.flyroc.crm4bos2cxf.service.ICustomerService;

@Transactional // 事务注解
public class CustomerServiceImpl implements ICustomerService {

	// 提供setter方法使其可以用spring注入进此类中
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * 查询所有客户
	 */
	public List<Customer> findAll() {
		String sql = "select * from t_customer";
		List<Customer> list = jdbcTemplate.query(sql, new RowMapper<Customer>() {
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");

				return new Customer(id, name, station, telephone, address, decidedzone_id);
			}
		});

		return list;
	}

	/*
	 * 查询未关联定区的客户
	 */
	public List<Customer> findListNotAssociation() {
		String sql = "select * from t_customer where decidedzone_id is null";
		List<Customer> list = jdbcTemplate.query(sql, new RowMapper<Customer>() {
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");

				return new Customer(id, name, station, telephone, address, decidedzone_id);
			}
		});

		return list;
	}

	/*
	 * 查询已关联定区的客户
	 */
	public List<Customer> findListHasAssociation(String decidedzoneId) {
		String sql = "select * from t_customer where decidedzone_id = ?";
		List<Customer> list = jdbcTemplate.query(sql, new RowMapper<Customer>() {
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");

				return new Customer(id, name, station, telephone, address, decidedzone_id);
			}
		}, decidedzoneId);

		if (list.size() != 0 && list != null) {
			return list;
		}

		list.add(null);
		return list;
	}

	/*
	 * 该定区与选中的客户关联
	 */
	public void assigncustomerstodecidedzone(String decidedzoneId, List<Integer> ids) {
		// 将已经与本定区关联的客户decidedzone_id字段清空
		String sql = "update t_customer set decidedzone_id = null where decidedzone_id = ?";
		jdbcTemplate.update(sql, decidedzoneId);
		if (ids.size() != 0 && ids != null) {
			// 将页面下拉框选中的客户关联到此定区
			sql = "update t_customer set decidedzone_id = ? where id = ?";
			for (Integer id : ids) {
				jdbcTemplate.update(sql, decidedzoneId, id);
			}
		} else {
			sql = "update t_customer set decidedzone_id = null";
			jdbcTemplate.update(sql);
		}
	}

	/*
	 * 根据手机号查询客户
	 */
	public Customer findCustomerByTelephone(String telephone) {
		String sql = "select * from t_customer where telephone = ?";
		List<Customer> list = jdbcTemplate.query(sql, new RowMapper<Customer>() {
			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				int id = rs.getInt("id");// 根据字段名称从结果集中获取对应的值
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");

				return new Customer(id, name, station, telephone, address, decidedzone_id);
			}
		}, telephone);

		if (list != null && list.size() > 0) {

			return list.get(0);
		}

		return null;
	}

	/*
	 * 根据客户地址查询该客户所属(关联)的定区
	 */
	public String findDecidedzoneIdByAddress(String address) {
		String sql = "select decidedzone_id from t_customer where address = ?";
		String decidedzoneId = jdbcTemplate.queryForObject(sql, String.class, address);

		return decidedzoneId;
	}

}
