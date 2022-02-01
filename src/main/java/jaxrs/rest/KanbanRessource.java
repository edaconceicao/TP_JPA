package jaxrs.rest;

import jaxrs.dao.generic.KanbanDao;
import jaxrs.domain.KanbanBoard;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/kanban")
@Produces({"application/json", "application/xml"})
public class KanbanRessource {

	@GET
    @Path("/mail")
    public List<KanbanBoard> getKanbansByEmail(@QueryParam("mail") String mail) {
        KanbanDao dao = new KanbanDao();
        return dao.getAllKanbansOfUser(mail);
    }
    @GET
    @Path("/allKanbans")
    public List<KanbanBoard> getAllKanbans() {
        KanbanDao dao = new KanbanDao();
        return dao.findAll();
    }
}
