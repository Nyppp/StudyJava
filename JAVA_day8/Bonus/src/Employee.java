public class Employee {
    private String name;
    private int baseSalary;

    public Employee(String name, int baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getSalary(){
        return baseSalary;
    }
}
