package service.tools;

import javax.ws.rs.core.Response;

public class ResponseService {

    public Response.ResponseBuilder getAccecAllowedResponse(){

        Response.ResponseBuilder response = Response
                .status(200);
        for (AccessHeaderEnum a: AccessHeaderEnum.values()){
            response.header(a.getAccesString(), a.getAccesValue());
        }
        return response;

    }
}
