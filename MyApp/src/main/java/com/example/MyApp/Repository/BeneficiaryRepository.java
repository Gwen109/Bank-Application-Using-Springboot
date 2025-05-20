package com.example.MyApp.Repository;

import com.example.MyApp.Model.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary,Integer> {


    //List<Beneficiary> findByLinkedaccno(Integer accno);
}
