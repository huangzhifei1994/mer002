package com.hzf.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import com.hzf.model.Order;
import com.hzf.util.BeanValidator;
import com.hzf.util.MyStringUtils;
import com.hzf.exception.SysMineException;
import com.hzf.service.OrderService.IdGenerator;
import com.hzf.dao.MesOrderCustomerMapper;
import com.google.common.base.Preconditions;

import com.hzf.beans.PageQuery;
import com.hzf.beans.PageResult;
import com.hzf.dto.SearchOrderDto;
import com.hzf.exception.ParamException;
import com.hzf.param.SearchOrderParam;
import com.hzf.dao.OrderMapper;
import com.hzf.param.MesOrderVo;


@Service
public class OrderService {
@Resource
private OrderMapper mesOrderMapper;
@Resource
private SqlSession sqlSession;
@Resource
private MesOrderCustomerMapper mesOrderCustomerMapper;

private IdGenerator ig=new IdGenerator();


public void batchStart(String ids) {
	// 144&143--order(id)
	if (ids != null && ids.length() > 0) {
		// 批量处理的sqlSession代理
		String[] idArray = ids.split("&");
       mesOrderCustomerMapper.batchStart(idArray);
		
//		planService.startPlansByOrderIds(idArray);
		
	}
	
	
}

public void update(MesOrderVo mesOrderVo) {
	BeanValidator.check(mesOrderVo);
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Order before = mesOrderMapper.selectByPrimaryKey(mesOrderVo.getId());
	Preconditions.checkNotNull(before, "待更新材料不存在");
	try {
		Order after = Order.builder().id(mesOrderVo.getId())
				.orderClientname(mesOrderVo.getOrderClientname())//
				.orderProductname(mesOrderVo.getOrderProductname()).orderContractid(mesOrderVo.getOrderContractid())//
				.orderImgid(mesOrderVo.getOrderImgid()).orderMaterialname(mesOrderVo.getOrderMaterialname())
				.orderCometime(MyStringUtils.string2Date(mesOrderVo.getComeTime(), null))//
				.orderCommittime(MyStringUtils.string2Date(mesOrderVo.getCommitTime(), null))
				.orderInventorystatus(mesOrderVo.getOrderInventorystatus()).orderStatus(mesOrderVo.getOrderStatus())//
				.orderMaterialsource(mesOrderVo.getOrderMaterialsource())
				.orderHurrystatus(mesOrderVo.getOrderHurrystatus()).orderStatus(mesOrderVo.getOrderStatus())
				.orderRemark(mesOrderVo.getOrderRemark()).build();

		
		// TODO
		after.setOrderOperator("tom");
		after.setOrderOperateIp("127.0.0.1");
		after.setOrderOperateTime(new Date());
		mesOrderMapper.updateByPrimaryKeySelective(after);
	} catch (Exception e) {
		throw new SysMineException("更改过程有问题");
	}
}

public void addOrder(MesOrderVo mesOrderVo) {
	BeanValidator.check(mesOrderVo);
	try {
	
					Order mesorder = Order.builder().orderId(mesOrderVo.getOrderId())
							.orderClientname(mesOrderVo.getOrderClientname())//
							.orderProductname(mesOrderVo.getOrderProductname()).orderContractid(mesOrderVo.getOrderContractid())//
							.orderImgid(mesOrderVo.getOrderImgid()).orderMaterialname(mesOrderVo.getOrderMaterialname())
							.orderCometime(MyStringUtils.string2Date(mesOrderVo.getComeTime(), null))//
							.orderCommittime(MyStringUtils.string2Date(mesOrderVo.getCommitTime(), null))
							.orderInventorystatus(mesOrderVo.getOrderInventorystatus()).orderStatus(mesOrderVo.getOrderStatus())//
							.orderMaterialsource(mesOrderVo.getOrderMaterialsource())
							.orderHurrystatus(mesOrderVo.getOrderHurrystatus()).orderStatus(mesOrderVo.getOrderStatus())
							.orderRemark(mesOrderVo.getOrderRemark()).build();

			
					mesorder.setOrderOperator("tom");
					mesorder.setOrderOperateIp("127.0.0.1");
					mesorder.setOrderOperateTime(new Date());
					mesOrderMapper.insertSelective(mesorder);
					
	} catch (Exception e) {
		// TODO: handle exception
		throw new SysMineException(e + "添加单个订单出现问题");
	}
}

public void orderBatchInserts(MesOrderVo mesOrderVo) {

	BeanValidator.check(mesOrderVo);
	Integer counts = mesOrderVo.getCount();

	List<String> ids = createOrderIdsDefault(Long.valueOf(counts));
	//set DIY id 
	OrderMapper mesOrderBatchMapper = sqlSession.getMapper(OrderMapper.class);
	for (String orderid : ids) {
		try {
			System.out.println(orderid);
			Order mesOrder = Order.builder().orderId(orderid)
					.orderClientname(mesOrderVo.getOrderClientname())//
					.orderProductname(mesOrderVo.getOrderProductname()).orderContractid(mesOrderVo.getOrderContractid())//
					.orderImgid(mesOrderVo.getOrderImgid()).orderMaterialname(mesOrderVo.getOrderMaterialname())
					.orderCometime(MyStringUtils.string2Date(mesOrderVo.getComeTime(), null))//
					.orderCommittime(MyStringUtils.string2Date(mesOrderVo.getCommitTime(), null))
					.orderInventorystatus(mesOrderVo.getOrderInventorystatus()).orderStatus(mesOrderVo.getOrderStatus())//
					.orderMaterialsource(mesOrderVo.getOrderMaterialsource())
					.orderHurrystatus(mesOrderVo.getOrderHurrystatus()).orderStatus(mesOrderVo.getOrderStatus())
					.orderRemark(mesOrderVo.getOrderRemark()).build();

		
			// TODO
			mesOrder.setOrderOperator("tom");
			mesOrder.setOrderOperateIp("127.0.0.1");
			mesOrder.setOrderOperateTime(new Date());
//			if(mesOrder.getOrderStatus()==1) {
//			planService.prePlan(mesOrder);
//			}
			mesOrderBatchMapper.insertSelective(mesOrder);
		} catch (Exception e) {
			throw new SysMineException("创建过程有问题");
		}
	}
}

public Object searchPageList(SearchOrderParam param, PageQuery page) {
	
	BeanValidator.check(page);
	
	SearchOrderDto dto = new SearchOrderDto();
	
	if (StringUtils.isNotBlank(param.getKeyword())) {
		dto.setKeyword("%" + param.getKeyword() + "%");
	}
	if (StringUtils.isNotBlank(param.getSearch_status())) {
		dto.setSearch_status(Integer.parseInt(param.getSearch_status()));
	}
	try {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (StringUtils.isNotBlank(param.getFromTime())) {
			dto.setFromTime(dateFormat.parse(param.getFromTime()));
		}
		if (StringUtils.isNotBlank(param.getToTime())) {
			dto.setToTime(dateFormat.parse(param.getToTime()));
		}
	} catch (Exception e) {
		throw new ParamException("传人的日期格式有问题，正确格式为：yyy-MM-dd");
	}

	int count = mesOrderCustomerMapper.countBySearchDto(dto);
	if (count > 0) {
		List<Order> orderList = mesOrderCustomerMapper.getPageListBySearchDto(dto, page);
		return PageResult.<Order>builder().total(count).data(orderList).build();
	}

	return PageResult.<Order>builder().build();
}

public List<String> createOrderIdsDefault(Long ocounts) {//1

	if (ig == null) {
		ig = new IdGenerator();
	
	}

	ig.setCurrentdbidscount(getOrderCount());// get count from database
	List<String> list = ig.initIds(ocounts);
	ig.clear();
	return list;
}

private Long getOrderCount() {
	
	System.out.println("chazhi++"+mesOrderCustomerMapper.getOrderCount());
	return mesOrderCustomerMapper.getOrderCount();
}

class IdGenerator{
	private Long currentdbidscount;
	private List<String> ids = new ArrayList<String>();
	private String idpre;
	private String yearstr;
	private String idafter;
	
	public List<String> initIds(Long ocounts) {
		for (int i = 0; i < ocounts; i++) {//zx 
			this.ids.add(getIdPre() + yearStr() + getIdAfter(i));
			
		}
		return this.ids;
	}

	

	public void setCurrentdbidscount(Long orderCount) {
//		this.currentdbidscount=currentdbidscount;
		this.currentdbidscount=orderCount;
		if(null==this.ids) {
			this.ids=new ArrayList<String>();
		}
		
	}


	private String yearStr() {//
		Date currentdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String yearstr = sdf.format(currentdate).substring(2, 4);
		return yearstr;
	}
	private String getIdAfter(int addcount) {
		
		int goallength = 5;
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
		
		this.idpre = "ZX";
		return this.idpre;
	}
	public void clear() {
	
		this.ids = null;
	}	
	@Override
	public String toString() {
		return "IdGenerator [ids=" +ids+ "]";
	}
}
}
