public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getSeniority(){
        String strSenior = new String();
        if(age >= 35){
            strSenior =  "시니어";
        }else{
            strSenior =  "주니어";
        }

        return strSenior;
    }
}
