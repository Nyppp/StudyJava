public class BinarySearch {
    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] > target){
                right = mid- 1;
            }else if (arr[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {1,3,5,7,9,11,13,15,17,19,21};

        System.out.println(binarySearch(numbers, 13));

    }
}
