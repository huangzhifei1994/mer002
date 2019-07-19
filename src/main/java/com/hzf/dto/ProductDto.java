package com.hzf.dto;

import java.util.Date;

import javax.validation.constraints.Min;

import com.hzf.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	@Min(1)
	private Integer count=1;
	
	  private Integer id;
	  private Product parent;

	    private Integer pId;

	    private String productId;

	    private Integer productOrderid;

	    private Integer productPlanid;

	    private Float productTargetweight;//工艺重量

	    private Float productRealweight;//投料重量

	    private Float productLeftweight;//剩余重量

	    private Float productBakweight;//备份重量用于绑定

	    private String productIrontype;//钢锭类型

	    private Float productIrontypeweight;//锭型

	    private String productMaterialname;//材料名称

	    private String productImgid;//图号

	    private String productMaterialsource;

	    private Integer productStatus;//状态

	    private String productRemark;//备注
	   

	    private String productOperator;

	    private Date productOperateTime;

	    private String productOperateIp;

	    private String furnacenumber;
}
