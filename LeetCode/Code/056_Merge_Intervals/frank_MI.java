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
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        
        Collections.sort(intervals, new Comparator<Interval>() {
           @Override
            public int compare(Interval a, Interval b) {
                if (a.start == b.start) return 0;
                return a.start < b.start ? -1 : 1;
            }
        });
        
        
        int left = intervals.get(0).start;
        int right = intervals.get(0).end;
        
        for (Interval inter : intervals) {
            if (inter.start > right) {
                res.add(new Interval(left, right));
                left = inter.start;
                right = inter.end;
            }else {
                right = inter.end > right ? inter.end : right;
            }
        }
        
        res.add(new Interval(left, right));
        
        return res;
    }
}

/*  Time: O(n)  Space: O(1)    n = intervals.size()
    sort all interval based on their start
    
    left right pointer to record current handle interval until there is it not overlap with others
    
*/