package com.example.MyApp.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "users")
public class User {
    public User(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="userID",unique = true, nullable=false)
    private String userIdField;

    @Column(name="password", nullable=false)
    private String passwordField;

    @OneToOne
    @JoinColumn(name="linkedaccountno",referencedColumnName = "accountnumber",unique = true, nullable=false)
    private Account accountNumberField;



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userIdField='" + userIdField + '\'' +
                ", passwordField='" + passwordField + '\'' +
                ", accountNumberField=" + accountNumberField +
                '}';
    }

    public User(String userID, String password, Account accountNo) {
        this.userIdField = userID;
        this.passwordField = password;
        this.accountNumberField = accountNo;

    }


}
