package com.lc.backend_personal_finance_tracker.controller;

import com.lc.backend_personal_finance_tracker.entity.User;
import com.lc.backend_personal_finance_tracker.exception.UserNotFoundException;
import com.lc.backend_personal_finance_tracker.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/user")
    User newUser(@RequestBody User user) { return userRepo.save(user);}

//    @PutMapping("/user/{id}")
//    public ResponseEntity<?> editUser(@RequestBody User userDetails, @PathVariable Long id) {
//        User updateUser = userRepo.findById(id).get();
//        updateUser.setUsername(userDetails.getUsername());
//        updateUser.setEmail(userDetails.getEmail());
//        updateUser.setPassword(userDetails.getPassword());
//        userRepo.save(updateUser);
//        return ResponseEntity.ok(updateUser);
//    }

    @GetMapping("/user")
    List<User> getAllUsers() { return userRepo.findAll(); }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        User passUser = userRepo.findByUsername(username);
        return new ResponseEntity<>(passUser, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepo.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepo.deleteById(id);
        return  "User with id "+id+" has been deleted successfully.";
    }

}