public class practice {
    public static void main(String[] args) {
        int studentCount = 17;
        int teamPerStudents = 5;
        int teamCount = studentCount / teamPerStudents;

        System.out.println("전체 학생 수 : " + studentCount);
        System.out.println("조를 이룬 학생 수 : " + (teamCount * teamPerStudents));
        System.out.println("조를 이루지 못한 학생 수 : " + (studentCount % teamCount));
    }
}
