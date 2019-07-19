package com.hzf.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hzf.beans.PageQuery;
import com.hzf.beans.PageResult;
import com.hzf.common.JsonData;
import com.hzf.model.Order;
import com.hzf.param.MesOrderVo;
import com.hzf.param.SearchOrderParam;
import com.hzf.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	private static String FPATH="order/";
	
	@Resource
	private OrderService orderService;

	@RequestMapping("/orderBc.page")
	public String orderPage() {
		return FPATH+"orderBc";
	}
	
	//批量处理转发
	@RequestMapping("/orderBatch.page")
	public String orderBatchPage() {
		return FPATH+"orderBatch";
	}
	
	//批量启动处理
	@ResponseBody
	@RequestMapping("/orderBatchStart.json")
	public JsonData orderBatchStart(String ids) {
		orderService.batchStart(ids);
		return JsonData.success();
	}
	
    @RequestMapping("/order.json")
    @ResponseBody
    public JsonData searchPage(SearchOrderParam param, PageQuery page) {
    	PageResult<Order> pr=(PageResult<Order>) orderService.searchPageList(param, page);
    	return JsonData.success(pr);
    }
	
	//添加接收json数据的注解
	@ResponseBody
	@RequestMapping("/insert.json")
	public JsonData insertAjax(MesOrderVo mesOrderVo) {
		orderService.orderBatchInserts(mesOrderVo);//batch 批量
		return JsonData.success();
	}
	
    @RequestMapping("/update.json")
    @ResponseBody
    public JsonData updateOrder(MesOrderVo mesOrderVo) {
    	orderService.update(mesOrderVo);
    	return JsonData.success();
    }
	
}