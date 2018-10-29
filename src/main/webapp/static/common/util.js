//项目中出现两次以上
//考虑封装成一个工具类
var util = {
		SUCCESS : 0,
		ERROR : 1,
		NEED_LOGIN : 2,
		isNull : function(value) {
			//判断输入的值是否为空
			if(value == "" || value == undefined || value == null ){
				return true;
			} else {
				return false;
			}
		},
		//获得选中的id
		getSelectedIds : function(data) {
			var idArray = [];// [1,3,4]
		    for(var i in data){
		    	idArray.push(data[i].id);
 	    }
		    var ids = idArray.join(","); // "1,3,4"
		    return ids;
	 	}
		
}
