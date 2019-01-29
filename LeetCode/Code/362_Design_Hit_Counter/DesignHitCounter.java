class HitCounter {

    Hitter head;
    Hitter tail;
    int lastCount;
    int preHits = 0;
    /** Initialize your data structure here. */
    public HitCounter() {
        tail = null;
        head = null;
        lastCount = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
    
        
        if (head == null) {
            head = new Hitter(timestamp);
            tail = head;
            head.hits = 1;
            lastCount = 1;
            preHits = 0;
            return; 
        }
        
        tail.next = new Hitter(timestamp);
        tail.next.hits = tail.hits + 1;
        tail = tail.next;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        
        while (head != null && head.time + 300 <= timestamp) {
            preHits = head.hits;
            head = head.next;
        }
        
        if (head == null) {
            return 0;
        }else {
            return tail.hits - preHits;
        }
    }
    
    
    class Hitter {
        public int time;
        public int hits;
        public Hitter next;
        public Hitter(int time) {
            this.time = time;
            next = null;
            hits = 0;
        }
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */


/*  
    Use a linked List to maintain the time line. 
    
    care there might be multiple same calls, how to deal with these cases


*/