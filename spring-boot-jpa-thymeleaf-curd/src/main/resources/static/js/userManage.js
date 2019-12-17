var $table = $("#testTable");
// 初始化页面
$(document).ready(function(){
    $('#editable-select').editable();
    $("#toolbar").find("select").change(function(){
         $table.bootstrapTable('destroy');
         $table.bootstrapTable({
            exportDataType : $(this).val(),
            exportTypes : ['json','xml','csv','txt','sql','excel','pdf'],
            url : 'getUserList1',
            pagination : true,
            search : true,
            showExport : true,
            sidePagination : "server",
            clickToSelect : true,
            toolbar : "#toolbar",
            showToggle : true,
            showColumns : true,
            columns : [
            {
                field : 'state',
                checkbox : true,
//                visible : $(this).val() === "selected"
            },
            {
                field : 'id',
                title : 'id'
            },
            {
                field : 'age',
                title : 'age'
            },
            {
                field : 'password',
                title : 'password'
            },
            {
                field : 'userName',
                title : 'userName'
            }
            ]
        })
    });
});


$.fn.editable = function(config){
	$(this).each(function(i,t){
		$(t).change(function(){
			var me=$(this);
			me.find('.customval').remove();
			if(-1 == me.val())
			{
				var ed = $("<input type=\"text\" class=\"form-control\" />");
				me.after(ed).hide();
				ed.blur(function(){
					var v=ed.val();
					if(null === v ||  v.length ==0){
					// 如果什么都不输入，那么移除输入框，并将下拉框当前选中的值置空
						ed.remove();me.val(null).show();
					}else{
					// 如果用户输入了值则将输入值追加到下拉列表中，并显示输入的值
						me.append("<option value=\""+v+"\" class=\"customval\" selected>"+v+"</option>").show();
						// 移除输入框，重新变回下拉框
						ed.remove();
					}
				}).focus();
			}
		})
	});
}


$(document).on("click", "#isDelete", function(){
    var id = $(this).data("id");
    $("#hiddenValue").val(id);
});


//$(document).on("click", "#confirm", function(){
//    var id = $("#hiddenValue").val();
//    $.ajax({
//        url : "/delete",
//        data : {
//            id : id
//        },
//        dataType : "text",
//        async : false,
//        type : "post",
//        success : function(data){
//            alert(data);
//            $("#modal-warning").modal("hide");
//        },
//        error : function(){
//            console.log("删除错误！");
//        }
//    })
//});