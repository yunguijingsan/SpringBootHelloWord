package cn.lcf.core.entity;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.io.Serializable;
import java.util.List;

import cn.lcf.ims.entity.Application;

public class Page<E> implements Serializable {
	

	@ApiParam(hidden = true)
	private List<E> data; // 数据集合
	
	private static final long serialVersionUID = -283738461742224367L;
	@ApiModelProperty(value = "每页数据条数", example = "10", allowableValues = "range[1,infinity]")
	@ApiParam(value = "每页数据条数", defaultValue = "10", allowableValues = "range[1,infinity]")
	private int pageSize = 10; // 每页多少条,默认10
	@ApiModelProperty(value = "页码", example = "1", allowableValues = "range[1,infinity]")
	@ApiParam(value = "页码", defaultValue = "1", allowableValues = "range[1,infinity]")
	private int pageNum; // 页码 ，从1开始
	@ApiParam(hidden = true)
	private int totalCount; // 总条数

	@ApiParam(hidden = true)
	private int totalPage; // 总页数

	public Page() {

	}

	/**
	 * @param data
	 *            结果集
	 * @param pageSize
	 *            每页多少条
	 * @param pageNum
	 *            页码
	 * @param totalCount
	 *            总条数
	 */
	public Page(List<E> data, int pageSize, int pageNum, int totalCount) {
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = this.totalCount / this.pageSize
				+ (this.totalCount % this.pageSize == 0 ? 0 : 1);
		this.data = data;
		if (pageNum < 1 || pageNum > totalPage) {
			pageNum = 1;
		}
		this.pageNum = pageNum;
	}

	// public Page<E> setPage(org.springframework.data.domain.Page<E> page){
	// this.setData(page.getContent());
	// this.setPageSize(page.getSize());
	// this.setTotalCount(((Long)page.getTotalElements()).intValue());
	// return this;
	// }

	public int getTotalPage() {
		return totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		if (this.pageNum == 0)
			pageNum = 1;
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@ApiParam(value = "返回的实际数据", hidden = true, required = false)
	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.totalPage = totalCount / pageSize
				+ (totalCount % pageSize > 0 ? 1 : 0);
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
