package com.hzf.param;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchOrderDto {
private Integer count=1;
	
    private Integer id;

    private String orderId;

    private String orderClientname;

    private String orderProductname;

    private String orderContractid;

    private String orderImgid;

    private String orderMaterialname;

    private Date orderCometime;

    private Date orderCommittime;

    private Integer orderInventorystatus;

    private String orderSalestatus;

    private String orderMaterialsource;

    private Integer orderHurrystatus;

    private Integer orderStatus;

    private String orderRemark;
    
    @NotBlank(message="开始日期")
    private String comeTime;
    
    @NotBlank(message="结束日期")
    private String commitTime;
    
}
