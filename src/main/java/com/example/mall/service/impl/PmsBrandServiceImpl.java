package com.example.mall.service.impl;

/*
 *@program:myMall
 *@author: songjiamin
 *@Time: 2020/12/7  16:05
 */

import com.example.mall.mbg.mapper.PmsBrandMapper;
import com.example.mall.mbg.model.PmsBrand;
import com.example.mall.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    private PmsBrandMapper pmsBrandMapper;

    public PmsBrandServiceImpl(PmsBrandMapper pmsBrandMapper) {
        this.pmsBrandMapper = pmsBrandMapper;
    }

    @Override
    public PageInfo<PmsBrand> findByPage(int size, int page) {
        PageHelper.startPage(size, page);
        List<PmsBrand> pmsProductCategorys = pmsBrandMapper.findAll();
        return new PageInfo<>(pmsProductCategorys);
    }

    @Override
    public boolean save(PmsBrand pmsBrand) {
        //参数效验
        if(!parameterValidation(pmsBrand)){
            return false;
        }
        int result = pmsBrandMapper.insert(pmsBrand);
        return result == 1;
    }

    @Override
    public boolean update(PmsBrand pmsBrand) {
        //参数效验
        if(!parameterValidation(pmsBrand)){
            return false;
        }
        PmsBrand pmsBrand1 = pmsBrandMapper.selectByPrimaryKey(PmsBrand.getId());
        pmsBrand1.setName(pmsBrand.getName());
        pmsBrand1.setFirstLetter(pmsBrand.getFirstLetter());
        pmsBrand1.setSort(pmsBrand.getSort());
        pmsBrand1.setFactoryStatus(pmsBrand.getFactoryStatus());
        pmsBrand1.setShowStatus(pmsBrand.getShowStatus());
        pmsBrand1.setProductCommentCount(pmsBrand.getProductCommentCount());
        pmsBrand1.setLogo(pmsBrand.getLogo());
        pmsBrand1.setBigPic(pmsBrand.getBigPic());
        pmsBrand1.setBrandStory(pmsBrand.getBrandStory());
        int result = pmsBrandMapper.updateByPrimaryKey(pmsBrand1);
        return result == 1;
    }

    @Override
    public boolean delete(String id) {
        int result = pmsBrandMapper.deleteByPrimaryKey(Long.parseLong(id));
        return result == 1;
    }

    /**
     * 参数效验
     * @param pmsBrand
     * @return
     */
    private boolean parameterValidation(PmsBrand pmsBrand){
       return true;
    }
}
