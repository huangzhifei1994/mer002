<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div id="dialog-productUpdate-form" style="display: none;">
		<form id="productUpdateForm">
			<table
				class="table table-striped table-bplaned table-hover dataTable no-footer"
				role="grid">
				<input type="hidden" value="" name="id" id="id2"/>
				<tr>
					<td><label for="productImgid">图号</label></td>
					<td><input id="productImgid2" type="text" name="productImgid" value=""
						class="text ui-widget-content ui-corner-all"></td>
					<td><label for="productMaterialname">材料名称</label></td>
					<td><input id="productMaterialname2" type="text"
						name="productMaterialname" value=""
						class="text ui-widget-content ui-corner-all"></td>
				</tr>
				<tr>
					<td><label for="productMaterialsource">材料来源</label></td>
					<td><select id="productMaterialsource2" name="productMaterialsource"
						data-placeholder="选择类型" style="width: 150px;">
							<option value="钢材">钢材</option>
							<option value="废料">废料</option>
							<option value="外协件">外协件</option>
							<option value="外购件">外购件</option>
							<option value="钢锭">钢锭</option>
					</select></td>
					<td><label for="productTargetweight">工艺重量</label></td>
					<td><input id="productTargetweight2" type="number"
						name="productTargetweight" value=""
						class="text ui-widget-content ui-corner-all"></td>
				</tr>
				<tr>
					<td><label for="productRealweight">投料重量</label></td>
					<td><input id="productRealweight2" type="number"
						name="productRealweight" value=""
						class="text ui-widget-content ui-corner-all"></td>
					<td><label for="productLeftweight">剩余重量</label></td>
					<td><input id="productLeftweight2" type="number"
						name="productLeftweight" value=""
						class="text ui-widget-content ui-corner-all"></td>
				</tr>
				<tr>
					<td><label for="productIrontypeweight">锭型</label></td>
					<td><input id="productIrontypeweight2" type="number"
						name="productIrontypeweight" value=""
						class="text ui-widget-content ui-corner-all"></td>
					<td><label for="productIrontype">钢锭类别</label></td>
					<td><input id="productIrontype2" type="text"
						name="productIrontype" value=""
						class="text ui-widget-content ui-corner-all"></td>
				</tr>
				<tr>
				<td><label for="furnacenumber">炉号</label></td> 
						<td><input id="furnacenumber2" type="text"
							name="furnacenumber" value=""
							class="text ui-widget-content ui-corner-all"></td>
					<td><label for="productRemark">备注</label></td>
					<td><input id="productRemark2" type="text" name="productRemark"
						value="" class="text ui-widget-content ui-corner-all"></td>
				</tr> 
			</table>
		</form>
	</div>