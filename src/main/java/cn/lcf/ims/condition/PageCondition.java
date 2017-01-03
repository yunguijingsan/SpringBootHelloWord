package cn.lcf.ims.condition;


public class PageCondition {
    //数据行数
    private int pageSize = Integer.MAX_VALUE;
    //当前页面
    private int pageNum = 1;

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageNum() {
        return pageNum;
    }
}
