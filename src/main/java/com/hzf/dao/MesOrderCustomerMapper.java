package com.hzf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.hzf.beans.PageQuery;
import com.hzf.dto.SearchOrderDto;
import com.hzf.model.Order;

public interface MesOrderCustomerMapper {
	Long getOrderCount();

	// @Param("dto")--给mapper.xml查询sql指定参数名称 #{dto.keyword}
	int countBySearchDto(@Param("dto") SearchOrderDto dto);

	List<Order> getPageListBySearchDto(@Param("dto") SearchOrderDto dto, @Param("page") PageQuery page);

	Order getOrderByOid(@Param("pid") String pid);

	void batchStart(@Param("list")String[] idArray);

	Order selectByOrderId(@Param("orderid")String orderid);
}