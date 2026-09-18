class Solution {

    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        // Find first and last occurrence of every character
        for(int i = 0; i < n; i++){

            int c = s.charAt(i) - 'a';

            if(first[c] == -1){
                first[c] = i;
            }

            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        /*
            Try to create the smallest valid interval
            starting from every character's first occurrence.
        */
        for(int c = 0; c < 26; c++){

            if(first[c] == -1){
                continue;
            }

            int start = first[c];
            int end = last[c];

            boolean valid = true;

            for(int i = start; i <= end; i++){

                int x = s.charAt(i) - 'a';

                /*
                    Character x occurs before our starting point.

                    Therefore we cannot create an independent
                    substring starting at 'start'.
                */
                if(first[x] < start){
                    valid = false;
                    break;
                }

                /*
                    Character x occurs farther to the right,
                    so we must expand our interval.
                */
                end = Math.max(end, last[x]);
            }

            if(valid){
                intervals.add(new int[]{start, end});
            }
        }

        /*
            Sort intervals by their ending position.

            Choosing the interval that ends earliest allows us
            to fit the maximum number of non-overlapping intervals.
        */
        intervals.sort((a, b) -> a[1] - b[1]);

        List<String> result = new ArrayList<>();

        int prevEnd = -1;

        for(int[] interval : intervals){

            int start = interval[0];
            int end = interval[1];

            /*
                This interval doesn't overlap with
                the previously selected interval.
            */
            if(start > prevEnd){

                result.add(
                    s.substring(start, end + 1)
                );

                prevEnd = end;
            }
        }

        return result;
    }
}