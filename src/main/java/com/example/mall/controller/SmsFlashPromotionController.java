package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.dto.PageDTO;
import com.example.mall.mbg.model.SmsFlashPromotion;
import com.example.mall.service.SmsFlashPromotionService;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flashPromotion")
@ResponseBody
public class SmsFlashPromotionController {

    private final SmsFlashPromotionService limitedService;

    public SmsFlashPromotionController(SmsFlashPromotionService limitedService) {
        this.limitedService = limitedService;
    }

    @GetMapping("/list/{pageNo}/{pageSize}/{title}")
    public CommonResult list(@PathVariable("pageNo") String pageNo, @PathVariable("pageSize") String pageSize, @PathVariable("title") String title){
        PageInfo<SmsFlashPromotion> smsFlashPromotion = null;
        try {
            if(title.equals("0")){
                title = null;
            }else{
                title = "%"+title+"%";
            }
            smsFlashPromotion = limitedService.listByPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize), title);
        }catch (Exception e){
            return CommonResult.failed("参数异常");
        }
        PageDTO pageDTO = new PageDTO(smsFlashPromotion);
        return CommonResult.success(pageDTO);
    }

    @PostMapping("/")
    public CommonResult save(@RequestBody SmsFlashPromotion smsFlashPromotion){
        boolean result  = limitedService.save(smsFlashPromotion);
        if(result){
            return CommonResult.success("保存成功");
        }else{
            return CommonResult.success("保存失败");
        }
    }

    @PutMapping("/")
    public CommonResult update(@RequestBody SmsFlashPromotion smsFlashPromotion){
        boolean result = limitedService.update(smsFlashPromotion);
        if(result){
            return CommonResult.success("修改成功");
        }else{
            return CommonResult.success("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable("id") String id){
        boolean result = limitedService.delete(id);
        if(result){
            return CommonResult.success("删除成功");
        }else{
            return CommonResult.success("删除失败");
        }
    }
}
