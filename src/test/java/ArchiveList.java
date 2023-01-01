import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ArchiveList {
    public static void main(String[] args) {
        Singleton data =  Singleton.getInstance();
        Response response = RestAssured.
                given().
                baseUri("https://api.trello.com/1/lists/"+data.getListId()+"/closed").
                queryParam("key", data.getAPIKEY()).
                queryParam("token", data.getTOKEN()).
                queryParam("value",true).
                when().
                put();
        response.prettyPrint();

        //assertion on status code
        response.then().statusCode(200);
    }
}
