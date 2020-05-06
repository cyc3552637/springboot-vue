new Vue({
	el : '#app',
	data : {
		//导航栏,子窗口绑定的属性
		activeIndex: "default",
        iframeUrl: "/html/main/main.html",
        //子窗口首页地址
        mainUrl: "/html/main/main.html",
		menus : [ {
			name : "用户管理",
			id : "user",
			iconClass : "el-icon-message",
			children : [ {
				name : "用户列表",
				id : "user-list",
				url : "/html/user/userList.html"
			}, {
				name : "增加用户",
				id : "user-add",
				url : "/html/user/userAdd.html"
			} ]
		},
		{
			name : "权限管理",
			id : "authority",
			iconClass : "el-icon-news",
			children : [ {
				name : "权限列表",
				id : "authority-list",
				url : ""
			}, {
				name : "增加权限",
				id : "authority-add",
				url : ""
			}, {
				name : "赋予权限",
				id : "authority-grant",
				url : ""
			} ]
		} 
		]
	},
	methods: {
		testButton(){
			console.log('testButton');
			var _self=this;
			var active=_self.activeIndex;
			if('default' == active){
				_self.activeIndex='user-list';
			}else if('user-list' == active){
				_self.activeIndex='user-add';
			}else if('user-add' == active){
				_self.activeIndex='default';
			}
		},
		open(url){
			var _self=this;
			_self.iframeUrl = url;
        },
        async handleMessage (event) {
        	var _self=this;
            // 根据上面制定的结构来解析iframe内部发回来的数据
            var Msgdata = event.data;
            console.log(Msgdata);
            if('redirect' == Msgdata.cmd){
            	_self.activeIndex=Msgdata.params.activeIndex;
          	    _self.iframeUrl=Msgdata.params.iframeUrl;
            }
          }
	},
	 mounted () {
	    // 在外部vue的window上添加postMessage的监听，并且绑定处理函数handleMessage
	    window.addEventListener('message', this.handleMessage)
	  },
});