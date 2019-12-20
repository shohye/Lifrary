$(document).ready(function () {

   /* $.fn.dataTable.ext.search.push(
        function(settings, data, dataIndex){
            var min = Date.parse($('#fromDate').val());
            var max = Date.parse($('#toDate').val());
            var targetDate = Date.parse(data[5]);

            if( (isNaN(min) && isNaN(max) ) || 
                (isNaN(min) && targetDate <= max )|| 
                ( min <= targetDate && isNaN(max) ) ||
                ( targetDate >= min && targetDate <= max) ){ 
                    return true;
            }
            return false;
        }
    )*/

    var table = $('#myTable').DataTable({
       /* ajax: {
            'url':'test/json/MOCK_DATA.json', 
            //'type': 'POST',
            'dataSrc':''
        },*/
    /*    responsive: true,
        orderMulti: true,
        order : [[1, 'desc']],*/
        
        language: {
   		 "info" : "_START_ - _END_ (총 _TOTAL_ 개)",
   	     "infoEmpty" : "0개",
   	     "infoFiltered" : "(전체 _MAX_ 개 중 검색결과)",
   		 "search" : "전체항목에서 검색 : ",
   		 "lengthMenu" : "보기_MENU_ 개씩",
   		 "paginate" : {
   	            "next" : "다음",
   	            "previous" : "이전"
   	        }
   	 },
	 "zeroRecords" : "검색결과가 없습니다"
    }     
        /*dom : 'Blfrtip',
        buttons:[{
			extend:'csvHtml5',
			text: 'csv다운로드',
			footer: true,
			bom: true,
			className: 'exportCSV'
		}]*/
    });

    /* Column별 검색기능 추가 
    $('#myTable_filter').prepend('<select id="select"></select>');
    $('#myTable > thead > tr').children().each(function (indexInArray, valueOfElement) { 
        $('#select').append('<option>'+valueOfElement.innerHTML+'</option>');
    });
    
    $('.dataTables_filter input').unbind().bind('keyup', function () {
        var colIndex = document.querySelector('#select').selectedIndex;
        table.column(colIndex).search(this.value).draw();
    });

     날짜검색 이벤트 리바인딩 
    $('#myTable_filter').prepend('<input type="text" id="toDate" placeholder="yyyy-MM-dd"> ');
    $('#myTable_filter').prepend('<input type="text" id="fromDate" placeholder="yyyy-MM-dd">~');
    $('#toDate, #fromDate').unbind().bind('keyup',function(){
        table.draw();
    })*/


});