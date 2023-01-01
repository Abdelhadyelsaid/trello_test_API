import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateOrganization {
    public static void main(String[] args) {
        Singleton data =  Singleton.getInstance();
        Response response = RestAssured.
                given().
                baseUri("https://api.trello.com/1/organizations").
                header("Content-Type", "application/json").
                queryParam("displayName", "Test Organization").
                queryParam("key", data.getAPIKEY()).
                queryParam("token", data.getTOKEN()).
                when().
                post();
        response.prettyPrint();
        JsonPath path = response.jsonPath();
        String organizationId = path.getString("id");
         data.setOrganizationId(organizationId);
       // System.out.println("This is Org id: " + data.getOrganizationId());

        //assertion on status code
        response.then().statusCode(200);
    }
}
