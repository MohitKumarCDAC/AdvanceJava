package com.app.Services;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.EmployeeDetailsDto;
import com.app.DTO.SalaryDetailsDto;
import com.app.entity.EmployeeDetails;
import com.app.entity.SalaryDetails;
import com.app.entity.UserRegistration;
import com.app.exception.AadharNumberNotFound;
import com.app.exception.SalaryException;
import com.app.repositry.EmployeeDetailsRepository;
import com.app.repositry.SalaryDetailsRepository;
import com.app.repositry.UserRegistrationRepository;

@Service
public class EmployeeDetailsServices {

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;
    
    @Autowired
	private SalaryDetailsRepository salaryRepo;
    
    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @Autowired
    private ModelMapper mapper;
    

    public EmployeeDetailsDto saveEmployeeDetails(EmployeeDetailsDto dto) {
        // Fetch the employee by Aadhar number
        UserRegistration employee = userRegistrationRepository.findByAadharNumber(dto.getAadharNumber());
        if (employee == null) {
            throw new AadharNumberNotFound("Employee with Aadhar number " + dto.getAadharNumber() + " not found.");
        }

        // Convert DTO to entity
        EmployeeDetails employeeDetails = mapper.map(dto, EmployeeDetails.class);
        EmployeeDetails emp=employeeDetailsRepository.save(employeeDetails);
        // Save employee details to database
        return mapper.map(emp, EmployeeDetailsDto.class);
    }

    public SalaryDetailsDto addEmployeeSalary(SalaryDetailsDto salarydto) {
	    EmployeeDetails employee =employeeDetailsRepository.findByAadharNumber(salarydto.getAadharNumber());
	    if (employee == null) {
	        throw new AadharNumberNotFound("Accountant with Aadhar number " + salarydto.getAadharNumber() + " not found.");
	    }

	    // Extract month and year from payment date
	    LocalDate paymentDate = salarydto.getPaymentDate();
	    int month = paymentDate.getMonthValue();
	    int year = paymentDate.getYear();

	    // Check if a salary record for the same month and year already exists
	    List<SalaryDetails> existingSalaries = salaryRepo.findByEmployeeAndPaymentDateMonthAndPaymentDateYear(employee, month, year);
	    if (!existingSalaries.isEmpty()) {
	        throw new SalaryException("Salary already added for this month.");
	    }

	    SalaryDetails salaryDetails = mapper.map(salarydto, SalaryDetails.class);
	    salaryDetails.setEmployee(employee); // Ensure this is set

	    SalaryDetails savedSalary = salaryRepo.save(salaryDetails);
	    return mapper.map(savedSalary, SalaryDetailsDto.class);
	}

    
    
    
    
    
    public List<SalaryDetailsDto> getAllSalariesByAadharNumber(String aadharNumber) {
        EmployeeDetails employee = employeeDetailsRepository.findByAadharNumber(aadharNumber);
        if (employee == null) {
            throw new AadharNumberNotFound("Accountant with Aadhar number " + aadharNumber + " does not exist.");
        }
        List<SalaryDetails> salaries = salaryRepo.findByEmployee(employee);
        return salaries.stream()
                       .map(salary -> mapper.map(salary, SalaryDetailsDto.class))
                       .collect(Collectors.toList());
    }
    public EmployeeDetailsDto updateEmployeeDetails(String aadharNumber, EmployeeDetailsDto dto) {
        // Fetch the employee by Aadhar number
        EmployeeDetails existingEmployee = employeeDetailsRepository.findByAadharNumber(aadharNumber);
        if (existingEmployee == null) {
            throw new AadharNumberNotFound("Employee with Aadhar number " + aadharNumber + " not found.");
        }

        // Update the existing employee details with the new data
        existingEmployee.setName(dto.getName());
        existingEmployee.setAadharNumber(dto.getAadharNumber());
        // Add any other fields that need to be updated

        // Save the updated employee details to the database
        EmployeeDetails updatedEmployee = employeeDetailsRepository.save(existingEmployee);
        return mapper.map(updatedEmployee, EmployeeDetailsDto.class);
    }
}

