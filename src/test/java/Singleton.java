
public final class Singleton {
    private String TOKEN = "ATTA275a8cfc2c8e239510e5d7b36f3fdcb7af5c288f371028928b5f95c44a470f7b48CAECAE";
    private String APIKEY = "6304bbcf43512263ba8156151da766da";
    private static Singleton single_instance;
    public static String organizationId;//63b1cb554ac288040e23f500
    public static String memberId;//6111642a447306587ec2a01b
    private String boardId;//63b1ca5a321695052c9e0988
    private String listId;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (single_instance == null) {
            single_instance = new Singleton();
        }
        return single_instance;
    }

    public String getTOKEN() {
        return TOKEN;
    }

    public String getAPIKEY() {
        return APIKEY;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }
}
