package com.example.MyApp.Service;

import com.example.MyApp.Model.Account;
import com.example.MyApp.Model.Beneficiary;
import com.example.MyApp.Model.User;
import com.example.MyApp.Repository.AccountRepository;
import com.example.MyApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;


    public Integer generatedAccountNumber(){
       Integer lastaccnumber= accountRepository.findLastAccountnumber();
        System.out.println("last acc number  is " + lastaccnumber);
       Integer newaccnumber =lastaccnumber+1;
       System.out.println("new acc number  is " + newaccnumber);
       return newaccnumber;
    }

    public void createAccount(Account account){
        account.setAccountNumber(generatedAccountNumber());
        account.setBalance(0);
        System.out.println("inside createaccount() method");
        accountRepository.save(account);
        System.out.println("after save()"); }

    public Account fetchAccountRecord(Integer accno){

        return accountRepository.findByAccountNumber(accno);
    }

    //fetching Beneficiaries inside Account Object
    //@ONETOMANY automatically fetches all the beneficiary records related the account object
    public List<Beneficiary> fetchBeneficiaries(Integer accno){

        Account accountObj=fetchAccountRecord(accno);
        return accountObj.getBeneficiaries();
    }


}
