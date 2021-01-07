import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class StudentTest {

    Student s1;
    Student s2;

    @Before
    public void setUp(){
        s1 = new Student();
        s2 = new Student(112, "matthew");
    }


    @Test
    public void studentProperties(){
        ArrayList<Integer> startGrades = new ArrayList<>(Arrays.asList(100));
        long startId = 55005500;
        assertNotEquals(s1, null);
        s1.setId(startId);
        assertEquals(s1.getId(), startId);
        s1.setId(55454455);
        assertEquals(s1.getId(), 55454455);
    }

    @Test
    public void nameIsString(){
//        s1.setName("11");
        String testName = s1.getName();
        int notString = 0;
        try{
            notString = Integer.parseInt(testName);
        } catch (Exception ignored){

        }
//            assertEquals(notString, 11);
        assertEquals(notString, 0);
    }

    @Test
    public void validId(){
        assertTrue("id can not be less than 0", s2.getId() > 0);
    }

    @Test
    public void checkNameChange(){
        String startName = "matt";
        s1.setName(startName);
        assertEquals(s1.getName(), "matt");
        s1.setName("Matt");
        assertNotEquals(s1.getName(), startName);
        assertEquals(s1.getName(), "Matt");
    }

    @Test
    public void changeGrades(){
        ArrayList<Integer> grades = new ArrayList<>();
        s1.setGrades(grades);
        s1.addGrade(100);
        assertEquals(1, s1.getGrades().size());
        s1.deleteGrade(100);
        assertEquals(0, s1.getGrades().size());
    }

    @Test
    public void compareAvg(){
        ArrayList<Integer> grades = new ArrayList<>();
        grades.add(100);
        grades.add(75);
        grades.add(50);
        s1.setGrades(grades);
        assertEquals(75, s1.getGradeAvg(), 0.2);
    }



}
