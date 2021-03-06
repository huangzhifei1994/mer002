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
<%@ include file="/common/page.jsp" %>
<%@ include file="/template/product/ironListTemplate.jsp" %>
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
			<div class="col-xs-12">
				<div class="table-header">
					材料列表&nbsp;&nbsp; <!-- <a class="green" href="#"> <i
						class="ace-icon fa fa-plus-circle orange bigger-130 order-add"></i>
					</a>-->
				</div> 
				<div>
					<div id="dynamic-table_wrapper"
						class="dataTables_wrapper form-inline no-footer">
						<div class="row">
							<div class="col-xs-12">
								<div class="dataTables_length" id="dynamic-table_length">
									<label> 展示 <select id="pageSize"
										name="dynamic-table_length" aria-controls="dynamic-table"
										class="form-control input-sm">
											<option value="8">8</option>
									</select> 条记录
									</label> <input id="keyword" type="search" name="keyword"
										class="form-control input-sm" placeholder="关键词"
										aria-controls="dynamic-table">
										<input type="hidden" value="钢锭" name="search_msource" id="search_msource"/>
									  
									<label>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;是否到库 <select
										id="search_status" name="search_status"
										aria-controls="dynamic-table" class="form-control input-sm">
											<option value="0">未到库</option>
											<option value="1">已到库</option>
											
									</select>
									</label>  
								
										
									&nbsp;&nbsp;&nbsp;&nbsp;
									<button class="btn btn-info fa fa-check research"
										style="margin-bottom: 6px;" type="button">刷新</button>
								</div>
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
										colspan="1" class="batchStart-th">选择</th>	
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">材料自编号</th>
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">父级自编号</th>
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">材料名称</th>
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">材料来源</th>
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">工艺重量</th>
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">投料重量</th>
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">剩余重量</th>
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">图号</th>
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">钢锭类型</th>
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">锭型</th>
									
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">状态</th>
									<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">备注</th>
										<th tabindex="0" aria-controls="dynamic-table" rowspan="1"
										colspan="1">炉号</th>
									
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
	<%@ include file="productFrom/productUpdateForm.jsp" %>
	<%@ include file="productFrom/productForm.jsp" %>
</body>
</html>