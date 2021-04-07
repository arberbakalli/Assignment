package restAPI;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum Endpoints {


    POSTS("Can call a list of posts or a single post by it's ID","/posts"),

    COMMENTS("grab a list of comments","/comments"),
    ALBUM("grabs a list of albums","/album"),
    PHOTOS("list of photos","/photos"),
    TODOS("list of todos", "/todos"),
    USERS("list of users","/users");

    String summary;
    String path;

    Endpoints(String summary, String path){
        this.summary = summary;
        this.path = path;
    }

    public String getSummary(){
        return this.summary;
    }

    public String getPath(){
        return this.path;
    }
}