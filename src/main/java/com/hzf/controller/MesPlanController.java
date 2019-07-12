package com.hzf.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzf.beans.PageQuery;
import com.hzf.beans.PageResult;
import com.hzf.common.JsonData;
import com.hzf.model.MesPlan;
import com.hzf.param.SearchPlanParam;
import com.hzf.service.PlanService;



@Controller
@RequestMapping("/plan")
public class MesPlanController {
private static String FPATH="plan/";
@Resource
private PlanService planService;
@RequestMapping("/plan.page")
public String planPage() {
	return FPATH+"plan";
}
@RequestMapping("/planStarted.page")
public String planStartedPage() {
	return FPATH+"planStarted";
}
//分页显示
@RequestMapping("/plan.json")
@ResponseBody
public JsonData searchPage(SearchPlanParam param, PageQuery page) {
	PageResult<MesPlan> pr=(PageResult<MesPlan>) planService.searchPageList(param, page);
	return JsonData.success(pr);
}
}
