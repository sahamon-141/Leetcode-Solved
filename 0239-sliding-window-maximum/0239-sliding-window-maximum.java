class Solution { 
    static class pair implements Comparable<pair> { 
        int value; 
        int index; 
        
        pair(int value, int index) { 
            this.value = value; 
            this.index = index; 
        } 
        
        public int compareTo(pair p) { 
            return Integer.compare(p.value, this.value); 
        } 
    } 

    public int[] maxSlidingWindow(int[] nums, int k) { 
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1]; 
        PriorityQueue<pair> pq = new PriorityQueue<>(); 
        
        for (int i = 0; i < k; i++) { 
            pq.add(new pair(nums[i], i)); 
        } 
        //result for first window
        result[0] = pq.peek().value; 
        
        for (int i = k; i < n; i++) { 
            while (!pq.isEmpty() && pq.peek().index <= (i - k)) { 
                pq.poll(); 
            } 
            //add the current element in the pq
            pq.add(new pair(nums[i], i)); 
            //update the max of current window in the result 
            result[i - k + 1] = pq.peek().value; 
        } 
        
        return result;
    } 
}