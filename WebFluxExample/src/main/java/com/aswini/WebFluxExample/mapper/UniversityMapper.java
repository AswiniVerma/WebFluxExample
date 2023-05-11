package com.aswini.WebFluxExample.mapper;

import com.aswini.WebFluxExample.dto.UniversityDto;
import com.aswini.WebFluxExample.entity.University;

public class UniversityMapper {
	public static UniversityDto mapToUniversityDto(University university) {
		return new UniversityDto(
				university.getDomains(),
				university.getCountry(),
				university.getAlpha_two_code(),
				university.getWeb_pages(),
				university.getName()
				);
		}
	
	public static University mapToUniversity(UniversityDto universityDto) {
		return new University(
				universityDto.getDomains(),
				universityDto.getCountry(),
				universityDto.getAlpha_two_code(),
				universityDto.getWeb_pages(),
				universityDto.getName()
				
			
				);
	}
}
