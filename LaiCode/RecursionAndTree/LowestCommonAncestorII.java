/**
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 */
public class Solution {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {

    int hOne = 0;
    int hTwo = 0;
    TreeNodeP tmp = one;
    while (tmp != null) {
      tmp = tmp.parent;
      hOne ++;
    }
    tmp = two;
    while (tmp != null) {
      tmp = tmp.parent;
      hTwo++;
    }
    if (hTwo > hOne) {
      for (int i = 0; i < hTwo - hOne; i++) {
        two = two.parent;
      }
    }else {
      for (int i = 0; i < hOne - hTwo; i++) {
        one = one.parent;
      }
    }
    while (one != null && two != null) {
      if (one == two) {
        return one;
      }
      one = one.parent;
      two = two.parent;
    }
    return null;
  }
}
// Time: O(Max{hOne, hTwo}) Space: (1)
/*
  1.get the height of two target, make them at the same level
  2.then up-level tarverse 
  2.if one node gets to null, they are not at the same BT; Otherwise there must be an answer



*/