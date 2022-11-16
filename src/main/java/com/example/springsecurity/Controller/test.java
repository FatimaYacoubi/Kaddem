package com.example.springsecurity.Controller;


import com.example.springsecurity.Entity.EtudDTO;
import com.example.springsecurity.Entity.Etudiant;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class test {

    @Autowired
    private UserService userService;

    @PutMapping("/bannuser")
    public ResponseEntity<?> BanneUser(@RequestBody EtudDTO dto){
        userService.BannedUser(dto.getEmail(),dto.getBanned());
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }

    @PutMapping("/verifyuser")
    public ResponseEntity<?> VerifyUser(@RequestBody EtudDTO dto){
        userService.VerifyUser(dto.getEmail(),dto.getVerified());
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody Etudiant user){
        if (userService.findByEmail(user.getEmail()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        Etudiant Suser = userService.saveUser(user);
        return new ResponseEntity<>(Suser, HttpStatus.CREATED);
    }

}
