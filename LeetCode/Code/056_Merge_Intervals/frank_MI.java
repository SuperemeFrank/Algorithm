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
        if (intervals == null || intervals.size() == 0) return res;
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                if (a.start == b.start) return 0;
                return a.start < b.start ? -1 : 1;
            }
        });
        int i = 0, j = 1;
        while (j < intervals.size()) {
            if (intervals.get(j).start <= intervals.get(i).end) {
                intervals.get(i).end = intervals.get(i).end < intervals.get(j).end ? 
                    intervals.get(j).end : intervals.get(i).end;
            }else {
                res.add(new Interval(intervals.get(i).start, intervals.get(i).end));
                i = j;
            }
            j++;
        }
        res.add(new Interval(intervals.get(i).start, intervals.get(i).end));
        return res;
    }
}

/*  Time: O(n)  Space: O(1)    n = intervals.size()
    sort all interval based on their start
    
    left right pointer to record current handle interval until there is it not overlap with others
    
*/