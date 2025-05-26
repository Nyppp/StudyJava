public class Main {
    public static <T extends Comparable<T>> T findMax (T param1, T param2, T param3){
        if(param1.compareTo(param2) > 0){
            if(param1.compareTo(param3) > 0){
                return param1;
            }else{
                return param3;
            }
        }else{
            if(param2.compareTo(param3) > 0){
                return param2;
            }else{
                return param3;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findMax(1,1,3));
        System.out.println(findMax(100,2,3));
        System.out.println(findMax("a", "b", "c"));
        System.out.println(findMax("aa", "bb", "az"));
    }
}


