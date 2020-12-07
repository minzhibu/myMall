package com.example.mall.service;

import com.example.mall.mbg.model.PmsProductCategory;
import com.github.pagehelper.PageInfo;

public interface PmsProductCategoryService {

    /**
     * 分页查询
     * @param size
     * @param page
     * @return
     */
    PageInfo<PmsProductCategory> findByPage(int size,int page);

    /**
     * 保存方法
     * @param pmsProductCategory
     * @return
     */
    boolean save(PmsProductCategory pmsProductCategory);
}
