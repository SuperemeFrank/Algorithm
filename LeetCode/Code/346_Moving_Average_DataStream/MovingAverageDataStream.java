class MovingAverage {
    /** Initialize your data structure here. */
    private int size;
    int count;
    int[] array;
    int cur;
    int sum;
    public MovingAverage(int size) {
        this.size = size;
        this.count = 0;
        array = new int[size];
        cur = 0;
        sum = 0;
    }
    
    public double next(int val) {
        if (count < size) count++;
        int minors = array[cur];
        sum -= minors;
        sum += val;
        array[cur] = val;
        cur++;
        cur = cur % size;
        return (double)sum / count;
    }
}
