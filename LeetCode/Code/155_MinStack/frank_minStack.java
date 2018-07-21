//caustion: we don't need to care whether the pop() pop the expected 
//two stack
class MinStack1{

    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(! minStack.empty()){
            if(x <= minStack.peek()){
                minStack.push(x);
            }
        }else{
            minStack.push(x);
        }
    }
    
    public void pop() {
        int x = stack.pop();
        if(! minStack.empty()){
            if(x == minStack.peek()){
                minStack.pop();
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if(! minStack.empty()){
            System.out.print("not empty" + minStack.peek());
            return minStack.peek();
        }
        return 0;
    }
    
}
// One stack
class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(! minStack.empty()){
            if(x <= minStack.peek()){
                minStack.push(x);
            }
        }else{
            minStack.push(x);
        }
    }
    
    public void pop() {
        int x = stack.pop();
        if(! minStack.empty()){
            if(x == minStack.peek()){
                minStack.pop();
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if(! minStack.empty()){
            System.out.print("not empty" + minStack.peek());
            return minStack.peek();
        }
        return 0;
    }
    
}