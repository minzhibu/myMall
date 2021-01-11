package com.example.mall.service.impl;

import com.example.mall.mbg.mapper.SmsFlashPromotionSessionMapper;
import com.example.mall.mbg.model.SmsFlashPromotion;
import com.example.mall.mbg.model.SmsFlashPromotionSession;
import com.example.mall.service.SmsFlashPromotionSessionService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsFlashPromotionSessionServiceImpl implements SmsFlashPromotionSessionService {

    private final SmsFlashPromotionSessionMapper smsFlashPromotionSessionMapper;

    public SmsFlashPromotionSessionServiceImpl(SmsFlashPromotionSessionMapper smsFlashPromotionSessionMapper) {
        this.smsFlashPromotionSessionMapper = smsFlashPromotionSessionMapper;
    }

    @Override
    public List<SmsFlashPromotionSession> list() {
        List<SmsFlashPromotionSession> list = smsFlashPromotionSessionMapper.findAll();
        return list;
    }

    @Override
    public boolean save(SmsFlashPromotionSession smsFlashPromotionSession) {
        if(!parameterValidation(smsFlashPromotionSession)){
            return false;
        }
        int insert = smsFlashPromotionSessionMapper.insert(smsFlashPromotionSession);
        return insert == 1;
    }

    @Override
    public boolean update(SmsFlashPromotionSession smsFlashPromotionSession) {
        if(!parameterValidation(smsFlashPromotionSession)){
            return false;
        }
        int result = smsFlashPromotionSessionMapper.updateByPrimaryKey(smsFlashPromotionSession);
        return result == 1;
    }

    @Override
    public boolean delete(String id) {
        if(id == null){
            return false;
        }
        int result = smsFlashPromotionSessionMapper.deleteByPrimaryKey(Long.parseLong(id));
        return result == 1;
    }

    /**
     * 参数校验
     * @param smsFlashPromotionSession
     * @return
     */
    private boolean parameterValidation(SmsFlashPromotionSession smsFlashPromotionSession){
        return smsFlashPromotionSession.getId() != null &&
                Strings.isNotBlank(smsFlashPromotionSession.getName()) &&
                smsFlashPromotionSession.getStartTime() != null &&
                smsFlashPromotionSession.getEndTime() != null &&
                smsFlashPromotionSession.getStatus() !=null &&
                smsFlashPromotionSession.getCreateTime() != null;
    }
}
