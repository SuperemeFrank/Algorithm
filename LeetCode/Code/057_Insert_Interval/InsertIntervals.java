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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> res = new ArrayList<>();
        
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        int lastSmaller = getLastSmaller(intervals, newInterval.start);
        
        System.out.println(lastSmaller);
        for (int i = 0; i <= lastSmaller; i++) {
            Interval tmp = intervals.get(i);
            res.add(new Interval(tmp.start, tmp.end));
        }
        
        int cur = lastSmaller + 1;
        int start = newInterval.start;
        int end = newInterval.end;
        while (cur < intervals.size()) {
            Interval tmp = intervals.get(cur);
            if (tmp.start > end)
                break;
            start = start < tmp.start ? start : tmp.start;
            end = end > tmp.end ? end : tmp.end;
            cur++;
        }
        
        res.add (new Interval(start, end));
        
        for (int i = cur; i < intervals.size(); i++) {
            Interval tmp = intervals.get(i);
            res.add(new Interval(tmp.start, tmp.end));
        }
        
        return res;
    }
    
    private int getLastSmaller(List<Interval> intervals, int start) {
        int left = 0;
        int right = intervals.size() - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            Interval midInter = intervals.get(mid);
            if (midInter.end < start) {
                left = mid;
            }else {
                right = mid;
            }
        }
        
        if (intervals.get(right).end < start) {
            return right;
        }
        
        if (intervals.get(left).end >= start) {
            return left - 1;
        }else {
            return left;
        }
    }
}

/* Time: O(n) Space: O(n)
    use binary search to get the last interval that the end is smaller than the newInterval,
    then merge the new Interval from the right side

*/