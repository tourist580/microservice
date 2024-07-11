package com.spring.microservice.authservice.payload.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateOrSaveUserRequest {

    private int userId;
    private String name;
    private String dob;
    private Double salary;
    private String email;
}
