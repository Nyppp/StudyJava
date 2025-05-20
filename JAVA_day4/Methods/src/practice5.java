public class practice5 {
    public static int max(int a, int b){
        return a>b? a:b;
    }

    public static int max(int a, int b, int c){
        return a>b ? (a>c ? a : c) : (b>c ? b : c);
    }

    public static int max(int a, int b, int c, int d){
        return a>b ? (a>c ? (a>d ? a : d) : (c>d ? c : d)) : (b>c ? (b>d ? b : d) : (c>d ? c : d));
    }

    public static int max(int[] nums){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max){
                max = nums[i];
            }
        }

        return max;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(max(1,2));
        System.out.println(max(1,100, 3));
        System.out.println(max(1,500, 5, 4));
        System.out.println(max(arr));
    }
}
