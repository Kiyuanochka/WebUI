package Lesson3;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;


public class ExampleTest extends AbstractTest {

        @Test

        void getSpecifyingRequestDataTest() {
            given()
                    .queryParam("apiKey", getApiKey())
                    .queryParam("includeNutrition", "false")
                    .pathParam("query", "pizza")
                    .when()
                    .get(getBaseUrl()+"recipes/{query}/information")
                    .then()
                    .statusCode(200);
            given()
                    .queryParam("apiKey", getApiKey())
                    .queryParam("includeNutrition", "false")
                    .pathParam("maxReadyTime", 50)
                    .when()
                    .get(getBaseUrl()+"recipes/{maxReadyTime}/information")
                    .then()
                    .statusCode(200);
            given()
                    .queryParam("apiKey", getApiKey())
                    .queryParam("includeNutrition", "false")
                    .pathParam("cuisine", "Italian")
                    .when()
                    .get(getBaseUrl()+"recipes/{cuisine}/information")
                    .then()
                    .statusCode(200);
            given()
                    .queryParam("apiKey", getApiKey())
                    .queryParam("includeNutrition", "false")
                    .pathParam("diet", "Vegan")
                    .when()
                    .get(getBaseUrl()+"recipes/{diet}/information")
                    .then()
                    .statusCode(200);
            given()
                    .queryParam("apiKey", getApiKey())
                    .queryParam("includeNutrition", "false")
                    .pathParam("equipment", "pan")
                    .when()
                    .get(getBaseUrl()+"recipes/{equipment}/information")
                    .then()
                    .statusCode(200);
            given()
                    .queryParam("apiKey", getApiKey())
                    .queryParam("includeNutrition", "false")
                    .pathParam("sort", "calories")
                    .when()
                    .get(getBaseUrl()+"recipes/{sort}/information")
                    .then()
                    .statusCode(200);



            given()
                    .queryParam("hash", "a3da66460bfb7e62ea1c96cfa0b7a634a346ccbf")
                    .queryParam("apiKey", getApiKey())
                    .body("{\n"
                            + " \"date\": 1644881179,\n"
                            + " \"slot\": 1,\n"
                            + " \"position\": 0,\n"
                            + " \"type\": \"INGREDIENTS\",\n"
                            + " \"value\": {\n"
                            + " \"ingredients\": [\n"
                            + " {\n"
                            + " \"name\": \"1 banana\"\n"
                            + " }\n"
                            + " ]\n"
                            + " }\n"
                            + "}")
                    .when()
                    .post(getBaseUrl()+"mealplanner/geekbrains/items")
                    .then()
                    .statusCode(200);

        }



    }

