class Solution {
    public static void solve(int n,int left,int right,List<String> list,String s){
       if(s.length()==n*2){
        list.add(s);
        return;
       }
       if(left<n){
        solve(n,left+1,right,list,s+"(");
       }
       if(right<left){
        solve(n,left,right+1,list,s+")");
       }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        solve(n,0,0,res,"");
        return res;
    }
}