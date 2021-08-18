package com.exam.controller;

import com.exam.Configuration.JwtUtil;
import com.exam.Service.implementation.UserDetailsServiceImpl;
import com.exam.entity.JwtRequest;
import com.exam.entity.JwtResponse;
import com.exam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    private JwtUtil jwtUtil;
    private void authenticate(String username,String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

        }catch (DisabledException e)
        {
            throw new Exception("USER DISABLED"+e.getMessage());
        }catch (BadCredentialsException e)
        {
            throw new Exception("Invalid Credentials"+e.getMessage());
        }


    }
    //api to generate token
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try
        {
        authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (UsernameNotFoundException e)
        {
            e.printStackTrace();
            throw new Exception("User not found");

        }
        //authentication done
        //now we will load the user
        UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    //get the details of currrent user
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal)
    {
        return ((User) this.userDetailsServiceImpl.loadUserByUsername(principal.getName()));
    }
}
