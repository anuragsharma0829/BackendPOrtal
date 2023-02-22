package com.exam.controller;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.model.exam.Ehistory;
import com.exam.payload.MsgResponse;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.services.FileService;
import com.exam.services.UserService;
import com.exam.services.impl.EmailService;
import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.core.Authentication;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import static antlr.BaseAST.encode;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private FileService fileService;

    @Value("${project.image")
    private String path;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    PasswordEncoder encoder;

    //    Creating User
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        Set<UserRole> roles = new HashSet<>();
//        Encoding Password with BcryptPassWord Encoder
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setProfile("default.png");
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");
        UUID uuid = UUID.randomUUID();
        System.out.println("UUID=" + uuid.toString());
        user.setToken(String.valueOf(uuid));
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        roles.add(userRole);
        return this.userService.createUser(user, roles);
    }

//    GetUser By username

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

    //    Delete By ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        this.userService.deleteUser(id);
    }


    //    Get Users List
    @GetMapping("/")
    public ResponseEntity<?> userss() {
        Set<User> user = this.userService.getusers();
        return ResponseEntity.ok(user);
    }

    //Update User
    @PutMapping("/posts/{id}")
    public ResponseEntity<User> updateuser(@RequestBody User user, @PathVariable long id) {
        User updateUser = this.userService.updateUser(user, id);
        return new ResponseEntity<User>(updateUser, OK);
    }


    //user-image upload
    @PostMapping("/post/image/{id}")
    public ResponseEntity<User> uploadUserImage(@RequestParam("image") MultipartFile image, @PathVariable Long id) throws IOException {
        User user = this.userService.getUserById(id);
        String fileName = this.fileService.uploadImage(path, image);
        user.setProfile(fileName);
        User updatedUser = this.userService.updateUser(user, id);
        return new ResponseEntity<User>(updatedUser, OK);
    }

    //Serve image
    @GetMapping(value = "/post/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(
            @PathVariable("imageName") String imageName,
            HttpServletResponse response
    ) throws IOException {

        InputStream resource = this.fileService.getResource(path, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource, response.getOutputStream());

    }


    @GetMapping("/update/{id}")
    public ResponseEntity<User> getUserbyId(@PathVariable long id) {
        User user = this.userService.getUserById(id);
        return ResponseEntity.ok(user);
    }


    @GetMapping("/top/")
    public List<? extends Object> gethistory() {
        List<Object[]> orderTables = this.userRepository.getbytableno();
        if (orderTables.isEmpty()) {
            return (List<Ehistory>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something is went wrong");
        } else {
            HashMap hm = new HashMap();
            hm.put("Status", new String("true"));
            hm.put("message", new String("Token is verified"));
            return ResponseEntity.ok(orderTables).getBody();
        }
    }

//    Cheak Email
@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/{email}")
    public ResponseEntity<?>cheakEmail(@PathVariable("email") String email) throws MessagingException {
        Boolean result=this.userService.findByemail(email);
        if(result){
            String subject = "Exam Portal Password Generation";
            boolean resultt = this.emailService.Forgotpass(subject, email);
            if (result) {
                return ResponseEntity.ok(new MsgResponse("200","Email Sent SuccesFully"));

            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email Not Send");
            }
        }else{
            return new ResponseEntity<MsgResponse>(new MsgResponse("404", "Email Address not Found"), HttpStatus.NOT_FOUND);
        }
    }

//    /ForgotPAss
@PutMapping("/forgot/{email}")
public ResponseEntity<User> forgotPass(@PathVariable("email") String email, @RequestBody User user) {
    Optional<User> userdata = userRepository.findByEmail(email);
    if (userdata.isPresent()) {
        User user1 = userdata.get();
//        user1.setPassword(encode(user.getPassword()));
        user1.setPassword((encoder.encode(user.getPassword())));
        return new ResponseEntity<>(userRepository.save(user1), HttpStatus.OK);

    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

    @PutMapping("/{id}")
    public ResponseEntity<User> updateBook(@PathVariable Long id, @RequestBody User bookToUpdate) {
        Optional<User> optionalBook = userRepository.findById(id);
        if (optionalBook.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User existingBook = optionalBook.get();
        existingBook.setUsername(bookToUpdate.getUsername());
        existingBook.setFirstName(bookToUpdate.getFirstName());
        existingBook.setPhone(bookToUpdate.getPhone());
        User updatedBook = userRepository.save(existingBook);

        return ResponseEntity.ok(updatedBook);
    }
}








