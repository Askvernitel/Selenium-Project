package org.project.client;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.project.dto.Account;
import org.project.utils.RequestSpecFactory;

public class AccountClient {


    public Response createAccount(Account account){
        return given().spec(RequestSpecFactory.defaultJsonSpec())
                .body(account)
                .when()
                .post("/create");
    }
}
