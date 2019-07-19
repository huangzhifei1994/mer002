<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>计划管理</title>
<!-- jsp动态导入 -->
<%-- <jsp:include page="/common/backend_common.jsp" />
<jsp:include page="/common/page.jsp" />
<jsp:include page="/template/orderListTemplate.jsp" /> --%>
<%@ include file="/common/backend_common.jsp" %>
<%@ include file="/template/product/productBindTemplate.jsp" %>
<%@ include file="/template/product/productBoundTemplate.jsp" %>
 <script src="product.js"></script> 
</head>
<body class="no-skin" youdao="bind" style="background: white">
	<input id="gritter-light" checked="" type="checkbox"
		class="ace ace-switch ace-switch-5" />
	<div class="page-header">
		<h1>
			材料管理 <small><i class="ace-icon fa fa-angle-double-right"></i>
				创建与查询 </small>
		</h1>
	</div>
	<div class="main-content-inner">
		<div class="col-sm-12">
			<div class="col-xs-6">
			 <div class="col-xs-12" > 
				<div class="table-header">
					未绑定材料列表&nbsp;&nbsp; <!-- <a class="green" href="#"> <i
						class="ace-icon fa fa-plus-circle orange bigger-130 order-add"></i>
					</a>-->
				</div> 
				<div>
					<div id="dynamic-table_wrapper"
						class="dataTables_wrapper form-inline no-footer">
						<div class="row" style="position:relative;height:90%">
							<div class="col-xs-12">
						<div class="dataTables_length" id="dynamic-table_length">
					钢材编号<input id="productLeftweight2" type="text"
						name="productLeftweight" value="${product.productId}"
						class="text ui-widget-content ui-corner-all">
						&nbsp;&nbsp;&nbsp;理论剩余重量<input class="left-weight"type="text" readonly="readonly" value="">			  
					&nbsp;剩余重量
					<input class="left-weight"type="text" readonly="readonly" value="">		
						<input type="hidden" value="0" name="search_status" id="search_status"/>
					
					
									  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;材料来源 <select
										id="search_msource" name="search_msource"
										aria-controls="dynamic-table" class="form-control input-sm">
											<option value=""></option>
											<option value="钢锭">钢锭</option>	
											<option value="废料">废料</option>
											<option value="外协件">外协件</option>
											<option value="外购件">外购件</option>
											<option value="钢材">钢材</option>
									</select>
									
										<button class="btn btn-info fa fa-check research"
										style="margin-bottom: 6px;" type="button">刷新</button>
								 
						</div>
						
				</div>	
										
						

						
						<table id="dynamic-table"
							class="table table-striped table-bordered table-hover dataTable no-footer"
							role="grid" aria-describedby="dynamic-table_info"
							style="font-size: 14px">
							<thead>
								<tr role="row">
									<input type="hidden" id="id" name="id" class="id" />
											
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">材料自编号</th>
									
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">材料名称</th>
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">材料来源</th>
									
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">投料重量</th>
									
									 <th class="sorting_disabled" rowspan="1" colspan="1"
										aria-label="">操作</th> 
								</tr>
							</thead>
						 <tbody id="productList"></tbody>
						</table>
						<div class="row" id="productPage"></div>
					</div> 
				</div>
			</div>
			</div>
			</div>
		<div class="col-xs-6" >
			<div class="col-xs-13">
				<div class="table-header">
					已绑定材料列表&nbsp;&nbsp; <a class="green" href="#"> 
					</a>
				</div> 
						</div>
						<table id="dynamic-table"
							class="table table-striped table-bordered table-hover dataTable no-footer"
							role="grid" aria-describedby="dynamic-table_info"
							style="font-size: 14px">
							<thead>
								<tr role="row">
									<input type="hidden" id="id" name="id" class="id" />
											
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">材料自编号</th>
									
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">材料名称</th>
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">材料来源</th>
									
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">投料重量</th>
									
									 <th class="sorting_disabled" rowspan="1" colspan="1"
										aria-label="">操作</th> 
								</tr>
							</thead>
						 <tbody id="productBoundList"></tbody>
						</table>
						<div class="row" id="productPage"></div>
					</div> 
				</div>
			</div>
			</div>
		</div>
	</div> 
</div>
</body>
</html>