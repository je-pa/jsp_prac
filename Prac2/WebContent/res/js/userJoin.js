var frmElem = document.querySelector('#frm');
var uidElem = frmElem.uid;
var upwElem = frmElem.upw;
var chkPwElem = frmElem.chkPw;
var unmElem = frmElem.unm;
var chkUidResultElem = frmElem.querySelector('#chkUidResult');

var btnChkIdElem = frmElem.btnChkId;
btnChkIdElem.addEventListener('click',function(){
	idChkAjax(uidElem.value);
});
function idChkAjax(uid){
	fetch('idChk?uid='+uid)
	.then(function(res){
		return res.json();
	}).then(function(myJson){
		console.log(myJson);
		if(myJson.result==1){
			chkUidResultElem.innerText='이 아이디는 사용할수 없다';
		}else{
			chkUidResultElem.innerText='사용가능';
		}
	})
	
}
function frmChk(){
	var uidVal = uidElem.value;
	
	if(uidVal.length<3){
		if(uidVal.length==0){
			alert('아이디를 작성해 주세요');
			return false;
		}
		alert('아이디를 3자이상 작성해 주세요');
		return false;
	}
	var upwVal=upwElem.value;
	var chkPwVal = chkPwElem.value;
	if(upwVal.length<3){
		if(upwVal.length==0){
			alert('비밀번호를 작성해 주세요');
			return false;
		}
		alert('비밀번호를 3자이상 작성해 주세요');
		return false;
	}else if(upwVal !== chkPwVal){
		alert('비밀번호를 확인해 주세요');
		return false;
	}
	if(unmElem.value.length<2){
		alert('이름 2자이상!');
		return false;
	}
}


