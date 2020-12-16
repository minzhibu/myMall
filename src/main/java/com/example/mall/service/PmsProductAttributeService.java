package com.example.mall.service;
/*
 *@program:myMall
 *@author: songjiamin
 *@Time: 2020/12/10  20:22
 */

import com.example.mall.mbg.model.PmsProductAttribute;
import com.github.pagehelper.PageInfo;

public interface PmsProductAttributeService {
    PageInfo<PmsProductAttribute> findByPage(Long categoryId, Integer type, Integer page, Integer size);
}
