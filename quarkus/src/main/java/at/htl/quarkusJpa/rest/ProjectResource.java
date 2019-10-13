package at.htl.quarkusJpa.rest;

import at.htl.quarkusJpa.facades.ProjectFacade;
import at.htl.quarkusJpa.model.Project;

import javax.inject.Inject;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("projects")
public class ProjectResource {
    @Inject
    ProjectFacade facade;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id")long id){
        Project p = facade.getById(id);
        return Response.ok().entity(p).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok().entity(facade.getAll()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Project p){
        facade.insert(p);
        return Response.ok().entity(p).build();
    }
}
