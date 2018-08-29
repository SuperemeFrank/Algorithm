public class Solution {
  public List<String> subSets(String set) {
    List<String> res = new ArrayList<>();
    if (set == null) {
      return res;
    }
    char[] array = set.toCharArray();
    Arrays.sort(array);
    dfsHelper(res, array, new StringBuilder(), 0);
    return res;
  }
  private void dfsHelper(List<String> res, char[] array, StringBuilder prefix, int index) {
    res.add(prefix.toString());
    if (index >= array.length) {
      return;
    }
    for (int i = index; i < array.length; i++) {
      if (i != index && array[i] == array[i - 1]) {
        continue;
      }
      prefix.append(array[i]);
      dfsHelper(res, array, prefix, i + 1);
      prefix.deleteCharAt(prefix.length() - 1);
    }
  }
  
  
  
}  
  /* Time 
                       abbc
                      / | | \
size 1               a  b    c      C(1, n)     
                   / |   |          
size 2            b  c   b          C(2, n)
                / \       /
size 3         b  c       c         C(3, n)
              /                      ...   
size 4       c                      C(n, n)

C(1,n) + C(2, n) + C(3, n) + ... + C(n, n) ~ 2^n
Time: O(2^n)  Space: O(n)

sort the set first
1. we need to add the path of each level to our res.
2. at the same level, if one node has been added before, we skip it at this level. 
3. we always add the character that first exists among its duplicate in a single level

  */

class Solution2 {
  public List<String> subSets2(String set) {
    List<String> res = new ArrayList<>();
    if (set == null) {
      return res;
    }
    if (set.length() == 0) {
      res.add(set);
      return res;
    }
    char[] array = set.toCharArray();
    Arrays.sort(array);
    dfsHelper(res, array, new StringBuilder(), 0);
    return res;
  }
  
  private void dfsHelper(List<String> res, char[] array, StringBuilder prefix, int index) {
    if (index >= array.length) {
      res.add(prefix.toString());
      return;
    }
    prefix.append(array[index]);
    dfsHelper(res, array, prefix, index + 1);
    prefix.deleteCharAt(prefix.length() - 1);
    
    int j = index + 1;
    while (j < array.length && array[j] == array[index]) {
      j++;
    }
    dfsHelper(res, array, prefix, j);
  }
}



/* Time: O(2^n)  Space: O(n)
                      abbb
                    /     \
a                 a(bbb)    (bbb)   
                 / \         /  \
b           b(bb)   (bb)     b    (bb)
             /  \    |     /  \     |  
b          b(b)  |   |    b    |    |
         /   \   |   |   /     |    | 
b       b               b      

      if we don't choose the current character, then the following same character should not be
      chosen
      
*/