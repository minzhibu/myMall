package com.example.mall.mbg.mapper;

import com.example.mall.mbg.model.PmsProductFullReduction;
import com.example.mall.mbg.model.PmsProductFullReductionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductFullReductionMapper {
    int countByExample(PmsProductFullReductionExample example);

    int deleteByExample(PmsProductFullReductionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductFullReduction record);

    int insertSelective(PmsProductFullReduction record);

    List<PmsProductFullReduction> selectByExample(PmsProductFullReductionExample example);

    PmsProductFullReduction selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProductFullReduction record, @Param("example") PmsProductFullReductionExample example);

    int updateByExample(@Param("record") PmsProductFullReduction record, @Param("example") PmsProductFullReductionExample example);

    int updateByPrimaryKeySelective(PmsProductFullReduction record);

    int updateByPrimaryKey(PmsProductFullReduction record);
}