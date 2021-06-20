package TestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAPI {

	@Test(priority=8)

	public void RESTApiTest_validate_WrondCredentialsResponse() {

		RestAssured.baseURI = "https://gateway.healthrecoverysolutions.com";

		String response = given().log().headers()
				.body("{\"data\":{\"type\":\"credentials\",\"username\":\"testing\",\"password\":\"test\",\"source\":\"ClinicianConnect 2\"}}")
				.when().post("/v1/tokens").then().assertThat().statusCode(422).and().contentType(ContentType.JSON)
				.extract().response().asString();

		System.out.println(response);

		JsonPath js = new JsonPath(response);
		String message = js.getString("message");
		Assert.assertEquals("Invalid Credentials", message);
		System.out.println("Error message is " + message);

	}

	@Test(priority=9)

	public void RESTApiTest_validate_ConfigProperties() {

		RestAssured.baseURI = "https://healthrecoverysolutions.zendesk.com";

		String response = given().log().headers().when().get("embeddable/config").then().assertThat().statusCode(200)
				.and().contentType(ContentType.JSON).extract().response().asString();

		System.out.println(response);

		JsonPath js = new JsonPath(response);
		String brand = js.getString("brand");
		Assert.assertEquals("HRS Support", brand);
		System.out.println("Brand is displayed as " + brand);
		String brandlogourl = js.getString("brandLogoUrl");
		Assert.assertEquals("https://healthrecoverysolutions.zendesk.com/system/brands/360000125292/HRS-Logo_thumb.png",
				brandlogourl);
		System.out.println("URL is displayed as " + brandlogourl);
		String language = js.getString("locale");
		Assert.assertEquals("en-US", language);
		System.out.println("language is displayed as " + language);

	}

	@Test(priority=10)

	public void RESTApiTest_validate_LoginProperties() {

		RestAssured.baseURI = "https://cc.healthrecoverysolutions.com";

		String response = given().log().headers().when().get("app/login/Login.html").then().assertThat().statusCode(200)
				.and().contentType(ContentType.HTML).extract().response().asString();

		System.out.println(response);

	}
	
	@Test(priority=11)

	public void RESTApiTest_validate_ForgotpwdProperties() {

		RestAssured.baseURI = "https://cc.healthrecoverysolutions.com";

		String response = given().log().headers().when().get("app/forgotPassword/ForgotPassword.html").then().assertThat().statusCode(200)
				.and().contentType(ContentType.HTML).extract().response().asString();

		System.out.println(response);

	}
	
	
	@Test(priority=12)

	public void RESTApiTest_validate_MainComponents() {

		RestAssured.baseURI = "https://cc.healthrecoverysolutions.com";

		String response = given().log().headers().when().get("app/MainComponent/MainComponent.html").then().assertThat().statusCode(200)
				.and().contentType(ContentType.HTML).extract().response().asString();

		System.out.println(response);

	}

}
