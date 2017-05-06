package service;

import com.google.gson.Gson;
import db.Statements;
import exception.DataNotFoundException;

public class PostService {
    private Statements statements = new Statements();

    public String getAllPosts(){

        Gson gson = new Gson();
        String postString = gson.toJson(statements.getAllPosts());
        if(postString == null){
            throw new DataNotFoundException("No posts found");
        }

        return postString;
    }
    public String getLocationById(int id){
        Gson gson = new Gson();
        String locationString = gson.toJson(statements.getPostLocationById(id));
      if(locationString == null || locationString.equals("null")){
            throw new DataNotFoundException("No location set to post by id " + id);
        }
        return locationString;
    }
}
