package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetAndPostExamples {

    //@Test
    public void testGet() {
        baseURI = "https://reqres.in/api";

        given().
                get("/users?page=2").
        then().
               statusCode(200).
               body("data[2].id", equalTo(9)).
               body("data.first_name", hasItems("George", "Byron"));
    }
    @Test
    public void testPut() {
        Map<String, Object> map = new HashMap<String, Object>();

//        map.put("name", "Raghav");
//        map.put("job", "Teacher");
//        System.out.println(map);

        JSONObject request = new JSONObject(map);

        request.put("name", "Raghav");
        request.put("job", "Teacher");

        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
            post("/users").
        then().
            statusCode(201).
                log().all();
    }
}
