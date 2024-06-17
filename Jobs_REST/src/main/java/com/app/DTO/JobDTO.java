package com.app.DTO;

import java.time.LocalDate;

public class JobDTO {
	private Long id;
	
	private String JobTitle;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String CompanyName;
	
	private String Location;
	
	private String Description;
	
	private String  Requirements;
	private Long Salary;
	
	private LocalDate PostingDate;
	
	

	public JobDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getJobTitle() {
		return JobTitle;
	}

	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getRequirements() {
		return Requirements;
	}

	public void setRequirements(String requirements) {
		Requirements = requirements;
	}

	public Long getSalary() {
		return Salary;
	}

	public void setSalary(Long salary) {
		Salary = salary;
	}

	public LocalDate getPostingDate() {
		return PostingDate;
	}

	public void setPostingDate(LocalDate postingDate) {
		PostingDate = postingDate;
	}
	
	

}
