package com.exam.controller;

import com.exam.Service.UserService;
import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    //FOR CREATING A USER
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        user.setProfile("default.png");
        Set<UserRole> roles=new HashSet<>();
        Role role=new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);

        return this.userService.createUser(user,roles);
    }
    //FOR GETTING USER BY USERNAME
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username")String username){
return this.userService.getUser(username);
    }
    //FOR DELETING USER
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId")Long userId)
    {
        this.userService.deleteUser(userId);
    }
    //FOR UPDATING A USER
    @PostMapping("/{username}")
    public User updateUser(@PathVariable("username") String username)
    {
        return this.userService.updateUser(username);

    }

}
