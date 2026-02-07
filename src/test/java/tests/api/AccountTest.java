package tests.api;

import io.qameta.allure.*;
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

@Epic("API Tests")
@Feature("Account Management")
public class AccountTest extends ApiTestBase {

    private final AccountClient accountClient = new AccountClient();


    @Test
    @Story("Account Creation")
    @Description("Verify that a new account can be created via API")
    @Severity(SeverityLevel.BLOCKER)
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
    @Story("Account Deletion")
    @Description("Verify that an account can be deleted via API")
    @Severity(SeverityLevel.CRITICAL)
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
    @Story("Account Update")
    @Description("Verify that account information can be updated via API")
    @Severity(SeverityLevel.CRITICAL)
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
    @Story("Account Login")
    @Description("Verify that login succeeds with valid credentials via API")
    @Severity(SeverityLevel.BLOCKER)
    public void loginValidCredentials(){
        Account account = TestDataFactory.getAccount();

        accountClient.deleteAccount(account);

        accountClient.postVerifyLogin(account.getEmail(), account.getPassword())
                .then()
                .parser("text/html", Parser.JSON)
                .body("responseCode", equalTo(200))
                .body("message", equalTo("User exists!"));
    }

    @Test
    @Story("Account Login")
    @Description("Verify that login fails with invalid credentials via API")
    @Severity(SeverityLevel.CRITICAL)
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
    @Story("Account Login")
    @Description("Verify that login endpoint returns proper error for unsupported HTTP method")
    @Severity(SeverityLevel.NORMAL)
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
