package cn.lcf.core.entity;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

public class PageCondition {
	@ApiModelProperty(value = "每页数据条数", example = "10", allowableValues = "range[1,infinity]")
	@ApiParam(value = "每页数据条数", defaultValue = "10", allowableValues = "range[1,infinity]")
	protected int pageSize = 10; // 每页多少条,默认10
	@ApiModelProperty(value = "页码", example = "1", allowableValues = "range[1,infinity]")
	@ApiParam(value = "页码", defaultValue = "1", allowableValues = "range[1,infinity]")
	protected int pageNum; // 页码 ，从1开始
	
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

}
