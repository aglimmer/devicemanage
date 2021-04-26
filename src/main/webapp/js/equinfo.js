var BASE_URL = window.sessionStorage.getItem("BASE_URL");
function borrowFill(obj) {
	// user_id varchar(20),
	// equid int,
	// usi_reason varchar(100),
	// usinumber int,
	// usi_date date,
	// borrowdays int -->
	// var obj = '{"equ_id":3,"fac_id":1,"equ_name":"教室椅把","equ_type":"椅子","equ_purchasedate":"May 2, 2020 12:00:00 AM","equ_purchaser":"范新宇","equ_singleprice":149.0,"equ_unit":"张","equ_spec":"椅子","equ_total":10,"equ_curr":10,"equ_position":"实验楼库房101","del":0}';	
	var info = ["user_id", "equ_id", "equ_name", "equ_type", "equ_unit", "equ_curr", "equ_position", "equ_spec"];
	var js = JSON.parse(obj);
	if (js.equ_curr == 0) {
		messagePop("可借数量为0");
		return;
	}
	document.getElementById("borrowpop").style.display = "block";
	// 用户编号
	// 登录验证
	// js.user_id = window.sessionStorage.getItem("user_id");
	// if(js.user_id==null){
	// 	messagePop("请登录后再进行操作！");
	// 	return;
	// }
	js.user_id = "3182701101";

	for (var i = 0; i < info.length; i++) {
		if (info[i] == "equ_spec") {
			document.getElementById("equ_spec1").value = js[info[i]];
			continue;
		}
		document.getElementById(info[i]).value = js[info[i]];
	}

}

function borrowSend() {
	var info = ["user_id", "equ_id", "usi_date", "usi_day", "usi_size", "usi_reason", "equ_curr"];
	// var js = JSON.parse(info);

	var obj = {};
	for (var i = 0; i < info.length; i++) {
		obj[info[i]] = document.getElementById(info[i]).value;
	}
	if (obj.usi_day == "" || obj.usi_day == 0 || obj.usi_day > 14) {
		messagePop("输入有误，借用不能超14天");
		document.getElementById("usi_day").focus();
		return;
	}
	if (obj.usi_size == "" || obj.usi_size == 0 || obj.usi_size > obj.equ_curr) {
		messagePop("输入有误，数量不能超" + obj.equ_curr);
		document.getElementById("usi_size").focus();
		return;
	}
	if (obj.usi_date == "") {
		messagePop("日期不能为空");
		document.getElementById("usi_date").focus();
		return;
	}
	var param = {};
	param.user_id = obj.user_id;
	param.equ_id = obj.equ_id;
	param.usi_reason = obj.usi_reason;
	param.usi_size = obj.usi_size;
	param.usi_date = obj.usi_date;
	param.usi_day = obj.usi_day;

	$.ajax({
		url: BASE_URL+"/borrowequ.do",
		data: param,
		type: "GET",
		dataType: "json",
		xhrFields: {
			withCredentials: true
		},
		crossDomain: true,
		success: function(data) {
			// 分页查询
			if (data == 1) {
				messagePop("请求发送成功！");
				borrowClose();
			} else {
				messagePop("请求处理失败！");
			}

		}
	});

}

