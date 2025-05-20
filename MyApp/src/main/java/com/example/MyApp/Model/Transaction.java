package com.example.MyApp.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="transactions")
public class Transaction {
    public Transaction() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="senderaccno",nullable =false)
    private Integer linkedaccno;

    @Column(name="receivername",nullable =false)
    private String receivername;

    @Column(name="receiverbank",nullable =false)
    private String receiverbank;

    @Column(name="receiveraccno",nullable =false)
    private String receiveraccno;

    @Column(name="amount",nullable =false)
    private String amount;

}
