package api;

import api.requestData.UserData;
import api.responseData.UserLogin;
import api.responseData.UserRegister;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected String username = "newSuperUser";
    protected String password = "1234567";
    protected String token;
    protected UserRegister userRegisterResponse;
    protected UserLogin userLoginResponse;


    @BeforeTest
    public void setup() {
        RestAssured.baseURI = "http://www.robotdreams.karpenko.cc/";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();

        userRegisterResponse = RestAssured.given()
                .body(new UserData(username, password))
                .when()
                .post("/user")
                .then().log().all().statusCode(200)
                .extract().body().as(UserRegister.class);

        System.out.println(userRegisterResponse.username + " " + userRegisterResponse.password + " === регистрация респонс");


        userLoginResponse = RestAssured.given()
                .queryParams("username",userRegisterResponse.username)
                .queryParams("password",userRegisterResponse.password)
                .when()
                .get("/login")
                .then().statusCode(200).extract().as(UserLogin.class);

        token = userLoginResponse.session_token;

        System.out.println(userLoginResponse.session_token + " "
                        + userLoginResponse.username + " "
                        + userLoginResponse.valid_to + " === логин респонс"
        );

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("user-token",token)
                .build();
    }
}
