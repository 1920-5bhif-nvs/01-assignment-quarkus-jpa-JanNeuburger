package at.htl.quarkusJpa.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@NamedQuery(name = "Meeting.getAll", query = "select m from Meeting m")
@NamedQuery(name = "Meeting.findById", query = "select m from Meeting m WHERE m.id = :ID")
@Entity(name = "Meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private String description;

    @ManyToOne
    private Project project;

    //region Constructors
    public Meeting(){
    }
    public Meeting(LocalDateTime date, String description){
        this.date = date;
        this.description = description;
    }
    //endregion

    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    //endregion
}
