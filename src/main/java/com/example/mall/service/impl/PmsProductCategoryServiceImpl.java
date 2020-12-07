package com.example.mall.service.impl;

import com.example.mall.mbg.mapper.PmsProductCategoryMapper;
import com.example.mall.mbg.model.PmsProductCategory;
import com.example.mall.service.PmsProductCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {

    private final PmsProductCategoryMapper pmsProductCategoryMapper;

    public PmsProductCategoryServiceImpl(PmsProductCategoryMapper pmsProductCategoryMapper) {
        this.pmsProductCategoryMapper = pmsProductCategoryMapper;
    }

    @Override
    public PageInfo<PmsProductCategory> findByPage(int size, int page) {
        PageHelper.startPage(size, page);
        List<PmsProductCategory> pmsProductCategorys = pmsProductCategoryMapper.findAll();
        return new PageInfo<>(pmsProductCategorys);
    }
}
