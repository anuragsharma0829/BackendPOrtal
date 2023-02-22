package com.exam.services;

import com.exam.model.User;
import com.exam.model.UserRole;


import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

//    Creating User
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
//    Get USer by userName
     public User getUser(String username);

//     Delete user by ID
    public void deleteUser(Long id);

//    Update user
User updateUser(User user, Long id);

//    Get All users
public Set<User> getusers();

    User getUserById(Long id);

//    existnacy email
    Boolean findByemail(String email);


}
