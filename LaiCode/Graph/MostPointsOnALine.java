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
  public int most(Point[] points) {
    int max = 1;
    int same = 0;
    for (int i = 0; i < points.length - 1; i++) {
      int x1 = points[i].x;
      int y1 = points[i].y;
      for (int j = i + 1; j < points.length; j++) {
        if (points[j].x == x1 && points[j].y == y1) {
          same++;
          continue;
        }
        int count = 2;
        int x2 = points[j].x;
        int y2 = points[j].y;
        
        if (x1 == x2) {
          for (int m = j + 1; m < points.length; m++) {
            if (points[m].x == x1) {
              count++;
            }
          }
        }else {
          double k = (y2 - y1 + 0.0) / (x2 - x1);
          double b = y1 - k * x1;
          for (int m = j + 1; m < points.length; m++) {
            int x3 = points[m].x;
            int y3 = points[m].y;
            if (Math.abs(y3 - k * x3 - b) < 0.001) {
              count++;
            }
          }
        }
        max = Math.max(max, count + same);
      }
      same = 0;
    }
    return max;
  }
}

/*
  Time: O(n^3)  Space: O(1)

*/

class Solution2 {
  public int most(Point[] points) {
    
    int[] res = new int[1];
    dfsHelper(points, 0, res);
    return res[0];
  }
  
  private void dfsHelper(Point[] points, int start, int[] res) {
    if (start == points.length - 1) {
      res[0] = Math.max(res[0], 1);
      return;
    }
    int x1 = points[start].x;
    int y1 = points[start].y;
    int same = 0;
    // make lines from current start to each point
    for (int i = start + 1; i < points.length; i++) {
      int count = 2;
      // avoid same points
      if (points[i].x == x1 && points[i].y == y1) {
        same++;
        continue;
      }
      int x2 = points[i].x;
      int y2 = points[i].y;
      // if vertical line
      if (x2 == x1) {
        for (int j = i + 1; j < points.length; j++) {
          if (points[j].x == x1) {
            count++;
          }
        }
        res[0] = Math.max(res[0], count + same);
      // if horizontal
      }else {
        double k = (double)(y2 - y1) / (x2 - x1);
        double b = y1 - k * x1;
        for (int j = i + 1; j < points.length; j++) {
          int x3 = points[j].x;
          int y3 = points[j].y;
          if (Math.abs(y3 - (k * x3 + b)) < 0.001) {
            count++;
          }
        }
        res[0] = Math.max(res[0], count + same);
      }
      
    }
    dfsHelper(points, start + 1, res);
  }
}



/*  Time: O(n ^ n)  Space: O(n) 
|         x
|      x
|   x             x
| x        x          x
__________________________

k b
y = kx + b
k = (y2 - y1) / (x2 - x1)
b = y - kx

DFS, eumerate all the possible lines, and for each line calculate the points on it.
1. n levels,each level represents the current start point
2. n braches for each level, represent the end points 

big mistake !!   this problem can just use three loops !!!
*/
