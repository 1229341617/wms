//加载当前日期
function loadDate() {
    var time = new Date();
    var myYear = time.getFullYear();
    var myMonth = time.getMonth() + 1;
    var myDay = time.getDate();
    if (myMonth < 10) {
        myMonth = "0" + myMonth;
    }
    document.getElementById("day_day").innerHTML = myYear + "." + myMonth + "." + myDay;
}

/**
 * 隐藏或者显示侧边栏
 *
 **/
function switchSysBar(flag) {
    var side = $('#side');
    var left_menu_cnt = $('#left_menu_cnt');
    if (flag == true) {	// flag==true
        left_menu_cnt.show(500, 'linear');
        side.css({width: '280px'});
        $('#top_nav').css({width: '77%', left: '304px'});
        $('#main').css({left: '280px'});
    } else {
        if (left_menu_cnt.is(":visible")) {
            left_menu_cnt.hide(10, 'linear');
            side.css({width: '60px'});
            $('#top_nav').css({width: '100%', left: '60px', 'padding-left': '28px'});
            $('#main').css({left: '60px'});
            $("#show_hide_btn").find('img').attr('src', '/images/common/nav_show.png');
        } else {
            left_menu_cnt.show(500, 'linear');
            side.css({width: '280px'});
            $('#top_nav').css({width: '77%', left: '304px', 'padding-left': '0px'});
            $('#main').css({left: '280px'});
            $("#show_hide_btn").find('img').attr('src', '/images/common/nav_hide.png');
        }
    }
}



//=========================zTree

var setting = {
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onClick: function(event,treeId,treeNode) {
				if(treeNode.action){
					$("#rightMain").prop("src",treeNode.action + ".action");
					$("#here_area").html("当前位置："+treeNode.getParentNode().name+"&nbsp;->"+treeNode.name+"");
				}
			}
		}
	};
var zNodes={
		'business':[
		            { id:1, pId:0, name:"业务管理", isParent:true},
		            { id:11, pId:1, name:"a"},
		            { id:12, pId:1, name:"b"},
		            { id:13, pId:1, name:"c"},
		            { id:14, pId:1, name:"d"}
		            ],
		'system':[
			{ id:1, pId:0, name:"系统管理", isParent:true},
			{ id:11, pId:1, name:"员工管理",action:"employee"},
			{ id:12, pId:1, name:"部门管理",action:"department"},
			{ id:13, pId:1, name:"权限管理",action:"permission"},
			{ id:14, pId:1, name:"角色管理",action:"role"}
		],
		'chart':[
			{ id:1, pId:0, name:"报表管理", isParent:true},
			{ id:11, pId:1, name:"e"},
			{ id:12, pId:1, name:"f"},
			{ id:13, pId:1, name:"g"},
			{ id:14, pId:1, name:"h"}
		]
};

function loadMenu(sn){
	$.fn.zTree.init($("#dleft_tab1"), setting, zNodes[sn]);
}

//=========================zTree







$(function () {
	loadMenu("business");
	
	$("#TabPage2 li").click(function(){
		$.each($("#TabPage2 li"),function(index,item){
			$(this).removeClass("selected");
			$(this).children("img").prop("src","images/common/"+(index + 1)+".jpg");
		});
		$(this).addClass("selected");
		$(this).children("img").prop("src","images/common/"+($(this).index() + 1)+"_hover.jpg");
		$("#nav_module img").prop("src","images/common/module_"+($(this).index() + 1)+".png");
		
		loadMenu($(this).data("rootmenu"));
	});
	
	//加载日期
    loadDate();
    // 显示侧边栏
    switchSysBar(true);
    // 显示隐藏侧边栏
    $("#show_hide_btn").click(function () {
        switchSysBar();
    });
});
