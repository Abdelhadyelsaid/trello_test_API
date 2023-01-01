import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteOrganization {
    public static void main(String[] args) {
        Singleton data =  Singleton.getInstance();
        Response response = RestAssured.
                given().
                baseUri("https://api.trello.com/1/organizations/"+data.getOrganizationId()).
                queryParam("key", data.getAPIKEY()).
                queryParam("token", data.getTOKEN()).
                when().
                delete();
        response.prettyPrint();

        //assertion on status code
        response.then().statusCode(200);
    }
}
