class Solution {
    public static double posAverage(int[] arr) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                sum = sum + arr[i];
                count = count + 1;
            }
        }
        double average = (double) sum / count;
        return average;
    }
}
