package com.app.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.FarmerDto;
import com.app.DTO.PurchaseDetailsDto;
import com.app.entity.Farmer;
import com.app.entity.PurchaseDetails;
import com.app.entity.UserRegistration;
import com.app.exception.AadharNumberNotFound;
import com.app.repositry.FarmerRepository;
import com.app.repositry.PurchaseDetailRepository;
import com.app.repositry.UserRegistrationRepository;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private PurchaseDetailRepository purchaseDetailsRepository;
    
    @Autowired
    private UserRegistrationRepository userrepo;

    @Autowired
    private ModelMapper mapper;

    public FarmerDto saveFarmer(FarmerDto farmerDto) {
    	 // Fetch the employee by Aadhar number
        UserRegistration employee = userrepo.findByAadharNumber(farmerDto.getAadharNumber());
        if (employee == null) {
            throw new AadharNumberNotFound("Employee with Aadhar number " + farmerDto.getAadharNumber() + " not found.");
        }
    	Farmer farmer = mapper.map(farmerDto, Farmer.class);
        Farmer savedFarmer = farmerRepository.save(farmer);
        return mapper.map(savedFarmer, FarmerDto.class);
    }

    public PurchaseDetailsDto addPurchaseDetails(PurchaseDetailsDto purchaseDetailsDto) {
        Farmer farmer = farmerRepository.findByAadharNumber(purchaseDetailsDto.getAadharNumber());
        if (farmer == null) {
            throw new AadharNumberNotFound("Farmer with Aadhar number " + purchaseDetailsDto.getAadharNumber() + " not found.");
        }

        PurchaseDetails purchaseDetails = mapper.map(purchaseDetailsDto, PurchaseDetails.class);
        purchaseDetails.setFarmer(farmer);
        PurchaseDetails savedPurchaseDetails = purchaseDetailsRepository.save(purchaseDetails);
        return mapper.map(savedPurchaseDetails, PurchaseDetailsDto.class);
    }

    public List<PurchaseDetailsDto> getPurchasesByAadharNumber(String aadharNumber) {
        Farmer farmer = farmerRepository.findByAadharNumber(aadharNumber);
        if (farmer == null) {
            throw new AadharNumberNotFound("Farmer with Aadhar number " + aadharNumber + " not found.");
        }

        List<PurchaseDetails> purchases = purchaseDetailsRepository.findByFarmer(farmer);
        return purchases.stream()
                        .map(purchase -> mapper.map(purchase, PurchaseDetailsDto.class))
                        .collect(Collectors.toList());
    }

    public List<PurchaseDetailsDto> getPurchasesByDate(LocalDate date) {
        List<PurchaseDetails> purchases = purchaseDetailsRepository.findByPurchaseDate(date);
        return purchases.stream()
                        .map(purchase -> mapper.map(purchase, PurchaseDetailsDto.class))
                        .collect(Collectors.toList());
    }
}