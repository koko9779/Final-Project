/**
 * 
 */
function member_delete(mNo) {
	var updateForm = document.getElementById("member_"+mNo);
	updateForm.action="member_delete";
	updateForm.method="POST";
	updateForm.submit;
};
function member_delete() {
	
};