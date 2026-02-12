class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        
        long low = Integer.MAX_VALUE;
        long high = 0;
        
        for (int height : arr) {
            low = Math.min(low, height);
            high = Math.max(high, height);
        }
        
        high = high + k; // maximum possible
        
        long ans = low;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (canAchieve(arr, k, w, mid)) {
                ans = mid;
                low = mid + 1;   // try bigger
            } else {
                high = mid - 1;  // try smaller
            }
        }
        
        return (int) ans;
    }
    
    private boolean canAchieve(int[] arr, int k, int w, long target) {
        int n = arr.length;
        long[] diff = new long[n + 1];
        
        long operations = 0;
        long currWater = 0;
        
        for (int i = 0; i < n; i++) {
            
            currWater += diff[i];
            
            long currentHeight = arr[i] + currWater;
            
            if (currentHeight < target) {
                
                long needed = target - currentHeight;
                operations += needed;
                
                if (operations > k) return false;
                
                currWater += needed;
                
                if (i + w < n) {
                    diff[i + w] -= needed;
                }
            }
        }
        
        return true;
    }
}
