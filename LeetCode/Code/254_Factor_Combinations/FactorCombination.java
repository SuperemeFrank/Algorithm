public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(n <= 3)  return ret;
        List<Integer> path = new LinkedList<Integer>();
        getFactors(2, n, path, ret);
        return ret;
    }
    
    private void getFactors(int start, int n, List<Integer> path, List<List<Integer>> ret){
       for(int i = start; i <= Math.sqrt(n); i++){ 
           if(n % i == 0){  // The previous factor is no bigger than the next
               path.add(i);
               path.add(n/i);
               ret.add(new LinkedList<Integer>(path));
               path.remove(path.size() - 1);
               getFactors(i, n/i, path, ret);
               path.remove(path.size() - 1);
           }
       }
    }
}

/*
  Time: unknown (logn ^ logn) ?   Space: O(height + maxPath) = O(height)
  // to avoid duplicate,  smallest factor of n should no smaller than previous factor
  like 12 -> 2,6 -> 2, 2, 3
          -> 3,4 -> 3, 2, 2         duplicates ! we need make sure rge smallest factor of 4 is no smaller than 3
*/