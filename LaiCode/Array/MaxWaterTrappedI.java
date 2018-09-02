public class Solution {
  public int maxTrapped(int[] array) {
    int i = 0;
    int j = array.length - 1;
    int ll = 0;
    int lr = 0;
    int sum = 0;
    while (i <= j) {
      ll = Math.max(ll, array[i]);
      lr = Math.max(lr, array[j]);
      if (ll > lr) {
        sum += lr - array[j];
        j--;
      }else {
        sum += ll - array[i];
        i++;
      }
    }
    return sum;
  }
}

// Time: O(n)  Space: O(1)

class Solution2 {
  public int maxTrapped(int[] array) {
    if (array.length == 0) {
      return 0;
    }
    int[] ll = new int[array.length];
    int[] lr = new int[array.length];
    ll[0] = array[0];
    lr[array.length - 1] = array[array.length - 1];
    for (int i = 1; i < array.length; i++) {
      ll[i] = Math.max(ll[i - 1], array[i]);
      lr[array.length - 1 - i] = Math.max(lr[array.length - i], array[array.length - 1 - i]);
    }
    
    int sum = 0;
    
    for (int i = 0; i < array.length; i++) {
      sum += Math.min(ll[i], lr[i]) - array[i];
    }
    return sum;
  }
}
/*
  TIme: O(n)  Space: O(n)
*/




class Solution3 {
  public int maxTrapped(int[] array) {
    int result = 0;
    for (int i = 0; i < array.length; i++) {
      int ll = i;
      int lr = i;
      for (int j = i; j >= 0; j--) {
        ll = array[j] < array[ll] ? ll : j;
      }
      for (int j = i; j < array.length; j++) {
        lr = array[j] < array[lr] ? lr : j;
      }
      int min = Math.min(array[ll], array[lr]);
      result += min - array[i];
    }
    return result;
  }
}

/* Time: O(n^2)  Space: O(1)
  for index i, the water that i can trap is determined by 
  the largest index of left of i (ll)
  and the largest index of right of i. (lr)
  
  the water trapped at index i = Max(ll, lr) - array[i];
  
  1. get the ll and lr of index 0, minL = Min(ll, lr)
  2. if array[i] > minL, ll = array[i] 
*/