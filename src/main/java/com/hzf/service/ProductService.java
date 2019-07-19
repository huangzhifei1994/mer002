package com.hzf.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.hzf.dao.ProductMapper;
import com.hzf.dto.ProductDto;
import com.hzf.model.MesPlan;
import com.hzf.model.Order;
import com.hzf.model.Product;
import com.hzf.util.BeanValidator;
import com.hzf.util.MyStringUtils;
import com.hzf.util.UUIDUtil;
import com.hzf.dto.SearchProductDto;
import com.hzf.exception.SysMineException;
import com.google.common.base.Preconditions;
import com.hzf.beans.PageQuery;
import com.hzf.beans.PageResult;
import com.hzf.dao.MesPlanMapper;
import com.hzf.dao.OrderMapper;
import com.hzf.dao.ProductCustomerMapper;
import com.hzf.dao.ProductMapper;
import com.hzf.param.ProductVo;
import com.hzf.param.SearchProductParam;
@Service
public class ProductService {
	@Resource
	private ProductMapper prodcuctMapper;
	
	@Resource
	private ProductCustomerMapper ProductCustomerMapper;
	@Resource
	private SqlSession sqlSession;
	//批量启动
	public void batchStart(String ids) {
		if (ids != null && ids.length() > 0) {
			// 批量处理的sqlSession代理
			String[] idArray = ids.split("&");
	       ProductCustomerMapper.batchStart(idArray);
			
			
			
		}
		
	}
	
	private void batchStockPre(Integer id, ProductMapper mapper) {
		// TODO Auto-generated method stub
		if(id!=null) {
			Product product=mapper.selectByPrimaryKey(id);
			if(product!=null) {
				
			}
			
		}
	}

	public void productBatchInserts(ProductVo productVo) {
		// TODO Auto-generated method stub
		// 校验
				BeanValidator.check(productVo);
				// 获取增加个数
				Integer counts = productVo.getCount();
				if (counts != null && counts > 0) {
					for (int i = 0; i < counts; i++) {
						// 批量增加-productDto
						Product pd = Product.builder().productId(UUIDUtil.generateUUID())//
								.productTargetweight(productVo.getProductTargetweight())//
								.productRealweight(productVo.getProductRealweight())//
								.productLeftweight(productVo.getProductLeftweight())//
								.productBakweight(productVo.getProductLeftweight())//
								.productIrontype(productVo.getProductIrontype())//
								.productIrontypeweight(productVo.getProductIrontypeweight())//
								.productMaterialname(productVo.getProductMaterialname())//
								.productImgid(productVo.getProductImgid())//
								.productMaterialsource(productVo.getProductMaterialsource())//
								.productStatus(productVo.getProductStatus())//
								.productRemark(productVo.getProductRemark())
								.furnacenumber(productVo.getFurnacenumber()).build();
						pd.setProductOperateIp("127.0.0.1");
						pd.setProductOperateTime(new Date());
						pd.setProductOperator("user01");
						ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
						// 批量增加
						mapper.insertSelective(pd);
					}
				}
	}
	public PageResult<ProductDto> searchPageList(SearchProductParam param, PageQuery page) {
	
		// 校验
		BeanValidator.check(page);
		// vo-dto
		SearchProductDto dto = new SearchProductDto();
	
		if (StringUtils.isNotBlank(param.getKeyword())) {
			dto.setKeyword("%" + param.getKeyword() + "%");
		}
		if (StringUtils.isNotBlank(param.getSearch_source())) {
			dto.setSearch_source(param.getSearch_source());
			;
		}
		if (param.getSearch_status() != null) {
			dto.setSearch_status(param.getSearch_status());
		}
		int count=ProductCustomerMapper.countBySearchDto(dto);
		if (count > 0) {
			List<ProductDto> productList = ProductCustomerMapper.getPageListBySearchDto(dto, page);
			return PageResult.<ProductDto>builder().total(count).data(productList).build();
		}

		return PageResult.<ProductDto>builder().build();
	}

	public void update(ProductVo productVo) {
		BeanValidator.check(productVo);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Product before = prodcuctMapper.selectByPrimaryKey(productVo.getId());
		//Preconditions.checkNotNull(before, "待更新材料不存在");
		try {
			Product pds = Product.builder().id(productVo.getId())//
					.productTargetweight(productVo.getProductTargetweight())//
					.productRealweight(productVo.getProductRealweight())//
					.productLeftweight(productVo.getProductLeftweight())//
					.productBakweight(productVo.getProductLeftweight())//
					.productIrontype(productVo.getProductIrontype())//
					.productIrontypeweight(productVo.getProductIrontypeweight())//
					.productMaterialname(productVo.getProductMaterialname())//
					.productImgid(productVo.getProductImgid())//
					.productMaterialsource(productVo.getProductMaterialsource())//
					.productStatus(productVo.getProductStatus())//
					.productRemark(productVo.getProductRemark())
					.furnacenumber(productVo.getFurnacenumber()).build();
			
			// TODO
			pds.setProductOperateIp("127.0.0.1");
			pds.setProductOperateTime(new Date());
			pds.setProductOperator("user01");
			System.out.println("pds----->"+pds);
			prodcuctMapper.updateByPrimaryKeySelective(pds);
		} catch (Exception e) {
			throw new SysMineException("更改过程有问题");
		}
	}

	
	class IdGenerator{
		private Long currentdbidscount;
		private List<String> ids = new ArrayList<String>();
		private String idpre;
		private String idafter;
		
		public List<String> initIds(Long ocounts) {
			for (int i = 0; i < ocounts; i++) {//zx 
				this.ids.add(getIdPre()+ getIdAfter(i));
				
			}
			return this.ids;
		}

		

		public void setCurrentdbidscount(Long orderCount) {
//			this.currentdbidscount=currentdbidscount;
			this.currentdbidscount=orderCount;
			if(null==this.ids) {
				this.ids=new ArrayList<String>();
			}
			
		}
	
private String getIdAfter(int addcount) {
		
		int goallength = 6;
		System.out.println(this.currentdbidscount);
		System.out.println(this.currentdbidscount.intValue());
		int count = this.currentdbidscount.intValue() + 1 + addcount;
		StringBuilder sBuilder = new StringBuilder("");
		
		int length = goallength - new String(count + "").length();
		for (int i = 0; i < length; i++) {
			sBuilder.append("0");
		}
		sBuilder.append(count + "");
		return sBuilder.toString();
	}

	private String getIdPre() {
		
		this.idpre = "ZX-p-";
		return this.idpre;
	}
	}
	}


