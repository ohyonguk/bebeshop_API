$('#allCheck').change(() => {
	if ($('#allCheck').prop('checked')) {
		$('input[name="RowCheck"]').prop('checked', true);
		$('input[name="checked"]').val("true");
	} else {
		$('input[name="RowCheck"]').prop('checked', false);
		$('input[name="checked"]').val("false");
	}
});


$(".RowCheck").click(function() {

	console.log($(".RowCheck").index(this));

	$("#allCheck").prop("checked", false);

	if ($(this).prop('checked')) {
		$(".checked").eq($(".RowCheck").index(this)).val("true");
	}

	else {
		$(".checked").eq($(".RowCheck").index(this)).val("false");
	}
});