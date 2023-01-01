import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateBoard {
    public static void main(String[] args) {
        Singleton data =  Singleton.getInstance();
        Response response = RestAssured.
                given().
                baseUri("https://api.trello.com/1/boards").
                header("Content-Type", "application/json").
                queryParam("name", "My Amazing Board").
                queryParam("key", data.getAPIKEY()).
                queryParam("token", data.getTOKEN()).
                queryParam("idOrganization",data.getOrganizationId()).
                when().
                post();
        response.prettyPrint();
        JsonPath path = response.jsonPath();
        String boardId = path.getString("id");
        data.setBoardId(boardId);
        System.out.println("This is board id: " + data.getBoardId());

        //assertion on status code
        response.then().statusCode(200);
    }
}
