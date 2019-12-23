$(function() {
  $('.datatables-demo').dataTable({
	  order: [[ 4, 'desc' ]],
	    columnDefs: [ {
	    targets: [0,1,2,3,6],
	    orderable: false,
	    }],
	 language: {
		 "info" : "_START_ - _END_ (총 _TOTAL_ 개)",
	     "infoEmpty" : "0개",
	     "infoFiltered" : "(전체 _MAX_ 개 중 검색결과)",
		 "search" : "전체 항목에서 검색 : ",
		 "lengthMenu" : "보기_MENU_ 개씩",
		 "paginate" : {
	            "next" : "다음",
	            "previous" : "이전"
	        },
	     "zeroRecords" : "검색결과가 없습니다"
	 }
  });
});
