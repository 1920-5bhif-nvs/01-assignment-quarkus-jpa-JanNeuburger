package at.htl.quarkusJpa.facades;

import at.htl.quarkusJpa.model.Person;
import at.htl.quarkusJpa.model.Student;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class StudentFacade extends AbstractFacade<Student> {
    @Override
    public List<Student> getAll() {
        return em.createNamedQuery("Student.getAll",Student.class).getResultList();
    }

    @Override
    public Student getById(Long id) {
        return em.find(Student.class, id);
    }
}
