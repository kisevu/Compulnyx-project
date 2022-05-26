package com.ameda.kevin.kisevu.filter;

import com.ameda.kevin.kisevu.service.CustomUserDetails;
import com.ameda.kevin.kisevu.service.MyUserDetailsService;
import com.ameda.kevin.kisevu.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader=request.getHeader("Authorization");
        String emailId=null;
        String jwtToken=null;
        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")){
            jwtToken=authorizationHeader.substring(7);
            emailId=jwtUtility.getUsernameFromToken(jwtToken);
        }
        if(emailId!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            CustomUserDetails customUserDetails=this.myUserDetailsService.loadUserByUsername(emailId);
            if(jwtUtility.validateToken(jwtToken,customUserDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                        new UsernamePasswordAuthenticationToken(customUserDetails,null,customUserDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
