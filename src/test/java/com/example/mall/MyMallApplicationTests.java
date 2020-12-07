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

}
