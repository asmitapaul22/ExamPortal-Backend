package com.exam.Service.implementation;

import com.exam.Service.UserService;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        //checking if the username of a particular user already exist in the database or not
    if(local!=null)
    {
        System.out.println("User already exist");
        throw new Exception("User already present in db");
    }
    else{
        //create user
        //looping through all the roles
        for(UserRole ur: userRoles)
        {
            //adding the roles in Role Entity table
            roleRepository.save(ur.getRole());
        }
        //setting all the roles in UserRole set of the User Entity table
        user.getUserRoles().addAll(userRoles);
        //saving the user to the database
        User savedUser = this.userRepository.save(user);
        return savedUser;
    }

    }
//GETTING USER BY USERNAME
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }
    //FOR DELETING A USER
    @Override
    public void deleteUser(Long userId) {
    this.userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(String username) {
        User user = this.userRepository.findByUsername(username);
        this.userRepository.save(user);
        return user;
    }


}
