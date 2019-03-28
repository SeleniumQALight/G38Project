package restSteps.demoqa;

import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import restSteps.ParentApi;

import static io.restassured.RestAssured.given;

public class ApiDemoQA extends ParentApi {
    public ResponseBody custemerRegistrationByApi(JSONObject requestParams){
        return given()
                .contentType(ContentType.JSON)
                .body(requestParams.toMap())
                .when()
                .post(apiEndPoints.restapi_demoqa_com_customer_register())
                .then()
                .statusCode(200)
                .extract()
                .response().getBody();
    }
}

