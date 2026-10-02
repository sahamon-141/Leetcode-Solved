class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        if(n==1) return 1;
        
        int result = 0;
        int left = 0;
        int right = n-1;
        Arrays.sort(people);
        
        while(left<=right){
            int sum = people[left]+people[right];
            if(sum<=limit){
                result++;
                left++;
                right--;
            }
            else{
                result++;
                right--;
            }
        }
        return result;
    }
}