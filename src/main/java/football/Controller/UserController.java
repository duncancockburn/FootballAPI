package football.Controller;

import football.Model.User;
import football.Service.AuthService;
import football.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

@RequestMapping("/footballusers")


public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;


    //Get
    @GetMapping("/userInfo")
    public ArrayList<User> getUsers() {
        return userService.getAllUsers();
    }
    //Create
    @PostMapping("/userCreate")
    public User addNew(@RequestBody User user) {
        return userService.addNew(user);
    }

    //Update
    @PatchMapping("/")
    public User updateById(@RequestBody User user) {
        return userService.updateById(user);
    }

    //Delete
    @DeleteMapping("/")
    public User deleteById(@RequestParam User user){
        return userService.deleteById(user.getId());
    }
}

