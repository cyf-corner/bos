/**
 * 使用ajax加载数据字典，在特定标签对象内插入与数据字典相关联的select标签对象
 * @param typecode		数据字典类型
 * @param positionId	select标签对象要插入的标签对象id属性值
 * @param selectname	select标签对象的name属性值
 * @param selectdId		需要回显时(修改信息时可出现该情况)，选中哪个option
 */
function loadSelect(typecode, positionId, selectname, selectedId) {
	// 1、创建select标签对象，将name属性锁定
	var $select = $("<select name=" + selectname + "></select>");
	// 2、添加提示选项
	$select.append($("<option value=''>----请选择----</option>"));
	// 3、通过ajax访问后台
	$.post("${pageContext.request.contextPath}/BaseDictAction", {
		dict_type_code : typecode
	}, function(data) {
		// 4、对返回的json数组对象进行遍历，每次遍历创建一个option标签对象，最终添加到select标签对象中
		$.each(data, function(i, json) {
			var $option = $("<option value='" + json['dict_id'] + "'>" + json['dict_item_name'] + "</option>");
			if (json['dict_id'] == selectedId) {// 此处判断是否需要回显
				$option.attr("selected", "selected");
			}
			$select.append($option);
		});
	}, "json");
	// 5、将组装好的select标签对象插入页面指定id属性的标签对象中
	$("#" + positionId).append($select);
}