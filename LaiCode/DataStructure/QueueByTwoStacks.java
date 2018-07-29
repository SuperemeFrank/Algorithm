public class Solution {
  Stack<Integer> in = new Stack<>();
  Stack<Integer> out = new Stack<>();
  private int size;
  public Solution() {
    // Write your solution here.
  }
  private void transferStack(Stack<Integer> s1, Stack<Integer> s2) {
  	while (!s1.isEmpty()) {
    	s2.push(s1.pop());
    }
  }
  
  public Integer poll() {
    if (out.isEmpty()) {
    	transferStack(in, out);
    }
    if (!out.isEmpty()) { // stack1 might also empty
      size--;
    	return out.pop();
    }
    return null;
  }
  
  public void offer(int element) {
    
    size++;
    in.push(element);
  }
  
  public Integer peek() {
    if (out.isEmpty()) {
    	transferStack(in, out);
    }
    if (!out.isEmpty()) {
    	return out.peek();
    }
    return null;
  }
  
  public int size() {
    return this.size;
  }
  
  public boolean isEmpty() {
    return this.size == 0 ? true : false;
  }
}

/*
in:  | 5 6 7 8 <- offer()
out: | 4 3 2 1 -> poll()
*/