package com.example.mall.service.impl;
/*
 *@program:myMall
 *@author: songjiamin
 *@Time: 2020/12/10  20:22
 */

import com.example.mall.mbg.mapper.PmsProductAttributeMapper;
import com.example.mall.mbg.model.PmsProductAttribute;
import com.example.mall.mbg.model.PmsProductAttributeExample;
import com.example.mall.service.PmsProductAttributeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {

    private final PmsProductAttributeMapper pmsProductAttributeMapper;

    public PmsProductAttributeServiceImpl(PmsProductAttributeMapper pmsProductAttributeMapper) {
        this.pmsProductAttributeMapper = pmsProductAttributeMapper;
    }

    @Override
    public PageInfo<PmsProductAttribute> findByPage(Long categoryId, Integer type, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        PmsProductAttributeExample pmsProductAttributeExample = new PmsProductAttributeExample();
        pmsProductAttributeExample.setOrderByClause("sort desc");
        pmsProductAttributeExample.createCriteria().andProductAttributeCategoryIdEqualTo(categoryId).andTypeEqualTo(type);
        return new PageInfo<>(pmsProductAttributeMapper.selectByExample(pmsProductAttributeExample));
    }
}
