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
@RestController
@RequestMapping("/productCategory")
public class PmsProductCategoryController {

    private final PmsProductCategoryService pmsProductCategoryService;

    public PmsProductCategoryController(PmsProductCategoryService pmsProductCategoryService) {
        this.pmsProductCategoryService = pmsProductCategoryService;
    }

    @GetMapping("/list/{parentId}/{page}/{size}")
    public CommonResult findByPage(@PathVariable("parentId") String parentId, @PathVariable("page") String page, @PathVariable("size") String size){
        PageInfo<PmsProductCategory> PmsProductCategorys = null;
        try{
            if(!StringCommon.isNotEmpty(page) && !StringCommon.isNotEmpty(size)){
                return CommonResult.failed("参数异常");
            }
            PmsProductCategorys = pmsProductCategoryService.findByPage(Long.parseLong(parentId),Integer.parseInt(page), Integer.parseInt(size));
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
            return CommonResult.failed("保存失败");
        }
    }

    @PutMapping("/")
    public CommonResult update(@RequestBody PmsProductCategory pmsProductCategory){
        boolean result = pmsProductCategoryService.update(pmsProductCategory);
        if(result){
            return CommonResult.success("修改成功");
        }else{
            return CommonResult.failed("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable("id") String id){
        boolean result = pmsProductCategoryService.delete(id);
        if(result){
            return CommonResult.success("删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }
}
