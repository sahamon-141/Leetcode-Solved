class MyStack {
    Queue<Integer> qu1 = new LinkedList<>();
    Queue<Integer> qu2 = new LinkedList<>(); 
    public MyStack() {
        
    }
    
    public void push(int x) {
    qu2.add(x);
        while(!qu1.isEmpty()){
            qu2.add(qu1.remove());
        }
        Queue<Integer> temp = qu1   ;
        qu1=qu2;
        qu2=temp;
    }
    
    public int pop() {
        if(qu1.isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
            return qu1.remove();
        
    }
    
    public int top() {
        if(qu1.isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return qu1.peek();
    }
    
    public boolean empty() {
        if(qu1.isEmpty()){
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */