package tests.api;

import io.qameta.allure.*;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.apache.hc.core5.http.HttpStatus;
import org.project.base.ApiTestBase;
import org.project.client.ProductClient;
import org.project.utils.ApiUtils;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

@Epic("API Tests")
@Feature("Product Management")
public class ProductTest extends ApiTestBase {

    private final ProductClient productClient = new ProductClient();

    @Test
    @Story("Get Products")
    @Description("Verify that all products can be retrieved via API")
    @Severity(SeverityLevel.CRITICAL)
    public void getAllProducts() {
        Response response = productClient.getAllProducts();
        response.then().statusCode(HttpStatus.SC_SUCCESS).using().parser("text/html", Parser.JSON).body("responseCode", equalTo(200)).body("products", is(not(empty())));

        ApiUtils.attachResponse(response);
    }

    @Test
    @Story("Get Brands")
    @Description("Verify that all brands can be retrieved via API")
    @Severity(SeverityLevel.NORMAL)
    public void getAllBrands() {
        Response response = productClient.getAllBrands();
        response.then().statusCode(HttpStatus.SC_SUCCESS).using().parser("text/html", Parser.JSON).body("responseCode", equalTo(200)).body("brands", is(not(empty())));

        ApiUtils.attachResponse(response);
    }

    @Test
    @Story("Get Products")
    @Description("Verify that POST method is not allowed for getting all products")
    @Severity(SeverityLevel.NORMAL)
    public void postAllProducts() {
        Response response = productClient.postAllProducts();
        response.then().parser("text/html", Parser.JSON).body("responseCode", equalTo(405));

        ApiUtils.attachResponse(response);
    }

    @Test
    @Story("Get Brands")
    @Description("Verify that PUT method is not allowed for getting all brands")
    @Severity(SeverityLevel.NORMAL)
    public void postAllBrands() {
        Response response = productClient.putAllBrands();
        response.then().parser("text/html", Parser.JSON).body("responseCode", equalTo(405));

        ApiUtils.attachResponse(response);
    }
}