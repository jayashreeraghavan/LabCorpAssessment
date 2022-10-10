package com.labcorp.restassured;

import com.google.gson.Gson;
import com.labcorp.restassured.wsdto.UsersWsDTO;
import org.testng.annotations.Test;

import java.util.Date;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class TestRestAssured {


    @Test
    public void testPost() {

        UsersWsDTO usersWsDTO = new UsersWsDTO();
        usersWsDTO.setEmployee_firstname("Julia Bruen");
        usersWsDTO.setEmployee_lastname("Bruen");
        usersWsDTO.setEmployee_phonenumbe("264-783-9453");
        usersWsDTO.setEmployee_emaildress("test@test.com");
        usersWsDTO.setCitemployee_addressy("citemployee_address hello");
        usersWsDTO.setStateemployee_dev_level("stateemployee_dev_level");
        usersWsDTO.setEmployee_gender("employee_gender");
        usersWsDTO.setEmployee_hire_date(new Date());
        usersWsDTO.setEmployee_onleave(true);

        Gson gson = new Gson();
        String jsonInString = gson.toJson(usersWsDTO);
        given().
                body(jsonInString).
                when().
                post("https://63436a942dadea1175a78677.mockapi.io/test/user").
                then().assertThat()
                .statusCode(201);
    }


    @Test
    public void testGet() {

        given().get("https://63436a942dadea1175a78677.mockapi.io/test/user?id=10").then().
                statusCode(200).
                body("employee_firstname", hasItems("Julia Bruen")).
                log().all();
    }

    @Test
    public void testPhoneNumber() {

        given().get("https://63436a942dadea1175a78677.mockapi.io/test/user?id=10").then().
                statusCode(200).
                body("employee_phonenumbe", hasItems("employee_phonenumbe 10")).
                log().all();
    }

    @Test
    public void testGender() {

        given().get("https://63436a942dadea1175a78677.mockapi.io/test/user?id=10").then().
                statusCode(200).
                body("employee_gender", hasItems("employee_gender 10")).
                log().all();
    }

    @Test
    public void testEmailAddress() {

        given().get("https://63436a942dadea1175a78677.mockapi.io/test/user?id=10").then().
                statusCode(200).
                body("ademployee_emaildress", hasItems("ademployee_emaildress 10")).
                log().all();
    }
}
