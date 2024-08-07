package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.FarmerDto;
import com.app.DTO.PurchaseDetailsDto;
import com.app.Services.FarmerService;
import com.app.exception.AadharNumberNotFound;

@RestController
@RequestMapping("/api/farmers")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @PostMapping("/add")
    public ResponseEntity<?> addFarmer(@RequestBody FarmerDto farmerDto) {
        FarmerDto savedFarmer = farmerService.saveFarmer(farmerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFarmer);
    }

    @PostMapping("/add-purchase")
    public ResponseEntity<?> addPurchaseDetails(@RequestBody PurchaseDetailsDto purchaseDetailsDto) {
        try {
            PurchaseDetailsDto savedPurchase = farmerService.addPurchaseDetails(purchaseDetailsDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPurchase);
        } catch (AadharNumberNotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/purchases/aadhar/{aadharNumber}")
    public ResponseEntity<?> getPurchasesByAadharNumber(@PathVariable String aadharNumber) {
        try {
            List<PurchaseDetailsDto> purchases = farmerService.getPurchasesByAadharNumber(aadharNumber);
            return ResponseEntity.ok(purchases);
        } catch (AadharNumberNotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/purchases/date/{date}")
    public ResponseEntity<?> getPurchasesByDate(@PathVariable String date) {
        try {
            LocalDate purchaseDate = LocalDate.parse(date);
            List<PurchaseDetailsDto> purchases = farmerService.getPurchasesByDate(purchaseDate);
            return ResponseEntity.ok(purchases);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
