import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetOrganizations {
    public static void main(String[] args) {
        Singleton data = Singleton.getInstance();
        Response response = RestAssured.
                given().
                baseUri("https://api.trello.com/1/members/"+ data.memberId +"/organizations").
                queryParam("key", data.getAPIKEY()).
                queryParam("token", data.getTOKEN()).
                when().
                get();
        response.prettyPrint();

        //assertion on status code
        response.then().statusCode(200);
    }
}
