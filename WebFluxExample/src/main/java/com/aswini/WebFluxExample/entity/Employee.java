package com.aswini.WebFluxExample.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("employeeDocument")
public class Employee {
	@Id
    private String id;
    private String name;
    private String age;
}
