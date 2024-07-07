package ServiceNowRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.TestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class RequestHandling
{
    @Test
    public void createIncidentUsingPost()
    {
        //Base URI
        RestAssured.baseURI="https://dev191668.service-now.com/api/now/table/incident";

        //Authentication
        RestAssured.authentication=RestAssured.basic("admin","Muruga@1994");

        //Request Specification
        RequestSpecification requestSpecification=RestAssured.given().header("Content-Type","application/json")
                .body("{\"short_description\": \"Created from Postman by VR15\",\"category\": \"Software\"}");

        //Response
        Response response=requestSpecification.request(Method.POST);

        //Response Code
        System.out.println("Status code : "+response.getStatusLine());

        //Response
        System.out.println("Request is : "+response.asPrettyString());
    }
}
