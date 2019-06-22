/**加载权限*/
$(function(){
	$(".btn_permission_load").click(function(){
		var url = $(this).data("url");
		$.dialog({
			title:"提示",
			content:"亲，重新加载权限可能会耗费很长的时间，确定加载？",
			icon:"face-smile",
			cancel:true,
			ok:function(){
				var dialog = $.dialog({
					title:"操作提示",
					icon:"face-smile",
				});
				$.get(url,function(){
					dialog.content("权限加载完毕！").button({
						name:"确定",
						callback:function(){
							window.location.reload();
						}
					});
				});
			}
		});
	});
	
});