package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.dto.PageDTO;
import com.example.mall.mbg.model.OmsOrder;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *@program:myMall
 *@author: liufaming
 *@Time: 2020年12月29日
 *订单基本信息
 */
@RestController
@RequestMapping("/order")
public class OrderDataController {

    /**
     * 获取订单列表信息
     * @param omsOrder
     * @return
     */
    @PostMapping("/list")
    public CommonResult getOrderList(@RequestBody OmsOrder omsOrder){
        PageInfo<OmsOrder> omsOrderPageInfo = null;
        try {

        }catch (Exception exception){
            return CommonResult.failed("获取订单列表信息异常");
        }
        //分页对象
        PageDTO pageDTO = new PageDTO(omsOrderPageInfo);
        return CommonResult.success(pageDTO);
    }
}
