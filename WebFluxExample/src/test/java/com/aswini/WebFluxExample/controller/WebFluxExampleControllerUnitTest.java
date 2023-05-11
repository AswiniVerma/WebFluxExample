package com.aswini.WebFluxExample.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.aswini.WebFluxExample.Controller.UniversityController;
import com.aswini.WebFluxExample.Service.UniversityService;
import com.aswini.WebFluxExample.dto.UniversityDto;
import com.aswini.WebFluxExample.dto.EmployeeDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = UniversityController.class)
public class WebFluxExampleControllerUnitTest {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@MockBean
	private UniversityService universityService;
	
	@Test
	public void givenEmployeeObject_whenCreateEmployee_thenReturnSavedEmployee() throws Exception{
		EmployeeDto employee = EmployeeDto.builder().
				name("Aswini").
				age("24").
				build();
		
		given(universityService.addEmployee(any(EmployeeDto.class)))
        .willReturn(Mono.just(employee));

// when - action or behaviour that we are going test
WebTestClient.ResponseSpec response = webTestClient.post().uri("/add")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .body(Mono.just(employee), UniversityDto.class)
        .exchange();

// then - verify the result or output using assert statements
response.expectStatus().isCreated()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("$.name").isEqualTo(employee.getName())
        .jsonPath("$.age").isEqualTo(employee.getAge());
        
}
	
	@Test
    public void givenListOfUniversity_whenGetAllUniversity_thenReturnUniversityList() {

        // given - precondition or setup
        List<UniversityDto> listOfUniversity = new ArrayList<>();
        listOfUniversity.add(UniversityDto.builder().
        		domains(null).
        		country("United States").
        		alpha_two_code("US").
        		web_pages(null).
        		name("Marywood University").
        		build());
        listOfUniversity.add(UniversityDto.builder().
        		domains(null).
        		country("United States").
        		alpha_two_code("US").
        		web_pages(null).
        		name("Lindenwood University").
        		build());
        Flux<UniversityDto> employeeFlux = Flux.fromIterable(listOfUniversity);
        given(universityService.getUniversityDetails()).willReturn(employeeFlux);

        // when - action or behaviour that we are going test
        WebTestClient.ResponseSpec response = webTestClient.get().uri("/university")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
        // then - verify the result or output using assert statements
        response.expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(UniversityDto.class)
                .consumeWith(System.out::println);
    }

	}