function borrowClose() {
	document.getElementById("borrowpop").style.display = "none";
}
// 删除记录判断
function delinfo(data) {
	var judge = confirm("你确定要永久删除该条记录吗?");
	if (!judge) {
		// 不执行删除
		return;
	}
	var session = window.sessionStorage;
	if(session.getItem("userid")==null){
		session.setItem("usertype","2");
		session.setItem("userid","G0001");
		messagePop("请登录后进行操作");
	}
	var obj = {};
	obj.user_type=session.getItem("usertype");
	obj.adm_id = session.getItem("userid");
	obj.equ_id =JSON.parse(data).equ_id;
	$.ajax({
		url: BASE_URL+"/delequip.do",
		data: obj,
		type: "GET",
		dataType: "json",
		xhrFields: {
			withCredentials: true
		},
		crossDomain: true,
		success: function(data) {
			// 分页查询
			if (data == 1) {
				messagePop("删除成功！");
				initSearchSize(JSON.parse(Page.param),Page.totalsize-1);
			} else {
				messagePop("删除失败！");
			}
	
		}
	});
	
}
// 修改记录弹出框
function modifyinfo(data) {
	var obj = JSON.parse(data);
	var popdiv = document.getElementById('popdiv');
	popdiv.style.display = "block";
	fillInfo(data);
	// var content = popdiv.getElementsByClassName("content")[0];
	// content.innerHTML=obj;
	// content.innerHTML = data;
	// document.getElementById("info").innerHTML = obj;

}
// 获取修改的信息
function saveEquipment() {
	var arr = document.getElementsByName("equ");
	var obj = {};
	for (var i = 0; i < arr.length; i++) {
		if (arr[i].value == "") {
			arr[i].focus();
			messagePop("输入不能为空");
			return;
		}
	}
	obj.equ_id = arr[0].value;
	obj.equ_name = arr[1].value;
	obj.equ_type = arr[2].value;
	obj.equ_purchasedate = arr[3].value;
	obj.equ_purchaser = arr[4].value;
	obj.equ_singleprice = arr[5].value;
	obj.equ_total = arr[6].value;
	obj.equ_curr = arr[7].value;
	obj.equ_position = arr[8].value;
	obj.equ_unit = arr[9].value;
	var spec = document.getElementById("equ_spec");
	obj.equ_spec = spec.value;

	// alert(JSON.stringify(obj));
	$.ajax({
		url: BASE_URL+"/modifyequ.do",
		data: obj,
		type: "GET",
		dataType: "json",
		xhrFields: {
			withCredentials: true
		},
		crossDomain: true,
		success: function(data) {
			// 分页查询
			if (data == 1) {
				messagePop("请求发送成功！");
				borrowClose();
			} else {
				messagePop("请求处理失败！");
			}

		}
	});
}
//要修改的信息呈现到表单中 
function fillInfo(jstr) {
	// var jstr =
	// 	'{"equ_id":1,"fac_id":1,"equ_name":"多媒体教师主控台","equ_type":"多媒体","equ_purchasedate":"Aug 1, 2018 12:00:00 AM","equ_purchaser":"张喜","equ_singleprice":2300,"equ_unit":"套","equ_spec":"屏幕、控制盒","equ_total":1,"equ_curr":1,"equ_position":"工科楼A207","del":0}';
	// messagePop(jstr);
	var obj = JSON.parse(jstr);
	var arr = document.getElementsByName("equ");
	arr[0].value = obj.equ_id;
	arr[1].value = obj.equ_name;
	arr[2].value = obj.equ_type;
	arr[3].value = dateStringFormat(obj.equ_purchasedate);
	arr[4].value = obj.equ_purchaser;
	arr[5].value = obj.equ_singleprice;
	arr[6].value = obj.equ_total;
	arr[7].value = obj.equ_curr;
	arr[8].value = obj.equ_position;
	arr[9].value = obj.equ_unit;
	var spec = document.getElementById("equ_spec");
	spec.value = obj.equ_spec;

}
// 根据总数量进行查询
// obj为查询条件，total符合条件的数量
function initSearchSize(obj, total) {
	if (total == 0) {
		var res = "";
		res = "<h2>未查询到相关记录！</h2>";
		$("#contab").html(res);
		return;
	}
	Page.init(JSON.stringify(obj), total);

	obj.start = 0;
	obj.end = Page.limitsize;
	// Page对象
	$.ajax({
		url: BASE_URL+"/searchequ.do",
		data: obj,
		type: "GET",
		dataType: "json",
		xhrFields: {
			withCredentials: true
		},
		crossDomain: true,
		success: function(data) {
			// 分页查询
			printEquipment(data);
			Page.initPage();
		}
	});
}

function classifyEquipment() {
	// var limitsize = 10;
	var beginpos = (Page.currpage - 1) * Page.limitsize;
	var obj = JSON.parse(Page.param);
	obj.start = beginpos;
	obj.end = Page.limitsize;
	$.ajax({
		url: BASE_URL+"/searchequ.do",
		data: obj,
		type: "GET",
		dataType: "json",
		xhrFields: {
			withCredentials: true
		},
		crossDomain: true,
		success: function(data) {
			// 分页查询
			printEquipment(data);

		}
	});

}


