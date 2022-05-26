package com.ameda.kevin.kisevu.controller;

import com.ameda.kevin.kisevu.model.JwtRequest;
import com.ameda.kevin.kisevu.model.JwtResponse;
import com.ameda.kevin.kisevu.service.CustomUserDetails;
import com.ameda.kevin.kisevu.service.MyUserDetailsService;
import com.ameda.kevin.kisevu.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest
                                    )throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    jwtRequest.getEmailId(),
                    jwtRequest.getPassword()
            )
            );
        }catch (BadCredentialsException ex){
            throw new Exception("wrong credentials",ex);
        }
       final CustomUserDetails customUserDetails=myUserDetailsService.loadUserByUsername(jwtRequest.getEmailId());
        final String token=
                jwtUtility.generateToken(customUserDetails);
        return  new JwtResponse(token);
    }
}
