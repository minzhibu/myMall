package com.example.mall.service.impl;
/*
 *@program:myMall
 *@author: songjiamin
 *@Time: 2020/12/10  19:22
 */

import com.example.mall.common.StringCommon;
import com.example.mall.mbg.mapper.PmsProductAttributeCategoryMapper;
import com.example.mall.mbg.model.PmsProductAttributeCategory;
import com.example.mall.mbg.model.PmsProductAttributeCategoryExample;
import com.example.mall.service.PmsProductAttributeCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;


@Service
public class PmsProductAttributeCategoryServiceImpl implements PmsProductAttributeCategoryService {
    private final PmsProductAttributeCategoryMapper pmsProductAttributeCategoryMapper;
    public PmsProductAttributeCategoryServiceImpl(PmsProductAttributeCategoryMapper pmsProductAttributeCategoryMapper){
        this.pmsProductAttributeCategoryMapper = pmsProductAttributeCategoryMapper;
    }
    @Override
    public PageInfo<PmsProductAttributeCategory> findByPage(int size, int page) {
        PageHelper.startPage(size,page);
        return new PageInfo<>(pmsProductAttributeCategoryMapper.selectByExample(new PmsProductAttributeCategoryExample()));
    }

    @Override
    public boolean save(String name) {
        if(!StringCommon.isNotEmpty(name)){
            return false;
        }
        PmsProductAttributeCategory pmsProductAttributeCategory = new PmsProductAttributeCategory();
        pmsProductAttributeCategory.setAttributeCount(0);
        pmsProductAttributeCategory.setParamCount(0);
        pmsProductAttributeCategory.setName(name);
        return pmsProductAttributeCategoryMapper.insert(pmsProductAttributeCategory) == 1;
    }

    @Override
    public boolean update(PmsProductAttributeCategory pmsProductAttributeCategory) {
        if(!StringCommon.isNotEmpty(pmsProductAttributeCategory.getName())){
            return false;
        }
        PmsProductAttributeCategory pmsProductAttributeCategory1 = pmsProductAttributeCategoryMapper.selectByPrimaryKey(pmsProductAttributeCategory.getId());
        pmsProductAttributeCategory1.setName(pmsProductAttributeCategory.getName());
        return pmsProductAttributeCategoryMapper.updateByPrimaryKey(pmsProductAttributeCategory1) == 1;
    }

    @Override
    public boolean delete(String id) {
        if(!StringCommon.isNotEmpty(id)){
            return false;
        }
        return pmsProductAttributeCategoryMapper.deleteByPrimaryKey(Long.parseLong(id)) == 1;
    }


}
