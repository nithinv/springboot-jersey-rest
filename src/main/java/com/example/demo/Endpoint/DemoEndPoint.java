package com.example.demo.Endpoint;

import com.example.demo.Model.Message;
import com.example.demo.Model.User;
import com.example.demo.Service.MessageService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List ;

/**
 * Created by vadyan on 6/23/2017.
 */
@Component
@Path("/")
public class DemoEndPoint {

    @Autowired
    private UserService userService ;

    @Autowired
    private MessageService messageService ;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getEventVersion1(@PathParam("id") String id) {
        return userService.findById(id) ;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
        return "Hello World" ;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/messages")
    public List<Message> message() {
        return messageService.getMessages();
    }


}
