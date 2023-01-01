import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateList {
    public static void main(String[] args) {
        Singleton data =  Singleton.getInstance();
        Response response = RestAssured.
                given().
                baseUri("https://api.trello.com/1/lists").
                header("Content-Type", "application/json").
                queryParam("name", "My wonderful list").
                queryParam("idBoard",data.getBoardId()).
                queryParam("key", data.getAPIKEY()).
                queryParam("token", data.getTOKEN()).
                when().
                post();
        response.prettyPrint();
        JsonPath path = response.jsonPath();
        String listId = path.getString("id");
        data.setListId(listId);
        System.out.println("This is list id: " + data.getListId());

        //assertion on status code
        response.then().statusCode(200);
    }

}
