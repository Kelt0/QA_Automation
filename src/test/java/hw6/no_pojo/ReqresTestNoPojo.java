package hw6.no_pojo;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Clock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ReqresTestNoPojo {
    private final static String URL = "https://reqres.in";

    @Test
    public void avatarCheckNoPojo(){
        Response response = given()
            .when()
            .contentType(ContentType.JSON)
            .get(URL+"/api/users?page=2")
            .then()
            .log()
            .all()
            .body("page", equalTo(2))
            .body("data.id", notNullValue())
            .body("data.email", notNullValue())
            .body("data.first_name", notNullValue())
            .body("data.last_name", notNullValue())
            .body("data.avatar", notNullValue())
            .extract().response();

        JsonPath jsonPath = response.jsonPath();
        List<String> emails = jsonPath.getList("data.email");
        List<Integer> ids = jsonPath.getList("data.id");
        List<String> avatars = jsonPath.getList("data.avatar");

        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i).toString()));
        }

        Assert.assertTrue(emails.stream().allMatch(x -> x.endsWith("@reqres.in")));
    }

    @Test
    public void registrationCheckNoPojo(){
        Integer expectedId = 4;
        String expectedToken = "QpwL5tke4Pnpja7X4";
        HashMap<String, String> emailPassword = new HashMap<>();
        emailPassword.put("email", "eve.holt@reqres.in");
        emailPassword.put("password", "pistol");
        Response response = given()
                .body(emailPassword)
                .when()
                .contentType(ContentType.JSON)
                .post(URL + "/api/register")
                .then()
                .log()
                .all()
                .body("id", equalTo(4))
                .body("token", equalTo("QpwL5tke4Pnpja7X4"))
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        Integer actualId = jsonPath.getInt("id");
        String actualToken = jsonPath.getString("token");
        Assert.assertEquals(actualId, expectedId);
        Assert.assertEquals(actualToken, expectedToken);

        HashMap<String,String> email = new HashMap<>();
        email.put("email", "sydney@fife");
        Response response1 = given()
                .body(email)
                .when()
                .contentType(ContentType.JSON)
                .post(URL + "/api/register")
                .then()
                .log()
                .all()
                .extract()
                .response();
        JsonPath jsonPath1 = response1.jsonPath();
        Assert.assertEquals("Missing password", jsonPath1.getString("error"));
    }

    @Test
    public void sortCheckNoPojo(){
        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/api/unknown")
                .then()
                .log()
                .all()
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
        List<Integer> years = jsonPath.getList("data.id");
        List<Integer> sortedYears = years.stream().sorted().toList();
        Assert.assertEquals(sortedYears, years);
    }

    @Test
    public void deleteUserNoPojo(){
        Response response = given().
                when()
                .delete(URL + "/api/users/2")
                .then()
                .log()
                .all()
                .extract()
                .response();
        Assert.assertEquals(response.getStatusCode(), 204);
    }

    @Test
    public void updateUserNoPojo(){
        HashMap<String, String> nameJob = new HashMap<>();
        nameJob.put("name", "morpheus");
        nameJob.put("job", "zion resident");
        Response response = given()
                .body(nameJob)
                .when()
                .contentType(ContentType.JSON)
                .put(URL + "/api/users/2")
                .then()
                .log()
                .all()
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
        String currentTime = Clock.systemUTC().instant().toString().substring(0, 19);
        String responseTime = jsonPath.getString("updatedAt").substring(0, 19);
        Assert.assertEquals(currentTime, responseTime);
    }
}
