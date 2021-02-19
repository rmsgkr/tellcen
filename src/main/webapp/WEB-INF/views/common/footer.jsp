<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Footer -->
<footer id="footer">
	<div class="inner">
		<ul class="icons">
			<li><a href="http://www.cengroup.co.kr/app/view/main#0" class="icon brands alt fa-twitter"><span
					class="label">Twitter</span></a></li>
			<li><a href="http://www.cengroup.co.kr/app/view/main#0" class="icon brands alt fa-facebook-f"><span
					class="label">Facebook</span></a></li>
			<li><a href="http://www.cengroup.co.kr/app/view/main#0" class="icon brands alt fa-instagram"><span
					class="label">Instagram</span></a></li>
			<li><a href="http://www.cengroup.co.kr/app/view/main#0" class="icon brands alt fa-github"><span
					class="label">GitHub</span></a></li>
			<li><a href="http://www.cengroup.co.kr/app/view/main#0" class="icon brands alt fa-linkedin-in"><span
					class="label">LinkedIn</span></a></li>
		</ul>
		<ul class="copyright">
			<li><a href="http://www.cengroup.co.kr/app/view/main#0">&copy; ITCEN GROUP</a></li>
			<li>이근학</li>
		</ul>
	</div>
</footer>

</div>

<!-- Scripts -->
<script src="/tellcen/resources/js/jquery.min.js"></script>
<script src="/tellcen/resources/js/jquery.scrolly.min.js"></script>
<script src="/tellcen/resources/js/jquery.scrollex.min.js"></script>
<script src="/tellcen/resources/js/browser.min.js"></script>
<script src="/tellcen/resources/js/breakpoints.min.js"></script>
<script src="/tellcen/resources/js/util.js"></script>
<script src="/tellcen/resources/js/main.js"></script>


<script src="/tellcen/resources/js/jquery-ui.js"></script>
<script type="text/javascript">
$(document).ready(function () {
    $.datepicker.regional['ko'] = {

        dateFormat: 'yy/mm/dd',
        prevText: '이전달', 
        nextText: '다음달',
        currentText: '오늘',
        dayNames: ['일','월','화','수','목','금','토'],
        dayNamesShort: ['일','월','화','수','목','금','토'],
        dayNamesMin: ['일','월','화','수','목','금','토'],
        monthNames: ['1월','2월','3월','4월','5월','6월',
            '7월','8월','9월','10월','11월','12월'],
    }; 
    $.datepicker.setDefaults($.datepicker.regional['ko']);

    $('#complaintSdate').datepicker();
    $('#complaintSdate').datepicker("option", "maxDate", new Date());
    $('#complaintSdate').datepicker("option", "onClose", function ( selectedDate ) {
        $("#complaintEdate").datepicker( "option", "minDate", selectedDate );
    });

    $('#complaintEdate').datepicker();
    $('#complaintEdate').datepicker("option", "minDate", $("#complaintSdate").val());
   
});

$(document).ready(function () {
    $.datepicker.regional['ko'] = {

        dateFormat: 'yy/mm/dd',
        prevText: '이전달', 
        nextText: '다음달',
        currentText: '오늘',
        dayNames: ['일','월','화','수','목','금','토'],
        dayNamesShort: ['일','월','화','수','목','금','토'],
        dayNamesMin: ['일','월','화','수','목','금','토'],
        monthNames: ['1월','2월','3월','4월','5월','6월',
            '7월','8월','9월','10월','11월','12월'],
    }; 
    $.datepicker.setDefaults($.datepicker.regional['ko']);

    $('#suggestionSdate').datepicker();
    $('#suggestionSdate').datepicker("option", "maxDate", new Date());
    $('#suggestionSdate').datepicker("option", "onClose", function ( selectedDate ) {
        $("#suggestionEdate").datepicker( "option", "minDate", selectedDate );
    });

    $('#suggestionEdate').datepicker();
    $('#suggestionEdate').datepicker("option", "minDate", $("#suggestionSdate").val());
   
});

$(document).ready(function(){ //DOM이 준비되고
	$('#toggleButton1').click(function(){ // ID가 toggleButton인 요소를 클릭하면
		var state = $('#Menu1').css('display'); // state 변수에 ID가 moreMenu인 요소의 display의 속성을 '대입'
		if(state == 'none'){ // state가 none 상태일경우 
			$('#Menu1').show(); // ID가 moreMenu인 요소를 show();
		}else{ // 그 외에는
			$('#Menu1').hide(); // ID가 moreMenu인 요소를 hide();			
		}
	});
	$('#toggleButton2').click(function(){ // ID가 toggleButton인 요소를 클릭하면
		var state = $('#Menu2').css('display'); // state 변수에 ID가 moreMenu인 요소의 display의 속성을 '대입'
		if(state == 'none'){ // state가 none 상태일경우 
			$('#Menu2').show(); // ID가 moreMenu인 요소를 show();
		}else{ // 그 외에는
			$('#Menu2').hide(); // ID가 moreMenu인 요소를 hide();			
		}
	});
	$('#toggleButton3').click(function(){ // ID가 toggleButton인 요소를 클릭하면
		var state = $('#Menu3').css('display'); // state 변수에 ID가 moreMenu인 요소의 display의 속성을 '대입'
		if(state == 'none'){ // state가 none 상태일경우 
			$('#Menu3').show(); // ID가 moreMenu인 요소를 show();
		}else{ // 그 외에는
			$('#Menu3').hide(); // ID가 moreMenu인 요소를 hide();			
		}
	});
	$('#toggleButton4').click(function(){ // ID가 toggleButton인 요소를 클릭하면
		var state = $('#Menu4').css('display'); // state 변수에 ID가 moreMenu인 요소의 display의 속성을 '대입'
		if(state == 'none'){ // state가 none 상태일경우 
			$('#Menu4').show(); // ID가 moreMenu인 요소를 show();
		}else{ // 그 외에는
			$('#Menu4').hide(); // ID가 moreMenu인 요소를 hide();			
		}
	});
	$('#toggleButton5').click(function(){ // ID가 toggleButton인 요소를 클릭하면
		var state = $('#Menu5').css('display'); // state 변수에 ID가 moreMenu인 요소의 display의 속성을 '대입'
		if(state == 'none'){ // state가 none 상태일경우 
			$('#Menu5').show(); // ID가 moreMenu인 요소를 show();
		}else{ // 그 외에는
			$('#Menu5').hide(); // ID가 moreMenu인 요소를 hide();			
		}
	});
});
</script>
</body>
</html>