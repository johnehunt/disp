package com.jjh.rest;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/echo")
public class Echo {

	@GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getMessage(@PathParam("id") String id) {
		System.out.println("Echo.getM<essage(" + id + ")");
		Info info =  new Info(id, (new Date()).toString());
		return Response.status(Response.Status.OK).entity(info).build();
	}

}
