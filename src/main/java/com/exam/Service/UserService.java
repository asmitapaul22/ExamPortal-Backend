package com.exam.Service;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;
//creating user

public interface UserService {
    //for creating a user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String username);

    //for deleting a user
    public void deleteUser(Long userId);

    //for updating a user
    public User updateUser(String username);

}