// 点击事件，首次触发
function searchInfo() {

	// HTML:内容
	// CSS: 样子
	// Javascript: 动作
	//Ajax异步访问服务端
	var obj = {};
	obj.type = $("input[name=choice]:checked").val();
	obj.content = $("input[name=message]").val();
	$.ajax({
		url: BASE_URL+"/searchinit.do",
		data: obj,
		type: "GET",
		dataType: "json",
		xhrFields: {
			withCredentials: true
		},
		crossDomain: true,
		success: function(data) {
			initSearchSize(obj, data);
		}
	});
}
// 厂家信息呈现到表单
function fillFact(obj) {
	// var obj = JSON.parse(param);
	var fact = document.getElementsByName("facinfo");
	var heads = ["fac_id", "fac_name", "fac_addr", "fac_phone"];
	for (var i = 0; i < fact.length; i++) {
		fact[i].value = obj[heads[i]];
		fact[i].disabled = "true";
	}
}
// 查询厂家信息并显示
function factInfo(param) {
	var facid = document.getElementById("factid");
	if (param == 0) {
		facid.style.display = "none";
		return;
	}
	// alert(param);
	facid.style.display = "block";
	var obj = {
		id: param
	};
	// alert(obj.id);
	$.ajax({
		url: BASE_URL+"/factinfo.do",
		data: obj,
		type: "Get",
		dataType: "json",
		xhrFields: {
			withCredentials: true
		},
		crossDomain: true,
		success: function(data) {
			fillFact(data);
		},
		error: function(e) {
			messagePop("请求异常！");
			alert(JSON.stringify(e));
		}
	});
}
// 回调函数
function printEquipment(obj) {

	// $("#contab").html(JSON.stringify(data));
	var linetitle = ["设备编号", "设备名称", "设备类型", "设备单位", "规格", "总数量", "可借数量", "存放位置", "操作"];
	var oper = '<span><a href="javascript:void(0)">编辑</a><span>|<span><a href="javascript:void(0)">删除</a><span>';
	var res = "<table class='contab'>";
	var param = "";
	res += "<tr>";
	for (var i = 0; i < linetitle.length; i++) {
		res += "<th>" + linetitle[i] + "</th>";
	}
	res += "</tr>";
	var session = window.sessionStorage;
	var usertype = session.getItem("usertype");

	// usertype = "admin";
	for (var i = 0; i < obj.length; i++) {
		var item = obj[i];
		param = JSON.stringify(item).replace(/"/g, '&quot;');
		// alert(JSON.stringify(item));
		res += "<tr>";
		res += "<td>" + item.equ_id + "</td>";
		res += "<td>" + item.equ_name + "</td>";
		res += "<td>" + item.equ_type + "</td>";
		res += "<td>" + item.equ_unit + "</td>";
		res += "<td>" + item.equ_spec + "</td>";
		res += "<td>" + item.equ_total + "</td>";
		res += "<td>" + item.equ_curr + "</td>";
		res += "<td>" + item.equ_position + "</td>";
		res += "<td><pre>";
		if(item.fac_id!=0){
			res += "<input type=\"button\" value=\"详情\" class=\"btnbase\" onclick=\"factInfo(\'" + item.fac_id + "\')\">&nbsp;";
		}
		
		if (usertype == "2") {
			res += "&thinsp;<input type=\"button\" value=\"修改\" class=\"btnbase\" onclick=\"modifyinfo(\'" + param + "\')\">&nbsp;"
			res += "&thinsp;<input type=\"button\" value=\"删除\" class=\"btnbase\" onclick=\"delinfo(\'" + param + "\')\">";
			// res +='<a href="javascript:void(0)" onclick="delinfo(hello)">删除</a>';
		} else {
			res += "&thinsp;<input type=\"button\" value=\"借用\" class=\"btnbase\" onclick=\"borrowFill(\'" + param + "\')\">";
		}
		res += "</pre></td>";
		res += "</tr>";
	}
	res += "</table>";

	$("#contab").html(res);


	//修改该元素的内容

	// 	res += "<tr>";
	// 	var item = obj.item;
	// 	alert("obj:"+item["equ_id"]);

	// }



}
// 测试方法：数据库查询返回信息
function backjson() {
	// 设备编号（主键）、厂家编号（关联）、类型编号（关联）、设备名称、
	// 采购时间、采购人、单价、设备单位、存放位置
	var jstr =
		'[{"equ_id":3,"fac_id":1,"equ_name":"教室椅把","equ_type":"椅子","equ_purchasedate":"May 2, 2020 12:00:00 AM","equ_purchaser":"范新宇","equ_singleprice":149.0,"equ_unit":"张","equ_spec":"椅子","equ_total":10,"equ_curr":10,"equ_position":"实验楼库房101","del":0},{"equ_id":4,"fac_id":2,"equ_name":"挡水条","equ_type":"条幅","equ_purchasedate":"May 2, 2020 12:00:00 AM","equ_purchaser":"吴红","equ_singleprice":20.9,"equ_unit":"幅","equ_spec":"单条，10m","equ_total":3,"equ_curr":3,"equ_position":"工科楼文娱器材室102","del":0},{"equ_id":5,"fac_id":0,"equ_name":"联想台式电脑H359","equ_type":"联想电脑","equ_purchasedate":"Mar 1, 2020 12:00:00 AM","equ_purchaser":"何亮","equ_singleprice":3500.0,"equ_unit":"套","equ_spec":"主机、显示器、键盘","equ_total":1,"equ_curr":1,"equ_position":"实验楼B212","del":0},{"equ_id":1,"fac_id":1,"equ_name":"多媒体教师主控台","equ_type":"多媒体","equ_purchasedate":"Aug 1, 2018 12:00:00 AM","equ_purchaser":"张喜","equ_singleprice":2300.0,"equ_unit":"套","equ_spec":"屏幕、控制盒","equ_total":1,"equ_curr":1,"equ_position":"工科楼A207","del":0},{"equ_id":2,"fac_id":1,"equ_name":"学生实验桌","equ_type":"桌子、凳子","equ_purchasedate":"May 2, 2020 12:00:00 AM","equ_purchaser":"范新宇","equ_singleprice":135.0,"equ_unit":"张","equ_spec":"桌子，椅子","equ_total":20,"equ_curr":20,"equ_position":"工科楼B309","del":0},{"equ_id":3,"fac_id":1,"equ_name":"教室椅把","equ_type":"椅子","equ_purchasedate":"May 2, 2020 12:00:00 AM","equ_purchaser":"范新宇","equ_singleprice":149.0,"equ_unit":"张","equ_spec":"椅子","equ_total":10,"equ_curr":10,"equ_position":"实验楼库房101","del":0},{"equ_id":4,"fac_id":2,"equ_name":"挡水条","equ_type":"条幅","equ_purchasedate":"May 2, 2020 12:00:00 AM","equ_purchaser":"吴红","equ_singleprice":20.9,"equ_unit":"幅","equ_spec":"单条，10m","equ_total":3,"equ_curr":3,"equ_position":"工科楼文娱器材室102","del":0},{"equ_id":5,"fac_id":0,"equ_name":"联想台式电脑H359","equ_type":"联想电脑","equ_purchasedate":"Mar 1, 2020 12:00:00 AM","equ_purchaser":"何亮","equ_singleprice":3500.0,"equ_unit":"套","equ_spec":"主机、显示器、键盘","equ_total":1,"equ_curr":1,"equ_position":"实验楼B212","del":0}]';
	var name = "张三";
	var sex = "李四";
	var json = {};
	// alert(jstr);
	var linetitle = ["设备编号", "设备名称", "设备单位", "规格", "总数量", "可借数量", "存放位置", "操作"];
	var oper = '<span><a href="javascript:void(0)">编辑</a><span>|<span><a href="javascript:void(0)">删除</a><span>';
	var obj = JSON.parse(jstr);
	var res = "<table class='contab'>";
	// alert("ok");
	var param = "";
	// param = JSON.stringify(obj[0]).replace(/"/g,'&quot;');
	// alert(param);
	// alert(param);
	if (obj.length > 0) {
		for (var i = 0; i < linetitle.length; i++) {
			res += "<td>" + linetitle[i] + "</td>";
		}
	}
	for (var i = 0; i < obj.length; i++) {
		var item = obj[i];
		param = JSON.stringify(item).replace(/"/g, '&quot;');
		// alert(JSON.stringify(item));
		res += "<tr>";
		res += "<td>" + item.equ_id + "</td>";
		res += "<td>" + item.equ_name + "</td>";
		res += "<td>" + item.equ_unit + "</td>";
		res += "<td>" + item.equ_spec + "</td>";
		res += "<td>" + item.equ_total + "</td>";
		res += "<td>" + item.equ_curr + "</td>";
		res += "<td>" + item.equ_position + "</td>";
		// res +="<td><a href=\"javascript:void(0)\" onclick=\"delinfo(\'"+JSON.stringify(item)+"\')\">修改</a>|";
		res += "<td><button type=\"button\" onclick=\"modifyinfo(\'" + param + "\')\">修改</button>&nbsp;"
		res += "<button type=\"button\" onclick=\"delinfo(\'" + param + "\')\">删除</button>"
		// res +='<a href="javascript:void(0)" onclick="delinfo(hello)">删除</a>';
		res += "</td>";
		res += "</tr>";
	}
	res += "</table>";

	$("#contab").html(res);
	// 	res += "<tr>";
	// 	var item = obj.item;
	// 	alert("obj:"+item["equ_id"]);

	// }

	json.name = name;
	json.sex = sex;
	json.height = "170";

	// alert(JSON.stringify(json));
	// var cc=[];
	// cc.push(name);
	// cc.push(sex);
	// ss = JSON.stringify(cc);
	// alert(ss);
	// $("#content").html("隐藏信息"+oper);
	// alert($("#tip").text());
	// $("#content").html($("#tip").data());

}
// 关闭弹框
function btnClose() {
	document.getElementById("popdiv").style.display = "none";
}


var Page = {
	// 显示按钮数量
	limitpage: 8,
	// 每一页显示记录数量
	limitsize: 8,
	// 总记录条数
	totalsize: 0,
	// 总页数
	totalpage: 0,

	// 查询的参数
	param: "",
	beginpage: 0,
	endpage: 0,
	// 当前页按钮
	currid: "",
	currpage: 0,
	// 查询的json字符串、总结果数
	init: function(param, psize) {
		this.param = param;
		// 总数量
		this.totalsize = psize;
		// 计算总页数
		this.totalpage = Math.ceil(this.totalsize / this.limitsize);
		if (this.totalpage > 0) {
			this.beginpage = 1;
			this.currpage = 1;
		}
		// 起始页面范围
		if (this.totalpage <= this.limitpage) {
			this.endpage = this.totalpage;
		} else {
			this.endpage = this.limitpage;
		}

	},

	// 翻页改变样式
	changePageStyle: function(pstyle) {
		if (this.totalpage == 0) {
			return;
		}
		document.getElementById(this.currid).className = pstyle;
		if (this.currpage == this.totalpage && this.totalpage > 2) {
			document.getElementById("nextpage").className = pstyle;
			document.getElementById("tailerpage").className = pstyle;
		}
		if (this.currpage == 1 && this.totalpage > 2) {
			document.getElementById("homepage").className = pstyle;
			document.getElementById("lastpage").className = pstyle;
		}
	},

	// 首页 2-11 -- 1-10
	updateHomePage: function() {
		this.beginpage = 1;
		this.changePageStyle("oldpage");
		// 大于 10 页,更新
		if (this.endpage > this.limitpage) {
			this.endpage = this.limitpage;
			this.currpage = 1;
			this.currid = "page1";
			this.printBar();

		} else {
			this.currpage = 1;
			this.currid = "page1";
		}
		this.changePageStyle("currpage");

	},

	// 点击尾页
	updateTailerPage: function() {

		this.changePageStyle("odlpage");
		//当前页包含尾页
		if (this.endpage == this.totalpage) {
			this.currpage = this.endpage;
			var cnt = this.endpage - this.beginpage + 1;
			this.currid = document.getElementById("page" + cnt).id;
			// 末端页，还有下一页
		} else if (this.endpage < this.totalpage) {
			this.beginpage = this.totalpage - this.limitpage + 1;
			this.endpage = this.totalpage;
			this.currpage = this.totalpage;
			this.printBar();
			this.currid = "page" + this.limitpage;
			// alert(this.currid);

		}
		this.changePageStyle("currpage");

	},
	// 点击上一页更新
	updateLastPage: function() {

		var oldbtn = document.getElementById(this.currid);
		// messagePop(this.currpage);
		this.changePageStyle("oldpage");
		// oldbtn.className = "oldpage";

		// 不是开始页
		if (this.currpage != this.beginpage) {
			// 上一页
			var currbtn = oldbtn.parentElement.previousElementSibling.firstElementChild;
			this.currid = currbtn.id;
			this.currpage = this.currpage - 1;
			// 数字开始页
		} else {
			// 
			if (this.beginpage > this.limitpage) {
				this.endpage = this.beginpage - 1;
				this.beginpage = this.beginpage - this.limitpage;
				this.currpage = this.currpage - 1;
				this.printBar();
				this.currid = "page" + this.limitpage;
			} else {

				this.beginpage = 1;
				this.endpage = this.limitpage;
				this.currpage = this.currpage - 1;
				this.printBar();
				this.currid = "page" + this.currpage;
			}
		}
		this.changePageStyle("currpage");
	},
	// 下一页更新
	updateNextPage: function() {
		var obj = document.getElementById(this.currid);
		// 上一次页面恢复
		if (Page.currpage == 1) {
			document.getElementById("homepage").className = "oldpage";
			document.getElementById("lastpage").className = "oldpage";
		}

		// 上一次页面恢复
		obj.className = "oldpage";
		// 不是最末端页
		if (this.currpage != this.endpage) {
			var currbtn = obj.parentNode.nextElementSibling.firstChild;
			// 当前页禁用
			currbtn.className = "currpage";
			this.currid = currbtn.id;
			this.currpage += 1;
		} else {
			// 当前页等于末端页

			// 还有下一页
			if (this.currpage < this.totalpage) {
				var maxpage = this.currpage + this.limitpage;
				// 下一页不足10页，按10页显示
				if (maxpage >= this.totalpage) {
					this.beginpage = this.totalpage - this.limitpage + 1;
					this.endpage = this.totalpage;
					this.currpage += 1;
					this.printBar();
					var temp = this.currpage - this.beginpage + 1;
					this.currid = "page" + temp;
					// document.getElementById(this.currid).className = "currpage";
				} else {
					// 下一页超过10页，最多显示10页
					this.beginpage = this.endpage + 1;
					this.endpage = maxpage;
					this.currpage += 1;
					this.printBar();
					this.currid = "page1";
				}
				// 当前页禁用
				document.getElementById(this.currid).className = "currpage";

				// 恰好为尾页,没有下一页
			}
		}
		this.changePageStyle("currpage");

	},
	// 根据起始页、末端页打印翻页按钮
	printBar: function() {
		// 没有则不打印
		if (this.totalpage == 0) {
			return;
		}
		var res = "";
		res += "<div id=\"pagenavbar\">";
		res += "<table><tr>";

		if (this.totalpage > 2) {
			//首页按钮 
			res += "<td><input type=\"button\" name=\"txbtn\" id=\"homepage\" value=\"首页\" onclick=\"Page.pageBtn(this)\"></td>";
			// 上一页
			res += "<td><input type=\"button\" name=\"txbtn\" id=\"lastpage\" value=\"上一页\" onclick=\"Page.pageBtn(this)\"></td>";
		}
		// 显示记录最大容纳10条
		var serial = this.beginpage;
		var cnt = 1;
		while (serial <= this.endpage) {
			res += "<td><input type=\"button\" id=\"page" + cnt + "\" value=\"" + serial +
				"\" onclick=\"Page.pageNumber(this)\"></td>";
			serial += 1;
			cnt += 1;
		}
		if (this.totalpage > 2) {
			// 下一页
			res += "<td><input type=\"button\" name=\"txbtn\" id=\"nextpage\" value=\"下一页\" onclick=\"Page.pageBtn(this)\"></td>";
			// 尾页
			res += "<td><input type=\"button\" name=\"txbtn\" id=\"tailerpage\" value=\"尾页\" onclick=\"Page.pageBtn(this)\"></td>";
			res += "<td>跳转页：<input type=\"number\" id=\"gotopage\" step=\"1\" min=\"1\" value=\"" + this.currpage +
				"\" max=\"" + this.totalpage + "\"><input type=\"button\" value=\"GO\" onclick=\"Page.gotoPage()\"></td>";
		}
		res += "<td><label>总页数：" + this.totalpage + "</label></td>";
		res += "</tr></table>";

		res += "</div>";
		var con = document.getElementById("navbar");
		con.innerHTML = res;

	},
	// 点击数字按钮
	pageNumber: function(elembtn) {
		// 上一次恢复
		this.changePageStyle("oldpage");

		// 更新
		this.currid = elembtn.id;

		//当前页
		Page.currpage = parseInt(elembtn.value);

		// 更新后
		this.changePageStyle("currpage");
		// // 外部测试
		// printTable();
		classifyEquipment();


	},
	// 第一次查询处理，首先获得查询总数量
	initPage: function() {
		this.printBar();
		// alert(document.getElementById("page2").className);
		if (this.totalpage > 2) {
			document.getElementById("page1").className = "currpage";
			document.getElementById("homepage").className = "currpage";
			document.getElementById("lastpage").className = "currpage";
			this.currpage = 1;
			this.currid = "page1";
		} else {
			if (this.totalpage > 0) {
				this.currpage = 1;
				this.currid = "page1";
				document.getElementById("page1").className = "currpage";
			}
		}
		this.changePageStyle("currpage");

	},
	// 跳转到指定页面
	gotoPage: function() {
		var elembtn = document.getElementById("gotopage");
		//没有输入，返回
		if (elembtn.value == "") {
			return;
		}
		var cnt = parseInt(elembtn.value);
		// 跳转页不在总页数的范围内，或者就是当前页，无需任何操作
		if (cnt < 1 || cnt > this.totalpage || cnt == this.currpage) {
			return;
		}
		// 需要跳转

		// 上次点击恢复
		this.changePageStyle("odlpage");
		// 更新
		// // 跳转的页面在导航栏上
		if (cnt >= this.beginpage && cnt <= this.endpage) {
			this.currpage = cnt;
			var tempid = this.currpage - this.beginpage + 1;
			this.currid = "page" + tempid;
			// 跳转的页面没有在导航栏上
		} else {
			// 导航栏往前翻
			if (cnt < this.beginpage) {
				if (cnt <= this.limitpage) {
					// alert("1");
					this.currpage = cnt;
					this.beginpage = 1;
					this.endpage = this.limitpage;
					this.printBar();
					this.currid = "page" + cnt;
				} else {
					// alert("2");
					this.endpage = cnt;
					this.beginpage = this.endpage - this.limitpage + 1;
					this.currpage = cnt;
					this.printBar();
					this.currid = "page" + this.limitpage;
				}
				// 导航栏往后翻
			} else if (cnt > this.endpage) {
				var tp = this.totalpage - this.limitpage;
				if (cnt > tp) {
					this.beginpage = tp + 1;
					this.endpage = this.totalpage;
					this.currpage = cnt;
					this.printBar();
					var sid = this.currpage - this.beginpage + 1;
					this.currid = "page" + sid;
				} else {
					this.beginpage = cnt;
					this.endpage = cnt + this.limitpage - 1;
					this.currpage = cnt;
					this.printBar();
					this.currid = "page1";
				}
			}
		}
		// 设置当前页样式
		this.changePageStyle("currpage");
		// 添加处理函数
		classifyEquipment();
	},


	pageBtn: function(elembtn) {
		var btnvalue = elembtn.value;
		switch (btnvalue) {
			case "首页":
				this.updateHomePage();
				break;
			case "上一页":
				this.updateLastPage();
				break;
			case "下一页":
				this.updateNextPage();
				break;
			case "尾页":
				this.updateTailerPage();
				break;
		}
		classifyEquipment();
	}
}
