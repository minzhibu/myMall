package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.common.StringCommon;
import com.example.mall.dto.PageDTO;
import com.example.mall.mbg.model.PmsBrand;
import com.example.mall.mbg.model.PmsProductAttribute;
import com.example.mall.mbg.model.PmsProductAttributeCategory;
import com.example.mall.service.PmsProductAttributeCategoryService;
import com.example.mall.service.PmsProductAttributeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 *@program:myMall
 *@author: songjiamin
 *@Time: 2020/12/10  19:29
 * 商品属性
 */
@RestController
@RequestMapping("/productAttribute")
public class PmsProductAttributeCategoryController {

    private final PmsProductAttributeCategoryService pmsProductAttributeCategoryService;
    private final PmsProductAttributeService pmsProductAttributeService;

    public PmsProductAttributeCategoryController(PmsProductAttributeCategoryService pmsProductAttributeCategoryService, PmsProductAttributeService pmsProductAttributeService) {
        this.pmsProductAttributeCategoryService = pmsProductAttributeCategoryService;
        this.pmsProductAttributeService = pmsProductAttributeService;
    }

    /**
     * 分页查询商品属性列表
     * @param page 当前页
     * @param size  一页的记录条数
     * @return
     */
    @GetMapping("/category/list/{page}/{size}")
    public CommonResult findCategoryByPage( @PathVariable("page") String page, @PathVariable("size") String size){
        PageInfo<PmsProductAttributeCategory> PmsBrands = null;
        try{
            if(!StringCommon.isNotEmpty(page) && !StringCommon.isNotEmpty(size)){
                return CommonResult.failed("参数异常");
            }
            PmsBrands = pmsProductAttributeCategoryService.findByPage(Integer.parseInt(page), Integer.parseInt(size));
        }catch(Exception e){
            return CommonResult.failed("查询异常");
        }
        //构造分页参数
        PageDTO pageDTO = new PageDTO(PmsBrands);
        return CommonResult.success(pageDTO);
    }

    @GetMapping("/{page}/{size}/{categoryId}/{type}")
    public CommonResult findByPage(@PathVariable("categoryId") String categoryId,@PathVariable("type") String type,
                                   @PathVariable("page") String page, @PathVariable("size") String size){
        PageInfo<PmsProductAttribute> pmsProductAttributes = null;
        try{
            if(!StringCommon.isNotEmpty(page) && !StringCommon.isNotEmpty(size)){
                return CommonResult.failed("参数异常");
            }
            pmsProductAttributes = pmsProductAttributeService.findByPage(Long.parseLong(categoryId),Integer.parseInt(type),Integer.parseInt(page), Integer.parseInt(size));
        }catch(Exception e){
            return CommonResult.failed("查询异常");
        }
        //构造分页参数
        PageDTO pageDTO = new PageDTO(pmsProductAttributes);
        return CommonResult.success(pageDTO);
    }

    /**
     * 添加商品属性
     * @param name 名称
     * @return
     */
    @PostMapping("/")
    public CommonResult save(String name){
        if(pmsProductAttributeCategoryService.save(name)){
            return CommonResult.success("保存成功!");
        }
        return CommonResult.failed("保存失败!");
    }

    /**
     * 修改商品属性
     * @param pmsProductAttributeCategory
     * @return
     */
    @PutMapping("/")
    public CommonResult update(PmsProductAttributeCategory pmsProductAttributeCategory){
        if(pmsProductAttributeCategoryService.update(pmsProductAttributeCategory)){
            return CommonResult.success("修改成功!");
        }
        return CommonResult.failed("修改失败!");
    }

    /**
     * 删除商品属性
     * @param id
     * @return
     */
    @DeleteMapping("/")
    public CommonResult delete(String id){
        if(pmsProductAttributeCategoryService.delete(id)){
            return CommonResult.success("修改成功!");
        }
        return CommonResult.failed("修改失败!");
    }
}
