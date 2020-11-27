package board.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.member.service.MemberService;
import board.member.vo.MemberVo;
import common.Action;
import common.ActionForward;
import common.BCrypt;
import common.LoginManager;
import common.RegExp;

public class LoginProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		if (RegExp.isEmpty(id) || RegExp.isEmpty(pwd)) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('잘못된 접근입니다.');location.href='/';</script>");
			out.close();
			return null;
		}

		MemberService svc = new MemberService();
		MemberVo memberVo = svc.getMemberLoginInfo(id);
		
		if(memberVo==null ||!BCrypt.checkpw(pwd, memberVo.getPwd())) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 정보를 확인해 주세요.');history.back;</script>");
			out.close();
			return null;
		}
		
		LoginManager lm = LoginManager.getInstance();
		lm.setSession(request.getSession(), memberVo.getId());
		

		ActionForward forward = new ActionForward();
		forward.setPath("/");
		forward.setRedirect(true);
		return forward;
	}
}
