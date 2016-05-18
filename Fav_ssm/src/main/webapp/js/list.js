function add() {
	window.open('page/add.html','newwindow',
				'height=300, width=440, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');
}
function listFavoritesByTag(tname){
	//alert(tname);//测试点击事件
	
	//怎么发异步请求
	$.post("listFav.action",{tname:tname},function(data){
	//	alert(data); //测试点击事件
		var clickStr="";
		for(var i=0;i<data.length;i++){
			clickStr +='<div style="padding:6px 10px;"></div>'+
			'<a href="' + data[i].furl +'" style="color: blue;font-size: 18px;" target="_blank">'+
			data[i].flabel + '</a></div>'+
			'<div style="color:black;font-size:16px;">'+data[i].fdesc +'</div>' +
			'<div style="color:green;fontsize:14px;">' + data[i].furl +'</div></div>'
		}
		$("#clinks").html(clickStr);
	},"json");
	
}