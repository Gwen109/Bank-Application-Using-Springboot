package com.example.MyApp.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.MyApp.Model.Account;
import com.example.MyApp.Model.User;
import com.example.MyApp.Repository.AccountRepository;
import com.example.MyApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;

    public void registerUser(String userIdField,String passwordField,String accountNumberField){
        System.out.println("Inside register user method()");
        Account existingAccount =accountRepository.findByAccountNumber(Integer.valueOf(accountNumberField));
        if(existingAccount != null){
            System.out.println("account found");
            User user=new User(userIdField,passwordField,existingAccount);
            //created user object looks like : User{id=2, userIdField='bharg02', passwordField='vfdfgd', accountNumberField=Account{id=2, fullNameField='bharghavi', emailField='bh@gmail.com', mobileNumberField='78787878', addressField='mangadu', accountNumber=1000000002, balance=0}}

            userRepository.save(user);
            System.out.println("user registered");
            System.out.println(user);
        }
        else {
            System.out.println("Incorrect account number");
        }}

    //@ONETOONE fetches the linked account object automatically
    public User getLinkedAccountDetails(String userid){
       User userObjWithAccount = userRepository.findByUserIdField(userid);
       return userObjWithAccount;
    }
}