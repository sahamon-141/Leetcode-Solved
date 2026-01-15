class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            if(a=='#'){
                if(!st1.isEmpty()){st1.pop();}
            }
            else{
                st1.push(a);
            }
        }
        Stack<Character> st2 = new Stack<>();
        for(int i=0;i<t.length();i++){
            char a = t.charAt(i);
            if(a=='#'){
                if(!st2.isEmpty()){st2.pop();}
            }
            else{
                st2.push(a);
            }
        }
        if(st1.size()!=st2.size()){
            return false;
        }
        while(!st1.isEmpty()){
            if(st1.peek()==st2.peek()){
                st1.pop();
                st2.pop();
            }
            else{
                return false;
            }
        }
        return true;
    }
}