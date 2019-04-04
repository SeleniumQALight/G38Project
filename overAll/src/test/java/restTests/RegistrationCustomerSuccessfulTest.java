package restTests;

import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import restSteps.demoqa.ApiDemoQA;

import static libs.Utils.getDateAndTimeFormated;

public class RegistrationCustomerSuccessfulTest {
    @Test
    public void registrationSuccessful() {
//        String dateTime = getDateAndTimeFormated();
        String dateTime = "2019-03-28_21-35-10";

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Virender" + dateTime); // Cast
        requestParams.put("LastName", "Singh" + dateTime);
        requestParams.put("UserName", "sdimpleuser2dd20111" + dateTime);
        requestParams.put("Password", "password");
        requestParams.put("Email", "sample" + dateTime + "@gmail.com");

        ApiDemoQA apiDemoQA = new ApiDemoQA();
        ResponseBody response = apiDemoQA.custemerRegistrationByApi(requestParams);

        System.out.println("Respons " + response.asString());
        if (response.jsonPath().get("SuccessCode") == null) {
            String failCode = response.jsonPath().get("FaultId");
            Assert.fail(failCode);
        } else {
            Assert.assertEquals("Correct Success code was returned", response.jsonPath().get("SuccessCode"), "OPERATION_SUCCESS");
        }
    }
}

