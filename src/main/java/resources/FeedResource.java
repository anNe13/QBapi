package resources;

import service.PostService;
import service.tools.ResponseService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/postfeed") //BASE URL
public class FeedResource {
PostService postService = new PostService();
ResponseService responseService = new ResponseService();


    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPosts() {
        String postString = postService.getAllPosts();
        return responseService.getAccecAllowedResponse()
                .entity(postString)
                .build();
    }
    @Path("{id}/location")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocationById(@PathParam("id") int id) {
        String locationString = postService.getLocationById(id);
        return responseService.getAccecAllowedResponse()
                .entity(locationString)
                .build();
    }



}