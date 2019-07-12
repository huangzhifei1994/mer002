package com.hzf.dao;

import com.hzf.model.TestDemo;

public interface TestDemoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestDemo record);

    int insertSelective(TestDemo record);

    TestDemo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestDemo record);

    int updateByPrimaryKey(TestDemo record);
}