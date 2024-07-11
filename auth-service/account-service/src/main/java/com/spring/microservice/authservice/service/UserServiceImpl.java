package com.spring.microservice.authservice.service;

import com.spring.microservice.UserServiceGrpc;
import com.spring.microservice.authservice.payload.request.CreateOrSaveUserRequest;
import lombok.AllArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @GrpcClient("account-server")
    private final UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;


    @Override
    public void createUser(CreateOrSaveUserRequest request) {

        var user = com.spring.microservice.User.newBuilder()
                .setId(request.getUserId())
                .setName(request.getName())
                .setDob(request.getDob())
                .setSalary(request.getSalary())
                .build();

        var createUserRequest = com.spring.microservice.CreateOrSaveUserRequest.newBuilder()
                .setUser(user)
                .build();

        var userResponse = userServiceBlockingStub.createUser(createUserRequest);

        logger.info(String.format("Server sent a response: %1s", userResponse.getStatusMessage()));
    }
}
