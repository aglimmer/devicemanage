// 页面对象直接量
			var Page={
				// 显示数量
				limitpage:10,
				// 总记录条数
				totalsize:0,
				// 总页数
				totalpage:0,
				
				// 查询的参数
				param:"",
				beginpage:0,
				endpage:0,
				// 当前页按钮
				currid:"",
				currpage:0,
				// 查询的json字符串、总结果数
				init:function(param,psize){
					this.param = param;
					// 总数量
					this.totalsize = psize;
					// 计算总页数
					this.totalpage = Math.ceil(this.totalsize/this.limitpage);
					if(this.totalpage>0){
						this.beginpage = 1;
						this.currpage = 1;
					}
					// 起始页面范围
					if(this.totalpage<=this.limitpage){
						this.endpage = this.totalpage;
					}else{
						this.endpage = this.limitpage;
					}
						
				},
				getJson:function(){
					var obj = JSON.parse(this.param);
					return obj;
				},
				changePageStyle:function(pstyle){
					if(this.totalpage==0){return;}
					document.getElementById(this.currid).className = pstyle;
					if(this.currpage==this.totalpage && this.totalpage>2){
						document.getElementById("nextpage").className = pstyle;
						document.getElementById("tailerpage").className = pstyle;
					}
					if(this.currpage==1 && this.totalpage>2){
						document.getElementById("homepage").className = pstyle;
						document.getElementById("lastpage").className = pstyle;
					}
				},
				
				// 首页 2-11 -- 1-10
				updateHomePage:function(){
					this.beginpage = 1;
					this.changePageStyle("oldpage");
					// 大于 10 页,更新
					if(this.endpage>this.limitpage){
						this.endpage = this.limitpage;
						this.currpage = 1;
						this.currid = "page1";
						this.printBar();
						
					}else{
						this.currpage = 1;
						this.currid = "page1";
					}
					this.changePageStyle("currpage");
					
				},
				
				// 尾页 2-11
				updateTailerPage:function(){
					
					this.changePageStyle("odlpage");
					//当前页包含尾页
					if(this.endpage==this.totalpage){
						this.currpage =this.endpage;
						var cnt = this.endpage - this.beginpage+1;
						this.currid = document.getElementById("page"+cnt).id;
					// 末端页，还有下一页
					}else if(this.endpage < this.totalpage){
						this.beginpage = this.totalpage - this.limitpage+1;
						this.endpage = this.totalpage;
						this.currpage = this.totalpage;
						this.printBar();
						this.currid = "page"+this.limitpage;
						// alert(this.currid);
						
					}
					this.changePageStyle("currpage");
					
				},
				// 上一页更新bar
				updateLastPage:function(){
					
					var oldbtn = document.getElementById(this.currid);
					this.changePageStyle("oldpage");
					// oldbtn.className = "oldpage";
					
					// 不是开始页
					if(this.currpage!=this.beginpage){
						// 上一页
						var currbtn = oldbtn.parentElement.previousElementSibling.firstElementChild;
						this.currid = currbtn.id;
						this.currpage = this.currpage-1;
					// 数字开始页
					}else{
					// 
					if(this.beginpage>this.limitpage){
						this.endpage = this.beginpage -1;
						this.beginpage = this.beginpage - this.limitpage;
						this.currpage = this.currpage-1;
						this.printBar();
						this.currid = "page"+this.limitpage;
					}else{
						
						this.beginpage = 1;
						this.endpage = this.limitpage; 
						this.currpage = this.currpage-1;
						this.printBar();
						this.currid = "page"+this.currpage;
					}
					}
					this.changePageStyle("currpage");
		},
		// 下一页更新bar
		updateNextPage:function(){
					var obj = document.getElementById(this.currid);
					// 上一次页面恢复
					if(Page.currpage==1){
						document.getElementById("homepage").className = "oldpage";
						document.getElementById("lastpage").className = "oldpage";
					}
					
					// 上一次页面恢复
					obj.className = "oldpage";
					// 不是最末端页
					if(this.currpage!=this.endpage){
						var currbtn = obj.parentNode.nextElementSibling.firstChild;
						// 当前页禁用
						currbtn.className = "currpage";
						this.currid = currbtn.id;
						this.currpage += 1;
					}else{
						// 当前页等于末端页
						
						// 还有下一页
						if(this.currpage<this.totalpage){
							var maxpage = this.currpage+this.limitpage;
							// 下一页不足10页，按10页显示
							if(maxpage>=this.totalpage){
								this.beginpage = this.totalpage - this.limitpage+1;
								this.endpage = this.totalpage;
								this.currpage += 1;
								this.printBar();
								var temp = this.currpage - this.beginpage+1;
								this.currid = "page"+temp;
								// document.getElementById(this.currid).className = "currpage";
							}else{
								// 下一页超过10页，最多显示10页
								this.beginpage = this.endpage+1;
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
		// 根据起始页、末端页打印bar
		printBar:function(){
			// 没有则不打印
					if(this.totalpage==0){
						return;
					}
					var res = "";
					res += "<div id=\"pagenavbar\">";
					res += "<table><tr>";
					
					if(this.totalpage>2){
					//首页按钮 
					res +="<td><input type=\"button\" id=\"homepage\" value=\"首页\" onclick=\"Page.pageBtn(this)\"></td>";
					// 上一页
					res +="<td><input type=\"button\" id=\"lastpage\" value=\"上一页\" onclick=\"Page.pageBtn(this)\"></td>";
					}
					// 显示记录最大容纳10条
					var serial = this.beginpage;
					var cnt = 1;
					while(serial<=this.endpage){
						res += "<td><input type=\"button\" id=\"page"+cnt+"\" value=\""+serial+"\" onclick=\"Page.pageNumber(this)\"></td>";
						serial += 1;
						cnt += 1;
					}
					if(this.totalpage>2){
					// 下一页
					res +="<td><input type=\"button\" id=\"nextpage\" value=\"下一页\" onclick=\"Page.pageBtn(this)\"></td>";
					// 尾页
					res +="<td><input type=\"button\" id=\"tailerpage\" value=\"尾页\" onclick=\"Page.pageBtn(this)\"></td>";
					res +="<td>跳转页：<input type=\"number\" id=\"gotopage\" step=\"1\" min=\"1\" value=\""+this.currpage+"\" max=\""+this.totalpage+"\"><input type=\"button\" value=\"GO\" onclick=\"Page.gotoPage()\"></td>";
					}
					res +="<td><label>总页数："+this.totalpage+"</label></td>";	
				res += "</tr></table>";
				
				res +="</div>";
				var con = document.getElementById("navbar");
				con.innerHTML=res;
				
		},
		pageNumber:function(elembtn){
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
			alert("ok");
			
			
		},
		// 第一次查询处理
		initPage:function(){
			this.printBar();
			// alert(document.getElementById("page2").className);
			if(this.totalpage>2){
				document.getElementById("page1").className = "currpage";
				document.getElementById("homepage").className = "currpage";
				document.getElementById("lastpage").className = "currpage";
				this.currpage = 1;
				this.currid = "page1";
			}else{
				if(this.totalpage>0){
					this.currpage = 1;
					this.currid = "page1";
					document.getElementById("page1").className = "currpage";
				}
			}
			this.changePageStyle("currpage");
			
		},
		gotoPage:function(){
			var elembtn = document.getElementById("gotopage");
			if(elembtn.value==""){
				return;
			}
			var cnt = parseInt(elembtn.value);
			// 无需跳转
			if(cnt<1 || cnt>this.totalpage || cnt==this.currpage){
				return;
			}
			// 需要跳转
			
			// 上次点击恢复
			this.changePageStyle("odlpage");
			// 更新
			// 在当前页面
			if(cnt>=this.beginpage && cnt<=this.endpage){
				this.currpage = cnt;
				var tempid = this.currpage - this.beginpage + 1; 
				this.currid = "page"+tempid;
			}else{
				// 不在当前页
				// 在前面
				if(cnt<this.beginpage){
					if(cnt<=this.limitpage){
						// alert("1");
						this.currpage = cnt;
						this.beginpage = 1;
						this.endpage = this.limitpage;
						this.printBar();
						this.currid = "page"+cnt;
					}else{
						// alert("2");
						this.endpage = cnt;
						this.beginpage = this.endpage - this.limitpage+1;
						this.currpage = cnt;
						this.printBar();
						this.currid = "page"+this.limitpage;
					}
					// 在后面
				}else if(cnt>this.endpage){
					var tp = this.totalpage - this.limitpage;
					if(cnt>tp){
						this.beginpage = tp+1;
						this.endpage = this.totalpage;
						this.currpage = cnt;
						this.printBar();
						var sid = this.currpage-this.beginpage+1;
						this.currid = "page"+sid;
					}else{
						this.beginpage = cnt;
						this.endpage = cnt+this.limitpage-1;
						this.currpage = cnt;
						this.printBar();
						this.currid = "page1";
					}
				}
				}
				this.changePageStyle("currpage");
			},
			
		
		pageBtn:function(elembtn){
			var btnvalue = elembtn.value;
			switch(btnvalue){
				case "首页":this.updateHomePage();break;
				case "上一页":this.updateLastPage();break;
				case "下一页":this.updateNextPage();break;
				case "尾页":this.updateTailerPage();break;
			}
		}
		}
		
		function printTable(){
			
			
			var arr = JSON.parse(Page.param);
			var limitsize = 10;
			
			var currpage = Page.currpage;
			var beginpos = (currpage-1)*limitsize;
			
			var endpos = beginpos+limitsize;
			var res = "<table border='1'>";
			// 表格字段
			var headarr = ["序号","姓名","性别","身高"];
			res += "<tr>";
			for(var i=0;i<headarr.length;i++){
				res +="<th>"+headarr[i]+"</th>";
			}
			res += "</tr>";
			
			while(beginpos<endpos && beginpos<arr.length){
				res +="<tr>";
				var item = arr[beginpos];
				for(var k in item){
					res += "<td>"+item[k]+"</td>";
				}
				res +="</tr>";
				beginpos += 1;
			}
			res += "</table>";
			document.getElementById("con").innerHTML=res;
			
		}
	
		
		// 发送参数、总记录数量
		function initPageDeal(){
			var param = document.getElementById("pageid");
			if(param.value==""){
				return;
			}
			// 总记录数量
			var cnt = parseInt(param.value);
			
			var arr=[];
			var max = 180;
			var min = 155;
			for(var i=1;i<=cnt;i++){
				var obj={};
				obj.id=i;
				obj.name="A-"+i;
				obj.sex="B-"+i;
				obj.height=parseInt(Math.random()*(max-min+1)+min,10);
				arr.push(obj);
			}
			Page.init(JSON.stringify(arr),cnt);
			Page.initPage();
			
		}