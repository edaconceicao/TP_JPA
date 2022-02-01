package jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.Parameter;
import jaxrs.domain.Pet;

@Path("/pet")
@Produces({"application/json", "application/xml"})
public class PetResource {

  @GET
  @Path("/{petId}")
  public Pet getPetById(@PathParam("petId") Long petId)  {
      // return pet
      return new Pet();
  }

  @POST
  @Path("addPet")
  @Consumes("application/json")
  public Response addPet(
      @Parameter(description = "Pet object that needs to be added to the store", required = true) Pet pet) {
      pet.setId(1);
      pet.setName("yo");
    return Response.ok().entity("SUCCESS").build();
  }

  @GET
  @Path("hello")
  @Consumes("application/json")
  public String printHello() {
    String word = "Hello";
    return word;
  }

}