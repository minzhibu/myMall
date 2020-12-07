package com.example.mall.service;

import com.example.mall.mbg.model.PmsProductCategory;
import com.github.pagehelper.PageInfo;

public interface PmsProductCategoryService {

    PageInfo<PmsProductCategory> findByPage(int size,int page);
}
