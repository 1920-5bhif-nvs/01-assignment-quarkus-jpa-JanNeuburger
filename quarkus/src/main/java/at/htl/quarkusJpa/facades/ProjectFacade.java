package at.htl.quarkusJpa.facades;

import at.htl.quarkusJpa.model.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import java.util.List;

@ApplicationScoped
public class ProjectFacade extends AbstractFacade<Project> {

    @Override
    public List<Project> getAll() {
        return em.createNamedQuery("Project.getAll",Project.class).getResultList();
    }

    @Override
    public Project getById(Long id) {
        return em.find(Project.class, id);
    }
}
