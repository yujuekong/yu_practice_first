package com.first.Jersey;

import com.first.domain.Message;
import com.first.guice.jpa.GuiceJpaService;
import com.google.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by yujuekong on 2017/6/26.
 */
@Path("/api/get-practice")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetPractice{

    @Inject
    private GuiceJpaService jpaService;

    @GET
    @Path("get-message")
    public List<Message> getMessage(){
        System.out.println("getMessage");
        return jpaService.findAll();
    }

    @POST
    @Path("save-message")
    public Response saveMessage(Message message){
        jpaService.saveMessage(message);
        return Response.ok().build();
    }
}
