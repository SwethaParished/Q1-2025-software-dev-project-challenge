package com.lc.backend_personal_finance_tracker.exception;


public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("We could not find the requested user");
    }
}
