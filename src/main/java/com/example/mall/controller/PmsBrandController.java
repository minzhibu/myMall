package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.common.StringCommon;
import com.example.mall.dto.PageDTO;
import com.example.mall.mbg.model.PmsBrand;
import com.example.mall.service.PmsBrandService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

/*
 *@program:myMall
 *@author: songjiamin
 *@Time: 2020/12/8  9:29
 *品牌管理
 */
@RestController
@RequestMapping("/brand")
public class PmsBrandController {
    private final PmsBrandService pmsBrandService;

    public PmsBrandController(PmsBrandService pmsBrandService) {
        this.pmsBrandService = pmsBrandService;
    }

    /**
     *
     * @param keyword 不是必填
     * @param page 当前页
     * @param size 一页的条目数
     * @return
     */
    @GetMapping("/list/{page}/{size}")
    public CommonResult findByPage(@RequestParam(value = "keyword", required = false) String keyword, @PathVariable("page") String page, @PathVariable("size") String size){
        PageInfo<PmsBrand> PmsBrands = null;
        try{
            if(!StringCommon.isNotEmpty(page) && !StringCommon.isNotEmpty(size)){
                return CommonResult.failed("参数异常");
            }
            PmsBrands = pmsBrandService.findByPage(keyword, Integer.parseInt(page), Integer.parseInt(size));
        }catch(Exception e){
            return CommonResult.failed("查询异常");
        }
        //构造分页参数
        PageDTO pageDTO = new PageDTO(PmsBrands);
        return CommonResult.success(pageDTO);
    }

    @PostMapping("/")
    public CommonResult save(@RequestBody PmsBrand pmsBrand){
        boolean result = pmsBrandService.save(pmsBrand);
        if(result){
            return CommonResult.success("保存成功");
        }else{
            return CommonResult.failed("保存失败");
        }
    }

    @PutMapping("/")
    public CommonResult update(@RequestBody PmsBrand pmsBrand){
        boolean result = pmsBrandService.update(pmsBrand);
        if(result){
            return CommonResult.success("修改成功");
        }else{
            return CommonResult.failed("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable("id") String id){
        boolean result = pmsBrandService.delete(id);
        if(result){
            return CommonResult.success("删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }

    @PostMapping("/update/showStatus")
    public CommonResult updateShowStatus(@RequestParam("ids") String ids, @RequestParam("showStatus") String showStatus){
        boolean result = pmsBrandService.updateShowStatus(ids, showStatus);
        if(result){
            return CommonResult.success("修改成功");
        }else{
            return CommonResult.failed("修改失败");
        }
    }
}
