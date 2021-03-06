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
    PageInfo<PmsProductCategory> findByPage(Long parentId, int size,int page);

    /**
     * 保存方法
     * @param pmsProductCategory
     * @return
     */
    boolean save(PmsProductCategory pmsProductCategory);

    /**
     * 修改方法
     * @param pmsProductCategory
     * @return
     */
    boolean update(PmsProductCategory pmsProductCategory);

    /**
     * 删除
     * @param id 主键
     * @return
     */
    boolean delete(String id);
}
