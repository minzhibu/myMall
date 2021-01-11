package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.SmsFlashPromotionSession;
import com.example.mall.service.SmsFlashPromotionSessionService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/flashPromotionSession")
@ResponseBody
public class SmsFlashPromotionSessionController {

    private final SmsFlashPromotionSessionService smsFlashPromotionSessionService;

    public SmsFlashPromotionSessionController(SmsFlashPromotionSessionService smsFlashPromotionSessionService) {
        this.smsFlashPromotionSessionService = smsFlashPromotionSessionService;
    }

    @GetMapping("/list")
    public CommonResult list(){
        List<SmsFlashPromotionSession> list = null;
        try {
            list = smsFlashPromotionSessionService.list();
        }catch (Exception e){
            return CommonResult.success("参数异常");
        }
        return CommonResult.success(list);
    }

    @PostMapping("/")
    public CommonResult save(@RequestBody SmsFlashPromotionSession smsFlashPromotionSession){
        boolean result = smsFlashPromotionSessionService.save(smsFlashPromotionSession);
        if(result){
            return CommonResult.success("保存成功");
        }else{
            return CommonResult.success("保存失败");
        }
    }

    @PutMapping("/")
    public CommonResult update(@RequestBody SmsFlashPromotionSession smsFlashPromotionSession){
        boolean update = smsFlashPromotionSessionService.update(smsFlashPromotionSession);
        if(update){
            return CommonResult.success("修改成功");
        }else{
            return CommonResult.success("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable("id")String id){
        boolean delete = smsFlashPromotionSessionService.delete(id);
        if(delete){
            return CommonResult.success("删除成功");
        }else{
            return CommonResult.success("删除失败");
        }
    }
}
