//$(document).ready(function() {
//	var url = "${pageContext.request.contextPath}/SearchEncryptedAll";
//	var args = {
//		"time" : new Date()
//	};
//	$.post(url, args);
//});
//$(document).ready(function() {
//	$.ajax( {
//		type : "post",
//		url : "${pageContext.request.contextPath}/SearchEncryptedAll",
//		cache : false,
//		data : {
//			"time" : new Date()
//		},
//		dataType : 'json',
//		success : function(json) {
//			alert(json[1].encrId + " " + json[1].encrName);
//		}
//	}, "json");
//});
