//using two stack, one is the original, and another is the Queue order
class MyQueue {

    /** Initialize your data structure here. */
    private Stack<Integer> mainStack;
    private Stack<Integer> accStack;
    public MyQueue() {
        mainStack = new Stack<>();
        accStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        mainStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(! mainStack.empty()){
            accStack.push(mainStack.pop());
        }
        int pop = accStack.pop();
        while(! accStack.empty()){
            mainStack.push(accStack.pop());
        }
        return pop;
    }
    
    /** Get the front element. */
    public int peek() {
        while(! mainStack.empty()){
            accStack.push(mainStack.pop());
        }
        int pop = accStack.peek();
        while(! accStack.empty()){
            mainStack.push(accStack.pop());
        }
        return pop;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return mainStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */