package com.example.MyApp.Repository;

import com.example.MyApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {

    //fetching User record and associated Account record using userId
    /*Fetched User record(with linked account record) looks like => User{id=2,
                                                                         userIdField='bharg01',
                                                                         passwordField='1234',
                                                                         accountNumberField=  Account{
                                                                                                    id=2,
                                                                                                    fullNameField='bharghavi',
                                                                                                    emailField='bh@gmail.com',
                                                                                                    mobileNumberField='78787878',
                                                                                                    addressField='mangadu',
                                                                                                    accountNumber=1000000002,
                                                                                                    balance=10500}
                                                                         }
     */
    User findByUserIdField(String userid);

}
