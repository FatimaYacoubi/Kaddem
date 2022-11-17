package com.example.springsecurity.Controller;


import com.example.springsecurity.Entity.EtudDTO;
import com.example.springsecurity.Entity.Etudiant;
import com.example.springsecurity.service.UserService;
import com.example.springsecurity.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;

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
    public ResponseEntity<?> signUp(@RequestBody Etudiant user,@RequestParam("image") MultipartFile multipartFile)throws IOException
    {
        if (userService.findByEmail(user.getEmail()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        user.setImage(fileName);
        Etudiant Suser = userService.saveUser(user);
        String uploadDir = "user-photos/" + Suser.getIdEtudiant();
        System.out.println(uploadDir);
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return new ResponseEntity<>(Suser, HttpStatus.CREATED);
    }

}
