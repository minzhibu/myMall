package com.example.mall.dto;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 分页对象
 * @param <T>
 */
@Data
@ToString
public class PageDTO<T>{
    private int pageNum;
    private int pageSize;
    private int totalPage;
    private long total;
    private List<T> list;

    public PageDTO(PageInfo pageInfo){
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getSize();
        this.totalPage = pageInfo.getPages();
        this.total = pageInfo.getTotal();
        this.list = pageInfo.getList();
    }
}
