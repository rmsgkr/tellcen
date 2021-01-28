package com.itcen.tellcen.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.itcen.tellcen.domain.MemberDTO;


public class LoginInterceptor extends HandlerInterceptorAdapter {
	/*
	 * 컨트롤러(즉 RequestMapping이 선언된 메서드 진입) 실행 직전에 동작. 반환 값이 true일 경우 정상적으로 진행이 되고,
	 * false일 경우 실행이 멈춤(컨트롤러 진입을 하지 않음)
	 * 
	 * prehandle에서 return값이 false일 경우 다음으로 넘어가지 않고 끝나게 된다.
	 * posthandle의 경우 Controller에서 Exception이 발생 할 경우 posthandle로 요청이 넘어오지 않는다.
     * afterCompletion의 경우 Exception이 발생하여도 뷰단은 실행된다.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);

		// 세션이 존재하지 않을 때
		if (session == null) {
			response.sendRedirect("/tellcen/member/loginInterceptor");
			return false;
		}

		MemberDTO member = (MemberDTO) session.getAttribute("member");

		// 사용자 정보가 세션에 없을 때
		if (member == null) {
			response.sendRedirect("/tellcen/member/loginInterceptor");
			return false;
		}

		return true;
	}
}
