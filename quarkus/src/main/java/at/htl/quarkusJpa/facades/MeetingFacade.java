package at.htl.quarkusJpa.facades;

import at.htl.quarkusJpa.model.Meeting;

import java.util.List;

public class MeetingFacade extends AbstractFacade<Meeting> {
    @Override
    public List<Meeting> getAll() {
        return em.createNamedQuery("Meeting.getAll",Meeting.class).getResultList();
    }

    @Override
    public Meeting getById(Long id) {
        return em.find(Meeting.class, id);
    }
}
