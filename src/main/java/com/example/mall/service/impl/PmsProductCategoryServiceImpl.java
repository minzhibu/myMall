package com.example.mall.service.impl;

import com.example.mall.common.StringCommon;
import com.example.mall.mbg.mapper.PmsProductCategoryMapper;
import com.example.mall.mbg.model.PmsProductCategory;
import com.example.mall.service.PmsProductCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {

    private final PmsProductCategoryMapper pmsProductCategoryMapper;

    public PmsProductCategoryServiceImpl(PmsProductCategoryMapper pmsProductCategoryMapper) {
        this.pmsProductCategoryMapper = pmsProductCategoryMapper;
    }

    @Override
    public PageInfo<PmsProductCategory> findByPage(Long parentId, int size, int page) {
        PageHelper.startPage(size, page);
        List<PmsProductCategory> pmsProductCategorys = pmsProductCategoryMapper.findAll(parentId);
        return new PageInfo<>(pmsProductCategorys);
    }

    @Override
    public boolean save(PmsProductCategory pmsProductCategory) {
        if(!parameterValidation(pmsProductCategory)){
            return false;
        }
        int result = pmsProductCategoryMapper.insert(pmsProductCategory);
        return result == 1;
    }

    @Override
    public boolean update(PmsProductCategory pmsProductCategory) {
        if(!parameterValidation(pmsProductCategory) || pmsProductCategory.getId() == null){
            return false;
        }
        PmsProductCategory pmsProductCategory1 = pmsProductCategoryMapper.selectByPrimaryKey(pmsProductCategory.getId());
        pmsProductCategory1.setParentId(pmsProductCategory.getParentId());
        pmsProductCategory1.setName(pmsProductCategory.getName());
        pmsProductCategory1.setLevel(pmsProductCategory.getLevel());
        pmsProductCategory1.setProductCount(pmsProductCategory.getProductCount());
        pmsProductCategory1.setProductUnit(pmsProductCategory.getProductUnit());
        pmsProductCategory1.setNavStatus(pmsProductCategory.getNavStatus());
        pmsProductCategory1.setShowStatus(pmsProductCategory.getShowStatus());
        pmsProductCategory1.setSort(pmsProductCategory.getSort());
        pmsProductCategory1.setIcon(pmsProductCategory.getIcon());
        pmsProductCategory1.setKeywords(pmsProductCategory.getKeywords());
        pmsProductCategory1.setDescription(pmsProductCategory.getDescription());
        int result = pmsProductCategoryMapper.updateByPrimaryKey(pmsProductCategory1);
        return result == 1;
    }

    @Override
    public boolean delete(String id) {
        if(id == null){
            return false;
        }
        int result = pmsProductCategoryMapper.deleteByPrimaryKey(Long.parseLong(id));
        return result == 1;
    }

    /**
     * 参数效验
     * @param pmsProductCategory
     * @return
     */
    private boolean parameterValidation(PmsProductCategory pmsProductCategory){
        return pmsProductCategory.getParentId() != null &&
                StringCommon.isNotEmpty(pmsProductCategory.getName()) &&
                pmsProductCategory.getLevel() != null &&
                pmsProductCategory.getProductCount() != null &&
                StringCommon.isNotEmpty(pmsProductCategory.getProductUnit()) &&
                pmsProductCategory.getNavStatus() != null &&
                pmsProductCategory.getShowStatus() != null &&
                pmsProductCategory.getSort() != null &&
                StringCommon.isNotEmpty(pmsProductCategory.getKeywords());
    }
}
