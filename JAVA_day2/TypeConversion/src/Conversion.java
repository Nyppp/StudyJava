public class Conversion {
    public static void main(String[] args) {
        //묵시적 형변환
        byte b = 10;
        short s = b;
        int i = s;
        long l = i;
        float f = l;
        double d = f;

        //묵시적 형변환은 큰 데이터 > 작은 데이터로의 변환이 불가(데이터 유실에 대해 컴파일 에러 처리)
        long longValue = 100;
//        byte byteValue = longValue;

        //명시적 형변환
        double d2 = 123.456;
        float f2 = (float)d2;
        long l2 = (long)f2;
        int i2 = (int)l2;
        short s2 = (short)i2;
        byte b2 = (byte)s2;

        System.out.println(d2);
        System.out.println(f2);
        System.out.println(l2);
        System.out.println(i2);
        System.out.println(s2);
        System.out.println(b2);
    }
}
