package com.example.springsecurity.Controller;


import com.example.springsecurity.Entity.EtudDTO;
import com.example.springsecurity.Entity.Etudiant;
import com.example.springsecurity.service.UserService;
import com.example.springsecurity.util.FileUploadUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public ResponseEntity<?> signUp(@RequestParam("user") String user,@RequestParam("image") MultipartFile multipartFile)throws IOException
    {
        Etudiant e = new ObjectMapper().readValue(user, Etudiant.class);
        if (userService.findByEmail(e.getEmail()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        e.setImage(fileName);
        e.setBanned(false);
        Etudiant Suser = userService.saveUser(e);

        String uploadDir = "user-photos/" + Suser.getIdEtudiant();
        System.out.println(uploadDir);
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return new ResponseEntity<>(Suser, HttpStatus.CREATED);
    }

    @GetMapping("/showallusers")
    public ResponseEntity<?> ShowAllUsers(){
        userService.ShowAllStudent();
        return new ResponseEntity<>(userService.ShowAllStudent(), HttpStatus.OK);
    }



    @GetMapping("/getstatistic")
    public ResponseEntity<?> getstatic(){
        userService.Statistic();
        return new ResponseEntity<>(userService.Statistic(), HttpStatus.OK);
    }
    @PutMapping("/updateuseradmin/{id}")
    public ResponseEntity<?> udpateuserAdmin(@RequestBody Etudiant e , @PathVariable Long id){
        userService.UpdatEtudiantAdmin(e,id);
        return new ResponseEntity<>(userService.UpdatEtudiantAdmin(e,id), HttpStatus.OK);
    }
    @GetMapping("/getusernumber")
    public ResponseEntity<?> GETNUMBERUSER(){
        userService.getusernumber();
        return new ResponseEntity<>(userService.getusernumber(), HttpStatus.OK);
    }


}
