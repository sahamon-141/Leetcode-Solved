class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min_ind = Integer.MAX_VALUE;

        for(int i=0;i<strs.length;i++){
            if(strs[i].length()<min_ind){
                min_ind = strs[i].length();
            }
        }
        int idx=0;
        
        String result ="";
        while(idx<min_ind){
            char a = strs[0].charAt(idx);
            boolean check = true;;
            for(int i=0;i<strs.length;i++){
                if(strs[i].charAt(idx)!=a){
                    check =false;
                }
            }
            if(check==false){
                break;
            }
            if(check){
                result+=strs[0].charAt(idx);
            }
            idx++;
        }
        return result;
    }
}