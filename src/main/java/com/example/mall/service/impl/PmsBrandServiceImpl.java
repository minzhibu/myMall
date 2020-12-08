package com.example.mall.service.impl;

/*
 *@program:myMall
 *@author: songjiamin
 *@Time: 2020/12/7  16:05
 */

import com.example.mall.common.StringCommon;
import com.example.mall.mbg.mapper.PmsBrandMapper;
import com.example.mall.mbg.model.PmsBrand;
import com.example.mall.mbg.model.PmsBrandExample;
import com.example.mall.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    private PmsBrandMapper pmsBrandMapper;

    public PmsBrandServiceImpl(PmsBrandMapper pmsBrandMapper) {
        this.pmsBrandMapper = pmsBrandMapper;
    }

    @Override
    public PageInfo<PmsBrand> findByPage(String keyword, int size, int page) {
        PageHelper.startPage(size, page);
        List<PmsBrand> pmsBrands = pmsBrandMapper.findAll(keyword);
        return new PageInfo<>(pmsBrands);
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
        PmsBrand pmsBrand1 = pmsBrandMapper.selectByPrimaryKey(pmsBrand.getId());
        pmsBrand1.setName(pmsBrand.getName());
        pmsBrand1.setFirstLetter(pmsBrand.getFirstLetter());
        pmsBrand1.setSort(pmsBrand.getSort());
        pmsBrand1.setFactoryStatus(pmsBrand.getFactoryStatus());
        pmsBrand1.setShowStatus(pmsBrand.getShowStatus());
        pmsBrand1.setProductCount(pmsBrand.getProductCount());
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

    @Override
    public boolean updateShowStatus(String ids, String showStatus) {
        ArrayList<Long> id = Stream.of(ids.split(",")).mapToLong(Long::parseLong).collect(ArrayList::new,
                ArrayList::add,
                ArrayList::addAll);
        PmsBrand pmsBrand = new PmsBrand();
        pmsBrand.setShowStatus(Integer.parseInt(showStatus));
        PmsBrandExample pmsBrandExample = new PmsBrandExample();
        pmsBrandExample.createCriteria().andIdIn(id);
        pmsBrandMapper.updateByExampleSelective(pmsBrand, pmsBrandExample);
        return true;
    }

    /**
     * 参数效验
     * @param pmsBrand
     * @return
     */
    private boolean parameterValidation(PmsBrand pmsBrand){
        return  StringCommon.isNotEmpty(pmsBrand.getName()) &&
                StringCommon.isNotEmpty(pmsBrand.getFirstLetter()) &&
                pmsBrand.getSort() != null &&
                pmsBrand.getFactoryStatus() != null &&
                pmsBrand.getShowStatus() != null &&
                pmsBrand.getProductCount() != null &&
                pmsBrand.getProductCommentCount() != null &&
                StringCommon.isNotEmpty(pmsBrand.getLogo()) &&
                StringCommon.isNotEmpty(pmsBrand.getBigPic());
    }
}
