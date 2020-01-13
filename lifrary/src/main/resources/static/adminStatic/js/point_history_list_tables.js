$(function() {

  $('.datatables-demo').dataTable({
	  ajax: {
		  serverSide: true,
	      type : 'POST',
	      url : '/admin/getPointHistory',
	      dataType: 'JSON',
	      dataSrc : '',
	      dataFilter: function(data){
	    	  console.log(data);
             return data;   
	       }
	  },
	  order: [[ 6, 'desc' ]],
	    columnDefs: [ {
	    targets: [0,1,2,3,4,7],
	    orderable: false,
	    }],
	    columns: [
		      { "data": "uNumber" ,
		    	"defaultContent": ""},
		      { "data": "uName",
		    	"defaultContent": ""},
		      { "data": "pName" ,
		    	"defaultContent": ""},
		      { "data": "pStandard",
		    	"defaultContent": ""},
		      { "data": "pPoint",
		    	"defaultContent": ""},
		      { "data": "sumPoint",
		    	"defaultContent": ""},
		      { "data": "phDate",
		    	"defaultContent": ""},
		      { "data": "",
			    "defaultContent": ""},	
		      { "data": "",
		        "defaultContent": ""}
		    ],
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
	 },
	 createdRow: function (row, data, index) {
		 $('td', row).eq(7).addClass('text-center').html('').append(
		    '<a href="/admin/adminUserDetail?uId='+data.uId+'" class="btn btn-default btn-xs icon-btn md-btn-flat" title="상세보기" ><i class="ion ion-ios-copy"></i></a>'
				);
		 $('td', row).eq(8).addClass('text-center').html('').append(
			'<a href="/admin/pointHistoryDelete?phCode='+data.phCode+'" class="btn btn-default btn-xs icon-btn md-btn-flat" title="삭제" ><i class="ion ion-ios-cut d-block"></i></a>'
		);
		 
	 }
  });
});
