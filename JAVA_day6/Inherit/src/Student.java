public class Student extends Person {
    private String studentId;
    private double gpa;

    public Student(String firstName, String lastName, String studentId, double gpa){
        super(firstName, lastName);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String getStudentId(){
        return studentId;
    }

    public double getGpa(){
        return gpa;
    }

    public void setGpa(double gpa){
        if(gpa >= 0.0 && gpa <= 4.5){
            this.gpa = gpa;
        }
    }

    @Override
    public String getFullName(){
        return super.getFullName() + " " + studentId + " " + gpa;
    }
}
