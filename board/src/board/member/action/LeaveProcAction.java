package board.member.action;

import java.io.PrintWriter;

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

public class LeaveProcAction implements Action {

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
		String pwd = request.getParameter("pwd");

		if (RegExp.isEmpty(pwd)) {
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
			out.println("<script>alert('비밀번호를 확인해 주세요.');history.back;</script>");
			out.close();
			return null;
		}
		
		memberVo.setDel_fl(true);
		
		
		if(!svc.leaveMember(memberVo)) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원 탈퇴에 실패하였습니다..');history.back;</script>");
			out.close();
			return null;
		}
		
		lm.removeSession(id);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/");
		forward.setRedirect(true);
		return forward;
	}
}
