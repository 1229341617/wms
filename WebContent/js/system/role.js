/**1.权限移动操作*/
$(function(){
	$("#select").click(function(){
		$(".left option:selected").appendTo(".right");
	});
	$("#selectAll").click(function(){
		$(".left option").appendTo(".right");
	});
	$("#deselect").click(function(){
		$(".right option:selected").appendTo(".left");
	});
	$("#deselectAll").click(function(){
		$(".right option").appendTo(".left");
	});
});

/**2.删除左边权限中出现在右边的权限*/
$(function(){
	var values = $.map($(".right option"),function(item){
		return item.value;
	});
	$.each($(".left option"),function(index,item){
		if($.inArray(item.value,values) >= 0){
			$(item).remove();
		}
	});
	
	/*var values = [];
	$(".right option").each(function(index, item){
		values[index] = item.value;
	});
	$.each($(".left option"),function(index,item){
		if($.inArray(item.value,values) >= 0){
			$(item).remove();
		}
	});*/
	
	/*$(".left option").attr("value",function(index1, value1){
		$(".right option").attr("value",function(index2,value2){
			if(value1 == value2){
				$(".left option[value='" + value1 + "']" ).remove();
			}
		}) 
	});*/
});


/**3.菜单移动操作*/
$(function(){
	$("#mselect").click(function(){
		$(".mleft option:selected").appendTo(".mright");
	});
	$("#mselectAll").click(function(){
		$(".mleft option").appendTo(".mright");
	});
	$("#mdeselect").click(function(){
		$(".mright option:selected").appendTo(".mleft");
	});
	$("#mdeselectAll").click(function(){
		$(".mright option").appendTo(".mleft");
	});
});

/**4.删除左边菜单中出现在右边的菜单*/
$(function(){
	var values = $.map($(".mright option"),function(item){
		return item.value;
	});
	$.each($(".mleft option"),function(index,item){
		if($.inArray(item.value,values) >= 0){
			$(item).remove();
		}
	});
});



/**5.在表单提交前，把所有已经分配的权限和菜单设置为选中状态，如此才能提交保存成功*/
/*$(function(){
	$(".submit").click(function(){
		$.each($(".right option"),function(index,item){
			item.selected = true;
		});
		$.each($(".mright option"),function(index,item){
			item.selected = true;
		});
	});
});*/



$(function(){
	$("#editForm").submit(function(){
		$(".right option").prop("selected",true);
	});
	$("#editForm").submit(function(){
		$(".mright option").prop("selected",true);
	});
});
