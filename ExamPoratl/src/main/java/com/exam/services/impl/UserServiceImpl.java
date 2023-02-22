package com.exam.services.impl;

import com.exam.Exception.ResourceNotFoundException;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    //    Creating User
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already there");
            throw new Exception("User alrady present");
        } else {
//         User Create
            for (UserRole ur : userRoles) {
                roleRepository.save((ur.getRole()));
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    //    Get userBy username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    //Delete User By ID
    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user, Long id) {
        User user1= userRepository.findById(id).get();
        User user2= userRepository.save(user1);
        return user2;
    }

    //    /try
//    @Override
//    public User updateUser(User user, Long id) {
//        User user1=this.userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
//        user.setUsername(user1.getUsername());
//        user.setLastName(user1.getLastName());
//        user.setFirstName(user1.getFirstName());
//        user.setPhone(user1.getPhone());
//        User updatedUser=this.userRepository.save(user1);
//        return updatedUser;
//    }

    @Override
    public Set<User> getusers() {
        return new LinkedHashSet<>(this.userRepository.findAll());
    }

    @Override
    public User getUserById(Long id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "Id", id));
        return user;
    }

    @Override
    public Boolean findByemail(String email) {
       return this.userRepository.existsByEmail(email);
    }


}
