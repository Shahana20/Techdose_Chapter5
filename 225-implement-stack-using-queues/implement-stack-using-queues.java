class MyStack {
    Queue <Integer> queue1;
    Queue <Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue2.add(x);
        while(!queue1.isEmpty())
        {
            queue2.add(queue1.remove());
        }
        Queue<Integer> temp=queue1;
        queue1=queue2;
        queue2=temp;
    }
    
    public int pop() {
        int val=queue1.remove();
        return val;
    }
    
    public int top() {
        int val=queue1.peek();
        return val;
    }
    
    public boolean empty() {
        return queue1.isEmpty();
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