package com.spring.microservice.authservice.service;

import com.spring.microservice.CreateOrSaveUserRequest;
import com.spring.microservice.CreateOrSaveUserResponse;
import com.spring.microservice.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class UserServer extends UserServiceGrpc.UserServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(UserServer.class);

    @Override
    public void createUser(CreateOrSaveUserRequest request, StreamObserver<CreateOrSaveUserResponse> responseObserver) {
        var userResponse = CreateOrSaveUserResponse.newBuilder()
                .setId(1)
                .setStatusMessage("OK")
                .build();

        logger.info(String.format("sent a message: %1s", request.getUser()));

        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();
    }
}
