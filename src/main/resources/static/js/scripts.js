$(".answer-write input[type=submit]").click(addAnswer);

function addAnswer(e) {
	e.preventDefault();
	console.log("click!!");
	
	var queryString = $(".answer-write").serialize();
	console.log("query : " + queryString);
	
	var url = $(".answer-write").attr("action");
	console.log("url : " + url);
	
	$.ajax({
			type : 'post',
			url : url,
			data : queryString,
			dataType : 'json',
			error : onError,
			success : onSuccess });
}

function onError() {
	
}

function onSuccess(data, status) {
	console.log(data);
	var answerTemplate = $("#answerTemplate").html();
	var template = answerTemplate.format(data.writer.userId, data.formattedCreateDate, data.contents, data.question.id, data.id)
	$(".qna-comment-slipp-articles").prepend(template);
	
	$("textarea[name=contents]").val("");
}

$(".link-delete-article").click(deleteAnswer);

function deleteAnswer(e) {
	e.preventDefault();
	
	var deleteBtn = $(this); //this가 호출되는 위치에 따라 바뀐다
	var url = $(this).attr("href");
	console.log("URL: " + url);
	
	$.ajax({
		type : 'delete',
		url : url,
		dataType : 'json',
		error : function (xhr, status) {
			console.log("error");
		},
		success : function (data, status) {
			console.log(data);
			if (data.valid) {
				deleteBtn.closest("article").remove(); // 가장 가까운 아티클 삭제
			}
		}
	});
}

String.prototype.format = function() {
	  var args = arguments;
	  return this.replace(/{(\d+)}/g, function(match, number) {
	    return typeof args[number] != 'undefined'
	        ? args[number]
	        : match
	        ;
	  });
	};