package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.common.StringCommon;
import com.example.mall.dto.PageDTO;
import com.example.mall.mbg.model.PmsProductCategory;
import com.example.mall.service.PmsProductCategoryService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
 *@program:myMall
 *@author: songjiamin
 *@Time: 2020/12/7  10:49
 */
@Controller
@RequestMapping("/productCategory")
@ResponseBody
public class PmsProductCategoryController {

    private final PmsProductCategoryService pmsProductCategoryService;

    public PmsProductCategoryController(PmsProductCategoryService pmsProductCategoryService) {
        this.pmsProductCategoryService = pmsProductCategoryService;
    }

    @GetMapping("/list/{page}/{size}")
    public CommonResult findByPage(@PathVariable("page") String page, @PathVariable("size") String size){
        PageInfo<PmsProductCategory> PmsProductCategorys = null;
        try{
            if(!StringCommon.isNotEmpty(page) && !StringCommon.isNotEmpty(size)){
                return CommonResult.failed("参数异常");
            }
            PmsProductCategorys = pmsProductCategoryService.findByPage(Integer.parseInt(page), Integer.parseInt(size));
        }catch(Exception e){
            return CommonResult.failed("查询异常");
        }
        //构造分页参数
        PageDTO pageDTO = new PageDTO(PmsProductCategorys);
        return CommonResult.success(pageDTO);
    }

    @PostMapping("/")
    public CommonResult save(@RequestBody PmsProductCategory pmsProductCategory){
        boolean result = pmsProductCategoryService.save(pmsProductCategory);
        if(result){
            return CommonResult.success("保存成功");
        }else{
            return CommonResult.success("保存失败");
        }
    }
}
