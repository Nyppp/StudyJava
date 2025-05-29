public class Person implements Comparable<Person>{
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other){
        return Integer.compare(this.age, other.age); //오름차순
        //return -Integer.compare(this.age, other.age); //내림차순
        //return Integer.compare(other.age, this.age); //내림차순
    }

    @Override
    public String toString() {
        String s = this.name + "-" + this.age;
        return s;
    }
}
