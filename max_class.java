package max_class;
import java.util.*;
public class max_class {
    int maxSum(int[] arr) {
        int n = arr.length;
        int arrSum = 0;
        int currVal = 0;
      // Calculate sum of array and initial value of i*arr[i]
        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
            currVal += i * arr[i];
        }
        int maxVal = currVal;
        // Compute value for each rotation
        for (int i = 1; i < n; i++) {
            currVal = currVal + arrSum - n * arr[n - i];
            maxVal = Math.max(maxVal, currVal);
        }
        return maxVal;
    }
    public static void main(String[] args) {
        max_class sol = new max_class();
        int[] arr1 = {3, 1, 2, 8};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {4, 13};
        System.out.println(sol.maxSum(arr1)); // Output: 29
        System.out.println(sol.maxSum(arr2)); // Output: 8
        System.out.println(sol.maxSum(arr3)); // Output: 13
    }
}

