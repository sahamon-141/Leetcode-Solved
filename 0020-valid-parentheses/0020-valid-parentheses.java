class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            if(a=='(') st.push(')');
            else if(a=='[') st.push(']');
            else if(a=='{') st.push('}');
            else{
                if(st.isEmpty()||st.pop()!=a){
                    return false;
                }
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}