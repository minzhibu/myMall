package com.example.mall.mbg.mapper;

import com.example.mall.mbg.model.SmsHomeRecommendSubject;
import com.example.mall.mbg.model.SmsHomeRecommendSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsHomeRecommendSubjectMapper {
    int countByExample(SmsHomeRecommendSubjectExample example);

    int deleteByExample(SmsHomeRecommendSubjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeRecommendSubject record);

    int insertSelective(SmsHomeRecommendSubject record);

    List<SmsHomeRecommendSubject> selectByExample(SmsHomeRecommendSubjectExample example);

    SmsHomeRecommendSubject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsHomeRecommendSubject record, @Param("example") SmsHomeRecommendSubjectExample example);

    int updateByExample(@Param("record") SmsHomeRecommendSubject record, @Param("example") SmsHomeRecommendSubjectExample example);

    int updateByPrimaryKeySelective(SmsHomeRecommendSubject record);

    int updateByPrimaryKey(SmsHomeRecommendSubject record);
}