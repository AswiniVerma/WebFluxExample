package com.aswini.WebFluxExample.entity;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class University {
	
		@Id
		//private String id;
		private List<String> domains;
		private String country;
		private String alpha_two_code;
		//private String stateProvince;
		private List<String> web_pages;
		private String name;
		
		
}
