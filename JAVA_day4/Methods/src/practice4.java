import java.util.Arrays;
import java.util.Scanner;

public class practice4 {
    public static int[] reverseArr(int[] arr){
        int[] reverse = new int[arr.length];
        for (int i = arr.length-1; i >= 0 ; i--) {
            reverse[(arr.length-1) - i ] = arr[i];
        }

        return reverse;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[]{1,2,3,4,5};

        System.out.println(Arrays.toString(reverseArr(arr)));
    }
}
