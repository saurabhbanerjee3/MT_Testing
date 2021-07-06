package testcases;

import com.sun.source.tree.AssertTree;
import com.utils.AmzBaseSetup;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.core.net.Priority;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import java.io.IOException;

import static io.restassured.RestAssured.*;


public class RestApiTest extends AmzBaseSetup {

    @BeforeTest
    public void testSetup () throws IOException {
      RestAssured.baseURI = getProp().getProperty("baseuri");

    }

    @Test (priority = 1)
    public void getEmployeeDetails () throws IOException {

        RequestSpecification rs = RestAssured.given();
        Response res = rs.request(Method.GET,getProp().getProperty("uriGet"));
        String resBody = res.getBody().asString();
        log.info("Response body of the employee details is \n" + resBody);

        int  statusCode = res.getStatusCode();
        Assert.assertEquals(statusCode,200,"The status code is matched ");
        log.info("Validate the status code ");

        Assert.assertEquals(resBody.contains("Successfully! Record has been fetched."),true);
        log.info("Validate the request ");

    }

    @Test (priority=2 )
    public void delEmployee () throws IOException {
        RequestSpecification rs = RestAssured.given();
        Response res = rs.request(Method.DELETE,getProp().getProperty("uriDelEmployee"));
        String resBody = res.getBody().asString();
        log.info("Response body of the employee details is \n" + resBody);

        int  statusCode = res.getStatusCode();
        Assert.assertEquals(statusCode,200,"The status code is not  matched ");
        log.info("Validate the status ");

        Assert.assertEquals(resBody.contains("Successfully! Record has been deleted"),true);
        log.info("Validate the request sucessfully ");

    }
}
