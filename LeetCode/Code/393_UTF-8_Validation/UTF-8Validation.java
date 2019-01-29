class Solution {
    public boolean validUtf8(int[] data) {
        
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            int cur = data[i];
            if (count <= 0) {
                count = countOne(cur);
                if (count == 1 || count > 4) {
                    return false;
                }
                count--;
            }else {
                if (((cur >> 7) & 1) != 1 || ((cur >> 6) & 1) != 0) {
                    return false;
                }
                count--;
            }
        }
        
        if (count > 0) {
            return false;
        }
        return true;
    }
    
    private int countOne(int data) {
        int count = 0;
        for (int i = 7; i >= 0; i--) {
            if (((data >> i) & 1) != 1) {
                break;
            }
            count++;
        }
        
        return count;
    }
}

// Time: O(n)   Space: O(1)
// Take care of all edge cases