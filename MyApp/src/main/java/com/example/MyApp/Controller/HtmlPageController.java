package com.example.MyApp.Controller;

import com.example.MyApp.Model.Account;
import com.example.MyApp.Model.Beneficiary;
import com.example.MyApp.Service.AccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HtmlPageController {

    @Autowired
    AccountService accountService;


    @RequestMapping("/")
    public String displayWelcomePage(){
        return "welcomePage";
    }
    @RequestMapping("/registerPage")
    public String displayRegisterPage(){
        return "registerPage";
    }
    @RequestMapping("/createAccountPage")
    public String displayCreateAccountPage(){
        return "createAccountPage";
    }

    @RequestMapping("/dashboardPage")
    public String displayDashboardPage(HttpSession session, Model model){
        Integer accountno= (Integer) session.getAttribute("accountno");
        Account accountObj=accountService.fetchAccountRecord(accountno);
        model.addAttribute("CustomerName",accountObj.getFullNameField());
        model.addAttribute("Balance",accountObj.getBalance());
        return "dashboardPage";
    }

    @RequestMapping("/beneficiaryPage")
    public String displayBeneficiaries(HttpSession session,Model model){
        Integer accountno= (Integer) session.getAttribute("accountno");
        List<Beneficiary> beneficiaryList=accountService.fetchBeneficiaries(accountno);
        model.addAttribute("beneficiaryList",beneficiaryList);
        return "beneficiaryPage";
    }
}
