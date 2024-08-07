package com.app.repositry;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Farmer;
import com.app.entity.PurchaseDetails;

@Repository
public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetails, Long> {
    List<PurchaseDetails> findByFarmer(Farmer farmer);
    List<PurchaseDetails> findByPurchaseDate(LocalDate purchaseDate);
   
}
