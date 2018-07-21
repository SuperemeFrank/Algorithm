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
        Collections.sort(intervals, (a, b) -> a.start - b.start);  // sort first
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 0; i < intervals.size(); i++) {
            Interval inter = intervals.get(i);
            if (inter.start <= end) {
                end = end > inter.end ? end : inter.end;  // The end of next might less than the end of current
            } else {
                res.add(new Interval(start, end));
                start = inter.start;
                end = inter.end;
            }
        }
        res.add(new Interval(start, end));  //care here, only the interval before current has been added in res
        return res;
    }

}

//scanning Algrothm *****
