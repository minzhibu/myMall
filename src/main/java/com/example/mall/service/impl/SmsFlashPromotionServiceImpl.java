package com.example.mall.service.impl;

import com.example.mall.mbg.mapper.SmsFlashPromotionMapper;
import com.example.mall.mbg.model.SmsFlashPromotion;
import com.example.mall.service.SmsFlashPromotionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsFlashPromotionServiceImpl implements SmsFlashPromotionService {

    private final SmsFlashPromotionMapper smsFlashPromotionMapper;

    public SmsFlashPromotionServiceImpl(SmsFlashPromotionMapper smsFlashPromotionMapper) {
        this.smsFlashPromotionMapper = smsFlashPromotionMapper;
    }

    @Override
    public PageInfo<SmsFlashPromotion> listByPage(int pageNo, int pageSize, String title) {
        PageHelper.startPage(pageNo, pageSize);
        List<SmsFlashPromotion> smsFlashPromotion = smsFlashPromotionMapper.findAll(title);
        return new PageInfo<>(smsFlashPromotion);
    }

    @Override
    public boolean save(SmsFlashPromotion smsFlashPromotion) {
        if(!parameterValidation(smsFlashPromotion)){
            return false;
        }
        int insert = smsFlashPromotionMapper.insert(smsFlashPromotion);
        return insert == 1;
    }

    @Override
    public boolean update(SmsFlashPromotion smsFlashPromotion) {
        if (!parameterValidation(smsFlashPromotion)) {
            return false;
        }
        int result = smsFlashPromotionMapper.updateByPrimaryKey(smsFlashPromotion);
        return result == 1;
    }

    @Override
    public boolean delete(String id) {
        if(id ==null){
            return false;
        }
        int result = smsFlashPromotionMapper.deleteByPrimaryKey(Long.parseLong(id));
        return result == 1;
    }

    /**
     * 参数校验
     * @param smsFlashPromotion
     * @return
     */
    private boolean parameterValidation(SmsFlashPromotion smsFlashPromotion){
        return smsFlashPromotion.getId() != null &&
                Strings.isNotBlank(smsFlashPromotion.getTitle()) &&
                smsFlashPromotion.getStartDate() !=null &&
                smsFlashPromotion.getEndDate() != null &&
                smsFlashPromotion.getStatus() != null &&
                smsFlashPromotion.getCreateTime() != null;

    }
}

