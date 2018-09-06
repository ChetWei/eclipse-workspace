package domain;

import java.util.List;

public class PageBean<T> {

	private Integer currentPage;
	private Integer pageSize;
	private Integer totalCount;
	private Long totalPage;
	
	private List<T> list;
	
	public Long getTotalPage() {
		return totalPage;
	}
	
	
	
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", list=" + list + "]";
	}
	
	
}
