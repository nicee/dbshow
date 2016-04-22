//去掉所有空格
function trim(str){
	return str.replace(/\s+/g,"");
}

//检查是否为空
function isEmpty(str){
	if(str == '' || str.length == 0){
		return true;
	}
	return false;
}

//获取上下文
function getContextPath() {
    var webroot=document.location.href;
    webroot=webroot.substring(webroot.indexOf('//')+2,webroot.length);
    webroot=webroot.substring(webroot.indexOf('/')+1,webroot.length);
    webroot=webroot.substring(0,webroot.indexOf('/'));
    var rootpath="/"+webroot;
    return rootpath;
}

function jumpPage(page){
	$("#page").val(page);
	document.forms[0].submit();
}
	
function commit(totalPages){
	var reg = /^\d+$/;
	if(!$("#tiaozhuanzhi").val().match(reg)){
		alert("输入页码必须为数字");
		return;
	}
	if(parseInt($("#tiaozhuanzhi").val())<1){
		alert("输入页码能小于1");
		return;
	}
	if(parseInt($("#tiaozhuanzhi").val())>totalPages){
		alert("输入页码能大于总页数");
		return;
	}
	jumpPage($("#tiaozhuanzhi").val());
}

function refresh(){
	window.location.reload();
}