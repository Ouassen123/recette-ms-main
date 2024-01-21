package com.example.user.ws.provided;

import com.example.user.bean.User;
import com.example.user.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/user")
public class UserWs {
    @Autowired
    private UserService userService;

    @GetMapping("/ref/{ref}")
    public User findByRef(@PathVariable String ref) {
        return userService.findByRef(ref);
    }


    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return userService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }
    @PostMapping("/")
    public User save(@RequestBody User user) {
        userService.save(user);
        return user;
    }
    @PostMapping("/authentification")
    public User authentification(@RequestBody User user) {

        return userService.authentification(user);
    }


    @PutMapping("/")
    public int update(@RequestBody User user) {
        return userService.update(user);
    }

}
