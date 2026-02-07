package tests.api;

import io.qameta.allure.*;
import io.restassured.parsing.Parser;
import org.apache.hc.core5.http.HttpStatus;
import org.project.base.ApiTestBase;
import org.project.client.ProductClient;
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
    public void getAllProducts(){
        productClient
                .getAllProducts()
                .then()
                .statusCode(HttpStatus.SC_SUCCESS)
                .using()
                    .parser("text/html", Parser.JSON)
                .body("responseCode", equalTo(200))
                .body("products", is(not(empty())));

    }


    @Test
    @Story("Get Brands")
    @Description("Verify that all brands can be retrieved via API")
    @Severity(SeverityLevel.NORMAL)
    public void getAllBrands(){
        productClient
                .getAllBrands()
                .then()
                .statusCode(HttpStatus.SC_SUCCESS)
                .using()
                .parser("text/html", Parser.JSON)
                .body("responseCode", equalTo(200))
                .body("brands", is(not(empty())));
    }

    @Test
    @Story("Get Products")
    @Description("Verify that POST method is not allowed for getting all products")
    @Severity(SeverityLevel.NORMAL)
    public void postAllProducts(){
        productClient
                .postAllProducts()
                .then()
                .parser("text/html", Parser.JSON)
                .body("responseCode", equalTo(405));
    }

    @Test
    @Story("Get Brands")
    @Description("Verify that PUT method is not allowed for getting all brands")
    @Severity(SeverityLevel.NORMAL)
    public void postAllBrands(){
        productClient
                .putAllBrands()
                .then()
                .parser("text/html", Parser.JSON)
                .body("responseCode", equalTo(405));
    }


}
