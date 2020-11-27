package board.member.action;

import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.member.service.MemberService;
import board.member.vo.MemberVo;
import common.Action;
import common.ActionForward;
import common.BCrypt;
import common.LoginManager;
import common.RegExp;
import static common.RegExp.REGEXP_ID;
import static common.RegExp.REGEXP_PWD;
import static common.RegExp.REGEXP_NAME;

public class ModifyMemberProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		LoginManager lm = LoginManager.getInstance();
		String id = lm.getMemberId(session);
		
		if (id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('잘못된 접근입니다.');location.href='/';</script>");
			out.close();
			return null;
		}
		
		String name = request.getParameter("name");
		
		if (!RegExp.isValidExp(name, RegExp.REGEXP_NAME)) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('잘못된 접근입니다.');location.href='/';</script>");
			out.close();
			return null;
		}

		MemberVo memberVo = new MemberVo();
		memberVo.setId(id);
		memberVo.setName(name);

		MemberService svc = new MemberService();
		if (!svc.modifyMemberInfo(memberVo)) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원정보 수정에 실패하였습니다.');history.back();</script>");
			out.close();
			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setPath("/");
		forward.setRedirect(true);
		return forward;
	}
}
