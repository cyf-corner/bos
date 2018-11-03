package top.flyroc.bos.service;

import java.util.List;

import top.flyroc.bos.domain.Staff;
import top.flyroc.bos.utils.PageBean;

public interface IStaffService {

	public void save(Staff model);

	public void update(Staff staff);

	public Staff findById(String id);

	public void deleteBatch(String ids);

	public void pageQuery(PageBean pageBean);

	public List<Staff> findListNotDelete();

}
