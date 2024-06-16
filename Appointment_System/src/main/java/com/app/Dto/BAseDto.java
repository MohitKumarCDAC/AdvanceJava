package com.app.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class BAseDto {
//use during serialization
//	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
//	@JsonProperty(access=Access.READ_ONLY)
	private LocalDate creationDate;
//	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime updationDate;
}
