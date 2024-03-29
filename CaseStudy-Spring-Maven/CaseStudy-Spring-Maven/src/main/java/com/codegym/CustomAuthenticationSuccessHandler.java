package com.codegym;

import com.codegym.model.User;
import com.codegym.model.UserDetailsCustom;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        HttpSession session = httpServletRequest.getSession();
        //User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = ((UserDetailsCustom) authentication.getPrincipal()).getUserDetails();
        session.setAttribute("username", loggedInUser.getUsername());

        //set our response to OK status
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        //since we have created our custom success handler, its up to us to where
        httpServletResponse.sendRedirect("/admin/product/");
    }
}
