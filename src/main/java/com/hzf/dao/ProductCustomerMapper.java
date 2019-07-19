package com.hzf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzf.beans.PageQuery;
import com.hzf.dto.ProductDto;
import com.hzf.dto.SearchProductDto;
import com.hzf.model.Product;

public interface ProductCustomerMapper {
	
	int countBySearchDto(@Param("dto")SearchProductDto dto);

	List<ProductDto> getPageListBySearchDto(@Param("dto")SearchProductDto dto,@Param("page")PageQuery page);
    
	void batchStart(@Param("list")String[] idArray);
	
}
