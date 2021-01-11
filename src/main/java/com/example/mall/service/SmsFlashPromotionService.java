package com.example.mall.service;

import com.example.mall.mbg.model.SmsFlashPromotion;
import com.github.pagehelper.PageInfo;

public interface SmsFlashPromotionService {
    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param title
     * @return
     */
    PageInfo<SmsFlashPromotion> listByPage(int pageNo, int pageSize, String title);

    /**
     *保存方法
     * @param smsFlashPromotion
     * @return
     */
    boolean save(SmsFlashPromotion smsFlashPromotion);

    /**
     *修改方法
     * @param smsFlashPromotion
     * @return
     */
    boolean update(SmsFlashPromotion smsFlashPromotion);

    /**
     * 删除方法
     * @param id
     * @return
     */
    boolean delete(String id);

}
