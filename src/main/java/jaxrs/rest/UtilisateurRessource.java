package jaxrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.Parameter;
import jaxrs.dao.generic.UtilisateurDao;
import jaxrs.domain.Utilisateur;


@Path("/utilisateur")
@Produces({"application/json", "application/xml"})
public class UtilisateurRessource {

	@GET
    @Path("/name")
    public List<Utilisateur> getUserByName(@QueryParam("name") String name) {
        UtilisateurDao userdao = new UtilisateurDao();
        return userdao.getUserByName(name);
    }
    @GET
    @Path("/email")
    public Utilisateur getUserByEmail(@QueryParam("email") String email) {
        UtilisateurDao userdao = new UtilisateurDao();
        return userdao.getUserByEmail(email);
    }
    @GET
    @Path("/allUsers")
    public List<Utilisateur> getAllUsers() {
        UtilisateurDao userdao = new UtilisateurDao();
        return userdao.getAllUsers();
    }

    @POST
    @Path("addUser")
    @Consumes("application/json")
    public javax.ws.rs.core.Response addUtilisateur(
            @Parameter(description = "User object", required = true) Utilisateur utilisateur) {
        UtilisateurDao userdao = new UtilisateurDao();
        userdao.save(utilisateur);
        return Response.ok().build();
    }

    @PUT
    @Path("/updateUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(
            @Parameter(description = "User object ( the email can't be modify)", required = true) Utilisateur utilisateur) {
        UtilisateurDao userdao = new UtilisateurDao();
        userdao.update(utilisateur);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Path("/deleteUser/email")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@QueryParam("email") String email) {
        UtilisateurDao userdao = new UtilisateurDao();
        userdao.delete(userdao.getUserByEmail(email));
        return Response.ok().build();
    }
}
