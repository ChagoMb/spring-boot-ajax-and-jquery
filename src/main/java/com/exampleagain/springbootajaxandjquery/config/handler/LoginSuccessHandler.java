package com.exampleagain.springbootajaxandjquery.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("username", authentication.getPrincipal());

        UserDetails user = (UserDetails) authentication.getPrincipal();
        List<String> roles = user.getAuthorities().stream().map(r -> r.getAuthority()).collect(Collectors.toList());

        if (roles.contains("ADMIN")) {
            httpServletResponse.sendRedirect("/admin");
        } else if (roles.contains("USER")) {
            httpServletResponse.sendRedirect("/user");
        }
    }
}
