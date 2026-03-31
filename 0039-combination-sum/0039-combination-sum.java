class Solution {
    public static void backtrack(int[] candidates,List<List<Integer>> result,int target,List<Integer> temp,int start){
        if(target == 0){
    result.add(new ArrayList<>(temp)); 
    return;
}
        for(int i=start ;i<candidates.length;i++){
            int num = candidates[i];
            if(num<=target){
                temp.add(num);
                backtrack(candidates,result,target-num,temp,i);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates,result,target,new ArrayList(),0);
        return result;
    }
}