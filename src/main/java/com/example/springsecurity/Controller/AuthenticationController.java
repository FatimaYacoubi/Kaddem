package com.example.springsecurity.Controller;

import com.example.springsecurity.Entity.Etudiant;
import com.example.springsecurity.service.AuthenticationService;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authentication")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;



    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody Etudiant user){
        if (userService.findByEmail(user.getEmail()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        Etudiant Suser = userService.saveUser(user);
        return new ResponseEntity<>(Suser, HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Etudiant> signIn(@RequestBody Etudiant user){
        Etudiant Suser = authenticationService.SignInAndReturnJWT(user);
        return new ResponseEntity<>(Suser, HttpStatus.OK);
    }




}
