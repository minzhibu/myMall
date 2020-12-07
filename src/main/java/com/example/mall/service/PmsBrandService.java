package com.example.mall.service;

/*
 *@program:myMall
 *@author: songjiamin
 *@Time: 2020/12/7  16:04
 * 商品品牌
 */

import com.example.mall.mbg.model.PmsBrand;
import com.github.pagehelper.PageInfo;

public interface PmsBrandService {
    /**
     * 分页查询
     * @param size
     * @param page
     * @return
     */
    PageInfo<PmsBrand> findByPage(int size, int page);

    /**
     * 保存方法
     * @param PmsBrand
     * @return
     */
    boolean save(PmsBrand pmsProductCategory);

    /**
     * 修改方法
     * @param PmsBrand
     * @return
     */
    boolean update(PmsBrand pmsProductCategory);

    /**
     * 删除
     * @param id 主键
     * @return
     */
    boolean delete(String id);
}
