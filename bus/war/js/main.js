$(document).ready(function() {
	function getTimesStr(data,length){
		var content = "";
		for(var i = 0;i<length;i++){
			if (data[i] !="" && data[i] !== null && data[i] !== false && i < data.length){
				if (i != (length - 1)){
					content += data[i]+ ", ";
				}else{
					content += data[i]+ ".";
				}
			}
			else {
				return content.slice(0,content.length - 2) + ".";
			}
		}
		return content;
	}
	function submitDropdown(event, form, id){
		event.preventDefault(),
		$.getJSON('timetableAjax.action',
			$(form).serialize(),
			function(data) { 
		if(data !="" && data !== null && data !== false){
			if ($('body').find('#'+id).length > 0) {
				$("#"+id).replaceWith(
								$('<p id="'+id+'">Next 4 times: <br><br> '
										+ getTimesStr(data,4)
										+'</p>')).hide().fadeIn(2000);
			} else {
				$("#"+id).append(
								$('<p id="'+id+'">Next 4 times: <br><br> '
										+ getTimesStr(data,4)
										+ '</p>')).hide().fadeIn(2000);
			}
		}
		});
	}
	$("#getLangBusTimes").change(function(event){
		submitDropdown(event,"#getLangBusTimes","LangstoneCampusTimes"); });
	$("#getUniBusTimes").change(function(event){
		submitDropdown(event,"#getUniBusTimes","UniCampusTimes"); });
	$("#getLangBusTimes").submit(function(event) {
		submitDropdown(event,"#getLangBusTimes","LangstoneCampusTimes");
					});
	$("#getUniBusTimes").submit(function(event) {
		submitDropdown(event,"#getUniBusTimes","UniCampusTimes"); });
	
});
