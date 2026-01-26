class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> ch = new Stack<>();
        int result = 0;
        if(tokens.length==1){
            result = Integer.parseInt(tokens[0]);
        }
        for(String token :tokens ){
            if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")){
                int a = ch.pop();
                int b = ch.pop();
                switch(token){
                    case "+":
                        result = a+b;
                        break;
                    case "-":
                        result = b-a;
                        break;
                    case "*":
                        result = a*b;
                        break;
                    case "/":
                        result = b/a;
                        break;
                }
                ch.push(result);
            }
            else{
                ch.push(Integer.parseInt(token));
            }
            
        }
        return result;
    }
}