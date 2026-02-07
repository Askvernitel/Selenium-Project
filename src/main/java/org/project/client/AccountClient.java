package org.project.client;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.project.dto.Account;
import org.project.utils.RequestSpecFactory;

public class AccountClient {


    public Response createAccount(Account account){
        return given().spec(RequestSpecFactory.defaultFormDataSpec())
                .formParams(account.toMap())
                .when()
                .post("/createAccount");
    }


    public Response deleteAccount(Account account){
        return given().spec(RequestSpecFactory.defaultFormDataSpec())
                .formParams(account.toMap())
                .when()
                .delete("/deleteAccount");
    }

    public Response updateAccount(Account account){
        return given().spec(RequestSpecFactory.defaultFormDataSpec())
                //.body(account)
                .formParams(account.toMap())
                .when()
                .put("/updateAccount");
    }

    public Response getAccountByEmail(String email){
        return given().spec(RequestSpecFactory.defaultFormDataSpec())
                .param("email", email)
                .when()
                .get("/getUserDetailByEmail");
    }

    public Response postVerifyLogin(String email, String password){

        return given().spec(RequestSpecFactory.defaultFormDataSpec())
                .param("email", email)
                .param("password", password)
                .when()
                .post("/verifyLogin");
    }


    public Response deleteVerifyLogin(String email, String password){
        return given().spec(RequestSpecFactory.defaultJsonSpec())
                .param("email", email)
                .param("password", password)
                .when()
                .delete("/verifyLogin");
    }

}
