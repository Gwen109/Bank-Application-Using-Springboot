package com.example.MyApp.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Beneficiaries")
public class Beneficiary {

    public Beneficiary(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="beneficiaryname" ,nullable = false)
    private String Beneficiaryname;

    @Column(name="beneficiarybank", nullable = false)
    private String Beneficiarybank;

    @Column(name="beneficiaryaccno" , nullable = false)
    private Integer Beneficiaryaccno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="linkedaccno", referencedColumnName = "accountnumber")
    private Account Linkedaccno;

    public Beneficiary(String beneficiaryname, String beneficiarybank, Integer beneficiaryaccno, Account linkedaccno) {
        this.Beneficiaryname = beneficiaryname;
        this.Beneficiarybank = beneficiarybank;
        this.Beneficiaryaccno = beneficiaryaccno;
        this.Linkedaccno = linkedaccno;
    }

    @Override
    public String toString() {
        return "Beneficiary{" +
                "id=" + id +
                ", Beneficiaryname='" + Beneficiaryname + '\'' +
                ", Beneficiarybank='" + Beneficiarybank + '\'' +
                ", Beneficiaryaccno=" + Beneficiaryaccno +
                ", Linkedaccno=" + Linkedaccno +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBeneficiaryname() {
        return Beneficiaryname;
    }

    public void setBeneficiaryname(String beneficiaryname) {
        this.Beneficiaryname = beneficiaryname;
    }

    public String getBeneficiarybank() {
        return Beneficiarybank;
    }

    public void setBeneficiarybank(String beneficiarybank) {
        this.Beneficiarybank = beneficiarybank;
    }

    public Integer getBeneficiaryaccno() {
        return Beneficiaryaccno;
    }

    public void setBeneficiaryaccno(Integer beneficiaryaccno) {
        this.Beneficiaryaccno = beneficiaryaccno;
    }

    public Account getLinkedaccno() {
        return Linkedaccno;
    }

    public void setLinkedaccno(Account linkedaccno) {
        this.Linkedaccno = linkedaccno;
    }
}
