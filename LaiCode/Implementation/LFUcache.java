class LFUCache {
    int cap;
    Map<Integer, Integer> values;
    Map<Integer, Integer> count;
    Map<Integer, Set<Integer>> levels; // LinkedHashSet
    
    public LFUCache(int capacity) {
        cap = capacity;
        values = new HashMap<>();
        count = new HashMap<>();
        levels = new HashMap<>();
    }
    
    public int get(int key) {
        if (values.isEmpty() || !values.containsKey(key)) {
            return -1;
        }
        
        upgrade(key);
        
        return values.get(key);
    }
    
    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }
        if (values.isEmpty() && cap > 0) {
            values.put(key, value);
            count.put(key, 1);
            Set<Integer>  set = new LinkedHashSet<>();
            set.add(key);
            levels.put(1, set);
            return;
        }
        
        if (values.containsKey(key)) {
            values.put(key, value);
            upgrade(key);
        }else {
            if (values.size() >= cap) {
                removeLeastFrequency();
            }
            values.put(key, value);
            count.put(key, 1);
            levels.get(1).add(key);
        }
    } 
    
    private void upgrade(int key) {
        int curCount = count.get(key);
        count.put(key, curCount + 1);
        Set<Integer> level = levels.get(curCount);
        level.remove(key);
        Set<Integer> upLevel = levels.containsKey(curCount + 1) ? levels.get(curCount + 1) : new LinkedHashSet<>();
        upLevel.add(key);
        levels.put(curCount + 1, upLevel);
    }
    
    private void removeLeastFrequency() {
        int i = 1;
        while (levels.containsKey(i) && levels.get(i).size() == 0) {
            i++;
        }
        
        Set<Integer> level = levels.get(i);
        Iterator<Integer> iter = level.iterator();
        if (iter.hasNext()) {
            int key = iter.next();
            iter.remove();
            count.remove(key);
            values.remove(key);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */