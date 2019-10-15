package at.htl.quarkusJpa.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@NamedQuery(name = "Project.getAll", query = "select p from Project p")
@NamedQuery(name = "Project.findById", query = "select p from Project p WHERE p.id = :ID")
@Entity(name = "Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToMany
    @JoinTable(name="membership",
    joinColumns = @JoinColumn(name = "project_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> members;

    @OneToOne
    private Teacher supervisor;

    @OneToMany
    private List<Meeting> meetings;

    //region Constructors
    public Project(){
        members = new LinkedList<Student>();
        meetings = new LinkedList<Meeting>();
    }
    public Project(String name, String description){
        members = new LinkedList<Student>();
        meetings = new LinkedList<Meeting>();
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getMembers() {
        return members;
    }

    public void setMembers(List<Student> members) {
        this.members = members;
    }

    public Teacher getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Teacher supervisor) {
        this.supervisor = supervisor;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }


    //endregion

    public void addMember(Student student){
        members.add(student);
        student.getProjects().add(this);
    }

    public void addMeeting(Meeting m){
        meetings.add(m);
        m.setProject(this);
    }
}
