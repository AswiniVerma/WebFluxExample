package com.aswini.WebFluxExample.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aswini.WebFluxExample.Service.UniversityService;
import com.aswini.WebFluxExample.dto.EmployeeDto;
import com.aswini.WebFluxExample.dto.UniversityDto;
import com.aswini.WebFluxExample.entity.University;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UniversityController {
	@Autowired
	UniversityService universityService;
	@GetMapping("/university")
	public Flux<UniversityDto> getAllUniversity(){
		return universityService.getUniversityDetails();
	}
	
	@PostMapping("/add")
	@ResponseStatus(value = HttpStatus.CREATED)
    public Mono<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
        return universityService.addEmployee(employeeDto);
    }
}
