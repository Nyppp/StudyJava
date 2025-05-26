public class Manager extends Employee{
    private int bonus;

    public Manager(String name, int baseSalary, int bonus){
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public int getSalary(){
        System.out.println("급여량 : " + super.getSalary());
        System.out.println("보너스 : " + bonus);
        return super.getSalary() + bonus;
    }
}
