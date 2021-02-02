package com.stack.graphq.error;

import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import java.util.List;

public class CustomErrorHandler extends RuntimeException implements GraphQLErrorHandler {

    public CustomErrorHandler(String message, HttpStatus httpStatus) {
        super(message + " " + httpStatus.toString() + " "  + httpStatus.name());
    }

    public CustomErrorHandler(String message) {
        super(message);
    }

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        return null;
    }

}
