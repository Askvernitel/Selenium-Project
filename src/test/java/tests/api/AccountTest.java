package tests.api;

import io.qameta.allure.*;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.apache.hc.core5.http.HttpStatus;
import org.project.base.ApiTestBase;
import org.project.client.AccountClient;
import org.project.dto.Account;
import org.project.utils.ApiUtils;
import org.project.utils.TestDataFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

@Epic("API Tests")
@Feature("Account Management")
public class AccountTest extends ApiTestBase {

    private final AccountClient accountClient = new AccountClient();

    @Test
    @Story("Account Creation")
    @Description("Verify that a new account can be created via API")
    @Severity(SeverityLevel.BLOCKER)
    public void createAccount() {
        Account account = TestDataFactory.getAccount();
        ApiUtils.attachRequest(account);
        accountClient.deleteAccount(account);

        Response response = accountClient.createAccount(account);
        response.then().statusCode(HttpStatus.SC_SUCCESS).parser("text/html", Parser.JSON).body("responseCode", equalTo(201)).body("message", equalTo("User created!"));

        ApiUtils.attachResponse(response);
    }

    @Test
    @Story("Account Deletion")
    @Description("Verify that an account can be deleted via API")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteAccount() {
        Account account = TestDataFactory.getAccount();
        ApiUtils.attachRequest(account);
        accountClient.createAccount(account);

        Response response = accountClient.deleteAccount(account);
        response.then().statusCode(HttpStatus.SC_SUCCESS).parser("text/html", Parser.JSON).body("responseCode", equalTo(200)).body("message", equalTo("Account deleted!"));

        ApiUtils.attachResponse(response);

        Response verifyResponse = accountClient.getAccountByEmail(account.getEmail());
        verifyResponse.then().body("responseCode", not(equalTo(200)));

        ApiUtils.attachResponse(verifyResponse);
    }

    @Test
    @Story("Account Update")
    @Description("Verify that account information can be updated via API")
    @Severity(SeverityLevel.CRITICAL)
    public void updateAccount() {
        Account account = TestDataFactory.getAccount();
        ApiUtils.attachRequest(account);
        accountClient.createAccount(account);

        account.setName("Test");
        ApiUtils.attachRequest(account);

        Response response = accountClient.updateAccount(account);
        response.then().statusCode(HttpStatus.SC_SUCCESS).parser("text/html", Parser.JSON).body("responseCode", equalTo(200)).body("message", equalTo("User updated!"));

        ApiUtils.attachResponse(response);

        Response verifyResponse = accountClient.getAccountByEmail(account.getEmail());
        verifyResponse.then().parser("text/html", Parser.JSON).body("user.name", equalTo("Test"));

        ApiUtils.attachResponse(verifyResponse);
    }

    @Test
    @Story("Account Login")
    @Description("Verify that login succeeds with valid credentials via API")
    @Severity(SeverityLevel.BLOCKER)
    public void loginValidCredentials() {
        Account account = TestDataFactory.getAccount();
        ApiUtils.attachRequest(account);
        accountClient.createAccount(account);

        Response response = accountClient.postVerifyLogin(account.getEmail(), account.getPassword());
        response.then().parser("text/html", Parser.JSON).body("responseCode", equalTo(200)).body("message", equalTo("User exists!"));

        ApiUtils.attachResponse(response);
    }

    @Test
    @Story("Account Login")
    @Description("Verify that login fails with invalid credentials via API")
    @Severity(SeverityLevel.CRITICAL)
    public void loginInvalidCredentials() {
        Account account = TestDataFactory.getAccount();
        ApiUtils.attachRequest(account);
        accountClient.deleteAccount(account);

        Response response = accountClient.postVerifyLogin(account.getEmail(), account.getPassword());
        response.then().parser("text/html", Parser.JSON).body("responseCode", not(equalTo(200))).body("message", not(equalTo("User exists!")));

        ApiUtils.attachResponse(response);
    }

    @Test
    @Story("Account Login")
    @Description("Verify that login endpoint returns proper error for unsupported HTTP method")
    @Severity(SeverityLevel.NORMAL)
    public void loginBadRequest() {
        Account account = TestDataFactory.getAccount();
        ApiUtils.attachRequest(account);
        accountClient.createAccount(account);

        Response response = accountClient.deleteVerifyLogin(account.getEmail(), account.getPassword());
        response.then().parser("text/html", Parser.JSON).body("responseCode", equalTo(HttpStatus.SC_METHOD_NOT_ALLOWED)).body("message", equalTo("This request method is not supported."));

        ApiUtils.attachResponse(response);
    }
}