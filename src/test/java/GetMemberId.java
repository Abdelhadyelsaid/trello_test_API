import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetMemberId {
    public static void main(String[] args) {
        Singleton data = Singleton.getInstance();
        Response response = RestAssured.
                given().
                baseUri("https://api.trello.com/1/members/me").
                queryParam("key", data.getAPIKEY()).
                queryParam("token", data.getTOKEN()).
                when().
                get();
        response.prettyPrint();
        JsonPath path = response.jsonPath();
        String memberId = path.getString("id");
        data.memberId=memberId;
        //  System.out.println("This is Member id: " + data.getMemberId());
        //assertion on status code
        response.then().statusCode(200);
    }
}
