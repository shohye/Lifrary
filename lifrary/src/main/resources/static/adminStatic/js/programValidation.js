$(document).ready(function(){
		$('#inUpBtn').click(function(){
	  				
	  				var uId = $('#uId').val();
	  				var pmName = $('#pmName').val();
	  				var pmPlace = $('#pmPlace').val();
	  				var pmTarget = $('#pmTarget').val();
	  				
	  				var pmStartReceipt = $('#pmStartReceipt').val();
	  				var pmEndReceipt = $('#pmEndReceipt').val();
	  				var pmStartTerm = $('#pmStartTerm').val();
	  				var pmEndTerm = $('#pmEndTerm').val();
	  				var pmStartTime = $('#pmStartTime').val();
	  				var pmEndTime = $('#pmEndTime').val();
	  				
	  				var pmTeacherName = $('#pmTeacherName').val();
	  				var pmMnop = $('#pmMnop').val();
	  				var pmTel = $('#pmTel').val();
	  				var pmTuition = $('#pmTuition').val();
	  				var pmDetail = $('#pmDetail').val();
	  				
	  				var programInsertForm = $('#programInUpForm');
	  					  				
	  				if(uId == ""){
	  					$('#uId').focus();
	  					alert('세션이 만료되었습니다. 다시 로그인 해주세요.')
	  					location.href = "/admin/login";
	  					return false;
	  				}
	  				
	  				if(pmName == ""){
	  					$('#pmName').focus();
	  					alert('프로그램명을 입력해주세요.');
	  					return false;
	  				}
	  				if(pmPlace == ""){
	  					$('#pmPlace').focus();
	  					alert('장소를 입력해주세요.');
	  					return false;
	  				}
	  				if(pmTarget == ""){
	  					$('#pmTarget').focus();
	  					alert('대상을 입력해주세요.');
	  					return false;
	  				}
	  				if(pmStartReceipt > pmEndReceipt){
	  					alert('접수기간의 시작일이 종료일보다 이후입니다. 다시 입력해주세요.')
	  					//$('#pmStartReceipt').val('2000-01-01');
	  					$('#pmStartReceipt').focus();
	  					return false;
	  				}
	  				if(pmStartTerm > pmEndTerm){
	  					alert('운영기간의 시작일이 종료일보다 이후입니다. 다시 입력해주세요.')
	  					//$('#pmStartTerm').val('2000-01-01');
	  					$('#pmStartTerm').focus();
	  					return false;
	  				}
	  				if(pmStartTime > pmEndTime){
	  					alert('운영시간의 시작시간이 종료시간보다 이후입니다. 다시 입력해주세요.')
	  					//$('#pmStartTime').val('09:00');
	  					$('#pmStartTime').focus();
	  					return false;
	  				}	  					  					  					  				
	  				if(pmTeacherName == ""){
	  					$('#pmTeacherName').focus();
	  					alert('강사명을 입력해주세요.');
	  					return false;
	  				}
	  				if(pmMnop == ""){
	  					$('#pmMnop').focus();
	  					alert('최대 신청 인원을 입력해주세요.');
	  					return false;
	  				}
	  				if(pmTel == ""){
	  					$('#pmTel').focus();
	  					alert('강사 연락처를 입력해주세요.');
	  					return false;
	  				}
	  				if(pmTuition == ""){
	  					$('#pmTuition').focus();
	  					alert('수강료를 입력해주세요. (수강료가 없을시 0 입력)');
	  					return false;
	  				}
	  				if(pmDetail == ""){
	  					$('#pmDetail').focus();
	  					alert('상세정보를 입력해주세요.');
	  					return false;
	  				}
	  				
	  				programInsertForm.submit();
	  				
	  				/* console.log(uId);
	  				console.log(pmName);
	  				console.log(pmPlace);
	  				console.log(pmTarget);
	  				console.log(pmStartReceipt);
	  				console.log(pmEndReceipt);
	  				console.log(pmStartTerm);
	  				console.log(pmEndTerm);
	  				console.log(pmStartTime);
	  				console.log(pmEndTime);
	  				console.log(pmTeacherName);
	  				console.log(pmMnop);
	  				console.log(pmTel);
	  				console.log(pmTuition);
	  				console.log(pmDetail); */
		})
	})	
	  				
	  				