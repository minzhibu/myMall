package com.example.mall.service;
/*
 *@program:myMall
 *@author: songjiamin
 *@Time: 2020/12/10  19:21
 */

import com.example.mall.mbg.model.PmsProductAttributeCategory;
import com.github.pagehelper.PageInfo;

public interface PmsProductAttributeCategoryService {
    /**
     * 分页查询
     * @param size
     * @param page
     * @return
     */
    PageInfo<PmsProductAttributeCategory> findByPage(int size, int page);

    /**
     * 保存
     * @param name 商品属性的名称
     * @return
     */
    boolean save(String name);

    /**
     * 修改方法
     * @param name
     * @return
     */
    boolean update(PmsProductAttributeCategory pmsProductAttributeCategory);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean delete(String id);
}
