package board.member.action;

import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.member.service.MemberService;
import board.member.vo.MemberVo;
import common.Action;
import common.ActionForward;
import common.BCrypt;
import common.RegExp;
import static common.RegExp.REGEXP_ID;
import static common.RegExp.REGEXP_PWD;
import static common.RegExp.REGEXP_NAME;

public class MemberRegisterProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String pwdc = request.getParameter("pwdc");
		String name = request.getParameter("name");

		if (!RegExp.isValidExp(id, RegExp.REGEXP_ID) || !RegExp.isValidExp(pwd, RegExp.REGEXP_PWD)
				|| !RegExp.isValidExp(name, RegExp.REGEXP_NAME) || !pwd.equals(pwdc)) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('잘못된 접근입니다.');location.href='/';</script>");
			out.close();
			return null;
		}

		MemberVo memberVo = new MemberVo();
		memberVo.setId(id);
		memberVo.setPwd(BCrypt.hashpw(pwd, BCrypt.gensalt(12)));
		memberVo.setName(name);

		MemberService svc = new MemberService();
		if(!svc.registerMember(memberVo)) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원 가입에 실패하였습니다.');history.back();</script>");
			out.close();
			return null;
		}
		

		ActionForward forward = new ActionForward();
		forward.setPath("/");
		forward.setRedirect(true);
		return forward;
	}
}
