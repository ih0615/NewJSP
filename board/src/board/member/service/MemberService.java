package board.member.service;

import java.sql.Connection;

import board.member.dao.MemberDao;
import board.member.vo.MemberVo;

import static common.jdbcUtil.*;

public class MemberService {
	public boolean registerMember(MemberVo memberVo) {
		MemberDao dao = MemberDao.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int count = dao.registerMember(memberVo);
		boolean isSuccess = false;
		if (count > 0) {
			commit(con);
			isSuccess = true;
		} else {
			rollback(con);
			isSuccess = false;
		}
		close(con);
		return isSuccess;
	}

	public boolean checkId(MemberVo memberVo) {
		MemberDao dao = MemberDao.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		boolean isDuplicated = false;
		if (dao.checkId(memberVo) == 0) {
			isDuplicated = false;
		}
		else {
			isDuplicated = true;
		}
		close(con);
		return isDuplicated;
	}
	
	public MemberVo getMemberLoginInfo(String id) {
		MemberDao dao = MemberDao.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		MemberVo vo = dao.getMemberLoginInfo(id);
		close(con);
		return vo;
	}
	
	public MemberVo getMemberInfo(String id) {
		MemberDao dao = MemberDao.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		MemberVo vo = dao.getMemberInfo(id);
		close(con);
		return vo;
	}
	
	public boolean modifyMemberInfo(MemberVo memberVo) {
		MemberDao dao = MemberDao.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int count = dao.modifyMemberInfo(memberVo);
		boolean isSuccess = false;
		if (count > 0) {
			commit(con);
			isSuccess = true;
		} else {
			rollback(con);
			isSuccess = false;
		}
		close(con);
		return isSuccess;
	}
	public boolean leaveMember(MemberVo memberVo) {
		MemberDao dao = MemberDao.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int count = dao.leaveMember(memberVo);
		boolean isSuccess = false;
		if (count > 0) {
			commit(con);
			isSuccess = true;
		} else {
			rollback(con);
			isSuccess = false;
		}
		close(con);
		return isSuccess;
	}
}
