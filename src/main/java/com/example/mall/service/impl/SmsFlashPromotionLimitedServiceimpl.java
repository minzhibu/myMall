package com.example.mall.service.impl;

import com.example.mall.dto.SmsFlashPromotionLimited;
import com.example.mall.mbg.mapper.SmsFlashPromotionSessionMapper;
import com.example.mall.mbg.model.SmsFlashPromotionSession;
import com.example.mall.mbg.model.SmsFlashPromotionSessionExample;
import com.example.mall.service.SmsFlashPromotionLimitedService;

import javax.management.relation.RelationService;
import java.util.ArrayList;
import java.util.List;

class SmsFlashPromotionLimitedServiceImpl implements SmsFlashPromotionLimitedService{

    private final RelationService relationService;
    private final SmsFlashPromotionSessionMapper smsFlashPromotionSessionMapper;


    SmsFlashPromotionLimitedServiceImpl(SmsFlashPromotionSessionMapper smsFlashPromotionSessionMapper, RelationService relationService) {
        this.smsFlashPromotionSessionMapper = smsFlashPromotionSessionMapper;
        this.relationService = relationService;
    }



    @Override
    public List<SmsFlashPromotionLimited> findLimitedList(String flashPromotionId) {
        List<SmsFlashPromotionLimited> result = new ArrayList<>();
        SmsFlashPromotionSessionExample example = new SmsFlashPromotionSessionExample();
        example.createCriteria().andStatusEqualTo(1);
        List<SmsFlashPromotionSession> list = smsFlashPromotionSessionMapper.selectByExample(example);
        for (SmsFlashPromotionSession promotionSession : list) {
            SmsFlashPromotionLimited limited = new SmsFlashPromotionLimited();
//            BeanUtils.copyProperties(promotionSession, detail);
//            int count = relationService.getCount(flashPromotionId, promotionSession.getId());
            limited.setProductCount(1L);
            result.add(limited);
        }
        return result;
    }
}
