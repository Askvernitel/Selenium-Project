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

    public Response getAccountByEmail(String email){
        String requestBody = String.format("""
            {
            "email":"%s"
            }
        """, email);
        return given().spec(RequestSpecFactory.defaultJsonSpec())
                .body(requestBody)
                .when()
                .get("/getUserDetailByEmail");
    }


}
