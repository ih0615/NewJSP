<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈페이지</title>
<script>
	function gotoMemberRegisterPage() {
		location.href = '/memberRegister.do';
	}
</script>
</head>
<body>
	<button onclick="gotoMemberRegisterPage()">회원가입</button>

</body>
</html>