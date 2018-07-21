class MyStack {
    Queue<Integer> q;
    int size;
    /** Initialize your data structure here. */
    public MyStack() {
        this.q = new LinkedList<>();
        this.size = 0;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
        size++;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for (int i = 0; i < size - 1; i++) {
            q.add(q.poll());
        }
        size--;
        return q.poll(); 
    }
    
    /** Get the top element. */
    public int top() {
        for (int i = 0; i < size - 1; i++) {
            q.add(q.poll());
        }
        int res = q.poll();
        q.add(res);
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.size == 0;
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

//    12345    

