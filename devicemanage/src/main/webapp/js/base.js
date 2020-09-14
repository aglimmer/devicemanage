// 工具函数
// 弹出提示框
function messagePop(msg) {
	var div = document.createElement("div");
	div.id = "messageid";
	div.innerHTML = msg;
	document.body.appendChild(div);
	div.style.display = "block";
	setTimeout(function() {
		div.style.display = "none";
	}, 3000);
}
// 日期字符串格式化
function dateStringFormat(datestr) {
	var now = new Date(datestr);
	//格式化日，如果小于9，前面补0
	var day = ("0" + now.getDate()).slice(-2);
	//格式化月，如果小于9，前面补0
	var month = ("0" + (now.getMonth() + 1)).slice(-2);
	//拼装完整日期格式
	var today = now.getFullYear() + "-" + (month) + "-" + (day);
	return today;
}
