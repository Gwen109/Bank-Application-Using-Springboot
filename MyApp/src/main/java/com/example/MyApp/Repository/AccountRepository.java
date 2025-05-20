package com.example.MyApp.Repository;

import com.example.MyApp.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    // Custom query to find the last account number.
    @Query(value = "SELECT accountnumber FROM accounts ORDER BY accountnumber DESC LIMIT 1", nativeQuery = true)
    Integer findLastAccountnumber();

    Account findByAccountNumber(Integer accno);
}
