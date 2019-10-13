package at.htl.quarkusJpa.rest;

import at.htl.quarkusJpa.facades.MeetingFacade;
import at.htl.quarkusJpa.facades.ProjectFacade;
import at.htl.quarkusJpa.model.Meeting;
import at.htl.quarkusJpa.model.Project;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("meetings")
public class MeetingResource
{
    @Inject
    MeetingFacade facade;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id")long id){
        Meeting m = facade.getById(id);
        return Response.ok().entity(m).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok().entity(facade.getAll()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Meeting m){
        facade.insert(m);
        return Response.ok().entity(m).build();
    }
}
