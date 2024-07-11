package com.spring.microservice.authservice.service;

import com.spring.microservice.authservice.payload.request.CreateOrSaveUserRequest;

public interface UserService {

    public void createUser(CreateOrSaveUserRequest request);
}
