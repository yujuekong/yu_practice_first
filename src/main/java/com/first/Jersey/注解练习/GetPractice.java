package com.first.Jersey.注解练习;

import com.first.domain.Message;
import com.first.guice.jpa.GuiceJpaService;
import com.google.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by yujuekong on 2017/6/26.
 */
@Path("/api/get-practice")
public class GetPractice{

    @Inject
    private GuiceJpaService jpaService;

    @GET
    @Path("get-message")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Message getMessage(){
        System.out.println("getMessage");
        return jpaService.find();
    }
}
