package hw6.api;


import io.cucumber.java.zh_tw.而且;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private final static String URL = "https://reqres.in";

    @Test
    public void avatarCheck (){
        List<UserData> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/api/users?page=2")
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getList("data", UserData.class);
        users.stream().forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
        users.stream().forEach(x->Assert.assertTrue(x.getEmail().endsWith("reqres.in")));
    }

    @Test
    public void registrationCheck(){
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register register = new Register("eve.holt@reqres.in", "pistol");
        SuccessfulReg successfulReg = given()
                .body(register)
                .when()
                .contentType(ContentType.JSON)
                .post(URL + "/api/register")
                .then()
                .log()
                .all()
                .extract()
                .as(SuccessfulReg.class);
        Assert.assertEquals(id,successfulReg.getId());
        Assert.assertEquals(token, successfulReg.getToken());

        Register register1 = new Register("sydney@fife");
        UnsuccessfulReg unsuccessfulReg = given()
                .body(register1)
                .when()
                .contentType(ContentType.JSON)
                .post(URL + "/api/register")
                .then()
                .log()
                .all()
                .extract()
                .as(UnsuccessfulReg.class);
        Assert.assertEquals("Missing password", unsuccessfulReg.getError());
    }

    @Test
    public void sortCheck(){
        List<ListSortData> sortDataList = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/api/unknown")
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getList("data", ListSortData.class);
        List<Integer> years = sortDataList.stream().map(x -> x.getYear()).collect(Collectors.toList());
        List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(sortedYears, years);
    }

    @Test
    public void deleteUser(){
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
    public void updateUser(){
       UpdateUserData user = new UpdateUserData("morpheus", "zion resident");
       TimeData userTimeResponse = given()
               .body(user)
               .when()
               .contentType(ContentType.JSON)
               .put(URL + "/api/users/2")
               .then()
               .log()
               .all()
               .extract()
               .as(TimeData.class);
        String currentTime = Clock.systemUTC().instant().toString().substring(0, 19);
        String responseTime = userTimeResponse.getUpdatedAt().substring(0, 19);
        Assert.assertEquals(currentTime, responseTime);
        System.out.println(userTimeResponse.getUpdatedAt());

    }

}
