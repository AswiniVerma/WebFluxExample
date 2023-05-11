package com.aswini.WebFluxExample.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.aswini.WebFluxExample.Exceptions.EmptyInputException;
import com.aswini.WebFluxExample.Exceptions.InvalidValueException;
import com.aswini.WebFluxExample.Repository.UniversityRepository;
import com.aswini.WebFluxExample.dto.EmployeeDto;
import com.aswini.WebFluxExample.dto.UniversityDto;
import com.aswini.WebFluxExample.entity.Employee;
import com.aswini.WebFluxExample.entity.University;
import com.aswini.WebFluxExample.mapper.EmployeeMapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UniversityService  {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(University.class);
	@Autowired
	WebClient webClient;
	
	 @Autowired
	    private UniversityRepository universityRepository;
	 	String universityApi = "http://universities.hipolabs.com/search?country=United+States";

	public Flux<UniversityDto> getUniversityDetails(){
				return webClient.get()
                .uri(universityApi)
                .retrieve()
                .bodyToFlux(UniversityDto.class)
                .doOnError(throwable -> LOGGER.error("Failed for some reason", throwable));
	}
	
    public Mono<EmployeeDto> addEmployee(EmployeeDto employeeDto) {
    	Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        if(employee.getName().isEmpty() || employee.getName().length()==0 || employee.getAge().isEmpty()
        		||employee.getName().length()==0){
            throw new EmptyInputException("601","Input fields are empty");
        }
        int empAge = Integer.parseInt(employee.getAge());
        if(empAge<1 || empAge>100 ) {
        	throw new InvalidValueException("602","Invalid Age");
        }
        Mono<Employee> savedEmployee = universityRepository.save(employee);
        return savedEmployee.map((employeeEntity) -> EmployeeMapper.mapToEmployeeDto(employeeEntity));
    }
}
