class Solution {
    public int nthUglyNumber(int n) {
        
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.offer(1l);
        long currMin = 1;
        for (int i = 0; i < n; i++) {
            
            currMin = minHeap.poll();
            while (!minHeap.isEmpty() && currMin == minHeap.peek()) { // de-duplicate
                minHeap.poll();
            }
            minHeap.offer(currMin * 2);
            minHeap.offer(currMin * 3);
            minHeap.offer(currMin * 5);
        }
        return (int)currMin;
    }
    
}

// Time: O(nlogn)    Space: O(n)

/*
    use priorityQueuei
*/