package com.app.repositry;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.EmployeeDetails;
import com.app.entity.SalaryDetails;

@Repository
public interface SalaryDetailsRepository extends JpaRepository<SalaryDetails, Long> {
//	List<SalaryDetails> findByAccountant(Accountant accountant);
	
	List<SalaryDetails> findByEmployee(EmployeeDetails employee);
	
//	@Query("SELECT s FROM SalaryDetails s WHERE s.accountant = :accountant AND MONTH(s.paymentDate) = :month AND YEAR(s.paymentDate) = :year")
//	List<SalaryDetails> findByAccountantAndPaymentDateMonthAndPaymentDateYear(@Param("accountant") Accountant accountant, @Param("month") int month, @Param("year") int year);
	
	 @Query("SELECT s FROM SalaryDetails s WHERE s.employee = :employee AND MONTH(s.paymentDate) = :month AND YEAR(s.paymentDate) = :year")
	    List<SalaryDetails> findByEmployeeAndPaymentDateMonthAndPaymentDateYear(@Param("employee") EmployeeDetails employee, @Param("month") int month, @Param("year") int year);

}
