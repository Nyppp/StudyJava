public class Main {
    public static void main(String[] args) {
        Person p = new Person("노", "윤표");

        System.out.println(p.getFullName());

        Student s = new Student("노", "표윤", "16", 3.5);
        System.out.println(s.getFullName());

    }
}
