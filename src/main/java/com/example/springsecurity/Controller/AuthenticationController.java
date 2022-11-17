package com.example.springsecurity.Controller;

import com.example.springsecurity.Entity.Etudiant;
import com.example.springsecurity.Entity.Option;
import com.example.springsecurity.Entity.Rolee;
import com.example.springsecurity.service.AuthenticationService;

import com.example.springsecurity.service.UserService;
import com.example.springsecurity.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/authentication")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @PostMapping("/sign-in")
    public ResponseEntity<Etudiant> signIn(@RequestBody Etudiant user){
        Etudiant Suser = authenticationService.SignInAndReturnJWT(user);
        return new ResponseEntity<>(Suser, HttpStatus.OK);
    }


    //test post only pic
    @PostMapping("/changeimage")
    public ResponseEntity<Etudiant> qsd(@RequestParam("image") MultipartFile multipartFile)throws IOException {
        Etudiant user = new Etudiant();
        user.setPassword("hazem");
        user.setEmail("image@gmail.com");
        user.setOption(Option.SE);
        user.setRole(Rolee.USER);
        user.setPhonenumber("27272757");
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        user.setImage(fileName);
        Etudiant Suser = userService.saveUser(user);
        String uploadDir = "user-photos/" + Suser.getIdEtudiant();
        System.out.println(uploadDir);
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }




}
