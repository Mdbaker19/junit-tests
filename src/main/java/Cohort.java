import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cohort {

    private List<Student> students;

    public Cohort() {
        this.students = new ArrayList<>();
    }

    public double getCohortAverage() {
        double avg = 0;
        for (Student student: this.getStudents()) {
            avg += student.getGradeAverage();
        }
        return avg / this.getStudents().size();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public String findStudentById(long id){
        for(Student child : this.students){
            if(child.getId() == id){
                return child.getName();
            }
        }
        return "No student found";
    }

    public boolean allUniqueIds(){
        HashMap<Long, String> records = new HashMap<>();
        for(Student child : this.students){
            records.put(child.getId(), child.getName());
        }
        return records.size() == this.students.size();
    }
}