package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import BDD.App;
import BDD.MemberDAO;
import BDD.ProjectDAO;


@Path("/project")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProjectDBRessource {
	private static ProjectDAO daoProject = App.getDbi().open(ProjectDAO.class);
	private static MemberDAO daoMember = App.getDbi().open(MemberDAO.class);

	public ProjectDBRessource() {
		try {
			daoProject.createProjectTable();
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
	}
	
	
	@POST
	@Path("/{pseudo}")
	public Project createProject(@PathParam("pseudo") String pseudo, Project project) {
		
		new Project();
		project.setId(id + 1);
		project.addMember(member);
		projects.put(project.getId(), project);
		project.putBDD();
		return project;
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteProject(@PathParam("id") Integer id) {
		if (projects.containsKey(id)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	}
	
	protected Project find(String name) {
		for (Project projet : projets.values()) {
			if (projet.getName().equals(name)) {
				return projet;
			}
		}
		return null;
	}
	
	protected Project find(int id) {
		return projets.get(id);
	}


	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
	public Response updateProject(@PathParam("id") int id, 
			Project projet) {
		Project oldProjet = find(id);
		System.out.println("Should update projet with id: "+id
				+" ("+oldProjet+") to " +projet);
		if (projet == null) {
			throw new WebApplicationException(404);
		}
		oldProjet.setName(oldProjet.getName());
		return Response.status(200).entity(oldProjet).build();
	}
	
	@GET
	@Path("/{name}")
	public Project getProject(@PathParam("name") String name ) {
		Project out = find(name);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
	
	@GET
	public List<Project> getProjects(@DefaultValue("10") @QueryParam("limit") int limit) {
		return new ArrayList<Project>(projets.values());
	}

}