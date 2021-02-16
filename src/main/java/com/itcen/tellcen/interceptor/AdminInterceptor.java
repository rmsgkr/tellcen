package com.itcen.tellcen.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.itcen.tellcen.domain.MemberDTO;


public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("member");

		if (member == null || member.getAuthor() != 1) {
			response.sendRedirect("/tellcen/admin/adminInterceptor");
			return false;
		}

		return true;
	}
}
