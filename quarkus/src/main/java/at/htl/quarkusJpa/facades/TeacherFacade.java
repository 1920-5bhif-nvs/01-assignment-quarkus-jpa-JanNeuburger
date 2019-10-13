package at.htl.quarkusJpa.facades;

import at.htl.quarkusJpa.model.Teacher;

import java.util.List;

public class TeacherFacade extends AbstractFacade<Teacher> {
    @Override
    public List<Teacher> getAll() {
        return em.createNamedQuery("Teacher.getAll",Teacher.class).getResultList();
    }

    @Override
    public Teacher getById(Long id) {
        return em.find(Teacher.class, id);
    }
}
