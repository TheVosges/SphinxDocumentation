package edu.ib.spring_data.api;

import edu.ib.spring_data.dao.entity.User;
import edu.ib.spring_data.dao.entity.UserDTO;
import edu.ib.spring_data.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserApi {


    private UserManager userManager;

    @Autowired
    public UserApi(UserManager userManager) {
        this.userManager = userManager;
    }

    @GetMapping("/user/all")
    public Iterable<UserDTO> getAll() {
        return userManager.findAll();
    }

    @GetMapping("/user")
    public UserDTO geById(@RequestParam String name) {
        return userManager.find(name);
    }

    @PostMapping("admin/user")
    public UserDTO addCustomer(@RequestBody UserDTO user) {
        return  userManager.save(user);
    }
}
