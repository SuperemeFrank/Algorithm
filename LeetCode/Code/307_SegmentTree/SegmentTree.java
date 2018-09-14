class NumArray {
    int[] segTree;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        buildTree(nums);
    }
    
    private void buildTree(int[] nums) {
        segTree = new int[2 * n];
        for (int i = n; i < 2 * n; i++) {
            segTree[i] = nums[i - n];
        }
        for (int i = n - 1; i > 0; i--) {
            set(i, segTree[i * 2], segTree[i * 2 + 1]);
        }
    } 
    
    private void set(int i, int lChild, int rChild) {
        segTree[i] = lChild + rChild;
    }
    
    public void update(int i, int val) {
        int pos = i + n;
        segTree[pos] = val;
        while (pos > 1) {
            int p = pos / 2;
            int l = pos;
            int r = pos;
            if (pos % 2 == 1) {
                l = pos - 1;
            }else {
                r = pos + 1;
            }
            set(p, segTree[l], segTree[r]);
            pos = p;
        }
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        int l = i + n;
        int r = j + n;
        while (l < r) {
            if (l % 2 == 1) {
                sum += segTree[l];
                l++;
            }
            if (r % 2 == 0) {
                sum += segTree[r];
                r--;
            }
            
            l = l / 2;
            r = r / 2;
        }
        sum += segTree[r];
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */