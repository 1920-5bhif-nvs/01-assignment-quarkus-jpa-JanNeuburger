package at.htl.quarkusJpa.facades;

import at.htl.quarkusJpa.model.Person;

import java.util.List;

public class PersonFacade extends AbstractFacade<Person> {
    @Override
    public List<Person> getAll() {
        return em.createNamedQuery("Person.getAll",Person.class).getResultList();
    }

    @Override
    public Person getById(Long id) {
        return em.find(Person.class, id);
    }
}
