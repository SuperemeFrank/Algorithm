class Solution {
    public int compress(char[] chars) {
        if(chars==null || chars.length==0) return 0;
        
        int scanIndex = 0;
        int changeIndex = 0;
        
        while(scanIndex < chars.length){
            char curChar = chars[scanIndex];
            int count = 0;
          
            while(scanIndex < chars.length && chars[scanIndex]==curChar){
                scanIndex++;
                count++;
            }
            
            chars[changeIndex++] = curChar;
            if(count > 1){
                /*Stack<Character> stack = new Stack<>();
                int countTemp=count;
                while(countTemp>0){
                    int temp = countTemp % 10;
                    //System.out.println("stack push "+temp);
                    stack.push((char)(temp+'0'));
                    countTemp /= 10;
                }
                while(!stack.isEmpty())
                    chars[changeIndex++] = stack.pop();*/
                for(char c : String.valueOf(count).toCharArray()){
                    chars[changeIndex++] = c;
                }
            }
        }
        
        return changeIndex;
        
    }
}
