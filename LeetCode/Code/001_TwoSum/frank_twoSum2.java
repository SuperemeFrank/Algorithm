//Brute Forth
class Solution{
	public int[] twoSum(int[] numbers,int target){
		int[] result=new int[2];
		for(int x=0;x<numbers.length;x++){
			//the second loop y begins at the next of x
			for (int y=x+1; y<numbers.length; y++) {
				if(numbers[x]+numbers[y]==target){
					result[0]=x;
					result[1]=y;
					return result;
				}
			}
		}
		return null;
	}
}


//Time complexity: O(n^2)
//Space complexity: O(1)

//Thinking:
//use double loops.
