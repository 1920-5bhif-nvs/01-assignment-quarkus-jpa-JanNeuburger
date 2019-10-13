package at.htl.quarkusJpa.model;

import javax.persistence.*;

@NamedQuery(name = "Person.findAll", query = "select p from person p")
@NamedQuery(name = "Person.findById", query = "select p from person p WHERE p.id = :ID")
@Entity(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    //region Constructors
    public Person(){}
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //endregion

    //region Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //endregion
}