package org.project.client;

import io.restassured.response.Response;
import org.project.dto.Account;
import org.project.utils.RequestSpecFactory;

import static io.restassured.RestAssured.given;

public class ProductClient {


    public Response getAllProducts(){
        return given().spec(RequestSpecFactory.defaultJsonSpec())
                .when()
                .get("/productsList");
    }
    public Response postAllProducts(){
        return given().spec(RequestSpecFactory.defaultJsonSpec())
                .when()
                .post("/productsList");
    }

    public Response getAllBrands(){
        return given().spec(RequestSpecFactory.defaultJsonSpec())
                .when()
                .get("/brandsList");
    }


    public Response postAllBrands(){
        return given().spec(RequestSpecFactory.defaultJsonSpec())
                .when()
                .post("/productsList");
    }




    public Response searchAllProducts(){
        return given().spec(RequestSpecFactory.defaultJsonSpec())
                .when()
                .get("/brandsList");
    }


}
