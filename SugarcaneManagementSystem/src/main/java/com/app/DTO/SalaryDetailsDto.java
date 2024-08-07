package com.app.DTO;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SalaryDetailsDto {
    
   
    private String accountNumber;
 
    private String ifscCode;
    
    private LocalDate paymentDate;
    
    private Double salary;
    
    private String aadharNumber;

    
}