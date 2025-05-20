package com.example.MyApp.Controller;

import com.example.MyApp.Model.Account;
import com.example.MyApp.Model.User;
import com.example.MyApp.Service.AccountService;
import com.example.MyApp.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class ControllerClass {

    @Autowired
    AccountService accountService;
    @Autowired
    UserService userService;


    @PostMapping("/createaccount")
    public void handleCreateAccount(@ModelAttribute("accountobj") Account account){
        accountService.createAccount(account);

    }


    @PostMapping("/register")
    public String handleRegister(@RequestParam String userIdField,
                                 @RequestParam String passwordField,
                                 @RequestParam String accountNumberField){
        System.out.println("inside controller method");
        userService.registerUser(userIdField,passwordField,accountNumberField);
        return "dummy";
    }


    @PostMapping("/login")
    public String handleLogin(@RequestParam("userIdField") String userIdField, HttpServletRequest request){
        User userObjWithAccount = userService.getLinkedAccountDetails(userIdField);
        HttpSession session = request.getSession();
        session.setAttribute("accountno", userObjWithAccount.getAccountNumberField().getAccountNumber());
        System.out.println("Session attribute accountno :" + session.getAttribute("accountno"));

        return "redirect:/dashboardPage";
    }









}
