<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script>
	function validateCheck() {
		var id = $('#id');
		var pwd = $('#pwd');

		if (!id.val()) {
			alert("아이디를 입력해주세요");
			id.focus();
			return false;
		}
		if (!pwd.val()) {
			alert("비밀번호를 입력해주세요");
			pwd.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<form action="loginProc.do" method="post" onsubmit="return validateCheck()">
		<div>
			아이디<input type="text" id="id" name="id" />
		</div>
		<div>
			비밀번호 <input type="password" id="pwd" name="pwd" />
		</div>
		<input type="submit" value="로그인" /> <input type="button" value="취소" onclick="location.href='/'" />
	</form>
</body>
</html>