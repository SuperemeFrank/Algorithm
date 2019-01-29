class Solution {
    boolean flag = false;
    public List<String> findItinerary(String[][] tickets) {
        
        Map<String, List<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            if (map.containsKey(ticket[0])) {
                map.get(ticket[0]).add(ticket[1]);
            }else {
                List<String> target = new ArrayList<>();
                target.add(ticket[1]);
                map.put(ticket[0], target);
            }
        }
        
        for (List<String> target : map.values()) {
            Collections.sort(target, Comparator.reverseOrder());
        }
        
        List<String> res = new ArrayList<>();
        res.add("JFK");
        int targetSize = tickets.length + 1;
        dfsHelper(res, map, 1, targetSize);
        return res;
    }
    
    private void dfsHelper(List<String> res, Map<String, List<String>> map, int level, int target) {
        if (level == target) {
            flag = true;
            return;
        }
        String start = res.get(res.size() - 1);
        if (!map.containsKey(start)) {
            return;
        }
        List<String> targetPlaces = map.get(start);
        for (int i = targetPlaces.size() - 1; i >= 0; i--) {
            
            String end = targetPlaces.get(i);
            res.add(end);
            targetPlaces.remove(end);
            dfsHelper(res, map, level + 1, target);
            if (flag) {
                return;
            }
            res.remove(res.size() - 1);
            targetPlaces.add(i, end);
        }
    }
}

/*  Time: O(k^(logk N))  k is the average branches of each elements, N is the number of pairs
    DFS, sort the List of each place that it can reach
    set a flag to see if the current selection can traverse all the place
    

*/