package com.example.mall.dto;

import com.example.mall.mbg.model.SmsFlashPromotionSession;
import lombok.Getter;
import lombok.Setter;

public class SmsFlashPromotionLimited extends SmsFlashPromotionSession {

    //@ApiModelProperty("商品数量")
    @Setter
    @Getter
    private Long productCount;

    public Long getProductCount() {
        return productCount;
    }
    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }
}
