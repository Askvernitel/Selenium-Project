package org.project.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {

    public static RequestSpecification defaultJsonSpec(){
        return new RequestSpecBuilder()
                .setBaseUri("https://automationexercise.com/api")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification defaultFormDataSpec(){
        return new RequestSpecBuilder()
                .setBaseUri("https://automationexercise.com/api")
                .setContentType(ContentType.URLENC)
                .log(LogDetail.ALL)
                .build();
    }
}
