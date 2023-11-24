package com.employeemanagement.employeemanagementbackend.controller;

import com.employeemanagement.employeemanagementbackend.exception.UserNotFoundException;
import com.employeemanagement.employeemanagementbackend.model.User;
import com.employeemanagement.employeemanagementbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//sending data to database
@RestController
//@CrossOrigin("http://localhost:3000")
@CrossOrigin("*")

public class UserController {
    // need to inject user repository interface for that we are using @autowired annotation
    @Autowired
    private UserRepository userRepository;

    //for posting data we have postmapping annotation

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) { //passing the json body for that we are using RequestBody annotation
        System.out.println(userRepository.save(newUser));
        return userRepository.save(newUser); //post the data and return the data which we have posted
    }

    @GetMapping("/users")
        //to get the all the users
    List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepository.findById(id)
                .map(user ->{
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    System.out.println (userRepository.save(user));
                    return userRepository.save(user);
                }).orElseThrow(()-> new UserNotFoundException(id));

    }

    @DeleteMapping("user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        System.out.println("Deleting user");
        userRepository.deleteById(id);
        System.out.println(id + "deleted");
        return "User with id " +id+" has been deleted successfully";
    }

}


