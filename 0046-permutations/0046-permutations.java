class Solution {
    static void permutations(List<List<Integer>> res, int[] arr, int idx) {
        if (idx == arr.length) {
            List<Integer> temp = new ArrayList<>();
            for (int val : arr) temp.add(val);
            res.add(temp);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            // Swapping
            int temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;

            // Recursive call
            permutations(res, arr, idx + 1);

            // Backtracking
            temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permutations(res, nums, 0);
        return res;
    }
}