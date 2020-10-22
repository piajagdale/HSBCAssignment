package Com.StepDefinetion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

import static io.restassured.RestAssured.given;

public class ForeignRatesAPI {
	Response res;
	 		
	@Given("Rates API for latest foreign exchange rates")
	public void setUpAPI() {
		RestAssured.baseURI ="https://api.ratesapi.io/api/";
	}

	@When("The API is Available")
	public void invokeAPI() {
	   res=  RestAssured.given().header("Content-Type", "application/json")
			   .when().get("latest")
			   .then().log().all().assertThat().statusCode(200).extract().response();
	     
	}

	@Then("Verify the success status code of the response is success")
	public void validateAPIStatus() {
		
		 Assert.assertEquals(200, res.getStatusCode());
	    
		 System.out.println("Status Code of Response is :" + res.getStatusCode());

	}
	
}
