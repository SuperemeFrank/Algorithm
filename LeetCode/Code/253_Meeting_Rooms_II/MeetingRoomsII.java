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
    public int minMeetingRooms(Interval[] intervals) {
        // TODO: corner case
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        List<Interval> list = Arrays.asList(intervals);
        Collections.sort(list, (I1, I2) -> {
            if (I1.start == I2.start) {
                return 0;
            }
            return I1.start < I2.start ? -1 : 1;
        });
        boolean[] visited = new boolean[list.size()];
        int count = 0;
        for (int i = 0; i < list.size(); i++) { // Actually this is an O(n) loop
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int start = list.get(i).start;
            int end = list.get(i).end;
            for (int j = i + 1; j < list.size(); j++) {
                if (visited[j]) {
                   continue;
                }
                Interval cur = list.get(j);
                if (cur.start < end) {
                    continue;
                }else {
                    visited[j] = true;
                    end = end > cur.end ? end : cur.end;
                }
                
            }
            count++;
        }
        return count;
    }
}

/*
    Time: O(nlogn)   Space: O(n)
*/