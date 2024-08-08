package com.app;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.DTO.EmployeeDetailsDto;
import com.app.DTO.PurchaseDetailsDto;
import com.app.DTO.SalaryDetailsDto;
import com.app.DTO.SellingDetailsDto;
import com.app.entity.EmployeeDetails;
import com.app.entity.PurchaseDetails;
import com.app.entity.SalaryDetails;
import com.app.entity.SellingDetails;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean // equivalent to <bean id ..../> in xml file
	public ModelMapper mapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<PurchaseDetails, PurchaseDetailsDto>() {
		@Override
		protected void configure()
		{
			map(source.getFarmer().getAadharNumber(), destination.getAadharNumber());
		}
		});
		
		modelMapper.addMappings(new PropertyMap<SellingDetails, SellingDetailsDto>() {
			@Override
			protected void configure()
			{
				map(source.getCustomer().getAadharNumber(), destination.getAadharNumber());
			}
			});
		modelMapper.addMappings(new PropertyMap<SalaryDetails,SalaryDetailsDto>() {
			@Override
			protected void configure()
			{
				map(source.getEmployee().getAadharNumber(), destination.getAadharNumber());
			}
			});
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
				.setPropertyCondition(Conditions.isNotNull());
		return modelMapper;
	}

}
