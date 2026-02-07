package tests.api;

import io.restassured.parsing.Parser;
import io.restassured.response.ResponseBody;
import org.apache.hc.core5.http.HttpStatus;
import org.project.base.ApiTestBase;
import org.project.client.AccountClient;
import org.project.dto.Account;
import org.project.utils.TestDataFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.empty;

public class AccountTest extends ApiTestBase {

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
                .parser("text/html", Parser.JSON)
                .body("responseCode", equalTo(200))
                .body("message", equalTo("Account deleted!"));

        accountClient.getAccountByEmail(account.getEmail())
                .then()
                .body("responseCode", not(equalTo(200)));
    }


    @Test
    public void updateAccount(){
        Account account = TestDataFactory.getAccount();
        accountClient.createAccount(account);

        account.setName("Test");
        accountClient.updateAccount(account)
                        .then()
                        .statusCode(HttpStatus.SC_SUCCESS)
                        .parser("text/html", Parser.JSON)
                        .body("responseCode", equalTo(200))
                        .body("message", equalTo("User updated!"));

        accountClient.getAccountByEmail(account.getEmail())
                .then()
                .parser("text/html", Parser.JSON)
                .body("user.name", equalTo("Test"));
    }


    @Test
    public void loginValidCredentials(){
        Account account = TestDataFactory.getAccount();

        accountClient.createAccount(account);

        accountClient.postVerifyLogin(account.getEmail(), account.getPassword())
                .then()
                .parser("text/html", Parser.JSON)
                .body("responseCode", equalTo(200))
                .body("message", equalTo("User exists!"));
    }

    @Test
    public void loginInvalidCredentials(){
        Account account = TestDataFactory.getAccount();

        accountClient.deleteAccount(account);
        accountClient.postVerifyLogin(account.getEmail(), account.getPassword())
                .then()
                .parser("text/html", Parser.JSON)
                .body("responseCode", not(equalTo(200)))
                .body("message", not(equalTo("User exists!")));
    }
    @Test
    public void loginBadRequest(){
        Account account = TestDataFactory.getAccount();

        accountClient.createAccount(account);
        accountClient.deleteVerifyLogin(account.getEmail(), account.getPassword())
                .then()
                .parser("text/html", Parser.JSON)
                .body("responseCode", equalTo(HttpStatus.SC_METHOD_NOT_ALLOWED))
                .body("message", equalTo("This request method is not supported."));
    }




}
