<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script>
	function join() {
		var id = $('#id').val();
		var pwd = $('#pwd').val();
		var pwd_confirm = $('#pwd_confirm').val();
		var name = $('#name').val();

		if (!id) {
			alert("아이디를 입력해 주세요");
			$('#id').focus();
			return;
		}
		if (!pwd) {
			alert("비밀번호를 입력해 주세요");
			$('#pwd').focus();
			return;
		}
		if (!pwd_confirm) {
			alert("비밀번호 확인을 입력해 주세요");
			$('#pwd_confirm').focus();
			return;
		}
		if (!name) {
			alert("이름을 입력해 주세요");
			$('#name').focus();
			return;
		}
		if (pwd != pwd_confirm) {
			alert("비밀번호가 일치하지 않습니다.");
			return;
		}

		var regExp = new RegExp("^[a-z0-9]{4,12}$", "g");
		if (regExp.exec(id) == null) {
			alert("잘못된 아이디 형식입니다.");
			$('#id').val('');
			$('#id').focus();
			return;
		}

		regExp = new RegExp("^[a-zA-Z0-9!@#$%^&]{4,12}$", "g");
		if (regExp.exec(pwd) == null) {
			alert("잘못된 비밀번호 형식입니다.");
			$('#pwd').val('');
			$('#pwd').focus();
			return;
		}

		regExp = new RegExp("^[가-힣]{2,8}$", "g");
		if (regExp.exec(name) == null) {
			alert("잘못된 이름 형식입니다.");
			$('#name').val('');
			$('#name').focus();
			return;
		}

		$('#mrform').submit();
	}
</script>
</head>
<body>
	<form action="/memberRegisterProc.do" method="post" id="mrform">
		<div>
			아이디 : <input type="text" maxlength="12" placeholder="4~12자의 영문소문자, 숫자" id="id" name="id" />
		</div>
		<div>
			비밀번호 : <input type="password" placeholder="4~12자의 영문대소문자, 숫자, 특수기호(!,@,#,$,%,^,&,*)" id="pwd" name="pwd"/>
		</div>
		<div>
			비밀번호 확인 : <input type="password" id="pwd_confirm" name="pwdc"/>
		</div>
		<div>
			이름 : <input type="text" maxlength="8" placeholder="2~8자의 한글" id="name" name="name"/>
		</div>
	</form>
	<button onclick="join()">가입</button>
	<button onclick="location.href='/'">취소</button>
</body>
</html>