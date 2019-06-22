jQuery.ajaxSettings.traditional = true;

/**高级查询加分页操作*/
$(function(){
	//限定页面的页码选择范围
	$("input[name='qo.currentPage']")
				.prop("type","number")
				.css("width","40px")
				.prop("min",1)
				.prop("max",$(".totalPage").data("page"));
	//分页操作(指定页码跳转无值就前后首末跳转，以指定页码跳转为主)
	$(".btn_page").click(function(){
		var pageNo = $(this).data("page") || $("input[name='qo.currentPage']").val();
		$("input[name='qo.currentPage']").val(pageNo);
		$("#searchForm").submit();
	});
	//改变当前页面大小
	$(":input[name='qo.pageSize']").change(function(){
		$("#searchForm").submit();
	});
//	//手动跳转到指定页面合并到翻页中
//	$(".btn_go").click(function(){
//		$("#searchForm").submit();
//	});
});

/**点击按钮，打开另一个页面*/
$(function(){
		$(".btn_redirect").click(function(){
			window.location.href= $(this).data("url");
		});
	})

/** table鼠标悬停换色* */
$(function() {
	// 如果鼠标移到行上时，执行函数
	$(".table tr").mouseover(function() {
		$(this).css({background : "#CDDAEB"});
		$(this).children('td').each(function(index, ele){
			$(ele).css({color: "#1D1E21"});
		});
	}).mouseout(function() {
		$(this).css({background : "#FFF"});
		$(this).children('td').each(function(index, ele){
			$(ele).css({color: "#909090"});
		});
	});
});

//删除操作
$(function(){
	$(".btn_delete").click(function(){
		var url = $(this).data("url");
		$.dialog({
			title:"提示",
			icon:"face-smile",
			content:"确定删除？",
			ok:function(){
				var dialog = $.dialog({
					title:"操作提示",
					icon:"face-smile",
					ok:true
				});
				$.get(url, function(data){
					dialog.content(data).button({
						name:"确定",
						callback:function(){
							window.location.reload();
						}
					});
				});
			},
			cancel:true
		});
		
	});
});

//批量删除
$(function(){
	//1.1:全选/全不选
	$("#all").click(function(){
		$(".acb").prop("checked",this.checked);
	});
	//1.2:得到ids并发送ajax请求
	$(".btn_batch_delete").click(function(){
		var ids = [];
		/*$.each($(".acb:checked"), function(index, item){
			ids[index] = $(item).data("eid");
		});*/
		ids = $.map($(".acb:checked"), function(item){
			return $(item).data("eid");
		});
		if(ids.length == 0){
			$.dialog({
				title:"提示",
				icon:"face-smile",
				content:"请选择需要删除的选项！",
				ok:true
			});
			return;
		}
		//此时发现数组参数会多一个【】，此时需要禁用  将表单元素数组或者对象序列化 功能：
		//在公共页面中加上：jQuery.ajaxSettings.traditional = true; 禁用它
		$.dialog({
			title:"提示",
			content:"确定删除选中的选项?",
			icon:"face-smile",
			ok:function(){
				var dialog = $.dialog({
					title:"操作提示",
					icon:"face-smile",
					ok:true
				});
				$.get($(".btn_batch_delete").data("url"), {ids:ids},function(){
					dialog.content("删除成功！").button({
						name:"确定",
						callback:function(){
							window.location.reload();//批量删除后重新加载文档
						}
					});
				});
			},
			cancel:true
		});
		
	});
});

//批量切割试卷
$(function(){
	//1.1:全选/全不选
	$("#all").click(function(){
		$(".acb").prop("checked",this.checked);
	});
	//1.2:得到ids并发送ajax请求
	$(".btn_batch_cutpapers").click(function(){
		var ids = [];
		/*$.each($(".acb:checked"), function(index, item){
			ids[index] = $(item).data("eid");
		});*/
		ids = $.map($(".acb:checked"), function(item){
			return $(item).data("eid");
		});
		if(ids.length == 0){
			$.dialog({
				title:"提示",
				icon:"face-smile",
				content:"请选择需要切割的试卷！",
				ok:true
			});
			return;
		}
		//此时发现数组参数会多一个【】，此时需要禁用  将表单元素数组或者对象序列化 功能：
		//在公共页面中加上：jQuery.ajaxSettings.traditional = true; 禁用它
		$.dialog({
			title:"提示",
			content:"确定切割选中的试卷?",
			icon:"face-smile",
			ok:function(){
				var dialog = $.dialog({
					title:"操作提示",
					icon:"face-smile",
					ok:true
				});
				$.get($(".btn_batch_cutpapers").data("url"), {ids:ids},function(){
					dialog.content("操作成功！").button({
						name:"确定",
						callback:function(){
							window.location.reload();//批量删除后重新加载文档
						}
					});
				});
			},
			cancel:true
		});
		
	});
});