

$(document).ready(function(){
	
	function goWriteForm(){
		$.ajax({
			url : "board_writeForm",
			type : "GET",
			dataType : "html",
			success : function(data){
				alert("good");
				$('#show').load(data);  
				
			},
			error: function(data){
				alert("false");
			}
			
		});
		
	}

	
});