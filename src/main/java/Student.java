import java.util.ArrayList;

public class Student {

    private long id;
    private String name;
    private ArrayList<Integer> grades;

    public Student(long id, String name){
        this.name = name;
        this.id = id;
        this.grades = new ArrayList<>();
    }

    public Student(){}

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Integer> grades) {
        this.grades = grades;
    }

    public void addGrade(int grade){
        this.grades.add(grade);
    }

    public void deleteGrade(int grade){
        this.grades.remove(this.grades.indexOf(grade));
        setGrades(grades);
    }

    public double getGradeAvg(){
        double total = 0;
        for(int grade : this.grades){
            total+=grade;
        }
        return total/this.grades.size();
    }
}
