package com.aswini.WebFluxExample.Repository;



import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.aswini.WebFluxExample.entity.Employee;


public interface UniversityRepository extends ReactiveMongoRepository<Employee, String> {

}
