package com.app.other;

import com.app.base.Base;

public class Other extends Base{
    public void test() {
        Base b = new Base();
        //import를 한다고 해도 종속성(같은 패키지, 상속) 이 없다면 사용 불가
        //System.out.println(b.value);

        //상속을 받는 경우, protected 필드 접근 가능 (인스턴스로는 x)
        greet();
        
        //default 필드 > 상속을 받았다고 해도 접근 불가능
        //b.defualtValue;
    }
}
