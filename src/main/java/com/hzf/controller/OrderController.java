package com.hzf.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzf.model.Order;
import com.hzf.param.SearchOrderParam;
import com.hzf.beans.PageQuery;
import com.hzf.beans.PageResult;
import com.hzf.common.JsonData;
import com.hzf.param.MesOrderVo;
import com.hzf.service.OrderService;

///order/orderBatch.page
@Controller
@RequestMapping("/order")
public class OrderController {

	private static String FPATH = "order/";

	@Resource
	private OrderService orderService;
	@RequestMapping("/orderBc.page")
	public String orderPage() {
		return FPATH+"orderBc";
	}
	
	
	@RequestMapping("/orderBatch.page")
	public String orderBatchPage() {
		return FPATH + "orderBatch";
	}

	@RequestMapping("/order.json")
	@ResponseBody
	public JsonData searchPage(SearchOrderParam param, PageQuery page) {
		PageResult<Order> pr = (PageResult<Order>) orderService.searchPageList(param, page);
		return JsonData.success(pr);
	}

	@ResponseBody
	@RequestMapping("/insert.json")
	public JsonData insertAjax(MesOrderVo mesOrderVo) {
		System.out.println("lll");
		orderService.orderBatchInserts(mesOrderVo);
		System.out.println("meishi");
		return JsonData.success();

	}

	@RequestMapping("/update.json")
	@ResponseBody
	public JsonData updateOrder(MesOrderVo mesOrderVo) {
		orderService.update(mesOrderVo);
		return JsonData.success();
	}

}
