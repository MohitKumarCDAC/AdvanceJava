package com.app.Dto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto extends BAseDto{
	private String patientName;
    private String doctorName;
    private LocalDateTime date;
//    private LocalTime time;
}
