public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character,Integer> index = new HashMap<Character,Integer>();
        int lo = 0;
        int hi = 0;
        int maxLength = 0;
        while(hi < s.length()) {
            if(index.size() <= 2) {
                char c = s.charAt(hi);
                index.put(c, hi);
                hi++;
            }
            if(index.size() > 2) {
                int leftMost = s.length();
                for(int i : index.values()) {
                    leftMost = Math.min(leftMost,i);
                }
                char c = s.charAt(leftMost);
                index.remove(c);
                lo = leftMost + 1;
            }
            maxLength = Math.max(maxLength, hi - lo);
        }
        return maxLength;
    }
}

/*  Time O(n)  Space: O(1)
    sliding windows, two pointers i, j
    
    i is the starting of the substring(inclusive), j is the end of substring(exclusive) 
    
    Use HashMap to keep track of the two characters.
    To remove one characters from the string, we need to track the leftmost latest index of characters in the Map and delete it.
    
    'eceba'
    when j = 3, there are already 2 characters in the Map ('e', 'c'). Then tehe leftmost characters is 'c', index = 1.so we remove 'c' from the Map then put 'b' into the Map.

*/