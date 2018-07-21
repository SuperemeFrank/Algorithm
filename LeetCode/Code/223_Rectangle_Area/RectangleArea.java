class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        int areaOfBoth = (C - A) * (D - B) + (G - E) * (H - F);
        
        if (C <= E || A >= G || B >= H || D <= F) { // not overlap
            return areaOfBoth;
        }
        
        int overlapEdge = Math.min(C, G) - Math.max(A, E);
        int overlapLength = Math.min(D, H) - Math.max(B, F);
        return areaOfBoth - overlapEdge * overlapLength;
        
    }
}

// Time: O(1)  Space: O(1)