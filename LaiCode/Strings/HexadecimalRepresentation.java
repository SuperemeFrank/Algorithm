public class Solution {
  public String hex(int number) {
    if (number == 0) {
      return "0x0";
    }
    char[] map = {'0', '1', '2', '3', '4', '5',
                 '6', '7', '8', '9', 'A', 'B',
                 'C', 'D', 'E', 'F'};
    StringBuilder prefix = new StringBuilder();
    while (number != 0) {
      int mod = number % 16;
      number /= 16;
      prefix.append(map[mod]);
    }
    int i = prefix.length() - 1;
    while(i > 0 && prefix.charAt(i) == '0') {
      prefix.deleteCharAt(i--);
    }
    return "0x" + prefix.reverse().toString();
  }
}

// Time: O(log16(number)) Space: O(n)  n is the digits of rest;