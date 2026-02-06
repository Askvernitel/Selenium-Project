package tests.api;

import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.apache.hc.core5.http.HttpStatus;
import org.project.base.ApiTestBase;
import org.project.client.ProductClient;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class ProductTest extends ApiTestBase {

    private final ProductClient productClient = new ProductClient();


    @Test
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
}
