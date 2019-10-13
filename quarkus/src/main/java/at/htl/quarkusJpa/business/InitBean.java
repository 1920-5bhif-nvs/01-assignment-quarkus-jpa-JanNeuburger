package at.htl.quarkusJpa.business;

import at.htl.quarkusJpa.facades.MeetingFacade;
import at.htl.quarkusJpa.facades.ProjectFacade;
import at.htl.quarkusJpa.facades.StudentFacade;
import at.htl.quarkusJpa.facades.TeacherFacade;
import at.htl.quarkusJpa.model.Meeting;
import at.htl.quarkusJpa.model.Project;
import at.htl.quarkusJpa.model.Student;
import at.htl.quarkusJpa.model.Teacher;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.print.event.PrintJobEvent;
import javax.transaction.Transactional;
import java.awt.*;
import java.time.LocalDateTime;

public class InitBean {
    @Inject
    MeetingFacade meetingFacade;

    @Inject
    StudentFacade studentFacade;

    @Inject
    TeacherFacade teacherFacade;

    @Inject
    ProjectFacade projectFacade;

    @Transactional
    public void init(@Observes StartupEvent ev) {
        Teacher klor = new Teacher("Robin","Klor","Dr.");
        Teacher ambros = new Teacher("Annalena", "Ambros","DI");
        teacherFacade.insert(klor);
        teacherFacade.insert(ambros);

        Student brandauer = new Student("Olivia", "Brandauer", "if111111");
        Student rainer = new Student("Noah", "Rainer", "it222222");
        Student waismann = new Student("Michael","Waismann","in333333");
        studentFacade.insert(brandauer);
        studentFacade.insert(rainer);
        studentFacade.insert(waismann);

        Project coolGame = new Project("Cool Game", "A cool game for cool people");
        Project someIot = new Project("Some IOT", "Project for bringing more IOT into our school");
        coolGame.addMember(rainer);
        someIot.addMember(waismann);
        someIot.addMember(brandauer);
        coolGame.setSupervisor(klor);
        someIot.setSupervisor(ambros);

        Meeting gameLoopConcept = new Meeting(LocalDateTime.now(),"Discussion of Game Loop");
        Meeting textureDesign = new Meeting(LocalDateTime.now().plusDays(20),"Presentation of Texture Concept Art");
        Meeting hardwareDiscussion = new Meeting(LocalDateTime.now(),"Decision making on what hardware to use");
        Meeting prototypeTesting = new Meeting(LocalDateTime.now().plusDays(100),"Testing of Prototype");

        coolGame.addMeeting(gameLoopConcept);
        coolGame.addMeeting(textureDesign);
        someIot.addMeeting(hardwareDiscussion);
        someIot.addMeeting(prototypeTesting);

        projectFacade.insert(coolGame);
        projectFacade.insert(someIot);
        meetingFacade.insert(gameLoopConcept);
        meetingFacade.insert(textureDesign);
        meetingFacade.insert(hardwareDiscussion);
        meetingFacade.insert(prototypeTesting);

    }
}
