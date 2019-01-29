class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return 0;
                }
                return o1.getValue() > o2.getValue() ? -1 : 1;
            }
        });
        
        q.addAll(map.entrySet());
        int count = 0;
        while (!q.isEmpty()) {
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();
            int k = n + 1;
            while (k > 0 && !q.isEmpty()) {
                Map.Entry<Character, Integer> cur = q.poll();
                count++;
                k--;
                if (cur.getValue() == 1) {
                    continue;
                }
                cur.setValue(cur.getValue() - 1);
                list.add(cur);
            }
            for (Map.Entry entry : list) {
                q.add(entry);
            }
            
            if (q.isEmpty()) {
                break;
            }
            count += k;
        }
        
        return count;
        
        
    }
}


/*  Time: O(m * n)  m is the number of tasks   n is the cooling intervals
    Space: O(n)
    the strategy would be: always let the current top n + 1 frequent tasks to do the current round
    
    A B X | A B X | A B 
    
    we can separate the hits as n + 1 elements for each round. Because the same element must be apart from n elements
    which means to get the least time, we need to put the most frequent elements at the beginning as most as possible
    
    
    
*/