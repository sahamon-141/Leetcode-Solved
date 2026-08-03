class Solution {
    //custom class for each row , containing count and index
    static class row implements Comparable<row> {
        int count;
        int index;
        row(int count, int index) {
            this.index = index;
            this.count = count;
        }
        @Override
        public int compareTo(row r) {
            //if count is now equal , count is the comparison
            if (this.count != r.count) {
                return this.count - r.count;
            }
            //else index between them is the factor
            return this.index - r.index;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<row> pq = new PriorityQueue<>();
        // add every row info into the pq
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1)
                    count++;
            }
            pq.add(new row(count, i));
        } 
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.remove().index;
        }
        return result;

    }
}