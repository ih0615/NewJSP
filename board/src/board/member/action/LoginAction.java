package board.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import common.LoginManager;

public class LoginAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		LoginManager lm = LoginManager.getInstance();
		String id = lm.getMemberId(session);
		ActionForward forward = new ActionForward();
		if(id!=null) {
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}
		
		forward.setPath("/views/member/loginForm.jsp");
		return forward;
	}
}
