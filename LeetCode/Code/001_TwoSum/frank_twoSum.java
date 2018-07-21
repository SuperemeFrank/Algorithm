//Hash Table
class Solution {
   public int[] twoSum(int[] numbers, int target) {
       int[] result=new int[2];
       Map<Integer,Integer> map=new HashMap<Integer,Integer>();
       for(int i=0;i<numbers.length;i++){
           map.put(numbers[i],i);
       }
       for(int x=0;x<numbers.length;x++){
        //judge if remains of (target-numbers[x]) contained
           if(map.containsKey(target-numbers[x])){
               result[0]=x;
               result[1]=map.get(target-numbers[x]);
               //they should not be the same
               if(result[0]!=result[1])
               return result;
           }
       }
      return null;
}
}

//Time Complexity: O(n)
//Space Complexity: O(n)

//Thinking:
//1.put the Array into a Hash Table as key-value
//2.use Array[index] as keys, index as value.
//3.loop and find if each key's complement exists in HashMap through HashMap method
//4.if there are two keys fit the requirment while they are same, one key can be got 
// got from HashMap, and another got from the loop.
