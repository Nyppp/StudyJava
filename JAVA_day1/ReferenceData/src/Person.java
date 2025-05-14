public class Person implements Flyable {
    String name;
    int age;
    String gender;
    int birth;

    Person(String personName, int personAge, String personGender, int personBirth){
        name = personName;
        age = personAge;
        gender = personGender;
        birth = personBirth;
    }

    Person(){
        name = "아무개";
        age = 75;
        gender = "Male";
        birth = 500101;
    }

   public void fly(){
       System.out.println("사람은 날 수 없어요.");
   }

   public void calcAge(int year){
       System.out.println(year + "년에 나는 " + ((year - 2025)+age) + "살입니다.\n" );
   }

   public void printPersonInfo(){
       System.out.println("이름 : " + name);
       System.out.println("나이 : " + age);
       System.out.println("성별 : " + gender);
       System.out.println("생일 : " + birth);
   }
}
