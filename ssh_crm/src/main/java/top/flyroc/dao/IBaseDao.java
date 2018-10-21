package top.flyroc.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

public interface IBaseDao<T> {

	// 增
	void save(T t);
	
	//
	void saveOrUpdate(T t);

	// 删->通过对象删
	void delete(T t);

	// 删->通过id删
	void delete(Serializable id);

	// 改
	void update(T t);

	// 查->根据id查
	T getById(Serializable id);

	// 查->符合条件的总记录数
	Integer getTotalCount(DetachedCriteria dc);

	// 查->查询分页列表数据
	List<T> getPageList(DetachedCriteria dc, Integer startIndex, Integer pageSize);

}
