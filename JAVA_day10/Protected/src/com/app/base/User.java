package com.app.base;

public class User {
    public void test() {
        Base b = new Base();
        //protected > 같은 패키지, 상속 관계라면 접근 가능
        System.out.println(b.value);
        b.greet();

        //default > 같은 패키지 내에서는 접근 가능
        System.out.println(b.defaultValue);
        b.defaultGreet();
    }
}
