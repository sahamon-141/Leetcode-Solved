class Solution {

    public int minimumDifference(int[] nums) {

        int n = nums.length;
        int half = n / 2;

        // Calculate total sum
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        /*
            left[i]  = all possible sums by selecting exactly i
                       elements from the left half

            right[i] = all possible sums by selecting exactly i
                       elements from the right half
        */
        List<Integer>[] left = new ArrayList[half + 1];
        List<Integer>[] right = new ArrayList[half + 1];

        for (int i = 0; i <= half; i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }

        // Generate all subset sums
        generate(nums, 0, half, 0, 0, left);
        generate(nums, half, n, 0, 0, right);

        // Sort the right-side sums
        for (int i = 0; i <= half; i++) {
            Collections.sort(right[i]);
        }

        int answer = Integer.MAX_VALUE;

        /*
            Suppose we select i elements from left.

            Then we need:

                half - i

            elements from right.

            So we combine:

                left[i] + right[half-i]
        */
        for (int i = 0; i <= half; i++) {

            List<Integer> list1 = left[i];
            List<Integer> list2 = right[half - i];

            for (int sum1 : list1) {

                /*
                    We want:

                        sum1 + sum2 ≈ total / 2

                    Therefore:

                        sum2 ≈ total/2 - sum1
                */
                int target = total / 2 - sum1;

                // Binary search for the closest value to target
                int index = Collections.binarySearch(list2, target);

                if (index < 0) {
                    index = -index - 1;
                }

                // Check the element at index
                if (index < list2.size()) {

                    int sum = sum1 + list2.get(index);

                    answer = Math.min(
                        answer,
                        Math.abs(total - 2 * sum)
                    );
                }

                // Also check the element immediately before index
                if (index > 0) {

                    int sum = sum1 + list2.get(index - 1);

                    answer = Math.min(
                        answer,
                        Math.abs(total - 2 * sum)
                    );
                }
            }
        }

        return answer;
    }


    /*
        Generates all possible subset sums.

        start = starting index
        end   = ending index
        count = number of elements selected
        sum   = current subset sum

        result[count] stores all sums that use exactly
        'count' elements.
    */
    private void generate(
        int[] nums,
        int start,
        int end,
        int count,
        int sum,
        List<Integer>[] result
    ) {

        // Reached the end of this half
        if (start == end) {
            result[count].add(sum);
            return;
        }

        // Don't take current element
        generate(
            nums,
            start + 1,
            end,
            count,
            sum,
            result
        );

        // Take current element
        generate(
            nums,
            start + 1,
            end,
            count + 1,
            sum + nums[start],
            result
        );
    }
}