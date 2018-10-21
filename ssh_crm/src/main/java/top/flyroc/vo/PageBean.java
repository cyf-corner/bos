package top.flyroc.vo;

import java.util.List;

@SuppressWarnings("all")
public class PageBean {

	private Integer currentPage;// 当前页面

	private Integer totalCount;// 总记录数

	private Integer pageSize;// 每页显示条数

	private Integer totalPage;// 总页数

	private List list;// 分页列表数据

	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currentPage = currentPage;

		/*
		 * 默认显示第一页
		 */
		if (this.currentPage == null) {
			this.currentPage = 1;
		}
		/*
		 * 默认每页显示三条记录
		 */
		if (this.pageSize == null) {
			this.pageSize = 3;
		}
		/*
		 * 计算总页数
		 */
		this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;
		/*
		 * 判断当前页码是否违规
		 */
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}
		if (this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		}
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	/*
	 * 计算启始索引
	 */
	public int getStartIndex() {
		return (this.currentPage - 1) * this.pageSize;
	}

}
