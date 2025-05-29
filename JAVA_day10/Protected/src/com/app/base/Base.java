package com.app.base;

public class Base {
    //protected > 같은 패키지, 상속받은 클래스 내에서만 접근 가능
    protected String value = "protected value";
    private String privateValue = "private value";

    //필드에서 접근 제한자를 사용하지 않는 경우 > default 처리
    String defaultValue = "default value";

    protected void greet(){
        System.out.println("greeting!");
    }

    void defaultGreet(){
        System.out.println("default greeting!");
    }
}