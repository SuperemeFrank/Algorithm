public class Solution {
  private Stack<Integer> stack;
  private Stack<PType> minStack;
  public Solution() {
    // write your solution here
    this.stack = new Stack<>();
    this.minStack = new Stack<>();
  }
  
  public int pop() {
    if (stack.isEmpty()) {
    	return -1;
    }
    PType min = minStack.peek();
    if (stack.peek() == min.value && stack.size() == min.size) {    	
      minStack.pop();
    } 
    return stack.pop();
  }
  
  public void push(int element) {
    int min = min();
    if (stack.isEmpty() || element < min) {
    	minStack.push(new PType(element, stack.size() + 1));
    }
    stack.push(element);
  }
  
  public int top() {
    if (stack.isEmpty()) {
    	return -1;
    }
    return stack.peek();
  }
  
  public int min() {
    if (!minStack.isEmpty()) {
    	return minStack.peek().value;
    }
    return -1;
  }
}

class PType {
	public int value;
  public int size;
  public PType(int v, int s) {
  	this.value = v;
    this.size = s;
  }
}

/*
  stack |  4  2  1  5  -5
minStack|  4  2  1  1  -5
*/

