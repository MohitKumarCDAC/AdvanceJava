package com.app.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="job")
public class Jobs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="Job_Title",length = 30)
	private String JobTitle;
	@Column(name="Company_Name",length = 30)
	private String CompanyName;
	@Column(length = 30)
	private String Location;
	@Column(length=200)
	private String Description;
	@Column(length=100)
	private String  Requirements;
	private Long Salary;
	@Column(name="Posting_Date")
	private LocalDate PostingDate;
	
	public Jobs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Jobs(String jobTitle, String companyName, String location, String description, String requirements,
			Long salary, LocalDate postingDate) {
		super();
		JobTitle = jobTitle;
		CompanyName = companyName;
		Location = location;
		Description = description;
		Requirements = requirements;
		Salary = salary;
		PostingDate = postingDate;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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


	@Override
	public String toString() {
		return "Jobs [id=" + id + ", JobTitle=" + JobTitle + ", CompanyName=" + CompanyName + ", Location=" + Location
				+ ", Description=" + Description + ", Requirements=" + Requirements + ", Salary=" + Salary
				+ ", PostingDate=" + PostingDate + "]";
	}
	
	

}
