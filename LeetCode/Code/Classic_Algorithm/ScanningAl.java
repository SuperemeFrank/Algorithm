/*Problem: Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].*/
-------------------------
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList<>();
        }
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, (i1, i2) -> {  // important
            if (i1.start == i2.start) {
                return 0;
            }
            return i1.start < i2.start ? -1 : 1;
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval node = intervals.get(i);
            if (node.start <= end) {
                end = end > node.end ? end : node.end;
            } else {
                res.add(new Interval(start, end));
                start = node.start;
                end = node.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}

// Time: O(nlogn + n)    Space: O(1)
