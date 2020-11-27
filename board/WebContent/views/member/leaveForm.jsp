<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script>
	function leave() {
		if (confirm("정말 탈퇴 하시겠습니까?")) {
			$('#LForm').submit();
		} else {
			location.href = "/";
		}
	}
</script>
</head>
<body>
	<form action="/leaveProc.do" method="post" id="LForm">
		비밀번호확인 <input type="password" id="pwd" name="pwd" />
	</form>
	<button onclick="leave()">탈퇴</button>
</body>
</html>