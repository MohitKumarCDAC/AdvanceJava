package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "User", uniqueConstraints = {
	    @UniqueConstraint(columnNames = "email"),
	    @UniqueConstraint(columnNames = "aadhar_no")
	})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @NotBlank
    private String Name;

    @Column(length = 50, unique = true)
    @NotBlank
    @Email(message = "Email should be valid")
    private String Email;

    @Column(name = "contact_number", length = 10)
    @NotBlank
    @Size(min = 10, max = 10)
    @Pattern(regexp = "\\d{10}", message = "Contact number must be exactly 10 digits")
    private String ContactNumber;

    
    
    @Enumerated(EnumType.STRING)
    @Column(name="role" ,nullable = false)
    private Role Role;

    @Column(name = "aadhar_no", length = 12)
    @NotBlank
    @Size(min = 12, max = 12)
    @Pattern(regexp = "\\d{12}", message = "Aadhar number must be exactly 12 digits")
    private String aadharNumber;

    @NotBlank
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String Password;

    private Address address;

    
}
