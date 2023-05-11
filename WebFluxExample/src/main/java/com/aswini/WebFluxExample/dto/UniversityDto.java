package com.aswini.WebFluxExample.dto;

import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UniversityDto {

	
	private List<String> domains;
	private String country;
	private String alpha_two_code;
	//private String stateProvince;
	private List<String> web_pages;
	private String name;
}
