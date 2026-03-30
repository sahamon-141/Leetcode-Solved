/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1))
                lo = mid + 1;
            else
                hi = mid;
        }
        int peak = lo;
        int left = binarySearch(target, mountainArr, 0, peak, true);
        if (left != -1) return left;  
        return binarySearch(target, mountainArr, peak + 1, n - 1, false);
    }
    
    private int binarySearch(int target, MountainArray arr, 
                             int lo, int hi, boolean asc) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int val = arr.get(mid);
            if (val == target) return mid;
            if ((val < target) == asc) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}