package restSteps.privateBank;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import restSteps.ParentApi;

public class ApiPrivateBank extends ParentApi {
    /**
     * GET request to Private Bank
     * https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5
     * @param coursid
     * @return
     */
    public CurrencyValues[] getRequestToPrivateBankApi(Integer coursid) {
        return RestAssured.given()
                .contentType(ContentType.JSON)    // Header
                .queryParam("json")
                .queryParam("exchange")         //adding param to URL
                .queryParam("coursid", coursid) //adding param to URL
                .when()
                .get(apiEndPoints.privatbank_p24api_pubinfo()) // Base URL from apiEndPoints.properties
                .then()
                .statusCode(200)
                .extract()
                .response().getBody().as(CurrencyValues[].class);
    }
}

