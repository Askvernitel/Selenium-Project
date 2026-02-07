package org.project.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import java.io.ByteArrayInputStream;

public class ApiUtils {

    public static void attachRequest(Object requestObj) {
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = "";
        try {
            requestJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        Allure.addAttachment(
                "API Request",
                "application/json",
                new ByteArrayInputStream(requestJson.getBytes()),
                ".json"
        );
    }

    public static void attachResponse(Response response) {
        Allure.addAttachment(
                "API Response",
                "application/json",
                new ByteArrayInputStream(response.getBody().asPrettyString().getBytes()),
                ".json"
        );
    }
}