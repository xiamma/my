package com.demo.entity;

/**
 * @Description 分页对象
 * @Author leslee
 * @Date 2020-12-13 下午1:27
 */
public class Page {

    private Integer offset;

    private Integer limit;

    public Page(Integer offset, Integer limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Page{" +
                "offset=" + offset +
                ", limit=" + limit +
                '}';
    }
}
