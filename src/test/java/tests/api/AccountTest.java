package tests.api;

import io.restassured.parsing.Parser;
import org.apache.hc.core5.http.HttpStatus;
import org.project.client.AccountClient;
import org.project.dto.Account;
import org.project.utils.TestDataFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.empty;

public class AccountTest {

    private final AccountClient accountClient = new AccountClient();
    @Test
    public void createAccount(){
        Account account = TestDataFactory.getAccount();
        accountClient.deleteAccount(account);
        accountClient.createAccount(account)
                .then()
                .statusCode(HttpStatus.SC_SUCCESS)
                .parser("text/html", Parser.JSON)
                .body("responseCode", equalTo(201))
                .body("message", equalTo("User created!"));

    }

    @Test
    public void deleteAccount(){
        Account account = TestDataFactory.getAccount();
        accountClient.createAccount(account);
        accountClient.deleteAccount(account)
                .then()
                .statusCode(HttpStatus.SC_SUCCESS)
                .body("responseCode", equalTo(200))
                .body("message", equalTo("User updated!"));

        accountClient.getAccountByEmail(account.getEmail())
                .then()
                .statusCode(not(equalTo(200)));
    }




}
