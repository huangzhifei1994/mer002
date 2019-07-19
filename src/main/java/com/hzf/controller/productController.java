package com.hzf.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hzf.dto.ProductDto;
import com.hzf.beans.PageQuery;
import com.hzf.beans.PageResult;
import com.hzf.common.JsonData;
import com.hzf.common.SameUrlData;
import com.hzf.model.Product;
import com.hzf.param.ProductVo;
import com.hzf.param.SearchOrderParam;
import com.hzf.param.SearchProductParam;
import com.hzf.service.OrderService;
import com.hzf.service.ProductService;

@Controller
@RequestMapping("/product")
public class productController {
	
	@Resource
	private ProductService productService;
	
	private  String FPATH = "product/";
	@RequestMapping("/productinsert.page")
	public String productinsertPage() {
		return FPATH+"productinsert";
	}
	@RequestMapping("/product.page")
	public String productPage() {
		return FPATH+"product";
	}
	@RequestMapping("/productCome.page")
	public String productComePage() {
		return FPATH+"productCome";
	}
	@RequestMapping("/productIron.page")
	public String productIronPage() {
		return FPATH+"productIron";
	}
	@RequestMapping("/productBindList.page")
	public String productBindListpage() {
		return FPATH+"productBindList";
	}
	@RequestMapping("/productBind.page")
	public String productBindpage() {
		System.out.println("111");
		return FPATH+"productBind";
	}
	@RequestMapping("/product.json")
	@ResponseBody
    public JsonData searchPage(SearchProductParam param, PageQuery page) {
    	PageResult<ProductDto> pr=(PageResult<ProductDto>) productService.searchPageList(param, page);
    	return JsonData.success(pr);
    }
	@ResponseBody
	@SameUrlData
	@RequestMapping("/insert.json")
	public JsonData insertAjax(ProductVo productVo) {
		productService.productBatchInserts(productVo);//batch 批量
		return JsonData.success();
	}
	@SameUrlData
	@ResponseBody
	@RequestMapping("/productBatchStart.json")
	public JsonData productBatchStart(String ids) {
		productService.batchStart(ids);
		return JsonData.success();
	}


	@ResponseBody
	@RequestMapping("/update.json")
	public JsonData UpdateProduct(ProductVo productVo) {
		productService.update(productVo);
		System.out.println(productVo);
		return JsonData.success(true);
	}
	
}
