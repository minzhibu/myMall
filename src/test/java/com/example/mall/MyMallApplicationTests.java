package com.example.mall;

import com.example.mall.mbg.model.PmsProductCategory;
import com.example.mall.service.impl.PmsProductCategoryServiceImpl;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyMallApplicationTests {

    @Autowired
    private PmsProductCategoryServiceImpl pmsProductCategoryService;

    @Test
    void contextLoads() {
        PageInfo<PmsProductCategory> byPage = pmsProductCategoryService.findByPage(1, 5);
        System.out.println(byPage);
    }

    @Test
    void testPmsProductCategorySave(){
        PmsProductCategory pmsProductCategory = new PmsProductCategory();
        pmsProductCategory.setParentId(0L);
        pmsProductCategory.setName("测试");
        pmsProductCategory.setLevel(0);
        pmsProductCategory.setProductCount(100);
        pmsProductCategory.setProductUnit("件");
        pmsProductCategory.setNavStatus(1);
        pmsProductCategory.setShowStatus(1);
        pmsProductCategory.setSort(1);
        pmsProductCategory.setKeywords("家具");
        pmsProductCategoryService.save(pmsProductCategory);
    }
}
