package com.hzf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzf.beans.PageQuery;
import com.hzf.dto.SearchPlanDto;
import com.hzf.model.MesPlan;

public interface MesPlanCustomerMapper {
	Long getPlanCount();

	// @Param("dto")--给mapper.xml查询sql指定参数名称 #{dto.keyword}
	int countBySearchDto(@Param("dto") SearchPlanDto dto);

	List<MesPlan> getPageListBySearchDto(@Param("dto") SearchPlanDto dto, @Param("page") PageQuery page);

	void batchStartWithIds(@Param("list") String[] tempIds);

}