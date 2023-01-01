import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteBoard {
    public static void main(String[] args) {
        Singleton data =  Singleton.getInstance();
        Response response = RestAssured.
                given().
                baseUri("https://api.trello.com/1/boards/"+data.getBoardId()).
                queryParam("key", data.getAPIKEY()).
                queryParam("token", data.getTOKEN()).
                when().
                delete();
        response.prettyPrint();

        //assertion on status code
        response.then().statusCode(200);
    }
}
