package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Embeddable
public class Address {

	@Column(name="city_name",length=30)
	@NotBlank
	private String CityName;
	@NotBlank
	@Size(min = 6, message = "pincode must be at least 6 characters long")
	private int pincode;
	@NotBlank
	private String State;
	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public Address(@NotBlank String cityName, @NotBlank int pincode, @NotBlank String state) {
		super();
		CityName = cityName;
		this.pincode = pincode;
		State = state;
	}
	public Address()
	{
		
	}
	
}
