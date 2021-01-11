package com.example.mall.service;

import com.example.mall.dto.SmsFlashPromotionLimited;

import java.util.List;
import java.util.Map;

public interface SmsFlashPromotionLimitedService {
    /**
     * 查询指定活动秒杀时间段列表
     * @param flashPromotionId
     * @return
     */
    List<SmsFlashPromotionLimited> findLimitedList(String flashPromotionId);
}
