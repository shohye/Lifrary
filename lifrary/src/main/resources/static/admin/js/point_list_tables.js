$(function() {
  $('.datatables-demo').dataTable({
	  ajax: {
		  serverSide: true,
	      type : 'POST',
	      url : '/admin/pointAjax',
	      dataType: 'JSON',
	      dataSrc : '',
	      dataFilter: function(data){
             var json = jQuery.parseJSON( data );
             json.recordsTotal = json.total;
             json.recordsFiltered = json.total;
             json.data = json.list;
             console.log(json);
             return JSON.stringify( json );   
	       }
	  },
	  order: [[ 2, 'desc' ]],
	    columnDefs: [ {
	    targets: [0,1,3,4,5],
	    orderable: false,
	    }],
	    columns: [
		      { "data": "pName" ,
		    	"defaultContent": ""},
		      { "data": "pStandard",
		    	"defaultContent": ""},
		      { "data": "pPoint",
		    	"defaultContent": ""},
		      { "data": "pDate",
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
		 $('td', row).eq(4).addClass('text-center').html('').append(
		    '<a href="#?uId='+data.pCode+'" class="btn btn-default btn-xs icon-btn md-btn-flat" title="수정" ><i class="ion ion-md-create"></i></a>'
				);
		 $('td', row).eq(5).addClass('text-center').html('').append(
			'<a href="#?phCode='+data.pCode+'" class="btn btn-default btn-xs icon-btn md-btn-flat" title="삭제" ><i class="ion ion-ios-cut d-block"></i></a>'
		);
		 
	 }
  });
});
