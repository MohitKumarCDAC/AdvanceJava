package com.app.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.CustomerDetailsDto;
import com.app.DTO.SellingDetailsDto;
import com.app.entity.CustomerDetails;
import com.app.entity.SellingDetails;
import com.app.entity.UserRegistration;
import com.app.exception.AadharNumberNotFound;
import com.app.repositry.CustomerDetailsRepository;
import com.app.repositry.SellingDetailsRepository;
import com.app.repositry.UserRegistrationRepository;

@Service
@Transactional
public class CustomerDetailsImpl{

	
	@Autowired
	private CustomerDetailsRepository custRepo;
	
	@Autowired
	private UserRegistrationRepository userRegistrationRepository;
	 
	@Autowired
	private SellingDetailsRepository sellingRepo;

	@Autowired
	private ModelMapper mapper;
	
	public CustomerDetailsDto addCustomer(CustomerDetailsDto customerDto)
	{
		//first check that aadhar number is valid or not
		UserRegistration customer=userRegistrationRepository.findByAadharNumber(customerDto.getAadharNumber());
		if(customer == null)
		{
			throw new AadharNumberNotFound("Customer with Aadhar number " + customerDto.getAadharNumber() + " not found.");
		}
		//convert DTO to entity
		CustomerDetails custDetails=mapper.map(customerDto, CustomerDetails.class);
		CustomerDetails details=custRepo.save(custDetails);
		return mapper.map(details, CustomerDetailsDto.class);
	}
	
	public SellingDetailsDto addSellingData(SellingDetailsDto sellingDto) {
	    CustomerDetails customer = custRepo.findByAadharNumber(sellingDto.getAadharNumber());
	    if (customer == null) {
	        throw new AadharNumberNotFound("Customer with Aadhar number " + sellingDto.getAadharNumber() + " not found.");
	    }
	    
	    SellingDetails sellingDetails = mapper.map(sellingDto, SellingDetails.class);
	    sellingDetails.setCustomer(customer);
	    
	    SellingDetails savedSellingDetails = sellingRepo.save(sellingDetails);
	    return mapper.map(savedSellingDetails, SellingDetailsDto.class);
	}

	public List<SellingDetailsDto> getSellingDetailByAadharNumber(String aadharNumber) {
	    CustomerDetails customer = custRepo.findByAadharNumber(aadharNumber);
	    if (customer == null) {
	        throw new AadharNumberNotFound("Customer with Aadhar number " + aadharNumber + " not found.");
	    }

	    List<SellingDetails> sell = sellingRepo.findByCustomer(customer);
	    return sell.stream()
	               .map(selling -> mapper.map(selling, SellingDetailsDto.class))
	               .collect(Collectors.toList());
	}

	public List<SellingDetailsDto> getSellingDetailsByDate(LocalDate date) {
	    List<SellingDetails> selling = sellingRepo.findBySellingDate(date);
	    System.out.println("Selling details fetched: " + selling);
	    return selling.stream()
	                  .map(sellingDetails -> {
	                      SellingDetailsDto dto = mapper.map(sellingDetails, SellingDetailsDto.class);
	                      System.out.println("Mapped DTO: " + dto);
	                      return dto;
	                  })
	                  .collect(Collectors.toList());
	}

	
}
