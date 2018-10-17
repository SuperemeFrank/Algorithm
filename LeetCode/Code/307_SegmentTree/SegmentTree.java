/*
    TreeNode to build the segment tree
*/
class NumArray {
    SegNode root;
    class SegNode{
        int start;
        int end;
        int sum;
        SegNode left;
        SegNode right;
        public SegNode(int s, int e, int sum) {
            start = s;
            end = e;
            this.sum = sum;
            left = null;
            right = null;
        }
    }
    public NumArray(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }
    
    private SegNode build(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new SegNode(l, l, nums[l]);
        }
        
        int mid = l + (r - l) / 2;
        
        SegNode left = build(nums, l, mid);
        SegNode right = build(nums, mid + 1, r);
        
        SegNode root = new SegNode(l, r, left.sum + right.sum);
        root.left = left;
        root.right = right;
        return root;
    }
    
    public void update(int i, int value) {
        updateHelper(root, i, value);
    }
    
    private void updateHelper(SegNode root, int i, int value) {
        if (root == null) {
            return;
        }
        if (root.start > i || root.end < i) {
            return;
        }
        
        if (root.start == i && root.end == i) {
            root.sum = value;
            return;
        }
        updateHelper(root.left, i, value);
        updateHelper(root.right, i, value);
        
        root.sum = root.left.sum + root.right.sum;
    }
    
    public int sumRange(int i, int j) {
        return sumHelper(root, i, j);
    }
    
    private int sumHelper(SegNode root, int i , int j) {
        if (root == null) {
            return 0;
        }
        
        if (j < root.start) {
            return 0;
        }
        
        if (i > root.end) {
            return 0;
        }
        
        i = Math.max(root.start, i);
        j = Math.min(root.end, j);
        
        if (i == root.start && j == root.end) {
            return root.sum;
        }
        
        int left = sumHelper(root.left, i, j);
        int right = sumHelper(root.right, i, j);
        
        return left + right;
    }
}


    
// Array Segment Tree
class NumArray2 {
    int[] segTree;
    int n;
    public NumArray2(int[] nums) {
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
            if (l % 2 == 1) { // l is the right child of its parent
                sum += segTree[l];
                l++;
            }
            if (r % 2 == 0) { // r is the left child of its parent
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