package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class TestOnLocalApi {

  //  @Test
    public void get() {
        baseURI = "http://localhost:3000";

        given().get("/users").then().statusCode(200).log().all();
    }

//    @Test
//    public void testPut() {
//
//        JSONObject request = new JSONObject();
//
//        request.put("firstName", "Raghav");
//        request.put("lastName", "Teacher");
//        request.put("subjectId", 1);
//
//        System.out.println(request.toJSONString());
//
//        baseURI = "http://localhost:3000";
//
//        given().
//                contentType(ContentType.JSON).
//                accept(ContentType.JSON).
//                body(request.toJSONString()).when().
//                post("/users").
//                then().
//                statusCode(201).
//                log().all();
//    }


}
