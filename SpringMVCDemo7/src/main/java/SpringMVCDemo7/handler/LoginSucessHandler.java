package SpringMVCDemo7.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import SpringMVCDemo7.pojos.User;
import SpringMVCDemo7.service.UserSevice;


public class LoginSucessHandler implements AuthenticationSuccessHandler {
	@Autowired
	private UserSevice userDetailsSevice;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		User u = userDetailsSevice.getUsers(authentication.getName()).get(0);
		request.getSession().setAttribute("currentUser", u);
		response.sendRedirect("/SpringMVCDemo7");
	}

}
