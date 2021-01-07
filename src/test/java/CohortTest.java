import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CohortTest {

    Cohort jupiter;
    Student self;
    Student newKid = new Student(777888, "noOneKnows");
    Student person = new Student(777887, "personOther");
    Student person2 = new Student(777855, "personOther2");
    Student person3 = new Student(7778879, "personOther3");

    @Before
    public void setUp(){
        jupiter = new Cohort();
        self = new Student(889900, "Matt");
        self.addGrade(100);
        self.addGrade(75);
        self.addGrade(50);
        jupiter.addStudent(self);
    }

    @Test
    public void addStudent(){
        Student person1 = new Student(222333, "Random");
        jupiter.addStudent(person1);
        assertEquals(2, jupiter.getStudents().size());
    }

    @Test
    public void getStudentList(){
        // LINE 22
        assertTrue("Unable to get a list of valid students", jupiter.getStudents().size() > 0);
    }

    @Test
    public void checkCohortAvg(){
        newKid.addGrade(50);
        newKid.addGrade(50);
        newKid.addGrade(50);
        jupiter.addStudent(newKid);
//        assertEquals(jupiter.getCohortAverage(), 75, 0.5); // fails after adding a new student;
        assertEquals(jupiter.getCohortAverage(), 62, 0.5); // passes with rounding
    }

    @Test
    public void findStudentById(){
        long searchedId = self.getId();
        assertEquals(jupiter.findStudentById(searchedId), self.getName());
    }

    @Test
    public void uniqueStudentIds(){
        jupiter.addStudent(newKid);
        jupiter.addStudent(person);
        jupiter.addStudent(person2);
        jupiter.addStudent(person3);
//        Student breaksRecords = new Student(777888, "hahaha");
//        jupiter.addStudent(breaksRecords);        // duplicate id
        assertTrue(jupiter.allUniqueIds());
    }

}