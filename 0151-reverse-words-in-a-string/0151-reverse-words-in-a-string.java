class Solution {
    public static String reverseWords(String s) {
        String[] reverse = s.trim().split("\\s+");
        int n = reverse.length-1;
        String result = "";
        for(int i=n;i>-1;i--){
            result+=reverse[i];
            result+=" ";
        }

        return result.trim();
    }
}