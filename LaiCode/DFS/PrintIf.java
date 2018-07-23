import java.util.*;

public class PrintIf {
	public static void main(String[] args) {
		Solution so = new Solution();
		so.allBlocks(4);
	}
}

class Solution {
    public void allBlocks(int n) {
        List<List<Character>> permutation = new ArrayList<>();
        dfsHelper(permutation, new ArrayList<>(), n, n);
        printParatheses(permutation);
        return;
    }
    
    private void dfsHelper(List<List<Character>> permutation, List<Character> list, 
    						int left, int right) {
    	if (left == 0 && right == 0) {
    		permutation.add(new ArrayList(list));
    	}
    	if (left > 0) {
    		list.add('{');
    		dfsHelper(permutation, list, left - 1, right);
    		list.remove(list.size() - 1);
    	}
    	if (right > left) {
    			list.add('}');
    			dfsHelper(permutation, list, left, right - 1);
    			list.remove(list.size() - 1);
    	}
    }
    private void printParatheses(List<List<Character>> lists) {

    	for (List<Character> list : lists) {
    		int indence = 0;
    		for (Character ch : list) {
    			StringBuilder level = new StringBuilder();
    			for (int i = 0; i < indence - 2; i++) {
    				level.append(" ");
    			}
    			if (ch == '{') {
    				
    				if (indence == 0) {
    					System.out.println(level.append("if{"));
    				}else {
    					level.append("  ");
    					System.out.println(level.append("if{ //here should exist two spaces before each inner block"));
    				}
    				indence += 2;
    			}else {
    				System.out.println(level.append("}"));
    				System.out.println();
    				indence -= 2;
    			}
    		}
    	}
    }
}

// Time: O(2^n) Space: O(2^n)
