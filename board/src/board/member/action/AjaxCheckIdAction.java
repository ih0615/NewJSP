package board.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.member.service.MemberService;
import board.member.vo.MemberVo;
import common.Action;
import common.ActionForward;
import common.BCrypt;
import common.RegExp;

public class AjaxCheckIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		// 아이디 정규표현식 검사
		if (!RegExp.isValidExp(id, RegExp.REGEXP_ID)) {

		}

		MemberVo memberVo = new MemberVo();
		memberVo.setId(id);

		MemberService svc = new MemberService();
		request.setAttribute("isTrue", svc.checkId(memberVo));

		ActionForward forward = new ActionForward();
		forward.setPath("/views/ajax/common.jsp");
		return forward;
	}
}
