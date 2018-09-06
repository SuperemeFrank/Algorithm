/*
* class Point {
*   public int x;
*   public int y;
*   public Point(int x, int y) {
*     this.x = x;
*     this.y = y;
*   }
* }
*/
public class Solution {
  public int largest(Point[] points) {
    if (points.length == 0) {
      return 0;
    }
    Arrays.sort(points, new Comparator<Point>(){
      @Override
      public int compare(Point o1, Point o2) {
        if (o1.x == o2.x) return 0;
        return o1.x < o2.x ? -1 : 1;
      }
    });
    int[] M = new int[points.length];
    M[0] = 1;
    for (int i = 1; i < points.length; i++) {
      M[i] = 1;
      for (int j = 0; j < i; j++) {
        if (points[j].x < points[i].x && points[j].y < points[i].y) {
          M[i] = Math.max(M[i], M[j] + 1);
        } 
      }
    }
    int res = 0;
    for (int i = 0; i < M.length; i++) {
      res = Math.max(res, M[i]);
    }
    
    return res > 1 ? res : 0;
  }
}



/* Time: O(n ^ 2)   Space: O(n)
| x  x     x 
|      x       x
|  x        x      x
|    x             x
----------------------------------

to make every points in the set can form positive slope,
the next point we add into the set should be larger than previous one both in x and y
  p[i - 1].x < p[i].x && p[i - 1].y < p[i].y
  
  1. sort the array base on x
  2. M[i] represents the max number of set from 0 to i, inclusive
  M[i] = for j < i && (i.x > j.x && i.y > j.y) Max{M[j] + 1}
*/