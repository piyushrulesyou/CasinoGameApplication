$(".rechargeAmountButton").click(function() {
	var id = $(this).attr("id").split("-")[0]
	var name = $(this).attr("id").split("-")[1]
	$("#rechargeID").val(id);
	$("#customerName").val(name);
})