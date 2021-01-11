package com.example.mall.service;

import com.example.mall.mbg.model.SmsFlashPromotionSession;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SmsFlashPromotionSessionService {
    /**
     * 分页查询
     * @return
     */
    List<SmsFlashPromotionSession> list();

    /**
     *保存方法
     * @param smsFlashPromotionSession
     * @return
     */
    boolean save(SmsFlashPromotionSession smsFlashPromotionSession);

    /**
     *修改方法
     * @param smsFlashPromotionSession
     * @return
     */
    boolean update(SmsFlashPromotionSession smsFlashPromotionSession);

    /**
     * 删除方法
     * @param id
     * @return
     */
    boolean delete(String id);
}
