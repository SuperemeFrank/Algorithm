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
    public boolean canAttendMeetings(Interval[] intervals) {
        // TODO: corner case
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        List<Interval> list = Arrays.asList(intervals);
        Collections.sort(list, (In1, In2) -> {
            if (In1.start == In2.start) {
                return 0;
            }
            return In1.start < In2.start ? -1 : 1;
        });
        int start = list.get(0).start;
        int end = list.get(0).end;
        for (int i = 1; i < list.size(); i++) {
            Interval curM = list.get(i);
            if (curM.start < end) {
                return false;
            }
            end = end > curM.end ? end : curM.end;
        }
        return true;
    }
}

/*
    #sliding window
    Time: O(nlogn)          Space: O(n)
*/